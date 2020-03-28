package com.spring.transaction.service.impl;

import com.spring.transaction.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml"})
public class StudentServiceAImplTest {

    @Resource
    private StudentServiceAImpl studentServiceA;

    /**
     * 事务生效，插入失败
     */
    @Test
    public void privateMethodWithTx() {
        Student student = new Student();
        student.setName("tom");
        student.setSex("0");
        studentServiceA.privateMethodWithTx(student);
    }

    /**
     * 事务生效，插入失败
     */
    @Test
    public void privateMethodWithTxWithoutSelfTest() {
        Student student = new Student();
        student.setName("tom");
        student.setSex("0");
        studentServiceA.privateMethodWithTxWithoutSelf(student);
    }

    /**
     * 事务生效，插入失败
     */
    @Test
    public void addWithTxTest() {
        Student student = new Student();
        student.setName("tom");
        student.setSex("0");
        studentServiceA.addWithTx(student);
    }
}
