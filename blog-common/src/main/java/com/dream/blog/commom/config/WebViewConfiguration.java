package com.dream.blog.commom.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import java.util.Objects;


/**
 * =======================
 * 类名: WebViewConfiguration
 * 描述：视图配置类
 * 作者：dream colors
 * 日期：2020/7/15 0:11
 * 版本：1.0
 * =======================
 **/
@Configuration
public class WebViewConfiguration implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(WebViewConfiguration.class);

    @Value("${file.upload-path:E://temp/}")
    private String mImagesPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
                .addVersionStrategy(new ContentVersionStrategy(), "/**");
        // 配置静态文件访问路径
        registry
                .addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(2592000)
                .resourceChain(true)
                .addResolver(versionResourceResolver);
        // 解决swagger无法访问
        registry
                .addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry
                .addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        // 配置图片或者文件访问路径
        if (mImagesPath.equals("") || mImagesPath.equals("${file.upload-path}")) {
            String imagesPath = Objects.requireNonNull(WebViewConfiguration.class.getClassLoader().getResource("")).getPath();
            logger.info("1.上传配置类fileUploadPath" + imagesPath);
            if (imagesPath.indexOf(".jar") > 0) {
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            } else if (imagesPath.indexOf("classes") > 0) {
                imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/getfile/";
            mImagesPath = imagesPath;
        }
        logger.info("fileUploadPath=======" + mImagesPath);
        registry.addResourceHandler("/getfile/**").addResourceLocations("file:" + mImagesPath);
    }
}
