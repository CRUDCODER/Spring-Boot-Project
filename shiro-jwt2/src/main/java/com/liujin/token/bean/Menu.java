package com.liujin.token.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liujin
 * @date created in 2020/3/1 16:29
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String path;
    private String name;
    private String component;
    private Integer parentId;
    private  Integer enabled;
    private String title;
    private String icon;
    private boolean hidden;
    private String redirect;
    @TableField(exist = false)
    private MenuMete meta;
    @TableField(exist = false)
    private List<Menu> children;
}
