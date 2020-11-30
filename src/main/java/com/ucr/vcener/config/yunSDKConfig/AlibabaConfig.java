package com.ucr.vcener.config.yunSDKConfig;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author ymn
 * @date 2020/11/27 10:50
 */
@Component
@Data
public class AlibabaConfig {
    private IAcsClient client;

    public void setIAcdClient(String regionId, String accessKeyId, String accessKey) {
        // 创建DefaultAcsClient实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(
            regionId, // 您的地域ID
            accessKeyId, // 您的AccessKey ID
            accessKey
        ); // 您的AccessKey Secret
        this.client = new DefaultAcsClient(profile);
    }
}
