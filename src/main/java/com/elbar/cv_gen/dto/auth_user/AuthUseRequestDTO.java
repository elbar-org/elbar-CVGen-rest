package com.elbar.cv_gen.dto.auth_user;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUseRequestDTO {
    @NotBlank
    private String phone;
    @NotBlank
    private String password;
}
