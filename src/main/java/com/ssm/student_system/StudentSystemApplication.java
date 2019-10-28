package com.ssm.student_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//在写过mapper的接口后，要再此加上该注解 作用：指定要扫描的的mapper类的包路径
@MapperScan("com.ssm.student_system.mapper*")//@MapperScan 用户扫描MyBatis的Mapper接口
public class StudentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSystemApplication.class, args);
    }

}
