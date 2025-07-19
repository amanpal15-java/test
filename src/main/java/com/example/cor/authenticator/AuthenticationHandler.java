package com.example.cor.authenticator;

import com.example.cor.authenticator.AuthHandler;

public class AuthenticationHandler extends AuthHandler {

    @Override
    public boolean process(AuthRequest request) {
        if ("admin".equals(request.username) && "1234".equals(request.password)) {
            System.out.println("Authentication passed");
            return next != null ? next.handle(request) : true;
        }
        System.out.println("Authentication failed");
        return false;
    }
}
