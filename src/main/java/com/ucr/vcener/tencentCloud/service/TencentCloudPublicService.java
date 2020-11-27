package com.ucr.vcener.tencentCloud.service;

import java.util.Map;

/**
 * 公共接口
 * @author ymn
 * @date 2020/11/27 14:11
 */
public interface TencentCloudPublicService {
    /**
     * 需要对接别的api,不在sdk内
     * 查询项目列表
     * @param asList 传1拉取所有项目（包括隐藏项目），不传或传0拉取显示项目
     * @return
     * https://cloud.tencent.com/document/api/378/4400
     */
    Map<String, Object> describeProject(Integer asList);
}
