package com.hussam.carrental.services;

import com.hussam.carrental.entities.User;
import com.hussam.carrental.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByEmail(String email) {

        return userRepository.findUserByEmail(email);
    }

    @Override
    public void saveUser(User user) {

        userRepository.save(user);
    }
}
