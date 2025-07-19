package com.example.cor.authenticator;

import com.example.cor.authenticator.AuthHandler;
import com.example.cor.authenticator.AuthRequest;

public class RoleHandler extends AuthHandler {
    @Override
    public boolean process(AuthRequest request) {
        if ("ADMIN".equals(request.role)) {
            System.out.println("Role check passed");
            return next != null ? next.handle(request) : true;
        }
        System.out.println("Role check failed");
        return false;
    }
}
