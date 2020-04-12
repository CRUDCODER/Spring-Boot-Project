package com.coder.cloud.controller;

import cn.hutool.core.util.ObjectUtil;
import com.coder.api.bean.CommonResult;
import com.coder.api.bean.User;
import com.coder.cloud.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author pluviophile
 * @github https://github.com/CRUDCODER
 * @email 710683598@qq.com
 * @create 2020-04-10 12:47
 * @description
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private DataSource dataSource;
    @Resource
    private UserMapper userMapper;

    /**
     * 获取所有用户信息
     * @return
     */
    @GetMapping("/list")
    public CommonResult<User> userCommonResultList() {
        return new CommonResult(200, "success", userMapper.selectList(null));
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/create")
    public CommonResult<User> userCommonResultCreate(@RequestBody User user) {
        if (ObjectUtil.isEmpty(user)) {
            return new CommonResult(500, "fail", null);
        }
        userMapper.insert(user);
        return new CommonResult(200, "success", user);
    }
}
