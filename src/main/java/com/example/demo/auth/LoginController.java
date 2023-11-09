package com.example.demo.auth;

import com.example.demo.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/myapp")
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;
@RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if (authenticationService.authenticate(username, password)) {

            return ResponseEntity.ok("User Logged in successfuly: Username "+username);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Login failed: Username "+username);
        }
    }

}
