package com.core.appbackend.security.authResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class authResponse {
    private String userName;
    private Collection<? extends GrantedAuthority> authorities;
    private String jwtToken;

    private HttpStatus responseStatus;

    public authResponse(String userName, Collection<? extends GrantedAuthority> authorities, String jwtToken, HttpStatus responseStatus) {
        this.userName = userName;
        this.authorities = authorities;
        this.jwtToken = jwtToken;
        this.responseStatus = responseStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
