package com.ucr.vcener.tencentCloud.serviceImpl;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.models.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import com.ucr.vcener.tencentCloud.service.TencentCloudDescribeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ymn
 * @date 2020/11/27 10:20
 */
public class TencentCloudDescribeServiceImpl implements TencentCloudDescribeService {
    @Autowired
    private TencentConfig tencentConfig;

    @Override
    public CommonResult describeZones() {
        DescribeZonesRequest req = new DescribeZonesRequest();
        HashMap<String, Object> result = new HashMap<>(4);
        try {
            DescribeZonesResponse describeZonesResponse = tencentConfig.getCvmClient().DescribeZones(req);
            result.put("totalCount", describeZonesResponse.getTotalCount());
            result.put("ZoneSet", describeZonesResponse.getZoneSet());
            result.put("requestId", describeZonesResponse.getRequestId());
            return CommonResult.ok(result);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }

        return CommonResult.error();
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
    public CommonResult describeRegions() {
        DescribeRegionsRequest req = new DescribeRegionsRequest();
        try {
            DescribeRegionsResponse describeRegionsResponse = tencentConfig.getCvmClient().DescribeRegions(req);
            return CommonResult.ok(describeRegionsResponse);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }
}
