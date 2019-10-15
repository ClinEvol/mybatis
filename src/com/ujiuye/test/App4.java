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

public class App4 {
    //添加
    @Test
    public void testSave() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> list=new ArrayList<>();
        list.add(new Person(0,"李城地12",new Date(),"合肥"));
        list.add(new Person(0,"李城地23",new Date(),"合肥"));
        list.add(new Person(0,"李城地34",new Date(),"合肥"));
        list.add(new Person(0,"李城地45",new Date(),"合肥"));
        int result = mapper.saveByList(list);
        //手动提交事务   增 删除  改
        sqlSession.commit();
        if(result>0){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

        sqlSession.close();

    }



    @Test
    public void testRmove() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Integer> list=new ArrayList<>();
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);
        int result = mapper.removeByList(list);
        //手动提交事务   增 删除  改
        sqlSession.commit();
        if(result>0){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

        sqlSession.close();

    }
}
