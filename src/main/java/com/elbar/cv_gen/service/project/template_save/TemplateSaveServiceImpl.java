package com.elbar.cv_gen.service.project.template_save;

import com.elbar.cv_gen.annotation.IdConstraint;
import com.elbar.cv_gen.criteria.project.template_save.TemplateSaveCriteria;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveCreateDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveDetailDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveGetDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveUpdateDTO;
import com.elbar.cv_gen.exception.exception.NotFoundException;
import com.elbar.cv_gen.mapper.project.template_save.TemplateSaveMapper;
import com.elbar.cv_gen.repository.project.template_save.TemplateSaveRepository;
import com.elbar.cv_gen.service.AbstractService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateSaveServiceImpl extends AbstractService<TemplateSaveMapper, TemplateSaveRepository> implements TemplateSaveService {

    public TemplateSaveServiceImpl(TemplateSaveMapper mapper, TemplateSaveRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(TemplateSaveCreateDTO dto) {
        // TODO template Service yozilgan keyin! checklari uchun kere
    }

    @Override
    public void update(TemplateSaveUpdateDTO dto) {
        // TODO template Service yozilgan keyin! checklari uchun kere
    }

    @Override
    public void delete(@IdConstraint Integer id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("TemplateSave not found");
        }
        repository.deleteById(id);
    }

    @Override
    public TemplateSaveGetDTO get(@IdConstraint Integer id) {
        return mapper.fromGetDTO(
                repository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("TemplateSave not found");
                })
        );
    }

    @Override
    public List<TemplateSaveGetDTO> list(TemplateSaveCriteria criteria) {
        return repository.findAll(
                        PageRequest.of(criteria.getPage(),
                                criteria.getSize())).stream()
                .map(mapper::fromGetDTO)
                .toList();
    }

    @Override
    public TemplateSaveDetailDTO detail(@IdConstraint Integer id) {
        return mapper.fromDetailDTO(
                repository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("TemplateSave not found");
                })
        );
    }
}
