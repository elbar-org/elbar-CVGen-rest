package com.elbar.cv_gen.controller.project.template;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.criteria.project.template.TemplateCriteria;
import com.elbar.cv_gen.dto.project.template.TemplateCreateDTO;
import com.elbar.cv_gen.dto.project.template.TemplateGetDTO;
import com.elbar.cv_gen.dto.project.template.TemplateUpdateDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.project.template.TemplateServiceImpl;
import com.elbar.cv_gen.specification.project.template.TemplateBetweenSpecification;
import com.elbar.cv_gen.specification.project.template.TemplateSearchSpecification;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/template/*")
public class TemplateControllerImpl extends AbstractController<TemplateServiceImpl> implements TemplateController {
    public TemplateControllerImpl(TemplateServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(TemplateCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully created template"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(TemplateUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully updated template"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<String>> delete(Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully deleted template"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<TemplateGetDTO>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TemplateGetDTO>>> list(TemplateCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TemplateGetDTO>>> list_with_search(TemplateSearchSpecification criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_search(criteria)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<TemplateGetDTO>>> list_with_between(TemplateBetweenSpecification criteria) {
        return new ResponseEntity<>(new Data<>(service.list_with_between(criteria)), HttpStatus.OK);
    }
}
