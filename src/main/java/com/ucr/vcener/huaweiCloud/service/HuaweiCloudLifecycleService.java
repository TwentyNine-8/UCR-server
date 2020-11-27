package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 生命周期管理接口
 * @author xuww
 * @date 2020/11/27 16:11
 */
public interface HuaweiCloudLifecycleService {
    /**
     * 创建云服务器(按需)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=CreatePostPaidServers
     */
    CommonResult CreatePostPaidServers();

    /**
     * 创建云服务器
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=CreateServers
     */
    CommonResult CreateServers();

    /**
     * 删除云服务器
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=DeleteServers
     */
    CommonResult DeleteServers();

    /**
     * 查询云服务器详情列表
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ListServersDetails
     */
    CommonResult ListServersDetails();

    /**
     * 创建云服务器
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaCreateServers
     */
    CommonResult NovaCreateServers();

    /**
     * 删除云服务器
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaDeleteServer
     */
    CommonResult NovaDeleteServer();

    /**
     * 查询云服务器列表(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/doc?product=ECS&api=NovaListServers
     */
//    CommonResult NovaListServers();

    /**
     * 查询云服务器详情列表
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaListServersDetails
     */
    CommonResult NovaListServersDetails();

    /**
     * 查询云服务器详情
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaShowServer
     */
    CommonResult NovaShowServer();

    /**
     * 修改云服务器(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaUpdateServer
     */
//    CommonResult NovaUpdateServer();

    /**
     * 查询云服务器详情
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ShowServer
     */
    CommonResult ShowServer();

    /**
     * 修改云服务器
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=UpdateServer
     */
    CommonResult UpdateServer();
}
