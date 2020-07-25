package com.dream.blog.persistence.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 参数设置表
 * </p>
 *
 * @author dreams color
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Setting extends Model<Setting> {

    private static final long serialVersionUID=1L;

    /**
     * 唯一主键
     */
    private Integer id;

    /**
     * 参数名
     */
    private String key;

    /**
     * 参数值
     */
    private String value;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态（0：失效，1：生效）
     */
    private String status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
