package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 可用区管理接口
 * @author xuww
 * @date 2020/11/29 21:15
 */
public interface HuaweiCloudAvailabilityZoneService {
    /**
     * 查询可用区列表
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaListAvailabilityZones
     */
    CommonResult NovaListAvailabilityZones();

}
