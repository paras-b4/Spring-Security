package com.paras.SpringSecEx;


//import com.paras.SpringSecEx.model.User;
//import com.paras.SpringSecEx.model.student;
import com.paras.SpringSecEx.model.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrinciple implements UserDetails {

    @Autowired
    private student stud;
    public UserPrinciple(student stud) {
        this.stud=stud;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return Collections.singleton(new SimpleGrantedAuthority("user"));
    }


    @Override
    public String getPassword() {
        return stud.getPassword();
    }

    @Override
    public String getUsername() {
        return stud.getUsername();
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
}
