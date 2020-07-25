package com.dream.blog.commom.config;

/**
 * =======================
 * 类名: DruidConfig
 * 描述：
 * 作者：dream colors
 * 日期：2020/7/13 1:34
 * 版本：1.0
 * =======================
 **/
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * =======================
 * 类名: DruidConfiguration
 * 描述：druid数据源
 * 作者：dream colors
 * 日期：2020/7/14 23:57
 * 版本：1.0
 * =======================
 **/
@Configuration
public class DruidConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);

    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet() {
        logger.info("init Druid Servlet DruidConfig");
        ServletRegistrationBean<StatViewServlet> srBean = new ServletRegistrationBean<>();
        srBean.setServlet(new StatViewServlet());
        srBean.addUrlMappings("/druid/*");
        // IP白名单
        srBean.addInitParameter("allow", "127.0.0.1");
        // IP黑名单(共同存在时，deny优先于allow)
        //srBean.addInitParameter("deny", "192.168.1.100");
        //控制台管理用户
        srBean.addInitParameter("loginUsername", "admin");
        srBean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        srBean.addInitParameter("resetEnable", "false");
        return srBean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterBean = new FilterRegistrationBean<>(new WebStatFilter());
        filterBean.addUrlPatterns("/*");
        filterBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return filterBean;
    }
}
