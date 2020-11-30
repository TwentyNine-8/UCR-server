package com.ucr.vcener.common;

import com.ucr.vcener.config.yunSDKConfig.AlibabaConfig;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AliAspect {
    @Autowired
    private AlibabaConfig alibabaConfig;

    @Pointcut("execution(* com.ucr.vcener.alibabaCloud..*(..))")
    public void aliCut() {}

    @Before("aliCut()")
    public void setAliClient() {
        // TODO: 2020/11/27 查询阿里云相关配置参数
        alibabaConfig.setIAcdClient("", "", "");
    }
}
