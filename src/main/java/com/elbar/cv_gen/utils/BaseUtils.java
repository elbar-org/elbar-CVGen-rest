package com.elbar.cv_gen.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseUtils {
    public static final String API = "/api";
    public static final String VERSION = "/v1";
    public static final String PATH = API + VERSION;
    public static final String CREATE_PATH = "create";
    public static final String UPDATE_PATH = "update";
    public static final String DELETE_PATH = "delete/{id}";
    public static final String GET_PATH = "get/{id}";
    public static final String LIST_PATH = "list";
    public static final String LIST_WITH_SEARCH_PATH = "list_with_search";
    public static final String LIST_WITH_BETWEEN_PATH = "list_with_between";
}
