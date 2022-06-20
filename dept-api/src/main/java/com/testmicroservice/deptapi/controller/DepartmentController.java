package com.testmicroservice.deptapi.controller;

import com.testmicroservice.deptapi.entity.Department;
import com.testmicroservice.deptapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/{deptId}")
    Department getDepartment(@PathVariable Long deptId){
        return service.getDepartmentById(deptId);
    }

    @PostMapping("/add")
    Department addDepartment(@RequestBody Department dept){
        return service.addDepartment(dept);
    }
}
