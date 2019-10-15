package com.ujiuye.test;

import com.ujiuye.mapper.PersonMapper;
import com.ujiuye.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App5 {
    //测试一级缓存：同一个sqlSession的操作
    @Test
    public void testOneLevel() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.getById(1);
        System.out.println(person);

        mapper.save(new Person(0,"tomer",new Date(),"hf"));
        sqlSession.commit();

        Person person2 = mapper.getById(1);
        System.out.println(person2);
        sqlSession.close();

    }
    //二能级缓存：同一个mapper不同Sqlsession的操作
    @Test
    public void testTwoLevel() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        SqlSession sqlSession3 = factory.openSession();

        PersonMapper mapper1 = sqlSession1.getMapper(PersonMapper.class);
        PersonMapper mapper2 = sqlSession2.getMapper(PersonMapper.class);
        PersonMapper mapper3 = sqlSession3.getMapper(PersonMapper.class);

        Person p1 = mapper1.getById(1);
        System.out.println(p1);
        sqlSession1.close();

        mapper2.save(new Person(0,"tomer22",new Date(),"hf"));
        sqlSession2.commit();
        sqlSession2.close();

        Person p3 = mapper3.getById(1);
        System.out.println(p3);
        sqlSession3.close();
    }
}
