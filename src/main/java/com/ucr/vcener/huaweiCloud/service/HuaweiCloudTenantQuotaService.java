package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 租户配额管理接口
 * @author xuww
 * @date 2020/11/29 21:00
 */
public interface HuaweiCloudTenantQuotaService {
    /**
     * 查询租户配额
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/doc?product=ECS&api=ShowServerLimits
     */
    CommonResult ShowServerLimits();

}
