package com.spring.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private  int id;

    private String name;

    private String sex;
}
