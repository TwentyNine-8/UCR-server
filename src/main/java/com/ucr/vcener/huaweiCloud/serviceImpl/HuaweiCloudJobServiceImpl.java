package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.ShowJobRequest;
import com.huaweicloud.sdk.ecs.v2.model.ShowJobResponse;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudJobService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudJobServiceImpl implements HuaweiCloudJobService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 查询任务的执行状态
     *
     */
    @Override
    public CommonResult ShowJob() {
        ShowJobRequest request = new ShowJobRequest();
        try {
            ShowJobResponse response = huaweiConfig.getClient().showJob(request);
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
