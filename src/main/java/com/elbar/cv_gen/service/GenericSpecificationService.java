package com.elbar.cv_gen.service;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.specification.BaseSpecification;

import java.util.List;

public interface GenericSpecificationService<SC extends BaseSpecification, BC extends BaseSpecification, GD extends GenericDTO> {
    List<GD> list_with_search(SC criteria);

    List<GD> list_with_between(BC criteria);
}
