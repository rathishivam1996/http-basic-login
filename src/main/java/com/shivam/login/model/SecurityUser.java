package com.shivam.login.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SecurityUser implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    private final JpaUser jpaUser;

    public SecurityUser(JpaUser jpaUser) {
        this.jpaUser = jpaUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = jpaUser.getRoles();
        Set<GrantedAuthority> rv = new HashSet<>(roles);
        for (Role role : roles) {
            rv.addAll(role.getAllowedAuthorities());
        }
        return rv;
    }

    @Override
    public String getPassword() {
        return jpaUser.getPassword();
    }

    @Override
    public String getUsername() {
        return jpaUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return jpaUser.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return jpaUser.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return jpaUser.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return jpaUser.isEnabled();
    }

    @Override
    public String toString() {
        return "SecurityUser [user=" + jpaUser + "]";
    }
}
