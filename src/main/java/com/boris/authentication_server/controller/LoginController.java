package com.boris.authentication_server.controller;

import com.boris.authentication_server.constant.Provider;
import com.boris.authentication_server.dto.AuthenticationDTO;
import com.boris.authentication_server.service.impl.LoginUserAuthenticationService;
import com.boris.authentication_server.service.impl.SignInUserAuthenticationService;
import com.boris.authentication_server.vo.authentication.AuthenticationResponse;
import com.boris.authentication_server.vo.request.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.boris.authentication_server.controller.ControllerConstant.END_POINT;

@RestController
@RequestMapping(END_POINT+"/login")
public class LoginController {

    @Autowired
    private LoginUserAuthenticationService loginUserAuthenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return new ResponseEntity<>(loginUserAuthenticationService
                .authenticate(AuthenticationDTO.builder()
                        .username(request.username())
                        .password(request.password()).provider(Provider.LOCAL)
                        .build()), HttpStatus.OK);
    }
}
