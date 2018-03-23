package com.spring.service.impl;



import com.spring.dao.StudentMapper;
import com.spring.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class StudentServiceBImpl {

    @Resource
    private StudentMapper studentMapper;

    @Transactional
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Transactional
    public void delete(int id) {
        studentMapper.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteWithRequiresNew(int id) {
        studentMapper.delete(id);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertWithNew(Student student) {
        studentMapper.insertStudent(student);
    }


    @Transactional(propagation = Propagation.NESTED)
    public void deleteWithNested(int id) {
        studentMapper.delete(id);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void insertStudentWithNever(Student student) {
        studentMapper.insertStudent(student);
    }


    @Transactional(propagation = Propagation.MANDATORY)
    public void insertStudentWithMandatory(Student student) {
        studentMapper.insertStudent(student);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void insertStudentWithNotSupport(Student student) {
        studentMapper.insertStudent(student);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void deleteWithNotSupported(int id) {
        studentMapper.delete(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void insertStudentWithSupports(Student student) {
        studentMapper.insertStudent(student);
    }
}
