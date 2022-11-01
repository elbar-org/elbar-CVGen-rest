package com.elbar.cv_gen.service.auth_token;

import com.elbar.cv_gen.criteria.auth_token.AuthTokenCriteria;
import com.elbar.cv_gen.dto.auth_token.AuthTokenCreateDTO;
import com.elbar.cv_gen.dto.auth_token.AuthTokenDetailDTO;
import com.elbar.cv_gen.dto.auth_token.AuthTokenGetDTO;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericGLService;

public interface AuthTokenService extends GenericGLService<AuthTokenGetDTO, AuthTokenCriteria, Integer>, BaseService {

    void create(AuthTokenCreateDTO dto);

    void delete(Integer id);

    AuthTokenDetailDTO detail(Integer id);

}
