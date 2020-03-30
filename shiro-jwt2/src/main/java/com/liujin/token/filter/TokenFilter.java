package com.liujin.token.filter;

import com.liujin.token.common.JwtBean;
import com.liujin.token.common.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author liujin
 * @date created in 2019/11/14 20:52
 */
@Slf4j
public class TokenFilter extends FormAuthenticationFilter {

    private JwtUtils jwtUtils;

    public TokenFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        log.info("匹配到了需要拦截的请求正在TokenFilter的onAccessDenied方法进行处理");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            log.info("捕获到跨域options请求,直接放行,请求地址为:{}", servletPath);
            return true;
        }
        if (isHasHeader(request)) {
            try {
                execteLogin(servletRequest, servletResponse);
                return true;
            } catch (Exception e) {
                responseError(request,response, e);
                return false;
            }
        } else {
            //如果token为空 则重定向 重定向方法抛出异常 因为filter抛出的异常 无法捕获
            //请求进来 会按照 filter -> interceptor -> controllerAdvice -> aspect  -> controller的顺序调用
            //当controller返回异常 也会按照controller -> aspect -> controllerAdvice -> interceptor -> filter来依次抛出
            //所以在filter抛出异常 无法进行捕获 只有重定向之后 再次进行抛出
            response.sendRedirect(request.getContextPath() + "/error/rethrow");
            return false;
        }
    }

    public boolean isHasHeader(HttpServletRequest request) {
        String header = request.getHeader(jwtUtils.getHEADER_NAME());
        if (header != null) {
            log.info("获取到token:{}", header);
            return true;
        }
        return false;
    }

    public boolean execteLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String header = httpServletRequest.getHeader(jwtUtils.getHEADER_NAME());
        JwtBean jwtBean = new JwtBean(header);
        getSubject(request, response).login(jwtBean);
        return true;
    }

    /**
     * 将非法请求跳转到 /error/userException/
     */
    private void responseError(HttpServletRequest request,HttpServletResponse response, Exception e) throws ServletException, IOException {

        request.setAttribute("filter.error",e);
        request.setAttribute("path",request.getServletPath());
        request.getRequestDispatcher("/error/jwtException").forward(request,response);
        //设置编码，否则中文字符在重定向时会变为空字符串
//            message = URLEncoder.encode(message, "UTF-8");
//            httpServletResponse.sendRedirect("/error/userException?message=" + message);

    }

    /**
     * jwt验证失败
     *
     * @param response
     * @param message
     */
    private void responseJwtError(ServletResponse response, String message) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            //设置编码，否则中文字符在重定向时会变为空字符串
            message = URLEncoder.encode(message, "UTF-8");
            httpServletResponse.sendRedirect("/error/JweException/" + message);
        } catch (IOException e) {

        }
    }
}
