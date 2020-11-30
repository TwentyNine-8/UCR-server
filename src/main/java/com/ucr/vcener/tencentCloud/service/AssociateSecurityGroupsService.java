package com.ucr.vcener.tencentCloud.service;

import com.tencentcloudapi.cvm.v20170312.models.AssociateSecurityGroupsRequest;
import com.tencentcloudapi.cvm.v20170312.models.DisassociateSecurityGroupsRequest;
import com.ucr.vcener.common.CommonResult;

/**
 * 安全组相关接口
 * @author ymn
 * @date 2020/11/27 20:50
 */
public interface AssociateSecurityGroupsService {
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
    CommonResult AssociateSecurityGroups(AssociateSecurityGroupsRequest request);

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
    CommonResult DisassociateSecurityGroups(DisassociateSecurityGroupsRequest request);
}
