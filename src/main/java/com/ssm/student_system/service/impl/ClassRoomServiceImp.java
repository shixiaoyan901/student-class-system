package com.ssm.student_system.service.impl;

import com.ssm.student_system.bean.ClassRoom;
import com.ssm.student_system.common.MyException;
import com.ssm.student_system.mapper.ClassRoomMapper;
import com.ssm.student_system.service.ClassRoomService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClassRoomServiceImp implements ClassRoomService {

    @Autowired
    private ClassRoomMapper classRoomMapper;

    @Override
    public void addClassRoom(ClassRoom classRoom) {
        this.classRoomMapper.insertClassRoom(classRoom);
    }

    @Override
    public void deleteClassRoomById(Integer cid) {
        this.classRoomMapper.deleteClassRoomById(cid);

    }

    @Override
    public void updateClassRoom(ClassRoom classRoom) {
        this.classRoomMapper.updateClassRoom(classRoom);

    }

    @Override
    public List<ClassRoom> findClassRoomAll() {

        return this.classRoomMapper.selectClassRoomAll();

    }

    @Override
    public ClassRoom findClassRoomById(Integer cid) {

        return this.classRoomMapper.selectClassRoomById(cid);
    }

    @Override
    public ClassRoom selectStudentByCid(Integer cid) {

        return this.classRoomMapper.selectStudentByCid(cid);
    }

    @Override
    public List<ClassRoom> selectClassRoom() {
        return classRoomMapper.selectClassRoom();
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;
        List<ClassRoom> classRoomList = new ArrayList<>();
        if(!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")){
            throw new MyException("上传文件格式不存在");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
            Workbook wb = null;
            if(isExcel2003){
                wb = new HSSFWorkbook(is);
            }else{
                wb = new XSSFWorkbook(is);
            }
            Sheet sheet = wb.getSheetAt(0);
            if (sheet !=null ){
                notNull = true;
            }
            ClassRoom classRoom;
//            r=2,表示从第3行开始循环
            for (int r =2;r<= sheet.getLastRowNum();r++){
//                通过sheet表单对象得到行对象
                Row row = sheet.getRow(r);
                if (row == null){
                    continue;
                }
//             sheet.getLastRowNum()的值是10，所以Excel表中的数据至少是10条，不然会报错空指针异常

                classRoom = new ClassRoom();
//                循环时，得到每一行的单元格进行判断
//
//
//                if (row.getCell(0).getCellType() !=1){
//                    throw new MyException("导入失败(第"+(r+1)+"行,班级请设为文本格式)");
//                }

////                得到每一行的第一个单元格的值
//                String cid = row.getCell(0).getStringCellValue();
////                判断是否为空
//                if (cid == null || cid.isEmpty()){
//                    throw new MyException("导入失败(第\"+(r+1)+\"行,班级id未填写)");
//                }
////                得到每一行的，第二个单元格的值
//                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//                String kind = row.getCell(1).getStringCellValue();
//
//                if (kind == null || kind.isEmpty()){
//                    throw new MyException("导入失败(第\"+(r+1)+\"行,班级类型未填写)");
//                }
//
////                完成的循环一次，组成一个对象
//                classRoom.setCid(cid);

                //得到每一行的第一个单元格的值
               //因为int不会为空，所以不能判断，直接从类型开始
//                int cid = (int) (row.getCell(0).getNumericCellValue());
//                得到每一行的，第二个单元格的值
                String kind = row.getCell(0).getStringCellValue();
//                if (kind == null || kind.isEmpty()){
//                    throw new MyException("导入失败(第\"+(r+1)+\"行,班级类型未填写)");
//                }

//                完整的循环一次，组成了一个对象
                //classRoom.setCid(cid);
                classRoom.setKind(kind);
                classRoomList.add(classRoom);
            }

            return notNull;
    }
 }
