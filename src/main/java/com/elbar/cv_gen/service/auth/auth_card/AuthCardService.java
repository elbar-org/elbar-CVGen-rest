package com.elbar.cv_gen.service.auth.auth_card;

import com.elbar.cv_gen.criteria.auth.auth_card.AuthCardCriteria;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardCreateDto;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardDto;
import com.elbar.cv_gen.dto.auth.auth_card.AuthCardUpdateDto;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericCUDService;
import com.elbar.cv_gen.service.GenericGLService;

public interface AuthCardService extends GenericCUDService<AuthCardCreateDto, AuthCardUpdateDto, Integer>,
        GenericGLService<AuthCardDto, AuthCardCriteria, Integer>, BaseService {


}
