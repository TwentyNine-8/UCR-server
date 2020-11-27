package com.ucr.vcener.tencentCloud.service;

import java.util.Map;

/**
 * 腾讯云接口
 * @author ymn
 * @date 2020/11/27 10:11
 */
public interface TencentCloudService {
    /**
     * 查询可用区列表
     * @return
     * https://cloud.tencent.com/document/api/213/15707
     */
    Map<String, Object> describeZones();
    /**
     * 查询地域列表
     * @return
     * https://cloud.tencent.com/document/api/213/15708
     */
    Map<String, Object> describeRegions();

    Map<String, Object> describeInstances();
}
