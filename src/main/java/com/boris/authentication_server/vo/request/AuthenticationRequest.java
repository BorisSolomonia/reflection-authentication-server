package com.boris.authentication_server.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record AuthenticationRequest(String username, String password) {
}
