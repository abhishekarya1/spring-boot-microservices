package com.testmicroservice.userapi.vo;

import com.testmicroservice.userapi.entity.Department;
import com.testmicroservice.userapi.entity.User;
import lombok.Data;

@Data
public class UserDepartment {
    private User user;
    private Department department;
}
