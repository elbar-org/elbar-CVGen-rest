package com.elbar.cv_gen.service.auth_user;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.auth_user.AuthUserBetweenCriteria;
import com.elbar.cv_gen.criteria.auth_user.AuthUserCriteria;
import com.elbar.cv_gen.criteria.auth_user.AuthUserSearchCriteria;
import com.elbar.cv_gen.dto.auth_user.*;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericCUDService;
import com.elbar.cv_gen.service.GenericGLService;
import com.elbar.cv_gen.service.GenericSpecificationService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthUserService extends GenericCUDService<AuthUserCreateDTO, AuthUserUpdateDTO, Integer>,
        GenericGLService<AuthUserGetDTO, AuthUserCriteria, Integer>,
        GenericSpecificationService<SearchCriteria, BetweenCriteria, AuthUserGetDTO>,
        UserDetailsService,
        BaseService {

    AuthUserDetailDTO detail(Integer id);

    Object login(AuthUserRequestDTO dto);

}
