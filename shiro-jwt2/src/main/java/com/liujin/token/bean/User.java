package com.liujin.token.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liujin
 * @date created in 2020/2/19 10:43
 */
@Data
@TableName(value = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;

    private String username;

    private String password;

    private String role;

    private String permission;

    private Integer ban;
}
