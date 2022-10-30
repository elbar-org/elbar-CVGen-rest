package com.elbar.cv_gen.controller.auth_user;

import com.elbar.cv_gen.controller.AbstractController;
import com.elbar.cv_gen.controller.GenericCUDController;
import com.elbar.cv_gen.controller.GenericGLController;
import com.elbar.cv_gen.criteria.auth_user.AuthUserCriteria;
import com.elbar.cv_gen.dto.auth_user.AuthUserCreateDTO;
import com.elbar.cv_gen.dto.auth_user.AuthUserDetailDTO;
import com.elbar.cv_gen.dto.auth_user.AuthUserGetDTO;
import com.elbar.cv_gen.dto.auth_user.AuthUserUpdateDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.auth_user.AuthUserService;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/auth_user/*")
public class AuthUserController extends AbstractController<AuthUserService>
        implements GenericCUDController<AuthUserCreateDTO, AuthUserUpdateDTO, Integer>,
        GenericGLController<AuthUserGetDTO, AuthUserCriteria, Integer> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<String>> create(AuthUserCreateDTO DTO) {
        service.create(DTO);
        return new ResponseEntity<>(new Data<>("Successfully Created - User"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<String>> update(AuthUserUpdateDTO DTO) {
        service.update(DTO);
        return new ResponseEntity<>(new Data<>("Successfully Updated - User"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<String>> delete(Integer id) {
        service.delete(id);
        return new ResponseEntity<>(new Data<>("Successfully Deleted - User"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Data<AuthUserGetDTO>> get(Integer id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data<AuthUserDetailDTO>> detail(@PathVariable Integer id) {
        return new ResponseEntity<>(new Data<>(service.detail(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<AuthUserGetDTO>>> list(AuthUserCriteria criteria) {
        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
    }
}
