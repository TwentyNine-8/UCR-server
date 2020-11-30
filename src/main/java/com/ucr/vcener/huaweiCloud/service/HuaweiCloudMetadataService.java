package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 元数据管理接口
 * @author xuww
 * @date 2020/11/29 18:30
 */
public interface HuaweiCloudMetadataService {
    /**
     * 删除云服务器指定元数据
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=DeleteServerMetadata
     */
    CommonResult DeleteServerMetadata();

    /**
     * 设置云服务器元数据(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaCreateServerMetadata
     */
//    CommonResult NovaCreateServerMetadata();

    /**
     * 删除云服务器指定元数据(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaDeleteServerMetadataItem
     */
//    CommonResult NovaDeleteServerMetadataItem();

    /**
     * 查询云服务器元数据列表(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaShowServerMetadata
     */
//    CommonResult NovaShowServerMetadata();

    /**
     * 获取云服务器指定Key的元数据(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaShowServerMetadataItem
     */
//    CommonResult NovaShowServerMetadataItem();

    /**
     * 更新云服务器元数据(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaUpdateServerMetadata
     */
//    CommonResult NovaUpdateServerMetadata();

    /**
     * 修改云服务器指定Key的元数据(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaUpdateServerMetadataItem
     */
//    CommonResult NovaUpdateServerMetadataItem();

    /**
     * 更新云服务器元数据
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=UpdateServerMetadata
     */
    CommonResult UpdateServerMetadata();
}
