package com.ssm.student_system.bean;

import java.io.Serializable;
import java.util.List;

public class ClassRoom implements Serializable {
    private Integer cid;
    private String kind;
//    为了实现一对多关联查询，在班级实体添加学生集合
    private List<Student> studentList;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> student) {
        this.studentList = student;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "cid=" + cid +
                ", kind='" + kind + '\'' +
                '}';
    }
}
