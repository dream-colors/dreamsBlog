package com.dream.blog.commom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;
/**
 * 类名: SwaggerConfiguration
 * 描述: swagger配置
 * 作者: 钟宗兵
 * 日期: 2020/7/25 13:08
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

//    @Value("${server.servlet-path}")
//    private String pathMapping;

    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("dreams blog restful API")
                //条款地址
                .termsOfServiceUrl("http://despairyoke.github.io/")
                .version("1.0")
                //描述
                .description(initContextInfo())
                .build();
    }
    private String initContextInfo() {
        return "api描述";
    }


    @Bean
    public Docket restfulApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("RestfulApi")
//                .genericModelSubstitutes(DeferredResult.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
//                .pathMapping(pathMapping) // base，最终调用接口后会和paths拼接在一起
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.dream.blog.*.controller"))
//                .paths((com.google.common.base.Predicate<String>) doFilteringRules())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * 设置过滤规则
     * 这里的过滤规则支持正则匹配
     * @return
     */
    private Predicate<String> doFilteringRules() {
        return ((Predicate<String>) regex("/hello.*")::apply).or(regex("/vehicles.*")::apply);
    }

}
