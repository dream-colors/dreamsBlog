package com.dream.blog.persistence.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 异常日志
 * </p>
 *
 * @author dreams color
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExceptionLog extends Model<ExceptionLog> {

    private static final long serialVersionUID=1L;

    /**
     * 唯一主键
     */
    private Integer id;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 请求url
     */
    private String url;

    /**
     * 操作时间
     */
    private LocalDateTime doTime;

    /**
     * 异常信息
     */
    private String exceptionInfo;

    /**
     * 异常类型（1：服务器异常，2：前端异常）
     */
    private String type;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
