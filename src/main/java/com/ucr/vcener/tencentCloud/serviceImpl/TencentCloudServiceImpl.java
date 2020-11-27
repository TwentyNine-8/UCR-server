package com.ucr.vcener.tencentCloud.serviceImpl;

import com.netflix.discovery.converters.Auto;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.CvmClient;
import com.tencentcloudapi.cvm.v20170312.models.DescribeRegionsRequest;
import com.tencentcloudapi.cvm.v20170312.models.DescribeRegionsResponse;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesRequest;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesResponse;
import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import com.ucr.vcener.tencentCloud.service.TencentCloudService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ymn
 * @date 2020/11/27 10:20
 */
public class TencentCloudServiceImpl implements TencentCloudService {
    @Autowired
    private TencentConfig tencentConfig;

    @Override
    public Map<String, Object> describeZones() {
        DescribeZonesRequest req = new DescribeZonesRequest();
        HashMap<String, Object> result = new HashMap<>(4);
        try {
            DescribeZonesResponse describeZonesResponse = tencentConfig.cvmClient.DescribeZones(req);
            result.put("totalCount", describeZonesResponse.getTotalCount());
            result.put("ZoneSet", describeZonesResponse.getZoneSet());
            result.put("requestId", describeZonesResponse.getRequestId());
            return result;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 查询地域列表
     *
     * @return map totalCount 	地域数量
     * RegionSet 地域列表信息
     * requestId 唯一请求 ID
     * <p>
     * https://cloud.tencent.com/document/api/213/15708
     */
    @Override
    public Map<String, Object> describeRegions() {
        DescribeRegionsRequest req = new DescribeRegionsRequest();
        HashMap<String, Object> result = new HashMap<>(4);
        try {
            DescribeRegionsResponse describeRegionsResponse = tencentConfig.cvmClient.DescribeRegions(req);
            result.put("totalCount", describeRegionsResponse.getTotalCount());
            result.put("RegionSet", describeRegionsResponse.getRegionSet());
            result.put("requestId", describeRegionsResponse.getRequestId());
            return result;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> describeInstances() {
        return null;
    }
}
