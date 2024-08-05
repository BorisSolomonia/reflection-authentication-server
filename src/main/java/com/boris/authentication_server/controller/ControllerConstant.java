package com.boris.authentication_server.controller;

public class ControllerConstant {
    public static final String END_POINT = "/user-auth";
    public static final String SIGN_IN = "/user-auth/sign-in";
    public static final String SIGN_UP = "/user-auth/sign-up";
    public static final String SIGN_OUT = "/user-auth/sign-out";
    public static final String REFRESH = "/user-auth/refresh";
    public static final String USER = "/user-auth/user";
    public static final String USER_ID = "/user-auth/user/{id}";
    public static final String USER_EMAIL = "/user-auth/user/email/{email}";
    public static final String USER_USERNAME = "/user-auth/user/username/{username}";
    public static final String USER_ROLE = "/user-auth/user/role/{role}";
    public static final String USER_ALL = "/user-auth/user/all";
    public static final String USER_DELETE = "/user-auth/user/delete/{id}";
    public static final String USER_UPDATE = "/user-auth/user/update/{id}";
    public static final String USER_UPDATE_ROLE = "/user-auth/user/update-role/{id}";
    public static final String USER_UPDATE_PASSWORD = "/user-auth/user/update-password/{id}";
    public static final String USER_UPDATE_EMAIL = "/user-auth/user/update-email/{id}";
    public static final String USER_UPDATE_USERNAME = "/user-auth/user/update-username/{id}";
    public static final String USER_UPDATE_STATUS = "/user-auth/user/update-status/{id}";
    public static final String USER_UPDATE_PROFILE = "/user-auth/user/update-profile/{id}";
    public static final String USER_UPDATE_PROFILE_IMAGE = "/user-auth/user/update-profile-image/{id}";
    public static final String USER_UPDATE_PROFILE_IMAGE_URL = "/user-auth/user/update-profile-image-url/{id}";
    public static final String USER_UPDATE_PROFILE_IMAGE_DELETE = "/user-auth/user/update-profile-image-delete/{id}";
    public static final String USER_UPDATE_PROFILE_IMAGE_URL_DELETE = "/user-auth/user/update-profile-image-url-delete/{id}";
    public static final String USER_UPDATE_PROFILE_IMAGE_URL_DELETE_ALL = "/user-auth/user/update-profile-image-url-delete-all/{id}";
    public static final String USER_UPDATE_PROFILE_IMAGE_DELETE_ALL = "/user-auth/user/update-profile-image-delete-all/{id}";
    public static final String USER_UPDATE_PROFILE_IMAGE_URL_DELETE_ALL_BY_URL = "/user-auth/user/update-profile-image-url-delete-all-by-url/{id}";
    public static final String USER_UPDATE_PROFILE_IMAGE_DELETE_ALL_BY_URL = "/user-auth/user/update-profile-image-delete-all-by-url/{id}";
    public static final String USER_UPDATE_PROFILE_IMAGE_DELETE_BY_URL = "/user";
}
