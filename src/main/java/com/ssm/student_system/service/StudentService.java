package com.ssm.student_system.service;

import com.ssm.student_system.bean.Student;

import java.util.List;

/**
 * @Author shixiaoyan
 * Date on 2019/10/15  10:50
 */
public interface StudentService {



    void addStudent(Student student);

    void deleteStudentById(Integer sid);

    void updateStudent(Student student);

    List<Student> findStudentAll();

    Student findStudentById(Integer sid);





}
