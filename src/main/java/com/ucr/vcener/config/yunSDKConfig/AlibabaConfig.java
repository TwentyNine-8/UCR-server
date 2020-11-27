package com.ucr.vcener.config.yunSDKConfig;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.context.annotation.Configuration;

/**
 * @author ymn
 * @date 2020/11/27 10:50
 */
@Configuration
public class AlibabaConfig {

    public static IAcsClient getIAcdClient(String regionId, String accessKeyId, String accessKey) {
        // 创建DefaultAcsClient实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(
            regionId, // 您的地域ID
            accessKeyId, // 您的AccessKey ID
            accessKey
        ); // 您的AccessKey Secret
        IAcsClient client = new DefaultAcsClient(profile);
        return client;
    }
}
