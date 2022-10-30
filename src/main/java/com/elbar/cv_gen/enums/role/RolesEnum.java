package com.elbar.cv_gen.enums.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum RolesEnum {
    USER("USER"),
    ADMIN("ADMIN");
    private final String value;

    public static boolean hasRoleIgnoreCase(String value) {
        return Arrays.stream(values())
                .anyMatch(f -> f.value.equalsIgnoreCase(value));
    }
}
