package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudServerGroupService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudServerGroupServiceImpl implements HuaweiCloudServerGroupService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 云服务器组添加成员
     *
     */
    @Override
    public CommonResult AddServerGroupMember() {
        AddServerGroupMemberRequest request = new AddServerGroupMemberRequest();
        try {
            AddServerGroupMemberResponse response = huaweiConfig.getClient().addServerGroupMember(request);
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
     * 创建云服务器组
     *
     */
    @Override
    public CommonResult CreateServerGroup() {
        CreateServerGroupRequest request = new CreateServerGroupRequest();
        try {
            CreateServerGroupResponse response = huaweiConfig.getClient().createServerGroup(request);
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
     * 删除云服务器组
     *
     */
    @Override
    public CommonResult DeleteServerGroup() {
        DeleteServerGroupRequest request = new DeleteServerGroupRequest();
        try {
            DeleteServerGroupResponse response = huaweiConfig.getClient().deleteServerGroup(request);
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
     * 云服务器组删除成员
     *
     */
    @Override
    public CommonResult DeleteServerGroupMember() {
        DeleteServerGroupMemberRequest request = new DeleteServerGroupMemberRequest();
        try {
            DeleteServerGroupMemberResponse response = huaweiConfig.getClient().deleteServerGroupMember(request);
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
