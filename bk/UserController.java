package com.example.spb.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spb.entity.User;
import com.example.spb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Objects;

// 接口实现
@RestController
// 前缀
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /*
    * 默认查询user表所有
    * */
    @GetMapping
    public List<User> index(){
        return userService.list();
    }

    /*
    * 新增-修改 旧版实现
    * */
//    @PostMapping("/mysave")
//    public Integer mySave(@RequestBody User user) {
//        return userService.mySave(user);
//    }

    /*
     * 新增-修改 mybatis plus实现
     * */
    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /*
    * 删除数据
    * */
    @DeleteMapping("/id={id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    /*
     * 批量删除数据
     * */
    @PostMapping("/del/batch")
    public boolean deleteBatch(@PathVariable List<Integer> ids){
        return userService.removeByIds(ids);
    }

    /*
     * 分页查询
     * */
    /*  @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String username){
        Integer startIndex = (pageNum - 1) * pageSize;
        Integer total = userMapper.selectTotal(username);
        String searchName = "%" + username + "%";
        List<User> data = userMapper.selectPage(startIndex, pageSize, searchName);
        Map<String, Object> result = new HashMap<>();
        result.put("data", data);
        result.put("total", total);
        return result;
    }*/

    /*
     * mybatis plus分页查询
     * */
    @GetMapping("/page")
    public IPage<User> findMbPage(@RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize,
                                  @RequestParam(defaultValue = "") String username,
                                  @RequestParam(defaultValue = "") String address,
                                  @RequestParam(defaultValue = "") String nickname,
                                  @RequestParam(defaultValue = "") String email,
                                  @RequestParam(defaultValue = "") String phone,
                                  @RequestParam(defaultValue = "") String avatar){
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!username.isEmpty(),"username", username);
        queryWrapper.like(!address.isEmpty(),"address", address);
        queryWrapper.like(!nickname.isEmpty(),"nickname", nickname);
        queryWrapper.like(!email.isEmpty(),"email", email);
        queryWrapper.like(!phone.isEmpty(),"phone", phone);
        queryWrapper.like(!avatar.isEmpty(),"avatar_url", avatar);
        return userService.page(page, queryWrapper);
    }
}
