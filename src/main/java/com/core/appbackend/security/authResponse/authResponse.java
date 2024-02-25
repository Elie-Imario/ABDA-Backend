package com.core.appbackend.security.authResponse;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class authResponse {
    private String userName;
    private Collection<? extends GrantedAuthority> authority;
    private String jwt;

    public authResponse(String userName, Collection<? extends GrantedAuthority> authority, String jwt) {
        this.userName = userName;
        this.authority = authority;
        this.jwt = jwt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<? extends GrantedAuthority> getAuthority() {
        return authority;
    }

    public void setAuthority(Collection<? extends GrantedAuthority> authority) {
        this.authority = authority;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
