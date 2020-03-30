package com.liujin.token.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liujin.token.bean.User;
import com.liujin.token.mapper.UserMapper;
import com.liujin.token.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author liujin
 * @date created in 2020/2/19 12:13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    private static List<User> userList=null;
    private static Map<String,User> map=null;
    static {
        map=new HashMap<>(16);
        map.put("1",new User(1,"张三","123456","admin","all",0));
        map.put("2",new User(2,"张三","123456","admin","all",0));
        map.put("3",new User(3,"王五","123456","admin","all",0));
        map.put("4",new User(4,"赵六","123456","admin","all",0));
        userList=new ArrayList<>(16);
        userList.add(new User(1,"张三","123456","admin","all",0));
        userList.add(new User(2,"李四","123456","admin","all",0));
        userList.add(new User(3,"王五","123456","admin","all",0));
        userList.add(new User(4,"赵六","123456","admin","all",0));
    }


    @Override
    public Collection<User> getUserInfo() {
        return map.values();
    }

    @Override
    public List<User> getUserInfo2() {
        return Arrays.asList(
                new User(1,"张三","123456","admin","all",0),
                new User(2,"李四","123456","admin","all",0)
                );
    }

    @Override
    public List<User> getUserInfo3() {
        return Arrays.asList(
                new User(1,"张三","123456","admin","all",0)
        );
    }

    @Override
    public List<User> getUserInfo4() {
        return Arrays.asList(
                new User(1,"张三","123456","admin","all",0),
                new User(4,"赵六","123456","admin","all",0),
                new User(3,"王五","123456","admin","all",0)
                );
    }

    @Override
    public void remove(String id) {
        map.remove(id);
        System.out.println(map);
    }
//    @Override
//    public User getUserById(String userId){
//        return map.get(userId);
//    }
}
