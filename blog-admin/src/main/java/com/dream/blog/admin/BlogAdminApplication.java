package com.dream.blog.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 类名: BlogAdminApplication
 * 描述: 主启动程序
 * 作者: 钟宗兵
 * 日期: 2020/7/25 13:43
 */
@SpringBootApplication(scanBasePackages = {"com.dream.blog"})
@MapperScan("com.dream.blog.persistence.mapper")
@ServletComponentScan(basePackages = {"com.dream.blog.common.config"})
public class BlogAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogAdminApplication.class, args);
    }
}
