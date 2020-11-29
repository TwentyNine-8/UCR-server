package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudDiskService;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudSecurityGroupService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudSecurityGroupServiceImpl implements HuaweiCloudSecurityGroupService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 添加安全组
     *
     */
    @Override
    public CommonResult NovaAssociateSecurityGroup() {
        NovaAssociateSecurityGroupRequest request = new NovaAssociateSecurityGroupRequest();
        try {
            NovaAssociateSecurityGroupResponse response = huaweiConfig.getClient().novaAssociateSecurityGroup(request);
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
     * 移除安全组
     *
     */
    @Override
    public CommonResult NovaDisassociateSecurityGroup() {
        NovaDisassociateSecurityGroupRequest request = new NovaDisassociateSecurityGroupRequest();
        try {
            NovaDisassociateSecurityGroupResponse response = huaweiConfig.getClient().novaDisassociateSecurityGroup(request);
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
     * 查询指定云服务器安全组列表
     *
     */
    @Override
    public CommonResult NovaListServerSecurityGroups() {
        NovaListServerSecurityGroupsRequest request = new NovaListServerSecurityGroupsRequest();
        try {
            NovaListServerSecurityGroupsResponse response = huaweiConfig.getClient().novaListServerSecurityGroups(request);
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
