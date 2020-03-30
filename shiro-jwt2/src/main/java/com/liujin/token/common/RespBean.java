package com.liujin.token.common;

import java.io.Serializable;

/**
 * @author liujin
 * @date created in 2019/11/17 11:40
 */
public class RespBean implements Serializable {
    private String msg;
    private Object data;
    private Integer status;

    public static RespBean ok(String msg,Object data){
        return new RespBean(200,msg,data);
    }

    public static RespBean ok(String msg){
        return new RespBean(200,msg,null);
    }

    public static RespBean error(String msg,Object data){
        return new RespBean(500,msg,data);
    }

    public static RespBean error(String msg){
        return new RespBean(500,msg,null);
    }

    public RespBean(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public RespBean() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
