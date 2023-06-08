//package com.shivam.login.model;
//
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class SecurityUser implements UserDetails {
//
//	private static final long serialVersionUID = 1L;
//
//	private User user;
//
//	public SecurityUser(User user) {
//		this.user = user;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return null;
//	}
//
//	@Override
//	public String getPassword() {
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return user.getUsername();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return user.isAccountNonExpired();
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return user.isAccountNonLocked();
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return user.isCredentialsNonExpired();
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return user.isEnabled();
//	}
//
//	@Override
//	public String toString() {
//		return "SecurityUser [user=" + user + "]";
//	}
//}
