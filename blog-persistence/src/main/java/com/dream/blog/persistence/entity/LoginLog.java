package com.dream.blog.persistence.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 登录/退出日志
 * </p>
 *
 * @author dreams color
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginLog extends Model<LoginLog> {

    private static final long serialVersionUID=1L;

    /**
     * 唯一主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 账户
     */
    private String account;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 操作时间
     */
    private LocalDateTime doTime;

    /**
     * 操作结果
     */
    private String result;

    /**
     * 失败原因
     */
    private String causeOfFailure;

    /**
     * ip
     */
    private String ip;

    /**
     * 日志类型（0：登录，1：退出）
     */
    private String doType;

    /**
     * 描述
     */
    private String description;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
