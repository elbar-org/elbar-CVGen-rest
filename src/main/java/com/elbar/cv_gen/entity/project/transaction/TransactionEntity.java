package com.elbar.cv_gen.entity.project.transaction;

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
@Table(name = "transaction", schema = "project")
public class TransactionEntity extends Auditable {
    @Column(name = "template_id", nullable = false)
    private Integer templateId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "card_id", nullable = false)
    private Integer cardId;

    // TODO: 10/31/2022 add field amount
}
