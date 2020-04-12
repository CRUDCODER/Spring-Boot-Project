package com.coder.cloud.controller;

import cn.hutool.core.util.ObjectUtil;
import com.coder.api.bean.CommonResult;
import com.coder.api.bean.User;
import com.coder.api.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author pluviophile
 * @github https://github.com/CRUDCODER
 * @email 710683598@qq.com
 * @create 2020-04-10 14:22
 * @description
 */
@RestController
@Slf4j
public class CodeController {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private IUserService userService;
    /**
     * 用户注册给用户发送验证码
     * 存入redis key为用户编号 value为验证码
     * @param user
     * @return
     */
    @PostMapping("/code/user/register")
    public CommonResult<Object> userRegisterValidateCode(@RequestBody User user){
        log.info("正在注册的用户:{}",user);
        int random =(int)  (Math.random()*1000000);
        log.info("生成的验证码为:{}",random);
        try {
            redisTemplate.opsForValue().set(user.getUserId().toString(),random,90, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.debug("存入验证码出现异常:{}",e.getMessage());
            return new CommonResult<>(500,"fail",null);
        }
        return new CommonResult<>(200,"success",null);
    }

    /**
     * 验证用户输入验证码是否与账号相匹配
     * 验证成功之后添加用户
     * @param user
     * @param code
     * @return
     */
    @PostMapping("/code/user/check")
    public CommonResult<User> userCheckValidateCode(@RequestBody User user,@RequestParam("code") int code){
        log.info("获取到用户编号:{},输入验证码为:{}",user.getUserId(),code);
        int o = (int) redisTemplate.opsForValue().get(user.getUserId().toString());
        if (ObjectUtil.isNotEmpty(o)){
            if (o==code){
                return userService.userCommonResultCreate(user);
            }
        }
        return new CommonResult<>(500,"验证失败~!");
    }
}
