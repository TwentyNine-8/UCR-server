package com.ucr.vcener.config.yunSDKConfig;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.cvm.v20170312.CvmClient;
import org.springframework.context.annotation.Configuration;

/**
 * 腾讯云配置类
 * @author ymn
 * @date 2020/11/27 11:04
 */
@Configuration
public class TencentConfig {

    /**
     * 获取腾讯云连接对象
     *
     * @param secretId   secretId
     * @param secretKey  secretKey
     * @param describeId 地域id
     * @return CvmClient
     */
    public static CvmClient getCvmClient(String secretId, String secretKey, String describeId) {
        // 实例化一个认证对象，入参需要传入腾讯云账户 secretId、secretKey
        Credential cred = new Credential(secretId, secretKey);

        // 实例化要请求产品（以 cvm 为例）的 client 对象
        CvmClient client = new CvmClient(cred, "ap-guangzhou");
        return client;
    }
}
