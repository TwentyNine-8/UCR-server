package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 云服务器组管理接口
 * @author xuww
 * @date 2020/11/29 21:50
 */
public interface HuaweiCloudServerGroupService {
    /**
     * 云服务器组添加成员
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=AddServerGroupMember
     */
    CommonResult AddServerGroupMember();

    /**
     * 创建云服务器组
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=CreateServerGroup
     */
    CommonResult CreateServerGroup();

    /**
     * 删除云服务器组
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=DeleteServerGroup
     */
    CommonResult DeleteServerGroup();

    /**
     * 云服务器组删除成员
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=DeleteServerGroupMember
     */
    CommonResult DeleteServerGroupMember();

    /**
     * 创建云服务器组(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaCreateServerGroup
     */
//    CommonResult NovaCreateServerGroup();

    /**
     * 删除云服务器组(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaDeleteServerGroup
     */
//    CommonResult NovaDeleteServerGroup();

    /**
     * 查询云服务器组列表(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaListServerGroups
     */
//    CommonResult NovaListServerGroups();

    /**
     * 查询云服务器组详情(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaShowServerGroup
     */
//    CommonResult NovaShowServerGroup();
}
