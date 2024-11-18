package com.paras.SpringSecEx.service;

import com.paras.SpringSecEx.model.student;
import com.paras.SpringSecEx.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTService JwtService ;

    private BCryptPasswordEncoder endoder=new BCryptPasswordEncoder(12);

    public student Register(student stud)
    {
        stud.setPassword(endoder.encode(stud.getPassword()));
        return repo.save(stud);
    }

    public String verify(student stud) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(stud.getUsername(),stud.getPassword()));
        if(authentication.isAuthenticated())
        {
            return JwtService.generateToken(stud);
        }
        return "fail";


    }
}
