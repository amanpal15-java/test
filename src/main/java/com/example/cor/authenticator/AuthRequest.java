package com.example.cor.authenticator;

public class AuthRequest {
    public String username;
    public String password;
    public String role;
    public String permission;

    public AuthRequest(String username,String password,String role,String permission){
        this.username = username;
        this.password = password;
        this.role = role;
        this.permission = permission;
    }

}
