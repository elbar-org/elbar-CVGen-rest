package com.elbar.cv_gen.specification.project.category;

import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.entity.project.category.CategoryEntity;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CategorySearchSpecification extends AbstractSpecification<SearchCriteria, CategoryEntity> {
    public CategorySearchSpecification(SearchCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<CategoryEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
