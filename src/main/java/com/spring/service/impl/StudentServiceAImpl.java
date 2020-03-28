package com.spring.service.impl;


import com.spring.dao.StudentMapper;
import com.spring.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Map;


@Service
public class StudentServiceAImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceAImpl.class);
    @Resource
    private StudentServiceBImpl studentServiceB;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentServiceAImpl self;

    @Transactional
    public void insertStudent(Student student, int id) {
        studentMapper.insertStudent(student);
        studentServiceB.delete(id);
    }

    /**
     * 如果不加try catch事务不生效，数据插入失败
     * @param student
     * @param id
     */
    @Transactional
    public void insertStudent1(Student student, int id) {
        studentMapper.insertStudent(student);
        try {
            //Propagation.REQUIRES_NEW
            studentServiceB.deleteWithRequiresNew(id);
        }catch (Exception e) {
        }
    }


    /**
     * 可以插入成功
     * @param student
     * @param id
     */
    @Transactional
    public void insertStudent3(Student student, int id) {
        //REQUIRES_NEW
        studentServiceB.insertWithNew(student);
        studentMapper.delete(id);
    }


    /**
     * 数据插入失败
     * @param student
     * @param id
     */
    @Transactional
    public void insertStudent4(Student student, int id) {
        studentMapper.insertStudent(student);
        studentServiceB.deleteWithNested(id);
    }

    /**
     * insertStudent5加上@Transactional注解会报错
     *org.springframework.transaction.IllegalTransactionStateException: Existing transaction found for transaction marked with propagation 'never'
     * @param student
     */
    @Transactional
    public void insertStudent5(Student student) {
        //Propagation.NEVER
        studentServiceB.insertStudentWithNever(student);
        studentMapper.insertStudent(student);
    }


    /**
     * 如果当前方法没有使用事务，则会报错
     * org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction marked with propagation 'mandatory'
     * @param student
     */
    public void insertStudent6(Student student) {
        studentServiceB.insertStudentWithMandatory(student);
    }


    @Transactional
    public void insertStudent7(Student student, int id) {
        studentMapper.insertStudent(student);
        studentServiceB.deleteWithNotSupported(id);
    }


    /**
     * Propagation.SUPPORTS
     * 如果当前存在事务怎加入当前事务，否则以非事务方式运行
     *
     * 有异常不会回滚，数据可以插入到数据库
     * @param student
     */
    public void insertStudent8(Student student) {
        studentServiceB.insertStudentWithSupports(student);
        throw new RuntimeException();
    }




    public void testAop(Student student, int id) {
        System.out.println(student);
        System.out.println("id = " + id);
    }



    public void testMap(Map<String, String> paramMap) {
        LOGGER.info("paramMap = " + paramMap);
    }

    /**
     * 事务生效，数据不会插入，如果没有self事务不生效，数据会插入
     * @param student
     */
    public void innerTx(Student student) {
        self.insertWithTx(student);
    }

    @Transactional
    public void insertWithTx(Student student) {
        studentMapper.insertStudent(student);
        throw new RuntimeException();
    }
}
