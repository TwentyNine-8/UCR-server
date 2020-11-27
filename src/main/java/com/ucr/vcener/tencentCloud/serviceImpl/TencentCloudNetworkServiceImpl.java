package com.ucr.vcener.tencentCloud.serviceImpl;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.models.*;
import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import com.ucr.vcener.tencentCloud.service.TencentCloudNetworkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuww
 * @date 2020/11/27 10:20
 */
public class TencentCloudNetworkServiceImpl implements TencentCloudNetworkService {
    @Autowired
    private TencentConfig tencentConfig;

    /**
     * 查询实例带宽配置
     *
     * @return map internetBandwidthConfigSet 	带宽配置信息列表
     *             requestId 唯一请求 ID
     * <p>
     * https://cloud.tencent.com/document/api/213/15734
     */
    @Override
    public Map<String, Object> DescribeInstanceInternetBandwidthConfigs(String InstanceId) {
        DescribeInstanceInternetBandwidthConfigsRequest req = new DescribeInstanceInternetBandwidthConfigsRequest();
        HashMap<String, Object> result = new HashMap<>(4);
        try {
            DescribeInstanceInternetBandwidthConfigsResponse describeInstanceInternetBandwidthConfigsResponse = tencentConfig.getCvmClient().DescribeInstanceInternetBandwidthConfigs(req);
            result.put("internetBandwidthConfigSet", describeInstanceInternetBandwidthConfigsResponse.getInternetBandwidthConfigSet());
            result.put("requestId", describeInstanceInternetBandwidthConfigsResponse.getRequestId());
            return result;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 查询实例带宽配置
     *
     * @return map internetChargeTypeConfigSet 	网络计费类型配置
     *             requestId 唯一请求 ID
     * <p>
     * https://cloud.tencent.com/document/api/213/15734
     */
    @Override
    public Map<String, Object> DescribeInternetChargeTypeConfigs() {
        DescribeInternetChargeTypeConfigsRequest req = new DescribeInternetChargeTypeConfigsRequest();
        HashMap<String, Object> result = new HashMap<>(4);
        try {
            DescribeInternetChargeTypeConfigsResponse describeInternetChargeTypeConfigsResponse = tencentConfig.getCvmClient().DescribeInternetChargeTypeConfigs(req);
            result.put("internetChargeTypeConfigSet",describeInternetChargeTypeConfigsResponse.getInternetChargeTypeConfigSet());
            result.put("requestId",describeInternetChargeTypeConfigsResponse.getRequestId());
            return result;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return result;
    }
}
