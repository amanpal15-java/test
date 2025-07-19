package com.example.cor.authenticator;

import com.example.cor.authenticator.AuthHandler;
import com.example.cor.authenticator.AuthRequest;

public class PermissionHandler extends AuthHandler {
    @Override
    public boolean process(AuthRequest request) {
        if ("READ_WRITE".equals(request.permission)) {
            System.out.println("Permission check passed");
            return next != null ? next.handle(request) : true;
        }
        System.out.println("Permission check failed");
        return false;
    }
}
