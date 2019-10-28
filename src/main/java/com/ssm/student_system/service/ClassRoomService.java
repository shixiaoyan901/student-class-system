package com.ssm.student_system.service;

import com.ssm.student_system.bean.ClassRoom;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface ClassRoomService {

    void addClassRoom(ClassRoom classRoom);

    void deleteClassRoomById(Integer cid);

    void updateClassRoom(ClassRoom classRoom);

    List<ClassRoom> findClassRoomAll();

    ClassRoom findClassRoomById(Integer cid);
//一对多查询
    public ClassRoom selectStudentByCid(Integer cid);

//文件的上传下载
    List<ClassRoom> selectClassRoom();

    boolean batchImport(String fileName, MultipartFile file) throws Exception;

}
