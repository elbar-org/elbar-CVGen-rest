package com.elbar.cv_gen.criteria;

import lombok.*;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ToString
@ParameterObject
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria extends GenericCriteria {
    private String key;
    private String operation;
    private String value;
}
