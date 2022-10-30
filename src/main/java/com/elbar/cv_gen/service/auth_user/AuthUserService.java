package com.elbar.cv_gen.service.auth_user;

import com.elbar.cv_gen.criteria.auth_user.AuthUserBetweenCriteria;
import com.elbar.cv_gen.criteria.auth_user.AuthUserCriteria;
import com.elbar.cv_gen.criteria.auth_user.AuthUserSearchCriteria;
import com.elbar.cv_gen.dto.auth_user.AuthUserCreateDTO;
import com.elbar.cv_gen.dto.auth_user.AuthUserDetailDTO;
import com.elbar.cv_gen.dto.auth_user.AuthUserGetDTO;
import com.elbar.cv_gen.dto.auth_user.AuthUserUpdateDTO;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericCUDService;
import com.elbar.cv_gen.service.GenericGLService;
import com.elbar.cv_gen.service.GenericSpecificationService;

public interface AuthUserService extends GenericCUDService<AuthUserCreateDTO, AuthUserUpdateDTO, Integer>,
        GenericGLService<AuthUserGetDTO, AuthUserCriteria, Integer>,
        GenericSpecificationService<AuthUserSearchCriteria, AuthUserBetweenCriteria, AuthUserGetDTO>, BaseService {

    AuthUserDetailDTO detail(Integer id);

}
