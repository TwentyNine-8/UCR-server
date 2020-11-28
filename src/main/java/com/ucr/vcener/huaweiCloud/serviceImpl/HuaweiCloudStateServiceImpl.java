package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudStateService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudStateServiceImpl implements HuaweiCloudStateService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 切换弹性云服务器操作系统
     *
     */
    @Override
    public CommonResult ChangeServerOsWithCloudInit() {
        ChangeServerOsWithCloudInitRequest request = new ChangeServerOsWithCloudInitRequest();
        try {
            ChangeServerOsWithCloudInitResponse response = huaweiConfig.getClient().changeServerOsWithCloudInit(request);
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
     * 切换弹性云服务器操作系统
     *
     */
    @Override
    public CommonResult ReinstallServerWithCloudInit() {
        ReinstallServerWithCloudInitRequest request = new ReinstallServerWithCloudInitRequest();
        try {
            ReinstallServerWithCloudInitResponse response = huaweiConfig.getClient().reinstallServerWithCloudInit(request);
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
     * 变更云服务器规格(按需)
     *
     */
    @Override
    public CommonResult ResizePostPaidServer() {
        ResizePostPaidServerRequest request = new ResizePostPaidServerRequest();
        try {
            ResizePostPaidServerResponse response = huaweiConfig.getClient().resizePostPaidServer(request);
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
     * 变更云服务器规格
     *
     */
    @Override
    public CommonResult ResizeServer() {
        ResizeServerRequest request = new ResizeServerRequest();
        try {
            ResizeServerResponse response = huaweiConfig.getClient().resizeServer(request);
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
     * 获取VNC远程登录地址
     *
     */
    @Override
    public CommonResult ShowServerRemoteConsole() {
        ShowServerRemoteConsoleRequest request = new ShowServerRemoteConsoleRequest();
        try {
            ShowServerRemoteConsoleResponse response = huaweiConfig.getClient().showServerRemoteConsole(request);
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
