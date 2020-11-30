package com.ucr.vcener.config.yunSDKConfig;

import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.ecs.v2.EcsClient;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.nio.file.attribute.AclEntry;

/**
 * 华为云配置类
 *
 * @author xuww
 * @date 2020/11/27 15:44
 */
@Component
@Data
public class HuaweiConfig {

private EcsClient client;
    /**
     * 获取华为云连接对象
     * @param ak  华为云账号 Access Key
     * @param sk  华为云账号 Secret Access Key
     * @param projectId 云服务所在项目 ID
     * @param endpoint
     * @return CvmClient
     */
    public void setCvmClient(String ak, String sk, String projectId ,String endpoint) {

        // 创建认证
        ICredential auth = new BasicCredentials()
            .withProjectId(projectId)
            .withAk(ak)
            .withSk(sk);

        // 初始化指定云服务的客户端 {Service}Client 以初始化 EcsClient 为例
         this.client = EcsClient.newBuilder()
            .withCredential(auth)
            .withEndpoint(endpoint)
            .build();

    }
}
