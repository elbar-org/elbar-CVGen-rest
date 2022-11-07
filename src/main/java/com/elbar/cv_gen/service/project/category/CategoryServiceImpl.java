package com.elbar.cv_gen.service.project.category;

import com.elbar.cv_gen.criteria.project.category.CategoryCriteria;
import com.elbar.cv_gen.dto.project.category.CategoryCreateDTO;
import com.elbar.cv_gen.dto.project.category.CategoryGetDTO;
import com.elbar.cv_gen.dto.project.category.CategoryUpdateDTO;
import com.elbar.cv_gen.mapper.project.category.CategoryMapper;
import com.elbar.cv_gen.repository.project.category.CategoryRepository;
import com.elbar.cv_gen.service.AbstractService;
import com.elbar.cv_gen.specification.project.category.CategoryBetweenSpecification;
import com.elbar.cv_gen.specification.project.category.CategorySearchSpecification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl extends AbstractService<CategoryMapper, CategoryRepository> implements CategoryService {
    public CategoryServiceImpl(CategoryMapper mapper, CategoryRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(CategoryCreateDTO dto) {

    }

    @Override
    public void update(CategoryUpdateDTO dto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public CategoryGetDTO get(Integer id) {
        return null;
    }

    @Override
    public List<CategoryGetDTO> list(CategoryCriteria criteria) {
        return null;
    }

    @Override
    public List<CategoryGetDTO> list_with_search(CategorySearchSpecification criteria) {
        return null;
    }

    @Override
    public List<CategoryGetDTO> list_with_between(CategoryBetweenSpecification criteria) {
        return null;
    }
}
