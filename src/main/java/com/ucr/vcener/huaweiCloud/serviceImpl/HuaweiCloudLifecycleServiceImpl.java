package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudLifecycleService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudLifecycleServiceImpl implements HuaweiCloudLifecycleService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 创建云服务器(按需)
     *
     */
    @Override
    public CommonResult CreatePostPaidServers() {
        CreatePostPaidServersRequest request = new CreatePostPaidServersRequest();
        try {
            CreatePostPaidServersResponse postPaidServers = huaweiConfig.getClient().createPostPaidServers(request);
            return CommonResult.ok(postPaidServers);
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
     * 创建云服务器
     *
     */
    @Override
    public CommonResult CreateServers() {
        CreateServersRequest request = new CreateServersRequest();
        try {
            CreateServersResponse response = huaweiConfig.getClient().createServers(request);
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
     * 删除云服务器
     *
     */
    @Override
    public CommonResult DeleteServers() {
        DeleteServersRequest request = new DeleteServersRequest();
        try{
            DeleteServersResponse response = huaweiConfig.getClient().deleteServers(request);
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
     * 查询云服务器详情列表
     *
     */
    @Override
    public CommonResult ListServersDetails() {
        ListServersDetailsRequest request = new ListServersDetailsRequest();
        try{
            ListServersDetailsResponse response = huaweiConfig.getClient().listServersDetails(request);
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
     * 创建云服务器
     *
     */
    @Override
    public CommonResult NovaCreateServers() {
        NovaCreateServersRequest request = new NovaCreateServersRequest();
        try{
            NovaCreateServersResponse response = huaweiConfig.getClient().novaCreateServers(request);
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
     * 删除云服务器
     *
     */
    @Override
    public CommonResult NovaDeleteServer() {
        NovaDeleteServerRequest request = new NovaDeleteServerRequest();
        try{
            NovaDeleteServerResponse response = huaweiConfig.getClient().novaDeleteServer(request);
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
     * 查询云服务器详情列表
     *
     */
    @Override
    public CommonResult NovaListServersDetails() {
        NovaListServersDetailsRequest request = new NovaListServersDetailsRequest();
        try{
            NovaListServersDetailsResponse response = huaweiConfig.getClient().novaListServersDetails(request);
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
     * 查询云服务器详情
     *
     */
    @Override
    public CommonResult NovaShowServer() {
        NovaShowServerRequest request = new NovaShowServerRequest();
        try{
            NovaShowServerResponse response = huaweiConfig.getClient().novaShowServer(request);
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
     * 查询云服务器详情
     *
     */
    @Override
    public CommonResult ShowServer() {
        ShowServerRequest request = new ShowServerRequest();
        try{
            ShowServerResponse response = huaweiConfig.getClient().showServer(request);
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
     * 修改云服务器
     *
     */
    @Override
    public CommonResult UpdateServer() {
        UpdateServerRequest request = new UpdateServerRequest();
        try{
            UpdateServerResponse response = huaweiConfig.getClient().updateServer(request);
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
