package com.boris.authentication_server.service.impl;

import com.boris.authentication_server.constant.Provider;
import com.boris.authentication_server.constant.Role;
import com.boris.authentication_server.dto.AuthenticationDTO;
import com.boris.authentication_server.entity.UserDetail;
import com.boris.authentication_server.service.AuthenticationService;
import com.boris.authentication_server.vo.authentication.AuthenticationResponse;
import com.boris.authentication_server.vo.authorization.AuthorizationParam;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

// ეს აბსტრაქტ კლასი არის მშობელი კლასი რომელიც გამოიყენება მომხმარებელთა ავთენთიფიკაციისთვის, ამ კლასში შექმნილია მეთოდი რომელიც ავთენთიფიკაციის რექვესთს იღებს და აბრუნებს ავთენთიფიკაციის რესპონსს
@AllArgsConstructor
public abstract class UserAuthenticationService implements AuthenticationService {

    protected final ApiClientAuthorizationService apiClientAuthorizationService; //ეს არის სერვისი რომელიც გამოიყენება ტოკენის გენერირებისთვის, უკავშირდება AuthorizationService ინტერფეისს, რომელიც საბოლოოდ უკავშირდება ავტორიზაციის სერვერს
    private final List<Role> userRoles = List.of(Role.ROLE_USER); // ეს არის როლების ლისტი რომელიც მომხმარებელს მისცემს ავტორიზაციას შემდეგ როლებს
    protected AuthenticationResponse authenticate(UserDetail userDetail) { // ეს მეთოდი ავთენთიფიკაციის რექვესთს იღებს და აბრუნებს ავთენთიფიკაციის რესპონსს
        AuthorizationParam authorizationParam = new AuthorizationParam(); // ეს არის ავთორიზაციის პარამეტრების კლასი, რომელიც გამოიყენება ტოკენის გენერირებისთვის, ის შეიცავს ჰედერის პარამეტრებს
        Map<String, String> headerParam = new HashMap<>();
        headerParam.put("username",userDetail.getUsername());
        headerParam.put("user-id",userDetail.getUser_id());
        headerParam.put("user-provider", String.valueOf(userDetail.getProvider()));
        headerParam.put("authorities",userRoles.stream().map(Enum::toString).collect(Collectors.joining(","))); // ეს არის როლების ლისტი რომელიც მომხმარებელს მისცემს ავტორიზაციას შემდეგ როლებს
        authorizationParam.setHeaderParam(headerParam);
        return new AuthenticationResponse(apiClientAuthorizationService.generateToken(authorizationParam).accessToken());
    }

    protected UserDetail mapUserDetail(AuthenticationDTO dto) {
        UserDetail userDetail = UserDetail.builder()
                .username(dto.getUsername())
                .provider(Provider.valueOf(dto.getProvider().name()))
                .password(dto.getPassword())
                .created_time(new Date())
                .created_by(dto.getUsername())
                .user_id(generateUniqueId())
                .build();
        return userDetail;
    }

    public static String generateUniqueId() {
        return UUID.randomUUID()+"-"+Calendar.getInstance().getTimeInMillis();
    }
}