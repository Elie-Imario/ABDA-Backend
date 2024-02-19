package com.core.appbackend.service.user;

import com.core.appbackend.beans.User;
import com.core.appbackend.repository.User.UserDetailRepositoryInterface;
import com.core.appbackend.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserDetailRepositoryInterface userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        return UserDetailsImpl.build(user);
    }
}

