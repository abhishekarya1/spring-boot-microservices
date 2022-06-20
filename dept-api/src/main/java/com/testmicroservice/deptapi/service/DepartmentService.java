package com.testmicroservice.deptapi.service;

import com.testmicroservice.deptapi.entity.Department;
import com.testmicroservice.deptapi.repository.DepartmentRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommonsLog
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department addDepartment(Department dept) {
        log.info("Adding Department...");
        return repository.save(dept);
    }

    public Department getDepartmentById(Long deptId) {
        return repository.findByDeptId(deptId);
    }
}
