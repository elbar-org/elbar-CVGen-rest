package com.elbar.cv_gen.service;

import com.elbar.cv_gen.dto.BaseDTO;
import com.elbar.cv_gen.dto.GenericDTO;

import java.io.Serializable;

public interface GenericCUDService<CD extends BaseDTO, UD extends GenericDTO, K extends Serializable> {
    Void create(CD dto);

    Void update(UD dto);

    Void delete(K id);
}
