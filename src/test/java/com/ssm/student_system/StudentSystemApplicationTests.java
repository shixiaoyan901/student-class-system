package com.ssm.student_system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentSystemApplicationTests {

    //    自动注入数据源，
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
//        查看数据源
        System.out.println(dataSource.getClass());
//        查看链接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }



}
