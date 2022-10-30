package com.elbar.cv_gen.specification;

import com.elbar.cv_gen.criteria.BaseCriteria;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractSpecification<CR extends BaseCriteria> {
    protected final CR criteria;
}
