package com.paras.SpringSecEx.repo;

//import com.paras.SpringSecEx.model.User;
import com.paras.SpringSecEx.model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<student,Integer> {
    student findByUsername(String username);
}
