package com.testmicroservice.deptapi.repository;

import com.testmicroservice.deptapi.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDeptId(Long deptId);
}
