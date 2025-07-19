package com.example.cor.authenticator;

abstract class AuthHandler {
    protected AuthHandler next;

    public AuthHandler setNext(AuthHandler next){
        this.next = next;
        return next;
    }

    public boolean handle(AuthRequest request){
        if(!process(request)){
            return false;
        }
        return next == null || next.handle(request);
    }

    public abstract boolean process(AuthRequest request);

}
