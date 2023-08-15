package com.shivam.login.service;

import com.shivam.login.model.JpaUser;
import com.shivam.login.model.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<JpaUser> found = userService.findByEmail(email);

        if (found.isEmpty())
            throw new UsernameNotFoundException("JpaUserDetailsService loadUserByEmail: " + email + " not found");

        return new SecurityUser(found.get());
    }
}
