package com.boris.authentication_server.service;

import com.boris.authentication_server.vo.authorization.AuthorizationParam;
import com.boris.authentication_server.vo.authorization.AuthorizationTokenResponse;

// ეს ინტერფეისი გამოიყენება ტოკენის გენერირებისთვის, ის Header იდან იღებს პარამეტრებს და აბრუნებს ტოკენს
public interface AuthorizationService {

    AuthorizationTokenResponse generateToken(AuthorizationParam param);
}
