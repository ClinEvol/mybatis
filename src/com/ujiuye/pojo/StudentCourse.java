package com.ujiuye.pojo;

/**
 * 中间表的实体类
 */
public class StudentCourse {
    private int scid;
    private int sid;
    private int cid;
    private Course course;//一个中间对应一个课程

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
