package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.NovaListAvailabilityZonesRequest;
import com.huaweicloud.sdk.ecs.v2.model.NovaListAvailabilityZonesResponse;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudAvailabilityZoneService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudAvailabilityZoneServiceImpl implements HuaweiCloudAvailabilityZoneService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 查询可用区列表
     *
     */
    @Override
    public CommonResult NovaListAvailabilityZones() {
        NovaListAvailabilityZonesRequest request = new NovaListAvailabilityZonesRequest();
        try {
            NovaListAvailabilityZonesResponse response = huaweiConfig.getClient().novaListAvailabilityZones(request);
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
