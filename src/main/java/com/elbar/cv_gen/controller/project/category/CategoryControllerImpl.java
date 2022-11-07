package com.elbar.cv_gen.controller.project.category;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.criteria.project.category.CategoryCriteria;
import com.elbar.cv_gen.dto.project.category.CategoryCreateDTO;
import com.elbar.cv_gen.dto.project.category.CategoryGetDTO;
import com.elbar.cv_gen.dto.project.category.CategoryUpdateDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.project.category.CategoryServiceImpl;
import com.elbar.cv_gen.specification.project.category.CategoryBetweenSpecification;
import com.elbar.cv_gen.specification.project.category.CategorySearchSpecification;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/category/*")
public class CategoryControllerImpl extends AbstractController<CategoryServiceImpl> implements CategoryController {
    public CategoryControllerImpl(CategoryServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(CategoryCreateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<String>> update(CategoryUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<String>> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<CategoryGetDTO>> get(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<CategoryGetDTO>>> list(CategoryCriteria criteria) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<CategoryGetDTO>>> list_with_search(CategorySearchSpecification criteria) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<CategoryGetDTO>>> list_with_between(CategoryBetweenSpecification criteria) {
        return null;
    }
}
