package com.ucr.vcener.tencentCloud.service;

import java.util.Map;

/**
 * 网络相关接口
 * @author xuww
 * @date 2020/11/27 10:11
 */
public interface TencentCloudNetworkService {
    /**
     * 查询实例带宽配置
     * @return
     * https://cloud.tencent.com/document/api/213/15734
     */
    Map<String, Object> DescribeInstanceInternetBandwidthConfigs(String InstanceId);

    /**
     * 查询网络计费类型
     * @return
     * https://cloud.tencent.com/document/api/213/15734
     */
    Map<String, Object> DescribeInternetChargeTypeConfigs();
}
