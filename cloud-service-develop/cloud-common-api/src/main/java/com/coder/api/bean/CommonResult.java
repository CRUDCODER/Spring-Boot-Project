package com.coder.api.bean;

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
 * @create 2020-04-10 12:34
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "公共响应数据模型")
public class CommonResult<T> implements Serializable {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "信息")
    private String message;
    @ApiModelProperty(value = "响应数据",dataType = "Object")
    private T data;
    public CommonResult(Integer code,String message)
    {
        this(code,message,null);
    }

}
