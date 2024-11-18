package com.paras.SpringSecEx.controller;

import com.paras.SpringSecEx.model.students;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController
{
    List<students> student =new ArrayList<>(Arrays.asList(new students(1,"paras",98)
            ,new students (2,"disha",99)));
    @GetMapping("/Student")
    public List<students> getAllStudents()
    {
        return student;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getcsrfToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/Student")
    public students addStudent(@RequestBody students stud)
    {
        student.add(stud);
        return stud;

    }
}
