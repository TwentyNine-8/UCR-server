package com.ucr.vcener.tencentCloud.serviceImpl;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.models.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import com.ucr.vcener.tencentCloud.service.AssociateSecurityGroupsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ymn
 * @date 2020/11/27 20:50
 */
public class AssociateSecurityGroupsImpl implements AssociateSecurityGroupsService {
    @Autowired
    private TencentConfig tencentConfig;

    /**
     * 绑定安全组
     * 本接口 (AssociateSecurityGroups) 用于绑定安全组到指定实例。
     *
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/31282
     */
    @Override
    public CommonResult AssociateSecurityGroups(AssociateSecurityGroupsRequest request) {
        try {
            AssociateSecurityGroupsResponse response = tencentConfig.getCvmClient().AssociateSecurityGroups(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 解绑安全组
     * 本接口 (DisassociateSecurityGroups) 用于解绑实例的指定安全组。
     *
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/31281
     */
    @Override
    public CommonResult DisassociateSecurityGroups(DisassociateSecurityGroupsRequest request) {
        try {
            DisassociateSecurityGroupsResponse response = tencentConfig.getCvmClient().DisassociateSecurityGroups(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }
}
