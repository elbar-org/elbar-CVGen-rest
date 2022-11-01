package com.elbar.cv_gen.validator.auth.auth_token;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.dto.auth.auth_token.AuthTokenCreateDTO;
import com.elbar.cv_gen.exception.exception.InvalidValidationException;
import com.elbar.cv_gen.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthTokenValidator extends AbstractValidator<AuthTokenCreateDTO, GenericDTO, Integer> {
    @Override
    public void validOnCreate(AuthTokenCreateDTO dto) throws RuntimeException {
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
        if (id < 1) {
            throw new InvalidValidationException("Invalid ID!");
        }
    }
}
