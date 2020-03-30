package com.liujin.token.service.impl;

import com.liujin.token.bean.Menu;
import com.liujin.token.bean.MenuMete;
import com.liujin.token.common.RespBean;
import com.liujin.token.mapper.MenuMapper;
import com.liujin.token.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liujin
 * @date created in 2020/3/1 16:44
 */
@Slf4j
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public RespBean getAllMenu() {
        List<Menu> menus = menuMapper.fetchMenuByParentId(0);
        for (Menu menu : menus) {
            MenuMete mate=new MenuMete();
            mate.setTitle(menu.getTitle());
            mate.setIcon(menu.getIcon());
            menu.setMeta(mate);
            if (menu.getChildren()!=null){
                for (Menu child : menu.getChildren()) {
                    log.info("child:{}",child.getTitle());
                    MenuMete mate2=new MenuMete();
                    mate2.setTitle(child.getTitle());
                    mate2.setIcon(child.getIcon());
                    child.setMeta(mate2);
                    log.info("child:{}",child);
                }
            }
        }
        return RespBean.ok( "success",menus);
    }

    @Override
    public Map<String, Object> fetchMenus() {
        Map<String, Object> map=new HashMap<>();
        map.put("data",menuMapper.fetchMenu());
        return map;
    }
}
