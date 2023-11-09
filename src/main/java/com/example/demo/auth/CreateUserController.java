package com.example.demo.auth;

import com.example.demo.security.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myappC")
public class CreateUserController {

    @Autowired
    private CreateUserService createUserService;

    @RequestMapping(value="/createUser",method= RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestParam String username, @RequestParam String password){
        createUserService.createUser(username,password);
        return ResponseEntity.ok("User created successfully for username :"+username);
    }


}
