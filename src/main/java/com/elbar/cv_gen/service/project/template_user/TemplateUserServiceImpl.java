package com.elbar.cv_gen.service.project.template_user;

import com.elbar.cv_gen.annotation.IdConstraint;
import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.template_user.TemplateUserCriteria;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserCreateDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserDetailDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserGetDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserUpdateDTO;
import com.elbar.cv_gen.entity.project.template_user.TemplateUserEntity;
import com.elbar.cv_gen.exception.exception.InvalidValidationException;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.project.template_user.TemplateUserMapper;
import com.elbar.cv_gen.repository.project.template_user.TemplateUserRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.service.auth.auth_user.AuthUserService;
import com.elbar.cv_gen.specification.project.templateUser.TemplateUserBetweenSpecification;
import com.elbar.cv_gen.specification.project.templateUser.TemplateUserSearchSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class TemplateUserServiceImpl extends AbstractService<TemplateUserMapper, TemplateUserRepository> implements TemplateUserService {

    private final AuthUserService userService;

    public TemplateUserServiceImpl(TemplateUserMapper mapper, TemplateUserRepository repository, AuthUserService userService) {
        super(mapper, repository);
        this.userService = userService;
    }

    @Override
    public void create(TemplateUserCreateDTO dto) {
        // TODO template Service yozilgan keyin! checklari uchun kere
        if (!userService.existById(dto.getUserId())) {
            throw new NotFoundException("User not found");
        }
        TemplateUserEntity templateUserEntity = mapper.toCreateDTO(dto);
        templateUserEntity.setIsEdit(false);
        repository.save(templateUserEntity);
    }

    @Override
    public void update(TemplateUserUpdateDTO dto) {
        if (Objects.isNull(dto.getId()) || dto.getId() < 1) {
            throw new InvalidValidationException("Invalid ID!");
        }
        TemplateUserEntity templateUser = repository.findById(dto.getId())
                .orElseThrow(() -> {
                    throw new NotFoundException("Template User not found");
                });
        if (templateUser.getIsEdit().booleanValue() != dto.getIsEdit().booleanValue()) {
            templateUser.setIsEdit(dto.getIsEdit());
            templateUser.setUpdatedAt(LocalDateTime.now());
            templateUser.setUpdatedBy(-1);
            repository.save(templateUser);
        }
    }

    @Override
    public void delete(@IdConstraint Integer id) {
        TemplateUserEntity entity = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Template User not found");
        });
        entity.setDeleted(true);
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdatedBy(-1);
        repository.save(entity);
    }

    @Override
    public TemplateUserGetDTO get(@IdConstraint Integer id) {
        return mapper.fromGetDTO(
                repository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("Template User not found");
                })
        );
    }

    @Override
    public TemplateUserDetailDTO detail(@IdConstraint Integer id) {
        return mapper.fromDetailDTO(
                repository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("Template User not found");
                })
        );
    }

    @Override
    public List<TemplateUserGetDTO> list(TemplateUserCriteria criteria) {
        return repository.findAll(
                        PageRequest.of(criteria.getPage(), criteria.getSize(),
                                criteria.getSort(), criteria.getFieldsEnum().getValue())
                ).stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public List<TemplateUserGetDTO> list_with_search(SearchCriteria criteria) {
        return repository.findAll(new TemplateUserSearchSpecification(criteria),
                        PageRequest.of(criteria.getPage(), criteria.getSize()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public List<TemplateUserGetDTO> list_with_between(BetweenCriteria criteria) {
        return repository.findAll(new TemplateUserBetweenSpecification(criteria),
                        PageRequest.of(criteria.getPage(), criteria.getSize()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

}
