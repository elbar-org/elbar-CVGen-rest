package com.elbar.cv_gen.dto.auth_user;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUserChangePasswordDTO {
    @NotBlank
    private Integer userId;
    @NotBlank
    @Size(min = 8, max = 120)
    private String oldPwd;
    @NotBlank
    @Size(min = 8, max = 120)
    private String newPwd;
}
