package com.example.spb.service.impl;

import com.example.spb.entity.User;
import com.example.spb.mapper.UserMapper;
import com.example.spb.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nibaba
 * @since 2024-01-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
