package com.dream.blog.persistence.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author dreams color
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    /**
     * 唯一主键
     */
    private Integer id;

    /**
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址
     */
    private String address;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 学校
     */
    private String school;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 特长
     */
    private String specialty;

    /**
     * 签名
     */
    private String signature;

    /**
     * 简介
     */
    private String intro;

    /**
     * 微博
     */
    private String microBlog;

    /**
     * 微信
     */
    private String weChat;

    /**
     * qq
     */
    private String qq;

    /**
     * github
     */
    private String gitHub;

    /**
     * 简书
     */
    private String bambooSlips;

    /**
     * 登录类型（1：账户密码登录，2：邮箱登录，3：微信登录，4：手机账号登录，5：qq登录
     */
    private String loginType;

    /**
     * 登录地址
     */
    private String loginIp;

    /**
     * 注册时间
     */
    @TableField("rigisterTime")
    private LocalDateTime rigisterTime;

    /**
     * 是否在线(1: 是，2：否）
     */
    private String isLogin;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
