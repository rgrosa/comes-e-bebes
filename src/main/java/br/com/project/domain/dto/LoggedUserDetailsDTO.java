package br.com.project.domain.dto;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class LoggedUserDetailsDTO implements UserDetails {

    private static final long serialVersionUID = 1L;

    private LoggedUserDTO loggedUser;

    public LoggedUserDetailsDTO(LoggedUserDTO loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.loggedUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.loggedUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public LoggedUserDTO getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(LoggedUserDTO loggedUser) {
        this.loggedUser = loggedUser;
    }
}