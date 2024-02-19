package com.core.appbackend.beans;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_user_key_generator")
    @TableGenerator(name = "id_user_key_generator",
            table = "pk_utilisateur",
            pkColumnName = "name",
            valueColumnName = "value",
            allocationSize = 1)
    @Column(name = "user_id")
    private Long userId;

    private String userName;
    private String password;

    private String role;


    public User() {}

    public User(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
