package com.paras.SpringOauth2Demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String greet()
    {
        return "welcome to world ";
    }
}
