package com.elbar.cv_gen.entity.project.template;

import com.elbar.cv_gen.entity.Auditable;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
@Table(name = "template", schema = "project")
public class TemplateEntity extends Auditable {
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "html", nullable = false, columnDefinition = "text")
    private String html;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "free_day", nullable = false)
    private Byte freeDay;

    @Column(name = "is_premium", nullable = false)
    private Boolean isPremium = false;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;
}
