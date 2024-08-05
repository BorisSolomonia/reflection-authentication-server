package com.boris.authentication_server.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.boris.authentication_server.controller.ControllerConstant.END_POINT;

@RestController
@RequestMapping(END_POINT)
public class TestController {

    @GetMapping("/test")
    public String testCors(HttpServletRequest request, HttpServletResponse response) {
        // Log headers before sending the response
        System.out.println("Controller CORS headers:");
        System.out.println("Access-Control-Allow-Origin: " + response.getHeader("Access-Control-Allow-Origin"));
        return "CORS headers logged";
    }
}