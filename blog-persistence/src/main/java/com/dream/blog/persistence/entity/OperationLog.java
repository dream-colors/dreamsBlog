package com.dream.blog.persistence.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author dreams color
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OperationLog extends Model<OperationLog> {

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
     * 用户姓名
     */
    private String userName;

    /**
     * ip
     */
    private String ip;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 操作类型（A：新增，U: 更新, D：删除，Q：查询）
     */
    private String doType;

    /**
     * 操作结果（0：失败，1：成功）
     */
    private String result;

    /**
     * 操作时间
     */
    private LocalDateTime doTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 响应结果
     */
    private String responseData;

    /**
     * 所处模块
     */
    private String module;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
