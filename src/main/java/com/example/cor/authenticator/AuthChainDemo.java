package com.example.cor.authenticator;

public class AuthChainDemo {
    public static void main(String[] args){
        AuthHandler auth = new AuthenticationHandler();
        AuthHandler role = new RoleHandler();
        AuthHandler perm = new PermissionHandler();

        auth.setNext(role).setNext(perm);
        AuthRequest req = new AuthRequest("admin","1234","ADMIN","READ_WRITE");
        boolean result = auth.handle(req);
        System.out.println("ACCESS " + (result ? "GRANTED" : "DENIED"));
    }
}
