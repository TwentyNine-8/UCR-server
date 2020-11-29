package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 查询Job状态接口
 * @author xuww
 * @date 2020/11/29 21:10
 */
public interface HuaweiCloudJobService {
    /**
     * 查询任务的执行状态
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ShowJob
     */
    CommonResult ShowJob();

}
