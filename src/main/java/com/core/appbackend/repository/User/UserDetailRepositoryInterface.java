package com.core.appbackend.repository.User;

import com.core.appbackend.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepositoryInterface extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);

}
