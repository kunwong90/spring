package com.spring.dao;


import com.spring.entity.Student;

import java.util.List;

public interface StudentMapper {

    int insertStudent(Student student);


    void delete(int id);
}
