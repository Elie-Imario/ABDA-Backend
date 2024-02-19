package com.core.appbackend.repository.User;

import com.core.appbackend.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryInterface extends CrudRepository<User, Long> {
    Boolean existsByUserName(String username);
}
