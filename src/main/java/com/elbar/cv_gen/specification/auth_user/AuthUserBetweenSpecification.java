package com.elbar.cv_gen.specification.auth_user;

import com.elbar.cv_gen.criteria.auth_user.AuthUserBetweenCriteria;
import com.elbar.cv_gen.entity.auth_user.AuthUserEntity;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AuthUserBetweenSpecification extends AbstractSpecification<AuthUserBetweenCriteria, AuthUserEntity> {

    public AuthUserBetweenSpecification(AuthUserBetweenCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<AuthUserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.between(root.get(criteria.getKey()), criteria.getFrom(), criteria.getTo());
    }
}
