package com.boris.authentication_server.service.impl;

import com.boris.authentication_server.dto.AuthenticationDTO;
import com.boris.authentication_server.entity.UserDetail;
import com.boris.authentication_server.exception.AuthenticationException;
import com.boris.authentication_server.exception.UserNotFoundException;
import com.boris.authentication_server.repo.UserDetailRepo;
import com.boris.authentication_server.vo.authentication.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUserAuthenticationService extends UserAuthenticationService {

    @Autowired
    private UserDetailRepo userDetailRepo;

    @Autowired
    private PasswordEncoder passwordencoder;

    public LoginUserAuthenticationService(ApiClientAuthorizationService apiClientAuthorizationService) {
        super(apiClientAuthorizationService);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationDTO request) {
        UserDetail userDetail = userDetailRepo.findByUsernameAndProvider(request.getUsername(),
                        request.getProvider())
                .orElseThrow(UserNotFoundException::new);
        System.out.println("userDetail = " + userDetail.getPassword()+" "+request.getPassword());
        System.out.println("00000000"+passwordencoder.matches(request.getPassword(), userDetail.getPassword()));
        if (!passwordencoder.matches(request.getPassword(), userDetail.getPassword())) {
            throw new AuthenticationException();
        }
        return authenticate(userDetail);
    }
}
