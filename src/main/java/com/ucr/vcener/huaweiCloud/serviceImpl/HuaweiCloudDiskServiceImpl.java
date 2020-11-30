package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudDiskService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudDiskServiceImpl implements HuaweiCloudDiskService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 弹性云服务器挂载磁盘
     *
     */
    @Override
    public CommonResult AttachServerVolume() {
        AttachServerVolumeRequest request = new AttachServerVolumeRequest();
        try {
            AttachServerVolumeResponse response = huaweiConfig.getClient().attachServerVolume(request);
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
     * 弹性云服务器卸载磁盘
     *
     */
    @Override
    public CommonResult DetachServerVolume() {
        DetachServerVolumeRequest request = new DetachServerVolumeRequest();
        try {
            DetachServerVolumeResponse response = huaweiConfig.getClient().detachServerVolume(request);
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
     * 查询弹性云服务器磁盘信息
     *
     */
    @Override
    public CommonResult ListServerBlockDevices() {
        ListServerBlockDevicesRequest request = new ListServerBlockDevicesRequest();
        try {
            ListServerBlockDevicesResponse response = huaweiConfig.getClient().listServerBlockDevices(request);
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
