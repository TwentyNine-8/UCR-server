package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudBatchOperationService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudBatchOperationServiceImpl implements HuaweiCloudBatchOperationService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 批量重启云服务器
     *
     */
    @Override
    public CommonResult BatchRebootServers() {
        BatchRebootServersRequest request = new BatchRebootServersRequest();
        try {
            BatchRebootServersResponse response = huaweiConfig.getClient().batchRebootServers(request);
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
     * 批量启动云服务器
     *
     */
    @Override
    public CommonResult BatchStartServers() {
        BatchStartServersRequest request = new BatchStartServersRequest();
        try {
            BatchStartServersResponse response = huaweiConfig.getClient().batchStartServers(request);
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
     * 批量关闭云服务器
     *
     */
    @Override
    public CommonResult BatchStopServers() {
        BatchStopServersRequest request = new BatchStopServersRequest();
        try {
            BatchStopServersResponse response = huaweiConfig.getClient().batchStopServers(request);
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
