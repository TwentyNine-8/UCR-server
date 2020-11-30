package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 安全组管理接口
 * @author xuww
 * @date 2020/11/29 17:13
 */
public interface HuaweiCloudSecurityGroupService {
    /**
     * 添加安全组
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaAssociateSecurityGroup
     */
    CommonResult NovaAssociateSecurityGroup();

    /**
     * 移除安全组
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaDisassociateSecurityGroup
     */
    CommonResult NovaDisassociateSecurityGroup();

    /**
     * 查询指定云服务器安全组列表
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaListServerSecurityGroups
     */
    CommonResult NovaListServerSecurityGroups();

}
