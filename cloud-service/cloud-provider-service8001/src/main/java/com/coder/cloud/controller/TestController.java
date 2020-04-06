package com.coder.cloud.controller;

import com.coder.bean.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author liujin
 * @date created in 2020/4/6 16:03
 */
@RestController
@Slf4j
@RequestMapping("/provider")
public class TestController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String applicationName;
    @GetMapping("/get")
    public CommonResult<String> providerTest(){
        return new CommonResult(200,"访问成功","applicationName:"+applicationName+",i from port:"+serverPort);
    }

    @GetMapping("/get2")
    public CommonResult<String> providerTest2(){
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"访问成功","applicationName:"+applicationName+",i from port:"+serverPort);
    }
}
