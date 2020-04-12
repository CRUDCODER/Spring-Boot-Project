package com.coder.api.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author pluviophile
 * @github https://github.com/CRUDCODER
 * @email 710683598@qq.com
 * @create 2020-04-10 12:32
 * @description
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@ApiModel(description = "用户信息模型")
public class User implements Serializable {
    @ApiModelProperty(value = "用户编号")
    @TableId(type = IdType.AUTO)
    private Long userId;
    @ApiModelProperty(value = "用户姓名")
    private String userName;
}
