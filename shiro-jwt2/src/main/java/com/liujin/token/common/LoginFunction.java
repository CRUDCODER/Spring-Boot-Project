package com.liujin.token.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liujin.token.bean.User;
import com.liujin.token.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujin
 * @date created in 2020/2/19 15:28
 */
@Slf4j
@Component
public class LoginFunction {
    @Autowired
    private IUserService userService;
    @Autowired
    private JwtUtils jwtUtils;
    public RespBean userLogin(User user){
        User user1 = userService.getBaseMapper().selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        log.info("获取到用户详细信息:{}",user1);
        if (user1==null){
            return RespBean.error("账号不存在!");
        }
        if (!checkUserPassword(user1.getPassword(),user.getPassword())){
            return RespBean.error("密码错误");
        }
        if (user1.getBan()==1){
            return RespBean.error("该账号已被封禁!");
        }
        Map<String,Object> map=new HashMap<>(16);
        map.put("username",user.getUsername());
        return RespBean.ok("登录成功",jwtUtils.generateToken(map));
    }

    public boolean checkUserPassword(String userPassword,String inputPassword){
        return userPassword.equals(inputPassword);
    }
}
