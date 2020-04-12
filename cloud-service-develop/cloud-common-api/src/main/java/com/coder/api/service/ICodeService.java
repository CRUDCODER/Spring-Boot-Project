package com.coder.api.service;

import com.coder.api.bean.CommonResult;
import com.coder.api.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author pluviophile
 * @github https://github.com/CRUDCODER
 * @email 710683598@qq.com
 * @create 2020-04-10 14:39
 * @description
 */
@FeignClient(value = "cloud-provider-validate-code")
public interface ICodeService {

    /**
     * 用户注册给用户发送验证码
     * 存入redis key为用户编号 value为验证码
     * @param user
     * @return
     */
    @PostMapping("/code/user/register")
    public CommonResult<Object> userRegisterValidateCode(@RequestBody User user);

    /**
     * 验证用户输入验证码是否与账号相匹配
     * @param user
     * @param code
     * @return
     */
    @PostMapping("/code/user/check")
    public CommonResult<User> userCheckValidateCode(@RequestBody User user,@RequestParam("code") int code);
}
