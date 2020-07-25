package com.dream.blog.persistence.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章元素表（分类，标签，链接）
 * </p>
 *
 * @author dreams color
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArticleMeta extends Model<ArticleMeta> {

    private static final long serialVersionUID=1L;

    /**
     * 唯一主键
     */
    private Integer id;

    /**
     * 代号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 类型（0：分类，1：标签，2：链接）
     */
    private String type;

    /**
     * 状态（0：不可用，1：可用）
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime creationTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 用户id
     */
    private Integer userId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
