package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudFlavorService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudFlavorServiceImpl implements HuaweiCloudFlavorService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 查询规格详情和规格扩展信息列表
     *
     */
    @Override
    public CommonResult ListFlavors() {
        ListFlavorsRequest request = new ListFlavorsRequest();
        try {
            ListFlavorsResponse response = huaweiConfig.getClient().listFlavors(request);
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
     * 查询云服务器规格变更支持列表
     *
     */
    @Override
    public CommonResult ListResizeFlavors() {
        ListResizeFlavorsRequest request = new ListResizeFlavorsRequest();
        try {
            ListResizeFlavorsResponse response = huaweiConfig.getClient().listResizeFlavors(request);
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
