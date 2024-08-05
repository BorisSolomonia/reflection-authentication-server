package com.boris.authentication_server.service.impl;

import com.boris.authentication_server.dto.AuthenticationDTO;
import com.boris.authentication_server.entity.UserDetail;
import com.boris.authentication_server.exception.UserAlreadyExistsException;
import com.boris.authentication_server.repo.UserDetailRepo;
import com.boris.authentication_server.vo.authentication.AuthenticationResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignInUserAuthenticationService extends UserAuthenticationService{

    @Autowired
    private UserDetailRepo userDetailRepo;

    @Autowired
    private PasswordEncoder passwordencoder;

    public SignInUserAuthenticationService(ApiClientAuthorizationService apiClientAuthorizationService) {
        super(apiClientAuthorizationService);
    }

    @Override
    @Transactional // ეს ანოტაცია ამუშავებს ტრანზაქციებს და თუ რამე შეცდომა მოხდება ტრანზაქციის რევერსის შესრულება მოხდება, ანუ თუ რამე ოპერაცია იყო განხორციელებული მანამდე, ყველაფერი გაუქმდება
    public AuthenticationResponse authenticate(AuthenticationDTO request) { // ეს მეთოდი ავთენთიფიკაციის რექვესთს იღებს და აბრუნებს ავთენთიფიკაციის რესპონსს, ოღონდ ისე რომ უკავშირდება აბსტრაქტ კლასს
        System.out.println("request = | got in Service" );
        Optional<UserDetail> userDetailOptional = userDetailRepo
                .findByUsernameAndProvider(request.getUsername(), request.getProvider());
        System.out.println("userDetailOptional Provider = | " + request.getProvider().name());
        if(userDetailOptional.isPresent()){
            throw new UserAlreadyExistsException();
        }else {
            UserDetail userDetail = mapUserDetail(request);
            userDetail.setPassword(passwordencoder.encode(userDetail.getPassword()));
            userDetail = userDetailRepo.save(userDetail);
            return authenticate(userDetail);
        }

    }

}
