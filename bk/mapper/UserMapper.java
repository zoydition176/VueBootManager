package com.example.spb.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spb.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// @mapper注解表示要把当前的userMapper类注入到springboot容器中，类似于前端的组件注册
// 定义数据库查询方法，返回UserMapper接口
//@Mapper
public interface UserMapper extends BaseMapper<User> {
/*    @Select("SELECT * from sys_user")
    List<User> findAll();

    // #{}里面的是接收到的值
    @Insert("INSERT into sys_user(username, password, nickname, email, phone, address, avatar_url) VALUES (#{username}, #{password}, #{nickname}, #{email}, #{phone}, #{address}, #{avatar})")
    int insert(User user);

    int update(User user);

    @Delete("delete from sys_user where id = #{id}")
    int deleteById(@Param("id") Integer id);

    @Select("SELECT * from sys_user where username like #{username} limit #{startIndex}, #{endIndex}")
    List<User> selectPage(Integer startIndex, Integer endIndex, String username);

    @Select("SELECT count(*) from sys_user where username like #{username}")
    Integer selectTotal(String username);*/
}
