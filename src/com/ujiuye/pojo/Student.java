package com.ujiuye.pojo;

import java.util.List;

/**
 * 学生
 */
public class Student {
    private int sid;
    private String sname;
    private List<StudentCourse> studentCourses;//一个学生对应多个中间

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }
}
