package com.liujin.token.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liujin.token.bean.User;

import java.util.Collection;
import java.util.List;

/**
 * @author liujin
 * @date created in 2020/2/19 12:13
 */
public interface IUserService extends IService<User> {

    Collection<User> getUserInfo();

    List<User> getUserInfo2();

    List<User> getUserInfo3();

    List<User> getUserInfo4();
    void remove(String id);
//     User getUserById(String userId);
}
