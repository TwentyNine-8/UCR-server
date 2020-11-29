package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 标签管理接口
 * @author xuww
 * @date 2020/11/29 21:15
 */
public interface HuaweiCloudTagService {
    /**
     * 批量添加云服务器标签
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=BatchCreateServerTags
     */
    CommonResult BatchCreateServerTags();

    /**
     * 批量删除云服务器标签
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=BatchDeleteServerTags
     */
    CommonResult BatchDeleteServerTags();

    /**
     * 查询项目标签(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ListServerTags
     */
//    CommonResult ListServerTags();

    /**
     * 查询云服务器标签
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ShowServerTags
     */
    CommonResult ShowServerTags();
}
