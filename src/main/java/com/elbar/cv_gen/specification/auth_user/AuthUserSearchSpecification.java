package com.elbar.cv_gen.specification.auth_user;

import com.elbar.cv_gen.criteria.auth_user.AuthUserSearchCriteria;
import com.elbar.cv_gen.entity.auth_user.AuthUserEntity;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AuthUserSearchSpecification extends AbstractSpecification<AuthUserSearchCriteria, AuthUserEntity> {

    public AuthUserSearchSpecification(AuthUserSearchCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<AuthUserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThan(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase(">=")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThan(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase("<=")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType().equals(String.class)) {
                return criteriaBuilder.like(
                        root.get(criteria.getKey()), criteria.getValue());
            } else {
                return criteriaBuilder.equal(root.<String>get(criteria.getKey()), Integer.getInteger(criteria.getValue()));
            }
        }
        return null;
    }
}
