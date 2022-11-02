package com.elbar.cv_gen.validator.auth.auth_block;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockCreateDTO;
import com.elbar.cv_gen.exception.exception.InvalidValidationException;
import com.elbar.cv_gen.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthBlockValidator extends AbstractValidator<AuthBlockCreateDTO, GenericDTO, Integer> {
    @Override
    public void validOnCreate(AuthBlockCreateDTO dto) throws RuntimeException {
        if (Objects.isNull(dto)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(GenericDTO dto) throws RuntimeException {

    }

    @Override
    public void validOnKey(Integer id) throws RuntimeException {
        if (Objects.isNull(id)) {
            throw new InvalidValidationException("ID is null");
        }
    }
}
