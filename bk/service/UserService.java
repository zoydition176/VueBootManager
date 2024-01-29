package com.example.spb.service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spb.entity.User;
import com.example.spb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// @Service注解表示要把当前的UserService类注入到springboot容器中，类似于前端的组件注册
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
//    @Autowired
//    private UserMapper userMapper;
//
//    public Integer mySave(User user){
//        if(user.getId() == null){
//            return userMapper.insert(user);
//        }else{
//            return userMapper.update(user);
//        }
//    }

    public boolean saveUser(User user) {
        return saveOrUpdate(user);
    }
}
