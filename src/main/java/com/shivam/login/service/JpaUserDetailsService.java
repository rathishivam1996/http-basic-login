package com.shivam.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shivam.login.model.JpaUser;
import com.shivam.login.model.SecurityUser;

public class JpaUserDetailsService implements UserDetailsService {
	@Autowired
	IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JpaUser> found = userService.findByUsername(username);

		if (found.isEmpty())
			throw new UsernameNotFoundException("JpaUserDetailsService loadUserByUsername: " + username + " not found");

		return new SecurityUser(found.get());
	}
}
