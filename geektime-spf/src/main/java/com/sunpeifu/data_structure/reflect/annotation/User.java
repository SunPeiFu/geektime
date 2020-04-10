package com.sunpeifu.data_structure.reflect.annotation;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表 
 * </p>
 *
 * @author mybatis-plus
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("claim_c_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private String userId;

    @TableField("channel_id")
    private String channelId;

    @TableField("scene_id")
    private String sceneId;

    @TableField("channel_user_id")
    private String channelUserId;

    @TableField("auth_status")
    private Integer authStatus;

    @TableField("auth_success_time")
    private String authSuccessTime;

    @TableField("id_card")
    private String idCard;

    @TableField("id_card_type")
    private Integer idCardType;

    @TableField("bank_no")
    private String bankNo;

    @TableField("phone")
    private String phone;

    @TableField("name")
    private String name;

    @TableField("sex")
    private Integer sex;

    @TableField("birthday")
    private String birthday;

    @TableField("image_url")
    private String imageUrl;

    @TableField("parent_id")
    private String parentId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("is_deleted")
    private Integer deleted;


}
