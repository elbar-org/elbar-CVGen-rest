package com.elbar.cv_gen.mapper.project.template;

import com.elbar.cv_gen.dto.project.template.TemplateCreateDTO;
import com.elbar.cv_gen.dto.project.template.TemplateGetDTO;
import com.elbar.cv_gen.dto.project.template.TemplateUpdateDTO;
import com.elbar.cv_gen.entity.project.template.TemplateEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TemplateMapper extends GenericMapper<TemplateCreateDTO, TemplateUpdateDTO, TemplateGetDTO, TemplateEntity> {
}
