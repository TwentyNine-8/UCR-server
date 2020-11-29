package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 磁盘管理接口
 * @author xuww
 * @date 2020/11/29 16:23
 */
public interface HuaweiCloudDiskService {
    /**
     * 弹性云服务器挂载磁盘
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=AttachServerVolume
     */
    CommonResult AttachServerVolume();

    /**
     * 弹性云服务器卸载磁盘
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=DetachServerVolume
     */
    CommonResult DetachServerVolume();

    /**
     * 查询弹性云服务器磁盘信息
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ListServerBlockDevices
     */
    CommonResult ListServerBlockDevices();

    /**
     * 查询弹性云服务器挂载磁盘信息(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ListServerVolumeAttachments
     */
//    CommonResult ListServerVolumeAttachments();

    /**
     * 弹性云服务器挂载磁盘(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaAttachVolume
     */
//    CommonResult NovaAttachVolume();

    /**
     * 卸载云服务器磁盘(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaDetachVolume
     */
//    CommonResult NovaDetachVolume();

    /**
     * 查询弹性云服务器器挂载磁盘信息(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaListServerVolumes
     */
//    CommonResult NovaListServerVolumes();

    /**
     * 查询弹性云服务器挂载的单个磁盘信息(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaShowServerVolume
     */
//    CommonResult NovaShowServerVolume();

    /**
     * 查询弹性云服务器单个磁盘信息(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ShowServerBlockDevice
     */
//    CommonResult ShowServerBlockDevice();
}
