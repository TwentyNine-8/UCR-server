package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 状态管理接口
 * @author xuww
 * @date 2020/11/28 18:00
 */
public interface HuaweiCloudStateService {
    /**
     * 切换弹性云服务器操作系统(安装Cloud-init)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/doc?product=ECS&api=ChangeServerOsWithCloudInit
     */
    CommonResult ChangeServerOsWithCloudInit();

    /**
     * 切换弹性云服务器操作系统(未安装Cloud-init)(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/doc?product=ECS&api=ChangeServerOsWithoutCloudInit
     */
//    CommonResult ChangeServerOsWithoutCloudInit();

    /**
     * 锁定云服务器(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaLockServer
     */
//    CommonResult NovaLockServer();

    /**
     * 重启云服务器(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaRebootServer
     */
//    CommonResult NovaRebootServer();

    /**
     * 关闭云服务器(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaStopServer
     */
//    CommonResult NovaStopServer();

    /**
     * 解锁云服务器(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaUnlockServer
     */
//    CommonResult NovaUnlockServer();

    /**
     * 管理云服务器自动恢复动作(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=RegisterServerAutoRecovery
     */
//    CommonResult RegisterServerAutoRecovery();

    /**
     * 重装弹性云服务器操作系统(安装Cloud-init)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ReinstallServerWithCloudInit
     */
    CommonResult ReinstallServerWithCloudInit();

    /**
     * 重装弹性云服务器操作系统(未安装Cloud-init)(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ReinstallServerWithoutCloudInit
     */
//    CommonResult ReinstallServerWithoutCloudInit();

    /**
     * 变更云服务器规格(按需)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ResizePostPaidServer
     */
    CommonResult ResizePostPaidServer();

    /**
     * 变更云服务器规格
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ResizeServer
     */
    CommonResult ResizeServer();

    /**
     * 查询云服务器是否配置了自动恢复动作(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ShowServerAutoRecovery
     */
//    CommonResult ShowServerAutoRecovery();

    /**
     * 获取VNC远程登录地址
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ShowServerRemoteConsole
     */
    CommonResult ShowServerRemoteConsole();
}
