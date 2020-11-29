package com.ucr.vcener.huaweiCloud.serviceImpl;

import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.ecs.v2.model.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.HuaweiConfig;
import com.ucr.vcener.huaweiCloud.service.HuaweiCloudKeyPasswordService;
import org.springframework.beans.factory.annotation.Autowired;

public class HuaweiCloudKeyPasswordServiceImpl implements HuaweiCloudKeyPasswordService {
    @Autowired
    private HuaweiConfig huaweiConfig;

    /**
     * 创建和导入SSH密钥
     *
     */
    @Override
    public CommonResult NovaCreateKeypair() {
        NovaCreateKeypairRequest request = new NovaCreateKeypairRequest();
        try {
            NovaCreateKeypairResponse response = huaweiConfig.getClient().novaCreateKeypair(request);
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
     * 删除SSH密钥
     *
     */
    @Override
    public CommonResult NovaDeleteKeypair() {
        NovaDeleteKeypairRequest request = new NovaDeleteKeypairRequest();
        try {
            NovaDeleteKeypairResponse response = huaweiConfig.getClient().novaDeleteKeypair(request);
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
     * 查询SSH密钥列表
     *
     */
    @Override
    public CommonResult NovaListKeypairs() {
        NovaListKeypairsRequest request = new NovaListKeypairsRequest();
        try {
            NovaListKeypairsResponse response = huaweiConfig.getClient().novaListKeypairs(request);
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
     * 一键重置弹性云服务器密码(企业项目)
     *
     */
    @Override
    public CommonResult ResetServerPassword() {
        ResetServerPasswordRequest request = new ResetServerPasswordRequest();
        try {
            ResetServerPasswordResponse response = huaweiConfig.getClient().resetServerPassword(request);
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
     * 查询是否支持一键重置密码
     *
     */
    @Override
    public CommonResult ShowResetPasswordFlag() {
        ShowResetPasswordFlagRequest request = new ShowResetPasswordFlagRequest();
        try {
            ShowResetPasswordFlagResponse response = huaweiConfig.getClient().showResetPasswordFlag(request);
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
