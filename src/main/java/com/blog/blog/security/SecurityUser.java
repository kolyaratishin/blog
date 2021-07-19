package com.blog.blog.security;

import com.blog.blog.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SecurityUser implements UserDetails {

    private String username;
    private String password;
    private List<SimpleGrantedAuthority> simpleGrantedAuthorities;
    private Boolean isActive;

    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> simpleGrantedAuthorities, Boolean isActive) {
        this.username = username;
        this.password = password;
        this.simpleGrantedAuthorities = simpleGrantedAuthorities;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(User user){
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                Collections.emptySet());
    }
}
