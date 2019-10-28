package com.ssm.student_system.controller;

import com.ssm.student_system.bean.Student;
import com.ssm.student_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author shixiaoyan
 * Date on 2019/10/15  11:27
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;



    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }


    /**
     * 添加学生
     */
    @RequestMapping("/addStudent")
    public String addStudent(Student student){
        this.studentService.addStudent(student);
        return "ok";
    }
    /**
     * 查询全部学生
     */
    @RequestMapping("/findStudentAll")
    public String findStudentAll(Model model){
        List<Student> list = this.studentService.findStudentAll();
        model.addAttribute("list", list);
        return "showStudent";
    }

    /**
     * 根据学生id查询学生
     */
    @RequestMapping("/findStudentById/{sid}")
    public String findStudentById(@PathVariable("sid") Integer sid, Model model){
        Student student = this.studentService.findStudentById(sid);
        model.addAttribute("student", student);
       return "findStudentById";
    }
/**
 *
 *
 *
 * */
    @RequestMapping("/editStudent")
    public String editStudent(Integer sid , Model model){
        Student student = this.studentService.findStudentById(sid);
        model.addAttribute("student", student);
        return "updateStudent";
    }

    /**
     * 更新用户
     */
    @RequestMapping("/editStudentComplete")
    public String editStudentComplete(Student student){
        this.studentService.updateStudent(student);
        return "ok";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delStudent")
    public String delStudent(Integer sid){
        this.studentService.deleteStudentById(sid);
        return "redirect:/student/findStudentAll";
    }


}
