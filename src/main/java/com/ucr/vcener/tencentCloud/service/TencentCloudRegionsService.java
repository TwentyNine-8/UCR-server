package com.ucr.vcener.tencentCloud.service;

import com.ucr.vcener.common.CommonResult;
import java.util.List;
import java.util.Map;

/**
 * 腾讯云 地域相关接口
 * @author ymn
 * @date 2020/11/27 10:11
 */
public interface TencentCloudRegionsService {
    /**
     * 查询可用区列表
     * @return
     * https://cloud.tencent.com/document/api/213/15707
     */
    CommonResult describeZones();
    /**
     * 查询地域列表
     * @return
     * https://cloud.tencent.com/document/api/213/15708
     */
    CommonResult describeRegions();
}
