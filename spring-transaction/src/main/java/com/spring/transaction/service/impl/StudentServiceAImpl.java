package com.spring.transaction.service.impl;


import com.spring.transaction.dao.StudentMapper;
import com.spring.transaction.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class StudentServiceAImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceAImpl.class);


    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentServiceAImpl self;


    public void privateMethodWithTx(Student student) {
        self.addStudent(student);
    }

    /**
     * 如果要针对private 方法启用事务，动态代理方式的AOP不可行，需要使用静态织入方式的AOP，
     * 也就是在编译期间织入事务增强代码，可以配置Spring框架使用AspectJ来实现AOP。
     * @param student
     */
    @Transactional
    private void addStudent(Student student) {
        studentMapper.insertStudent(student);
        throw new RuntimeException();
    }

    @Transactional
    public void addWithTx(Student student) {
        studentMapper.insertStudent(student);
        throw new RuntimeException();
    }

    public void privateMethodWithTxWithoutSelf(Student student) {
        addStudent(student);
    }
}
