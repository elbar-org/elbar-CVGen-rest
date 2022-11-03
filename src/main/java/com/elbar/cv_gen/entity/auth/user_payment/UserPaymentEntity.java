package com.elbar.cv_gen.entity.auth.user_payment;

import com.elbar.cv_gen.entity.Auditable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_payment", schema = "auth")
public class UserPaymentEntity extends Auditable {

    @Column(name = "user_id", nullable = false)
    private Integer userId;
    // TODO will be write other columns!
}
