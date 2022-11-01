package com.elbar.cv_gen.validator.auth.auth_user;

import com.elbar.cv_gen.dto.auth.auth_user.AuthUserCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_user.AuthUserUpdateDTO;
import com.elbar.cv_gen.exception.exception.InvalidValidationException;
import com.elbar.cv_gen.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthUserValidator extends AbstractValidator<AuthUserCreateDTO, AuthUserUpdateDTO, Integer> {

    @Override
    public void validOnCreate(AuthUserCreateDTO dto) throws RuntimeException {
        if (Objects.isNull(dto)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    @Override
    public void validOnUpdate(AuthUserUpdateDTO dto) throws RuntimeException {
        if (Objects.isNull(dto)) {
            throw new InvalidValidationException("DTO is null");
        }
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

    public void validOnPhone(String phone) throws RuntimeException {
        if (Objects.isNull(phone)) {
            throw new InvalidValidationException("PHONE is null");
        }
    }

}
