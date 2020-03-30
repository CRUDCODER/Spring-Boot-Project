package com.liujin.token.controller;

import com.liujin.token.common.RespBean;
import com.liujin.token.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liujin
 * @date created in 2020/3/1 16:53
 */
@RestController
public class MenuController {
    @Autowired
    private IMenuService menuService;


    @GetMapping("/menus")
    public RespBean fetchMenu(){
        return  menuService.getAllMenu();
    }
    @GetMapping("/fetchMenu")
    public Map<String,Object> fetchMenusa(){
        return menuService.fetchMenus();
    }

}
