package com.elbar.cv_gen.dto.project.template;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TemplateUpdateDTO extends GenericDTO {
    @NotBlank(message = "template title cannot be null")
    @Size(min = 5, max = 255, message = "template title length must be between 5 and 255")
    private String title;

    @NotBlank(message = "template html cannot be null")
    private String html;

    @NotNull(message = "template category id cannot be null")
    private Integer categoryId;

    @NotNull(message = "template price cannot be null")
    private Float price;

    @NotNull(message = "template free day cannot be null")
    private Byte freeDay;

    @NotNull(message = "template is premium cannot be null")
    private Boolean isPremium;

    @NotNull(message = "template is active cannot be null")
    private Boolean isActive;
}
