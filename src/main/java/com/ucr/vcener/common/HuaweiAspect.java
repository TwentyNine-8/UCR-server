package com.ucr.vcener.common;

import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 华为云切面
 * @author xuww
 * @date 2020/11/27 15:50
 */
@Aspect
@Component
public class HuaweiAspect {
    @Autowired
    private HuaweiConfig huaweiConfig;

    @Pointcut("execution(* com.ucr.vcener.huaweiCloud..*(..))")
    public void huaweiCut() {}

    /**
     * 构建华为云连接对象
     */
    @Before("huaweiCut()")
    public void setHuaweiClient() {
        // TODO: 2020/11/27 查询华为云相关配置参数
        huaweiConfig.setCvmClient("", "", "", "");
    }
}
