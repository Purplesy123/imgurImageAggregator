package com.example.demo.security;

import com.example.demo.data.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        boolean isUserPresent=false;

        if (user!=null) {
            String storedPassword = user.getPassword();
            isUserPresent=(storedPassword.equals(password));

        }
        return isUserPresent;
    }
}
