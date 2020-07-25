package com.dream.blog.commom.config;

import com.dream.blog.commom.constant.Constant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * =======================
 * 类名: WebLogAspect
 * 描述：
 * 作者：dream colors
 * 日期：2020/7/12 18:40
 * 版本：1.0
 * =======================
 **/
@Aspect
@Component
public class WebLogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    //这个表达式的意思是，HelloLogCotroller这个controller下所有的方法都会切入
    @Pointcut(Constant.WEB_LOG_ASPECT_EXECUTION)
    public void setLogger(){}

    @Before("setLogger()")
    public void doBefore(JoinPoint joinPoint) {

        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("请求路径 : " + request.getRequestURL().toString());
        logger.info("请求类型 : " + request.getMethod());
        logger.info("请求地址 : " + request.getRemoteAddr());
        logger.info("请求接口 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        StringBuilder result = new StringBuilder();
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (CollectionUtils.isEmpty(parameterMap)) {
            result.append(Arrays.toString(joinPoint.getArgs()));
        } else {
            result.append("{");
            boolean flag = false;
            for (Map.Entry<String, String[]> map : parameterMap.entrySet()){
                String key = map.getKey();
                result.append(key).append(": ");
                if (CollectionUtils.isEmpty(Arrays.asList(map.getValue()))) {
                    result.append("null,");
                } else if (map.getValue().length == 1){
                    flag = true;
                    result.append(map.getValue()[0]).append(", ");
                } else if (map.getValue().length > 1){
                    result.append(Arrays.asList(map.getValue()));
                }
            }
            if (flag) {
                result.delete(result.length()-2, result.length());
            }
            result.append("}");
        }
        logger.info("请求参数 : " + result);
    }

    @AfterReturning(returning = "ret", pointcut = "setLogger()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        logger.info("请求耗时 : " + (System.currentTimeMillis() - startTime.get()) + "ms");
        logger.info("响应结果 : " + ret);
        System.out.println();
    }

}
