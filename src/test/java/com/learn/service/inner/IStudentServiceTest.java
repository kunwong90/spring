package com.learn.service.inner;



import com.google.common.collect.Maps;
import com.spring.entity.Student;
import com.spring.service.impl.StudentServiceAImpl;
import com.spring.service.impl.StudentServiceBImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wangkun on 2017/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml"})
public class IStudentServiceTest {

    @Resource
    StudentServiceAImpl studentServiceA;


    @Resource
    StudentServiceBImpl studentServiceB;

    @Test
    public void required() {
        studentServiceA.insertStudent(assembleStudent(), 1);
    }

    @Test
    public void test1() {
        studentServiceA.insertStudent1(assembleStudent(), 1);
    }




    @Test
    public void test3() {
        studentServiceA.insertStudent3(assembleStudent(), 1);
    }


    @Test
    public void test4() {
        studentServiceA.insertStudent4(assembleStudent(), 1);
    }


    @Test
    public void test5() {
        studentServiceA.insertStudent5(assembleStudent());
    }

    @Test
    public void test6() {
        studentServiceA.insertStudent6(assembleStudent());
    }


    @Test
    public void test7() {
        studentServiceA.insertStudent7(assembleStudent(),1);
    }

    @Test
    public void test8() {
        studentServiceA.insertStudent8(assembleStudent());
    }
    private Student assembleStudent() {
        Student student = new Student();
        student.setName("侯亮平");
        student.setSex("0");
        return student;
    }

    

    @Test
    public void testAop() {
        studentServiceA.testAop(assembleStudent(), 11);
    }

    @Test
    public void testMap() {
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("name", "zhangsan");
        studentServiceA.testMap(paramMap);
    }

    @Test
    public void innerTxTest() {
        studentServiceA.innerTx(assembleStudent());
    }
}
