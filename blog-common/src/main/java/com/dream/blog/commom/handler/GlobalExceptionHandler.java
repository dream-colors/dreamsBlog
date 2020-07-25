package com.dream.blog.commom.handler;

import com.dream.blog.commom.exception.CustomException;
import com.dream.blog.commom.utils.ResponseResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * =======================
 * 类名: GlobalExceptionHandler
 * 描述：
 * 作者：dream colors
 * 日期：2020/7/15 0:49
 * 版本：1.0
 * =======================
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        System.out.println("请求有参数才进来");
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "dreams color");
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult<Object> handleException(Exception e, HttpServletRequest req){
        ResponseResult<Object> result;
        //业务异常
        if(e instanceof CustomException){
            result = ResponseResult.error(((CustomException) e).getCode(),((CustomException) e).getMsg());
        }else{//系统异常
            result = ResponseResult.error(500, "未知异常，请联系管理员" );
        }

        //使用HttpServletRequest中的header检测请求是否为ajax, 如果是ajax则返回json, 如果为非ajax则返回view(即ModelAndView)
        String contentTypeHeader = req.getHeader("Content-Type");
        String acceptHeader = req.getHeader("Accept");
        String xRequestedWith = req.getHeader("X-Requested-With");
        if ((contentTypeHeader != null && contentTypeHeader.contains("application/json"))
                || (acceptHeader != null && acceptHeader.contains("application/json"))
                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
            return result;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", e.getMessage());
            modelAndView.addObject("url", req.getRequestURL());
            modelAndView.addObject("stackTrace", e.getStackTrace()[0]);
            modelAndView.setViewName("error");
            return ResponseResult.error(modelAndView.getModel());
        }
    }
}
