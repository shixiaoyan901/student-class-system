package com.ssm.student_system.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author shixiaoyan
 * Date on 2019/10/11  15:46

 */

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

//    配置Druid的监控
//    1.配置一个管理后台的Servlet(statViewServlet)
    @Bean
    public ServletRegistrationBean statViewServlet(){
//        处理druid下的所有请求
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> intiParams = new HashMap<>();

        intiParams.put("loginUsername","admin");
        intiParams.put("loginPassword","123456");
        intiParams.put("allow","");//不写允许所有都可以访问。intiParams.put("allow","localhost");
        intiParams.put("deny","192.168.2.47");//拒绝访问

        bean.setInitParameters(intiParams);
        return bean;
    }
    //    2.配置一个web监控的filter(webStatFilter)
    public FilterRegistrationBean webStatFilter(){

        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());


        Map<String,String> intiParams = new HashMap<>();
//        不拦截静态的资源文件
        intiParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(intiParams);
//        拦截所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;

    }
}
