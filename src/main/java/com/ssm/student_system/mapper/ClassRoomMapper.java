package com.ssm.student_system.mapper;

import com.ssm.student_system.bean.ClassRoom;
import com.ssm.student_system.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


//通过sql的映射文件来操作表

//<!-- 网址:https://mybatis.org/mybatis-3/getting-started.html-->
//<!-- 注解介绍参考:https://blog.csdn.net/xiao_____wu/article/details/81503203-->
//@Mapper或者@MapperScan将接口扫描装配到容器中
@Mapper
public interface ClassRoomMapper {

   ClassRoom selectClassRoomById(Integer cid);

    List<ClassRoom> selectClassRoomAll();

    void insertClassRoom(ClassRoom classRoom);

    void updateClassRoom(ClassRoom classRoom);

    void deleteClassRoomById(Integer cid);

//    根据班级id查询所有的学生
    ClassRoom selectStudentByCid(Integer cid);

//    文件的上传下载
    List<ClassRoom> selectClassRoom();

}

