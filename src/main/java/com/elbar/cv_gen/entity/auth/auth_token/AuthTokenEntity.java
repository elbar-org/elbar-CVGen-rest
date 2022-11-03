package com.elbar.cv_gen.entity.auth.auth_token;

import com.elbar.cv_gen.entity.Auditable;
import com.elbar.cv_gen.enums.auth.token.TokenType;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auth_token", schema = "auth")
public class AuthTokenEntity extends Auditable {
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "duration", nullable = false)
    private Instant duration;

    @Column(name = "token", nullable = false)
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TokenType type;

}
