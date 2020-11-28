package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 批量操作接口
 * @author xuww
 * @date 2020/11/28 20:10
 */
public interface HuaweiCloudBatchOperationService {
    /**
     * 批量挂载指定共享盘(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=BatchAttachSharableVolumes
     */
//    CommonResult BatchAttachSharableVolumes();

    /**
     * 批量重启云服务器
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=BatchRebootServers
     */
    CommonResult BatchRebootServers();

    /**
     * 批量重置弹性云服务器密码(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=BatchResetServersPassword
     */
//    CommonResult BatchResetServersPassword();

    /**
     * 批量启动云服务器
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=BatchStartServers
     */
    CommonResult BatchStartServers();

    /**
     * 批量关闭云服务器
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=BatchStopServers
     */
    CommonResult BatchStopServers();

    /**
     * 批量修改弹性云服务器(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=BatchUpdateServersName
     */
//    CommonResult BatchUpdateServersName();
}
