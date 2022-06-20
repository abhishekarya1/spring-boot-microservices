package com.testmicroservice.userapi.service;

import com.testmicroservice.userapi.entity.Department;
import com.testmicroservice.userapi.entity.User;
import com.testmicroservice.userapi.repository.UserRepository;
import com.testmicroservice.userapi.vo.UserDepartment;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@CommonsLog
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public UserDepartment getUserAndDepartment(long deptId){

        log.info("Fetching User and Department...");
        UserDepartment userDepartment = new UserDepartment();

        User user = repository.findByDeptId(deptId);
        log.info("User Object = " + user);
        Department dept = restTemplate.getForObject("http://localhost:9002/departments/" + user.getDeptId(), Department.class);

        userDepartment.setUser(user);
        userDepartment.setDepartment(dept);

        return userDepartment;
    }

    public User addUser(User user){
        return repository.save(user);
    }
}
