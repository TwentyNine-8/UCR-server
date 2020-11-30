package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudTagService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudTagServiceImpl implements HuaweiCloudTagService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 批量添加云服务器标签
     *
     */
    @Override
    public CommonResult BatchCreateServerTags() {
        BatchCreateServerTagsRequest request = new BatchCreateServerTagsRequest();
        try {
            BatchCreateServerTagsResponse response = huaweiConfig.getClient().batchCreateServerTags(request);
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
     * 批量删除云服务器标签
     *
     */
    @Override
    public CommonResult BatchDeleteServerTags() {
        BatchDeleteServerTagsRequest request = new BatchDeleteServerTagsRequest();
        try {
            BatchDeleteServerTagsResponse response = huaweiConfig.getClient().batchDeleteServerTags(request);
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
     * 查询云服务器标签
     *
     */
    @Override
    public CommonResult ShowServerTags() {
        ShowServerTagsRequest request = new ShowServerTagsRequest();
        try {
            ShowServerTagsResponse response = huaweiConfig.getClient().showServerTags(request);
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
