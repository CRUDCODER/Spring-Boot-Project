package com.liujin.token.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liujin.token.bean.User;
import com.liujin.token.common.JwtBean;
import com.liujin.token.common.JwtUtils;
import com.liujin.token.exception.UserException;
import com.liujin.token.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liujin
 * @date created in 2020/2/19 10:48
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     *          !!!!!!!!!!!!
     *  必须加上 不然无法使用token验证
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtBean;
    }

    /**
     * shiro+jwt 认证方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("正在执行token身份认证");
        String tokenCredentials= (String) token.getCredentials();
        //校验token是否正确 如果正确则解析token中的username 如果异常则由全局异常处理
        String username =  (String) jwtUtils.validateTokenAndGetClaims(tokenCredentials);
        log.info("获取username:{}",username);
        User user = userService.getBaseMapper().selectOne(new QueryWrapper<User>().eq("username", username));
        if (user==null){
            throw  new UserException("该账号不存在!");
        }
        int ban=user.getBan();
        if (ban==1){
            throw  new UserException("该账号已被封号!");
        }
        log.info("可以通行");
        return new SimpleAuthenticationInfo(tokenCredentials, tokenCredentials, getName());
    }


    /**
     * shiro + jwt用户授权方法
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        log.info("正在执行用户授权方法,获取到用户信息:{}",principals.toString());
        String username = jwtUtils.getUsernameByToken(principals.toString());
        User user = userService.getBaseMapper().selectOne(new QueryWrapper<User>().eq("username", username));
        Set<String> userRole=new HashSet<>();
        userRole.add(user.getRole());
        Set<String> userPermission=new HashSet<>();
        userPermission.add(user.getPermission());
        simpleAuthorizationInfo.setStringPermissions(userPermission);
        simpleAuthorizationInfo.setRoles(userRole);
        return simpleAuthorizationInfo;
    }

    /**
     * 单shiro操作认证方法
     * @param token
     * @return
     * @throws AuthenticationException
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Object credentials = token.getCredentials();
        log.info("jwtToken:{}",credentials);
        log.info("到了UserRealm的用户认证方法");
        UsernamePasswordToken passwordToken=(UsernamePasswordToken)token;
        User user = userService.getBaseMapper().selectOne(new QueryWrapper<User>().eq("username", passwordToken.getUsername()));
        log.info("{}",user);
        if (user==null){
            return null;
        }
        ByteSource salt = ByteSource.Util.bytes(passwordToken.getUsername());
        String realName=getName();
        return new SimpleAuthenticationInfo(user,user.getPassword(),salt,realName);
    }
    *单shiro 用户授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        log.info("到了UserRealm的用户授权方法");
        User user = (User) principals.getPrimaryPrincipal();
        log.info("{}",user);
        Set<String> roleSet=new HashSet<>();
        roleSet.add(user.getRole());
        Set<String> permissions=new HashSet<>();
        permissions.add(user.getPermission());
        simpleAuthorizationInfo.setRoles(roleSet);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
     */
}
