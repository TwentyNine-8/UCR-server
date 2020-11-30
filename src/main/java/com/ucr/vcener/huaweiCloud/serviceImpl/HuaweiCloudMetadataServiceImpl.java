package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudMetadataService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudMetadataServiceImpl implements HuaweiCloudMetadataService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 删除云服务器指定元数据
     *
     */
    @Override
    public CommonResult DeleteServerMetadata() {
        DeleteServerMetadataRequest request = new DeleteServerMetadataRequest();
        try {
            DeleteServerMetadataResponse response = huaweiConfig.getClient().deleteServerMetadata(request);
            return CommonResult.ok(response);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (RequestTimeoutException e) {
            e.printStackTrace();
        } catch (ServiceResponseException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 更新云服务器元数据
     *
     */
    @Override
    public CommonResult UpdateServerMetadata() {
        UpdateServerMetadataRequest request = new UpdateServerMetadataRequest();
        try {
            UpdateServerMetadataResponse response = huaweiConfig.getClient().updateServerMetadata(request);
            return CommonResult.ok(response);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (RequestTimeoutException e) {
            e.printStackTrace();
        } catch (ServiceResponseException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }
}
