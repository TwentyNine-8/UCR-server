package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudNetworkService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudNetworkServiceImpl implements HuaweiCloudNetworkService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 批量添加云服务器网卡
     *
     */
    @Override
    public CommonResult BatchAddServerNics() {
        BatchAddServerNicsRequest request = new BatchAddServerNicsRequest();
        try {
            BatchAddServerNicsResponse response = huaweiConfig.getClient().batchAddServerNics(request);
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
     * 批量删除云服务器网卡
     *
     */
    @Override
    public CommonResult BatchDeleteServerNics() {
        BatchDeleteServerNicsRequest request = new BatchDeleteServerNicsRequest();
        try {
            BatchDeleteServerNicsResponse response = huaweiConfig.getClient().batchDeleteServerNics(request);
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
     * 查询云服务器网卡信息
     *
     */
    @Override
    public CommonResult ListServerInterfaces() {
        ListServerInterfacesRequest request = new ListServerInterfacesRequest();
        try {
            ListServerInterfacesResponse response = huaweiConfig.getClient().listServerInterfaces(request);
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
