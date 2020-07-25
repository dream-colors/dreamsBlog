package com.dream.blog.admin.controller;

import com.dream.blog.commom.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名: AdminController
 * 描述:
 * 作者: 钟宗兵
 * 日期: 2020/7/25 16:35
 */
@RestController
public class AdminController {

    @GetMapping
    public ResponseResult<String> test() {

        return ResponseResult.success("welcome to my dreams blog");
    }
}
