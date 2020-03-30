package com.liujin.token.service;

import com.liujin.token.common.RespBean;

import java.util.Map;

/**
 * @author liujin
 * @date created in 2020/3/1 16:44
 */
public interface IMenuService  {

    RespBean getAllMenu();


    Map<String,Object> fetchMenus();

}
