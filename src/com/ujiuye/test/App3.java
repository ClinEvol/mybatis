package com.ujiuye.test;

import com.ujiuye.mapper.PersonMapper;
import com.ujiuye.mapper.StudentMapper;
import com.ujiuye.pojo.Order;
import com.ujiuye.pojo.Person;
import com.ujiuye.pojo.Student;
import com.ujiuye.pojo.StudentCourse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class App3 {

    @Test
    public void testSelect() throws IOException {
        String fileName="mybatis-config.xml";
        //Resources是mybatis中提的一个IO工具类
        InputStream inputStream = Resources.getResourceAsStream(fileName);//ctr+alt+v
        //创建工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过工创建SqlSession
        SqlSession sqlSession = factory.openSession();
        //通过反射拿到接口对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.list();
        sqlSession.close();

        for (Student student:students) {
            System.out.println("-----------"+student.getSname()+"的课程----------");
            List<StudentCourse> studentCourses = student.getStudentCourses();
            for (StudentCourse sc:studentCourses){
                System.out.println(sc.getCourse().getCname());
            }
        }
    }

}
