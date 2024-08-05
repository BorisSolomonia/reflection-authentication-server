package com.boris.authentication_server.service.impl;

import com.boris.authentication_server.dto.AuthenticationDTO;
import com.boris.authentication_server.entity.UserDetail;
import com.boris.authentication_server.exception.UserAlreadyExistsException;
import com.boris.authentication_server.repo.UserDetailRepo;
import com.boris.authentication_server.vo.authentication.AuthenticationResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ThirdPartyUserAuthenticationService extends UserAuthenticationService{

    @Autowired
    UserDetailRepo userDetailRepo;

    public ThirdPartyUserAuthenticationService(ApiClientAuthorizationService apiClientAuthorizationService) {
        super(apiClientAuthorizationService);
    }

    @Override
    @Transactional
    public AuthenticationResponse authenticate(AuthenticationDTO request) {
            UserDetail userDetail = userDetailRepo
                .findByUsernameAndProvider(request.getUsername(), request.getProvider())
                .orElse(userDetailRepo.save(mapUserDetail(request)));
            return super.authenticate(userDetail);
    }
}

