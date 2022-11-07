package com.elbar.cv_gen.service.project.category;

import com.elbar.cv_gen.criteria.project.category.CategoryCriteria;
import com.elbar.cv_gen.dto.project.category.CategoryCreateDTO;
import com.elbar.cv_gen.dto.project.category.CategoryGetDTO;
import com.elbar.cv_gen.dto.project.category.CategoryUpdateDTO;
import com.elbar.cv_gen.service.GenericCUDService;
import com.elbar.cv_gen.service.GenericGLService;
import com.elbar.cv_gen.service.GenericSpecificationService;
import com.elbar.cv_gen.specification.project.category.CategoryBetweenSpecification;
import com.elbar.cv_gen.specification.project.category.CategorySearchSpecification;

public interface CategoryService extends GenericCUDService<CategoryCreateDTO, CategoryUpdateDTO, Integer>, GenericGLService<CategoryGetDTO, CategoryCriteria, Integer>, GenericSpecificationService<CategorySearchSpecification, CategoryBetweenSpecification, CategoryGetDTO> {
}
