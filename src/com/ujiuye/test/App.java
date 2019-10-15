package com.ujiuye.test;

import com.ujiuye.mapper.PersonMapper;
import com.ujiuye.pojo.Order;
import com.ujiuye.pojo.Person;
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
import java.util.Map;


public class App {

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
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> list = mapper.list();
        sqlSession.close();

        for (Person person:list) {
            System.out.println(person);
            if(person.getId()==2){
                System.out.println("-----------"+person.getName()+"的订单----------");
                List<Order> orders = person.getOrders();
                for (Order order:orders){
                    System.out.println(order);
                }
            }
            if(person.getId()==3){
                System.out.println(person.getCar());
            }

        }
    }
    //查单个对象
    @Test
    public void testGetById() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.getById(1);
        sqlSession.close();
        System.out.println(person);
    }

    //多个参数查单个对象
    @Test
    public void testGetByParam() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.getByParam(null,"北京市");
        sqlSession.close();
        System.out.println(person);
    }

    //多个参数查单个对象
    @Test
    public void testGetByIndex() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.getByIndex("梦琪","北京市");
        sqlSession.close();
        System.out.println(person);
    }

    //多个参数查单个对象
    @Test
    public void testGetByMap() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        HashMap<String,Object> map=new HashMap<String,Object>();
        map.put("name","梦琪");
        map.put("address","北京市");

        Person person = mapper.getByMap(map);
        sqlSession.close();
        System.out.println(person);
    }

    //多个参数查单个对象
    @Test
    public void testCount() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        ;

        int count = mapper.count();
        sqlSession.close();
        System.out.println(count);
    }


    //添加
    @Test
    public void testSave() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person=new Person(0,"李城地",new Date(),"合肥");
        int result = mapper.save(person);
        //手动提交事务   增 删除  改
        sqlSession.commit();
        if(result>0){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        System.out.println("id="+person.getId());
        sqlSession.close();
        System.out.println(person);
    }
    //修改
    @Test
    public void testUpdate() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person=new Person();
        person.setId(9);
        person.setName("李小气");
        int result = mapper.update(person);
        //手动提交事务   增 删除  改
        sqlSession.commit();
        if(result>0){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        sqlSession.close();
        System.out.println(person);
    }

    //删除
    @Test
    public void testRemove() throws IOException {
        String fileName="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(fileName);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

        int result = mapper.removeById(7);
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
