package com.paras.SpringSecEx.controller;

import com.paras.SpringSecEx.model.student;
import com.paras.SpringSecEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @Autowired
    private UserService service;

    @PostMapping("/Register")
    public student Register(@RequestBody student stud)
    {
        return service.Register(stud);
    }

    @PostMapping("/login")
    public String login(@RequestBody student stud)
    {
        return service.verify(stud);
    }

}
