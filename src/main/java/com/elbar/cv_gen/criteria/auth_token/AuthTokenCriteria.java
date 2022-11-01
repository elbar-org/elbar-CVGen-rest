package com.elbar.cv_gen.criteria.auth_token;

import com.elbar.cv_gen.criteria.GenericCriteria;
import com.elbar.cv_gen.enums.auth_token.AuthTokenFieldsEnum;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class AuthTokenCriteria extends GenericCriteria {
    private AuthTokenFieldsEnum fieldsEnum;
}
