package com.coder.api.service;

import com.coder.api.bean.CommonResult;
import com.coder.api.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author pluviophile
 * @github https://github.com/CRUDCODER
 * @email 710683598@qq.com
 * @create 2020-04-10 12:33
 * @description
 */
@FeignClient(value = "cloud-provider-user")
public interface IUserService {
    @GetMapping("/user/list")
    public List<User> getUserList();

    @PostMapping("/user/create")
    public CommonResult<User> userCommonResultCreate(@RequestBody User user);
}
