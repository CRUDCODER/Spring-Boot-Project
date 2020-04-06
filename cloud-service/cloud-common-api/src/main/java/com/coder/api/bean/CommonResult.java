package com.coder.api.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liujin
 * @date created in 2020/4/6 15:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "CommonResult",description = "用于响应给前端json数据")
public class CommonResult<T> {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "消息",dataType = "object")
    private String message;
    @ApiModelProperty(value = "结果集")
    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
