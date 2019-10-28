package com.ssm.student_system.bean;

import java.io.Serializable;

/**
 * @Author shixiaoyan
 * Date on 2019/10/11  16:27
 */

public class Student implements Serializable {
    private Integer sid;
    private String sname;
    private Integer age;
    private Integer cid;
    private Integer state;
    private String sex;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", cid=" + cid +
                ", state=" + state +
                ", sex='" + sex + '\'' +
                '}';
    }
}

