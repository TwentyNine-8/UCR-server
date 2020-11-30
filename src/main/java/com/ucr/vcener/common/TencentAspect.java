package com.ucr.vcener.common;

import com.netflix.discovery.converters.Auto;
import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 腾讯云切面
 * @author ymn
 * @date 2020/11/27 11:30
 */
@Aspect
@Component
public class TencentAspect {
    @Autowired
    private TencentConfig tencentConfig;

    @Pointcut("execution(* com.ucr.vcener.tencentCloud..*(..))")
    public void tencentCut() {}

    /**
     * 构建腾讯云连接对象
     */
    @Before("tencentCut()")
    public void setTencentClient() {
        // TODO: 2020/11/27 查询腾讯云相关配置参数
        tencentConfig.setCvmClient("", "", "");
    }
}
