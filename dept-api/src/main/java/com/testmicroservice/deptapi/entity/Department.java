package com.testmicroservice.deptapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long deptId;
    String deptName;
    String deptBuilding;
}
