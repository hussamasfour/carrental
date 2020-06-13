package com.hussam.carrental.services;

import com.hussam.carrental.entities.User;

public interface UserService {
    public User getUserById(Long id);
    User getUserByEmail(String email);
    void saveUser(User user);
}
