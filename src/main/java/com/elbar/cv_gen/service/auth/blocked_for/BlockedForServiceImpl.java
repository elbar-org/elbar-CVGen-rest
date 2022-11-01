package com.elbar.cv_gen.service.auth.blocked_for;

import com.elbar.cv_gen.criteria.auth.blocked_for.BlockedForCriteria;
import com.elbar.cv_gen.dto.auth.blocked_for.BlockedForCreateDTO;
import com.elbar.cv_gen.dto.auth.blocked_for.BlockedForGetDTO;
import com.elbar.cv_gen.entity.auth.blocked_for.BlockedForEntity;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.auth.blocked_for.BlockedForMapper;
import com.elbar.cv_gen.repository.auth.blocked_for.BlockedForRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.validator.auth.blocked_for.BlockedForValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockedForServiceImpl extends AbstractService<BlockedForValidator, BlockedForMapper, BlockedForRepository>
        implements BlockedForService {

    public BlockedForServiceImpl(BlockedForValidator validator, BlockedForMapper mapper, BlockedForRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public void create(BlockedForCreateDTO dto) {
        validator.validOnCreate(dto);
        if (repository.existsByCodeEquals(dto.getCode())) {
            throw new RuntimeException("this code already created!");
        }
        BlockedForEntity blockedForEntity = mapper.toCreateDTO(dto);
        repository.save(blockedForEntity);
    }

    @Override
    public void delete(Integer id) {
        validator.validOnKey(id);
        if (!repository.existsById(id)) {
            throw new NotFoundException("Blocked For not found");
        }
        repository.deleteById(id);
    }

    @Override
    public BlockedForGetDTO get(Integer id) {
        validator.validOnKey(id);
        return mapper.fromGetDTO(
                repository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("Blocked For not found");
                        }));
    }

    @Override
    public List<BlockedForGetDTO> list(BlockedForCriteria criteria) {
        return repository.findAll(PageRequest.of(criteria.getPage(),
                        criteria.getSize()))
                .stream()
                .map(mapper::fromGetDTO)
                .toList();
    }
}
