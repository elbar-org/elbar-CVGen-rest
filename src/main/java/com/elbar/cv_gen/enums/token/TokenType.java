package com.elbar.cv_gen.enums.token;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TokenType {
    ACCESS("Access"),
    REFRESH("Refresh");
    private final String value;
}
