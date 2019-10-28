package com.ssm.student_system.controller;

import com.ssm.student_system.bean.ClassRoom;
import com.ssm.student_system.service.ClassRoomService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


/**
 * @Author shixiaoyan
 * Date on 2019/10/23  15:23
 */
@Controller
public class IndexController {

    @Autowired
    private ClassRoomService classRoomService;

    @RequestMapping("/index")
    public String showClassRoom(Model model){
        List<ClassRoom> classRooms = classRoomService.selectClassRoom();
        model.addAttribute("classRoom",classRooms);
        return "index";
    }
//    导出文件
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws IOException{
        List<ClassRoom> classRooms = classRoomService.selectClassRoom();
//    创建excel对象
        HSSFWorkbook wb = new HSSFWorkbook();
//        创建sheet表单
        HSSFSheet sheet = wb.createSheet("获取班级excel测试表格");
        HSSFRow row = null;
//        创建第一个单元格
        row = sheet.createRow(0);
        row.setHeight((short)(26.25*20));
//        为第一行单元格设值
        row.createCell(0).setCellValue("班级信息列表");

        /*为标题设计空间
        * firstRow从第几行开始
        * lastRow从第几行结束
        *
        * 从第一个单元格开始，第三个单元格结束
        *
        * */

        CellRangeAddress rowRegion = new CellRangeAddress(0,0,0,2);
        sheet.addMergedRegion(rowRegion);

        /*动态数据库的列，sql语句*/
        /*第2行，含有列的名*/
        row = sheet.createRow(1);
//        设置行高
        row.setHeight((short)(22.50*20));
//        第一个单元格设值
        row.createCell(0).setCellValue("班级id");
//        第二个单元格设值
        row.createCell(1).setCellValue("班级类型");

        for (int i = 0;i<classRooms.size();i++){
            row = sheet.createRow(i+2);
            ClassRoom classRoom = classRooms.get(i);
            row.createCell(0).setCellValue(classRoom.getCid());
            row.createCell(1).setCellValue(classRoom.getKind());
        }

        sheet.setDefaultRowHeight((short)(16.5*20));
//        列宽自适应
        for (int i = 0;i<= 13;i++){
            sheet.autoSizeColumn(i);
        }
//???????????????????????????????????
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
//        默认Excel名称
        response.setHeader("Content-disposition","attachment;filename=class.xls");
        wb.write(os);
        os.flush();
        os.close();
    }

//    导入文件
    @RequestMapping(value = "/import")
    public String exImport(@RequestParam(value = "filename")MultipartFile file, HttpSession session){
        boolean a = false;
        String fileName = file.getOriginalFilename();

        try {
            a = classRoomService.batchImport(fileName,file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:index";
    }

//    获取单元格样式
    public HSSFCellStyle getStyle(HSSFWorkbook hssfWorkbook, Integer styleNum){
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
//       右边框
        style.setBorderRight(BorderStyle.THIN);
//       下边框
        style.setBorderBottom(BorderStyle.THIN);

        HSSFFont font = hssfWorkbook.createFont();
//        设置字体
        font.setFontName("微软雅黑");
//        生成platte颜色板，根据需要设置颜色
        HSSFPalette palette = hssfWorkbook.getCustomPalette();

        switch (styleNum){
            case(0):{
//                跨列居中
                style.setAlignment(HorizontalAlignment.CENTER_SELECTION);
//                粗体
                font.setBold(true);
//                设置字体大小
                font.setFontHeightInPoints((short)14);
                style.setFont(font);
//                替换颜色板中的颜色
                palette.setColorAtIndex(HSSFColor.BLUE.index,(byte)184,(byte)204,(byte)228);
                style.setFillForegroundColor(HSSFColor.BLUE.index);
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            }
            break;
            case (1): {
                font.setBold(true);//粗体
                font.setFontHeightInPoints((short) 11);//字体大小
                style.setFont(font);
            }
            break;
            case (2): {
                font.setFontHeightInPoints((short) 10);
                style.setFont(font);
            }
            break;
            case (3): {
                style.setFont(font);

                palette.setColorAtIndex(HSSFColor.GREEN.index, (byte) 0, (byte) 32, (byte) 96);//替换颜色板中的颜色
                style.setFillForegroundColor(HSSFColor.GREEN.index);
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            }
            break;
        }

        return style;
    }

}
