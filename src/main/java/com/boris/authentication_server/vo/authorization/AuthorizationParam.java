package com.boris.authentication_server.vo.authorization;

import lombok.Data;

import java.util.Map;

// ეს კლასი დაკავშირებულია AuthorizationService კლასსთან, AuthorizationService კლასი არის ინტერფეისი რომელიც გამოიყენება ტოკენის გენერირებისთვის, ის რექვესთის ჰედერიდან იღებს პარამეტრებს და აბრუნებს ტოკენს
@Data
public class AuthorizationParam {
    private Map<String,String> headerParam;
}
