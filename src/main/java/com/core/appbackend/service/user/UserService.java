package com.core.appbackend.service.user;

import com.core.appbackend.beans.User;
import com.core.appbackend.repository.User.UserDetailRepositoryInterface;
import com.core.appbackend.repository.User.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    UserRepositoryInterface userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Boolean existsByUsername(String username){
        return userRepository.existsByUserName(username);
    }
}
