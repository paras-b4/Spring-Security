package com.paras.SpringSecEx.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String greet(HttpServletRequest request)
    {
        return "hello world " + request.getSession().getId();
    }
}
