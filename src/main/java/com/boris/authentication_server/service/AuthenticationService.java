package com.boris.authentication_server.service;

import com.boris.authentication_server.dto.AuthenticationDTO;
import com.boris.authentication_server.vo.authentication.AuthenticationResponse;

// ეს ინტერფეისი გამოიყენება ავტორიზაციის სერვისისთვის, ის აუთენთიფიკაციის რექვესთს იღებს და აბრუნებს ავტორიზაციის რესპონსს
public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationDTO request);

}
