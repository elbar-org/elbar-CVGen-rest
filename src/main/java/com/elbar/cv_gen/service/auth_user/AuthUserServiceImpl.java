package com.elbar.cv_gen.service.auth_user;

import com.elbar.cv_gen.configs.encryption.PasswordEncoderConfigurer;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.auth_user.AuthUserBetweenCriteria;
import com.elbar.cv_gen.criteria.auth_user.AuthUserCriteria;
import com.elbar.cv_gen.criteria.auth_user.AuthUserSearchCriteria;
import com.elbar.cv_gen.dto.auth_user.*;
import com.elbar.cv_gen.entity.auth_user.AuthUserEntity;
import com.elbar.cv_gen.enums.role.RolesEnum;
import com.elbar.cv_gen.enums.status.StatusEnum;
import com.elbar.cv_gen.mapper.auth_user.AuthUserMapper;
import com.elbar.cv_gen.repository.auth_user.AuthUserRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.specification.auth_user.AuthUserBetweenSpecification;
import com.elbar.cv_gen.specification.auth_user.AuthUserSearchSpecification;
import com.elbar.cv_gen.utils.BaseUtils;
import com.elbar.cv_gen.validator.auth_user.AuthUserValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserValidator, AuthUserMapper, AuthUserRepository> implements AuthUserService {

    public AuthUserServiceImpl(AuthUserValidator validator, AuthUserMapper mapper, AuthUserRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public void create(AuthUserCreateDTO dto) {
        validator.validOnCreate(dto);
        if (repository.existsByPhoneEquals(dto.getPhone())) {
            throw new RuntimeException("This phone number already created!");
        }
        AuthUserEntity authUserEntity = mapper.toCreateDTO(dto);
        authUserEntity.setRole(RolesEnum.USER);
        authUserEntity.setPassword(new PasswordEncoderConfigurer().encoder().encode(dto.getPassword()));
        authUserEntity.setStatus(StatusEnum.NO_ACTIVE);
        authUserEntity.setFreeChance(3);
        authUserEntity.setLoginTryCount(0);
        repository.save(authUserEntity);
    }

    @Override
    public void update(AuthUserUpdateDTO dto) {
        validator.validOnUpdate(dto);
        AuthUserEntity entity = repository.findById(dto.getId())
                .orElseThrow(() -> {
                    throw new NotFoundException("User not found");
                });
        BeanUtils.copyProperties(dto, entity);
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdatedBy(dto.getId());
        repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        validator.validOnKey(id);
        if (!repository.existsById(id)) {
            throw new NotFoundException("User not found");
        }
        repository.deleteById(id);
    }

    @Override
    public AuthUserGetDTO get(Integer id) {
        validator.validOnKey(id);
        return mapper.fromGetDTO(
                repository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("User not found");
                        }));
    }

    @Override
    public AuthUserDetailDTO detail(Integer id) {
        validator.validOnKey(id);
        return mapper.fromDetailDTO(
                repository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("User not found");
                        }));
    }

    @Override
    public Object login(AuthUserRequestDTO dto) {
        HttpEntity<AuthUserRequestDTO> entity = new HttpEntity<>(dto);
        ResponseEntity<Object> exchange = BaseUtils.REST_TEMPLATE.exchange("http://localhost:8080/api/v1/login", HttpMethod.POST, entity, Object.class);
        return exchange.getBody();
    }

    @Override
    public List<AuthUserGetDTO> list(AuthUserCriteria criteria) {
        return repository.findAll(PageRequest.of(criteria.getPage(), criteria.getSize(),
                        criteria.getSort(), criteria.getFieldsEnum().getValue()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }


    @Override
    public List<AuthUserGetDTO> list_with_search(SearchCriteria criteria) {
        return repository.findAll(new AuthUserSearchSpecification(criteria),
                        PageRequest.of(criteria.getPage(),
                                criteria.getSize()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public List<AuthUserGetDTO> list_with_between(BetweenCriteria criteria) {
        return repository.findAll(new AuthUserBetweenSpecification(criteria),
                        PageRequest.of(criteria.getPage(),
                                criteria.getSize()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        validator.validOnPhone(username);
        AuthUserEntity entity = repository.findByPhoneEquals(username)
                .orElseThrow(() -> {
                    throw new NotFoundException("User not found");
                });
        return User.builder()
                .username(entity.getPhone())
                .password(entity.getPassword())
                .authorities(entity.getRole().getValue())
                .accountLocked(false)
                .accountExpired(false)
                .disabled(false)
                .credentialsExpired(false)
                .build();
    }
}
