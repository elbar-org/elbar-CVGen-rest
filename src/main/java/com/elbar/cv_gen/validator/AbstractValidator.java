package com.elbar.cv_gen.validator;

import com.elbar.cv_gen.dto.BaseDTO;
import com.elbar.cv_gen.dto.GenericDTO;

import java.io.Serializable;

public abstract class AbstractValidator<CD extends BaseDTO, UD extends GenericDTO, K extends Serializable> implements BaseValidator {
    public abstract void validOnCreate(CD dto) throws RuntimeException;

    public abstract void validOnUpdate(UD dto) throws RuntimeException;

    public abstract void validOnKey(K id) throws RuntimeException;
}
