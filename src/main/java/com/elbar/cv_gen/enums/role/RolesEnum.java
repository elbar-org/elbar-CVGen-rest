package com.elbar.cv_gen.enums.role;

import com.elbar.cv_gen.enums.language.LanguagesEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

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

    public static RolesEnum findAny() {
        return Arrays.asList(values())
                .get(new Random().nextInt(values().length));
    }
}
