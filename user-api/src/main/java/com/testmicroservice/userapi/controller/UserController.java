package com.testmicroservice.userapi.controller;

import com.testmicroservice.userapi.entity.Department;
import com.testmicroservice.userapi.entity.User;
import com.testmicroservice.userapi.service.UserService;
import com.testmicroservice.userapi.vo.UserDepartment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CommonsLog
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{deptId}")
//    @CircuitBreaker(name="testBreaker", fallbackMethod = "fallBackGetUserDept")
    @Retry(name="testBreaker")
    UserDepartment getUserById(@PathVariable Long deptId) {
        log.info("Fetching User details by Department ID...");
        return service.getUserAndDepartment(deptId);
    }

    @PostMapping("/add")
    User addUser(@RequestBody User user) {
        log.info("Adding User...");
        return service.addUser(user);
    }

    UserDepartment fallBackGetUserDept(Exception e){
        UserDepartment ud = new UserDepartment();
        User u = new User();
        u.setUserName("Failure");
        ud.setUser(u);
        Department d = new Department();
        d.setDeptName("Failure");
        ud.setDepartment(d);
        return ud;
    }

}
