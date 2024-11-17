package com.hellonext.serverside.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellonext.serverside.domains.User;
import com.hellonext.serverside.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public String getUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user != null) {
            return "{status : 'ok', token : '123456'}";
        }
        return "{status : 'wrong_credentials', token : ''}";
    }
}
