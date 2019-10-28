package com.ssm.student_system.controller;

import com.ssm.student_system.bean.ClassRoom;
import com.ssm.student_system.mapper.ClassRoomMapper;
import com.ssm.student_system.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/class")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;


    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    /**
     * 添加班级
     */
    @RequestMapping("/addClassRoom")
    public String addClassRoom(ClassRoom classRoom) {
        this.classRoomService.addClassRoom(classRoom);
        return "ok1";
    }

    /**
     * 查询全部班级
     */
    @RequestMapping("/findClassRoomAll")
    public String findClassRoomAll(Model model) {
        List<ClassRoom> list = this.classRoomService.findClassRoomAll();
        model.addAttribute("list", list);
        return "showClassRoom";
    }

    /**
     * 根据班级id查询班级
     */
    @RequestMapping("/findClassRoomById")
    public String findClassRoomById(Integer cid, Model model) {
        ClassRoom classRoom = this.classRoomService.findClassRoomById(cid);
        model.addAttribute("classRoom", classRoom);
        return "updateClassRoom";
    }

    /**
     * 更新班级
     */
    @RequestMapping("/editClassRoom")
    public String editClassRoom(ClassRoom classRoom) {
        this.classRoomService.updateClassRoom(classRoom);
        return "ok1";
    }

    /**
     * 删除班级
     */
    @RequestMapping("/delClassRoom")
    public String delClassRoom(Integer cid) {
        this.classRoomService.deleteClassRoomById(cid);
        return "redirect:/class/findClassRoomAll";
    }

  /**
    * 根据班级id查询所有的学生
    */

//在地址栏输入url路径，效果见笔记
//  @RequestMapping("/selectStudentByCid/{cid}")
//  @ResponseBody
  @RequestMapping("/selectStudentByCid/{cid}")
    public String getStudent(@PathVariable("cid") Integer cid,Model model){
      ClassRoom classRoom = this.classRoomService.selectStudentByCid(cid);
      model.addAttribute("classRoom", classRoom);//手动时删掉
      //return classRoom;
      return "selectStudentByCid";
  }
}
