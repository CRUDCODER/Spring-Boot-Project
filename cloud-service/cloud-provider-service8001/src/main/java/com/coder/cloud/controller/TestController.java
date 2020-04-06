package com.coder.cloud.controller;

import com.coder.api.bean.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(tags = "提供者接口")
public class TestController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String applicationName;

    @ApiResponses({
            @ApiResponse(code = 200, message = "访问成功"),
            @ApiResponse(code = 500, message = "访问失败")
    })
    @ApiOperation(value = "获取应用名和端口号")
    @GetMapping("/get")
    public CommonResult<String> providerTest() {
        return new CommonResult(200, "访问成功", "applicationName:" + applicationName + ",i from port:" + serverPort);
    }
    @ApiResponses({
            @ApiResponse(code = 200, message = "访问成功"),
            @ApiResponse(code = 500, message = "访问失败")
    })
    @ApiOperation(value = "超时测试")
    @GetMapping("/get2")
    public CommonResult<String> providerTest2() {
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200, "访问成功", "applicationName:" + applicationName + ",i from port:" + serverPort);
    }
}
