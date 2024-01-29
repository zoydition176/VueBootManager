package com.example.spb.entity;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author nibaba
 * @since 2024-01-21
 */
@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "User对象", description = "")
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Alias("用户名")
    private String username;

    @Alias("密码")
    private String password;

    @Alias("昵称")
    private String nickname;

    @Alias("邮箱")
    private String email;

    @Alias("手机")
    private String phone;

    @Alias("地址")
    private String address;

    @Alias("头像")
    private String avatarUrl;
}
