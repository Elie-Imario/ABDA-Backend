package com.core.appbackend.service;

import com.core.appbackend.beans.AuditRevisionEntity;
import com.core.appbackend.security.model.UserDetailsImpl;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object o) {
        String currentUser = Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(UserDetailsImpl.class::cast)
                .map(UserDetailsImpl::getUsername)
                .orElse("Unknown-User");

        AuditRevisionEntity audit = (AuditRevisionEntity) o;
        audit.setUserName(currentUser);
    }
}
