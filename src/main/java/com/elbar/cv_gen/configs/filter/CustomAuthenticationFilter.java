package com.elbar.cv_gen.configs.filter;

import com.auth0.jwt.JWT;
import com.elbar.cv_gen.dto.auth_user.AuthUserRequestDTO;
import com.elbar.cv_gen.response.ApplicationError;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.service.auth_user.AuthUserService;
import com.elbar.cv_gen.utils.jwt.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/api/v1/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            AuthUserRequestDTO dto = new ObjectMapper().readValue(request.getReader(), AuthUserRequestDTO.class);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getPhone(), dto.getPassword());
            return authenticationManager.authenticate(token);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        Date accessDate = JWTUtils.getExpiry();
        Date refreshDate = JWTUtils.getExpiryForRefreshToken();

        String accessToken = JWT.create().withSubject(user.getUsername())
                .withExpiresAt(accessDate).withIssuer(request.getRequestURL().toString())
                .withClaim("role", user.getAuthorities().stream().toList().get(0).getAuthority())
                .sign(JWTUtils.getAlgorithm());

        String refreshToken = JWT.create().withSubject(user.getUsername())
                .withExpiresAt(refreshDate).withIssuer(request.getRequestURL().toString())
                .sign(JWTUtils.getAlgorithm());

        // TODO auth token save write logic!

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("refreshToken", refreshToken);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), new Data<>(map));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Data<ApplicationError> errorData = new Data<>(new ApplicationError(failed.getMessage(), request.getRequestURL().toString(), HttpStatus.INTERNAL_SERVER_ERROR));
        errorData.setSuccess(false);
        new ObjectMapper().writeValue(response.getOutputStream(), errorData);
    }
}
