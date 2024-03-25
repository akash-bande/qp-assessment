package com.example.dto;

import com.example.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {

    private User user;
    private List<GrantedAuthority> roles;

    public CustomUserDetails(User user){
        this.user = user;
        this.roles = getRolesFromUserrole();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserEmail();
    }

    private List<GrantedAuthority> getRolesFromUserrole(){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        return grantedAuthorities;
    }
}
