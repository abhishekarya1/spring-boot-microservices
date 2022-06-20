package com.testmicroservice.userapi.entity;

import lombok.Data;

@Data
public class Department {
    Long deptId;
    String deptName;
    String deptBuilding;
}
