package com.boris.authentication_server.dto;

import com.boris.authentication_server.constant.Provider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationDTO {

    private String username;
    private String password;
    private Provider provider;
}
