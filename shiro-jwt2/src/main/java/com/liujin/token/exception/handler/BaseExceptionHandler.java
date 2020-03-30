package com.liujin.token.exception.handler;

import com.liujin.token.common.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

/**
 * @author liujin
 * @date created in 2020/2/19 18:15
 * 基础类型异常处理
 */
@RestControllerAdvice
public  class BaseExceptionHandler {
    @ExceptionHandler(ClassCastException.class)
    public RespBean classCastException(ClassCastException e, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return RespBean.error("类型转换异常",e.getMessage());
    }
//    @ExceptionHandler(RuntimeException.class)
//    public RespBean runtimeException(RuntimeException e,HttpServletResponse response){
//        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        return RespBean.error("运行环境异常",e.getMessage());
//    }
    @ExceptionHandler(NullPointerException.class)
    public RespBean nullPointerException(NullPointerException e,HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return RespBean.error("空指针异常",e.getMessage());
    }
    @ExceptionHandler(NumberFormatException.class)
    public RespBean numberFormatException(NumberFormatException e,HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return RespBean.error("数字转换异常",e.getMessage());
    }
    @ExceptionHandler(ParseException.class)
    public RespBean ParseException (ParseException  e,HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return RespBean.error("解析异常",e.getMessage());
    }

    @ExceptionHandler(ArithmeticException.class)
    public RespBean ParseException (ArithmeticException   e,HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return RespBean.error("数学运算异常",e.getMessage());
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException .class)
    public RespBean ParseException (ArrayIndexOutOfBoundsException    e,HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return RespBean.error("数组下标越界异常 ",e.getMessage());
    }

}
