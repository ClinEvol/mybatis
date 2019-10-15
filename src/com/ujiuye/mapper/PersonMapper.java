package com.ujiuye.mapper;

import com.ujiuye.pojo.Person;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PersonMapper {
    List<Person> list();

    Person getById(int id);

    int save(Person person);
    int update(Person person);
    int removeById(int id);

    Person getByParam(@Param("name") String name, @Param("address") String address);

    Person getByMap(Map<String,Object> map);

    Person getByIndex(String name,String address);

    int count();

    int saveByList(List<Person> list);
    int removeByList(List<Integer> list);
    int saf();
}
