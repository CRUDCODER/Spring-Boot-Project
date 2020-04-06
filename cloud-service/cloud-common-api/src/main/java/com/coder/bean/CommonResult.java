package com.coder.bean;

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
public class CommonResult<T> {
    private Integer code;

    private String message;

    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
