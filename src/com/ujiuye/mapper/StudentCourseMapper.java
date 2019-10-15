package com.ujiuye.mapper;

import com.ujiuye.pojo.StudentCourse;

import java.util.List;

public interface StudentCourseMapper {
    List<StudentCourse> listBySid(int sid);
}
