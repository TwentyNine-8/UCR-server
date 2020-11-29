package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudTenantQuotaService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudTenantQuotaServiceImpl implements HuaweiCloudTenantQuotaService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 查询租户配额
     *
     */
    @Override
    public CommonResult ShowServerLimits() {
        ShowServerLimitsRequest request = new ShowServerLimitsRequest();
        try {
            ShowServerLimitsResponse response = huaweiConfig.getClient().showServerLimits(request);
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
