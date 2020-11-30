package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 网卡管理接口
 * @author xuww
 * @date 2020/11/29 15:30
 */
public interface HuaweiCloudNetworkService {
    /**
     * 批量添加云服务器网卡
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=BatchAddServerNics
     */
    CommonResult BatchAddServerNics();

    /**
     * 批量删除云服务器网卡
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=BatchDeleteServerNics
     */
    CommonResult BatchDeleteServerNics();

    /**
     * 查询云服务器网卡信息
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ListServerInterfaces
     */
    CommonResult ListServerInterfaces();

    /**
     * 添加云服务器网卡(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaAttachInterface
     */
//    CommonResult NovaAttachInterface();

    /**
     * 删除云服务器网卡(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaDetachInterface
     */
//    CommonResult NovaDetachInterface();

    /**
     * 查询云服务器网卡信息(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaListServerInterfaces
     */
//    CommonResult NovaListServerInterfaces();

    /**
     * 查询指定云服务器网卡信息(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaShowServerInterface
     */
//    CommonResult NovaShowServerInterface();
}
