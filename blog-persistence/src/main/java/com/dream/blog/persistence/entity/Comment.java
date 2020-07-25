package com.dream.blog.persistence.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章评论信息
 * </p>
 *
 * @author dreams color
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Comment extends Model<Comment> {

    private static final long serialVersionUID=1L;

    /**
     * 唯一主键
     */
    private Integer id;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 评论者id
     */
    private Integer observerId;

    /**
     * 评论者姓名
     */
    private String observerName;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 父级评论id
     */
    private Integer parentCommentId;

    /**
     * 审核状态（0：待审核，1：审核通过，2：审核不通过）
     */
    private String auditStatus;

    /**
     * 支持数
     */
    private Integer supportTimes;

    /**
     * 反对数
     */
    private Integer unSupportTimes;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
