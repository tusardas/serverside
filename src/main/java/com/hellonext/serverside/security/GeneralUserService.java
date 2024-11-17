package com.hellonext.serverside.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hellonext.serverside.domains.User;
import com.hellonext.serverside.repositories.UserRepository;

public class GeneralUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username);
        if(user != null) {
            return new GeneralUserDetails(user);
        }
        else {
            throw new UsernameNotFoundException("Could not find user");
        }
    }
    
}
