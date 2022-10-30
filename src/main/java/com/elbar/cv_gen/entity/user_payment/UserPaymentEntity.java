package com.elbar.cv_gen.entity.user_payment;

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
@Table(name = "user_payment")
public class UserPaymentEntity extends Auditable {
    @Column(name = "user_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AuthUserEntity userId;
    // TODO will be write other columns!
}
