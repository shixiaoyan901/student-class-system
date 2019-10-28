package com.ssm.student_system.mapper;

import com.ssm.student_system.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {


    Student selectStudentById(Integer sid);

    List<Student> selectStudentAll();

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(Integer sid);



}
