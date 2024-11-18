package com.paras.SpringSecEx.service;

import com.paras.SpringSecEx.UserPrinciple;
//import com.paras.SpringSecEx.model.User;
import com.paras.SpringSecEx.model.student;
import com.paras.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Searching for user: " + username);

        student stud= repo.findByUsername(username);

        System.out.println(stud);
        if(stud==null)
        {
            System.out.println("User not found ");
            throw new UsernameNotFoundException("user nit found ");
        }
        return new UserPrinciple(stud);
    }
}
