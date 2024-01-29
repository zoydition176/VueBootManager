package com.example.spb.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
// 指定表名
@TableName(value = "sys_user")
public class User {
    // 指定主键名 User类里面可以定义别名
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    // 忽略一个字段不展示
    @JsonIgnore
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    // 指定字段名
    @TableField(value = "avatar_url")
    private String avatar;
}
