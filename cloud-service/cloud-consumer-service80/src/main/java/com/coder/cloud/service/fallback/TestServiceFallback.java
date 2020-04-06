package com.coder.cloud.service.fallback;

import com.coder.api.bean.CommonResult;
import com.coder.cloud.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liujin
 * @date created in 2020/4/6 18:37
 */
@Component
@Slf4j
public class TestServiceFallback implements ITestService {
    @Override
    public CommonResult<String> providerTest() {
        return new CommonResult(500, "接口访问失败");
    }

    @Override
    public CommonResult<String> providerTest2() {
        return new CommonResult(500, "接口访问失败");
    }
}
