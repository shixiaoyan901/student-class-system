package com.ssm.student_system.service.impl;

import com.ssm.student_system.bean.Student;
import com.ssm.student_system.mapper.StudentMapper;
import com.ssm.student_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author shixiaoyan
 * Date on 2019/10/15  11:00
 */

@Service
@Transactional
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public void addStudent(Student student) {
        this.studentMapper.insertStudent(student);
    }

    @Override
    public void deleteStudentById(Integer sid) {
        this.studentMapper.deleteStudentById(sid);

    }

    @Override
    public void updateStudent(Student student) {
        this.studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> findStudentAll() {
        return this.studentMapper.selectStudentAll();
    }

    @Override
    public Student findStudentById(Integer sid) {
        return this.studentMapper.selectStudentById(sid);
    }
}
