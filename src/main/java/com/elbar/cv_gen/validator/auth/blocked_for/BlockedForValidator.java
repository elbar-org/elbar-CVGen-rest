package com.elbar.cv_gen.validator.auth.blocked_for;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.dto.auth.blocked_for.BlockedForCreateDTO;
import com.elbar.cv_gen.exception.exception.InvalidValidationException;
import com.elbar.cv_gen.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BlockedForValidator extends AbstractValidator<BlockedForCreateDTO, GenericDTO, Integer> {
    @Override
    public void validOnCreate(BlockedForCreateDTO dto) throws RuntimeException {
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
