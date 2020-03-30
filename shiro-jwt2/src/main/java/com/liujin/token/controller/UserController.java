package com.liujin.token.controller;

import com.liujin.token.bean.User;
import com.liujin.token.common.LoginFunction;
import com.liujin.token.common.RespBean;
import com.liujin.token.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liujin
 * @date created in 2020/2/19 11:15
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private LoginFunction loginFunction;

    @Autowired
    private IUserService userService;
    @PostMapping("/login")
    public RespBean login(@RequestBody User user){
      return   loginFunction.userLogin(user);
}
    @GetMapping("/getMessage/{message}")
    public String getMessage(@PathVariable("message") String message){
         return message;
    }
    @GetMapping("/getMessage")
    @RequiresRoles(value ={"admin","user"},logical = Logical.OR)
    public String getMessage(){
        return "success";
    }

    @GetMapping("/users")
    public Collection<User> getUserInfo(){
        return userService.getUserInfo();
    }

    @GetMapping("/users2")
    public List<User> getUserInfo2(){
        return userService.getUserInfo2();
    }
    @GetMapping("/users3")
    public List<User> getUserInfo3(){
        return userService.getUserInfo3();
    }
    @GetMapping("/users4")
    public List<User> getUserInfo4(){
        return userService.getUserInfo4();
    }

    @DeleteMapping("/user/{id}")
    @RequiresRoles("user")
    public void del(@PathVariable("id") String id){
        userService.remove(id);
    }

    @GetMapping("/menu")
    public Map<String,Object> menuTest(){
        Map<String,Object> map=new HashMap<>(16);
        map.put("message","success");
        return map;
    }

}
