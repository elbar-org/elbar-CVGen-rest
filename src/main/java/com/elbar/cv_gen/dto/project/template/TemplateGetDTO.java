package com.elbar.cv_gen.dto.project.template;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TemplateGetDTO extends GenericDTO {
    private String title;

    private String html;

    private Integer categoryId;

    private Float price;

    private Byte freeDay;

    private Boolean isPremium;

    private Boolean isActive;
}
