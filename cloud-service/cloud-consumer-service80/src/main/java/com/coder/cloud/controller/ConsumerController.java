package com.coder.cloud.controller;

import com.coder.api.bean.CommonResult;
import com.coder.cloud.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liujin
 * @date created in 2020/4/6 18:07
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class ConsumerController {
    @Resource
    private ITestService testService;

    @GetMapping("/get")
    public CommonResult<String> providerTest(){
        return testService.providerTest();
    }

    @GetMapping("/get2")
    public CommonResult<String> providerTest2(){
        return testService.providerTest2();
    }
}
