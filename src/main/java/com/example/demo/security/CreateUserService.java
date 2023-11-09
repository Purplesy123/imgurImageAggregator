package com.example.demo.security;

import com.example.demo.data.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository userRepository;

   public  UserEntity createUser(String username, String password){
       UserEntity userEntity=new UserEntity();
       userEntity.setUsername(username);
       userEntity.setPassword(password);
       return userRepository.save(userEntity);
   }

}
