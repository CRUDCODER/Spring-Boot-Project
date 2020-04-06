package com.coder.cloud.service;

import com.coder.bean.CommonResult;
import com.coder.cloud.service.fallback.TestServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liujin
 * @date created in 2020/4/6 18:05
 */
@FeignClient(name = "CLOUD-PROVIDER-SERVICE",fallback = TestServiceFallback.class)
public interface ITestService {
    /**
     * 调用CLOUD-PROVIDER-SERVICE服务中的/provider/get接口
     * 主要测试正常请求数据返回
     * @return
     */
    @GetMapping("/provider/get")
    public CommonResult<String> providerTest();

    /**
     * 调用CLOUD-PROVIDER-SERVICE服务中的/provider/get2接口
     * 主要测试超时之后fallback回调
     * @return
     */
    @GetMapping("/provider/get2")
    public CommonResult<String> providerTest2();

//    /**
//     * 内部类
//     * FeignFallback处理方法
//     * 可以选择此种方法 避免类太多混淆
//     */
//    @Component
//    class TestServiceFallback implements ITestService{
//        @Override
//        public CommonResult<String> providerTest() {
//            return new CommonResult(500,"接口访问失败");
//        }
//    }
}

