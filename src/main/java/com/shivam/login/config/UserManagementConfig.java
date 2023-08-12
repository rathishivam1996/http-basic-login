package com.shivam.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

//	@Bean
//	UserDetailsService userDetailsService() {
//		var inMemoryUerDetails = new InMemoryUserDetailsManager();
//
//		UserDetails u1 = User.withUsername("u1").password("p1").roles("USER").authorities("READ").build();
//		UserDetails u2 = User.withUsername("u2").password("p2").roles("ADMIN").authorities("READ").build();
//
//		inMemoryUerDetails.createUser(u1);
//		inMemoryUerDetails.createUser(u2);
//
//		return inMemoryUerDetails;
//	}
//
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}

}
