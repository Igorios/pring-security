package com.security.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.model.User;

import lombok.Getter;

@Getter
public class UserPrincipal implements UserDetails {

    private Long idUsuario;
    private String username;
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    private UserPrincipal(User user) {

        this.idUsuario = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();

        this.authorities = user.getRoles().stream().map(role -> {
            return new SimpleGrantedAuthority("ROLE_".concat(role.getName()));
        }).collect(Collectors.toList());
    }


    public static UserPrincipal create(User user) {
        return new UserPrincipal(user);
    }

}
