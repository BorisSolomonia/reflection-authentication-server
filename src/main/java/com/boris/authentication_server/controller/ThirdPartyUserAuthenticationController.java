package com.boris.authentication_server.controller;

import com.boris.authentication_server.constant.Provider;
import com.boris.authentication_server.dto.AuthenticationDTO;
import com.boris.authentication_server.service.impl.LoginUserAuthenticationService;
import com.boris.authentication_server.service.impl.ThirdPartyUserAuthenticationService;
import com.boris.authentication_server.vo.authentication.AuthenticationResponse;
import com.boris.authentication_server.vo.request.AuthenticationRequest;
import com.boris.authentication_server.vo.request.ThirdPartyAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.boris.authentication_server.controller.ControllerConstant.END_POINT;

@RestController
@RequestMapping(END_POINT+"/third-party")
public class ThirdPartyUserAuthenticationController {

    @Autowired
    private ThirdPartyUserAuthenticationService thirdPartyUserAuthenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody ThirdPartyAuthenticationRequest request) {
        return new ResponseEntity<>(thirdPartyUserAuthenticationService
                .authenticate(AuthenticationDTO.builder()
                        .provider(request.provider())
                        .build()), HttpStatus.OK);
    }

    @GetMapping("/demo")
    public String demo() {
        return "Hello World!";
    }
}
