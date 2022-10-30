package com.elbar.cv_gen.entity.auth_block;

import com.elbar.cv_gen.entity.Auditable;
import com.elbar.cv_gen.entity.auth_user.AuthUserEntity;
import com.elbar.cv_gen.entity.blocked_for.BlockedForEntity;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auth_block")
public class AuthBlockEntity extends Auditable {
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "duration", nullable = false)
    private Instant duration;

    @Column(name = "blocked_for", nullable = false)
    private String blockedFor;

}
