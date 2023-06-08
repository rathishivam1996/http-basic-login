package com.shivam.login.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());

		// TODO - implement role check.
		boolean hasRoleUser = true;
		Set<GrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));

		if (username.equals("customU") && password.equals("customP") && hasRoleUser) {
			return new UsernamePasswordAuthenticationToken(username, password, roles);
		} else {
			throw new AuthenticationCredentialsNotFoundException(
					"CustomAuthenticationProvider could not verify username: " + username + ", password= " + password);
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {

		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
	}
}
