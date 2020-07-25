package com.dream.blog.persistence.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章信息
 * </p>
 *
 * @author dreams color
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Article extends Model<Article> {

    private static final long serialVersionUID=1L;

    /**
     * 唯一主键
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 来源（1：自创，2：转载）
     */
    private String origin;

    /**
     * 作者id
     */
    private Integer authorId;

    /**
     * 作者姓名
     */
    private String authorName;

    /**
     * 创建时间
     */
    private LocalDateTime creationTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 访问路径
     */
    private String accessPath;

    /**
     * 分类，以英文半角分号分开
     */
    private String sort;

    /**
     * 标签，以英文板件分号分开
     */
    private String label;

    /**
     * 是否允许访问（0：否，1：是）
     */
    private String allowAccess;

    /**
     * 是否允许评论（0：否，1：是）
     */
    private String allowComments;

    /**
     * 是否设为隐私（0：否，1：是）
     */
    private String isPrivcly;

    /**
     * 是否置顶（0：否，1：是）
     */
    private String isStick;

    /**
     * 是否允许更新（0：否，1：是）
     */
    private String allowUpdate;

    /**
     * 点赞次数
     */
    private Integer likeTimes;

    /**
     * 踩次数
     */
    private Integer unLickTimes;

    /**
     * 访问次数
     */
    private Integer visitTimes;

    /**
     * 是否允许显示（0：否，1：是）
     */
    private String isCollection;

    /**
     * 是否允许评论（0：否，1：是）
     */
    private String isShowComments;

    /**
     * 用户id
     */
    private Integer userId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
