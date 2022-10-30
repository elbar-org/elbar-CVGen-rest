package com.elbar.cv_gen.entity.auth_card;

import com.elbar.cv_gen.entity.Auditable;
import com.elbar.cv_gen.entity.auth_user.AuthUserEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auth_card")
public class AuthCardEntity extends Auditable {
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "holder_name", nullable = false)
    private String holderName;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "expire", nullable = false)
    private String expire;
}
