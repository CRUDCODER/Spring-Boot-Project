package com.liujin.token.mapper;

import com.liujin.token.bean.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujin
 * @date created in 2020/3/1 16:45
 */
public interface MenuMapper {


    List<Menu> fetchMenu();


    List<Menu> fetchMenuByParentId(@Param("parentId") Integer parentId);

}
