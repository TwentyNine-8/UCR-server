package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 密钥密码管理接口
 * @author xuww
 * @date 2020/11/29 21:30
 */
public interface HuaweiCloudKeyPasswordService {
    /**
     * Windows云服务器清除密码(企业项目)(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=DeleteWindowsServerPassword
     */
//    CommonResult DeleteWindowsServerPassword();

    /**
     * 创建和导入SSH密钥
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaCreateKeypair
     */
    CommonResult NovaCreateKeypair();

    /**
     * 删除SSH密钥
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaDeleteKeypair
     */
    CommonResult NovaDeleteKeypair();

    /**
     * 查询SSH密钥列表
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaListKeypairs
     */
    CommonResult NovaListKeypairs();

    /**
     * 查询SSH密钥详情(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaShowKeypair
     */
//    CommonResult NovaShowKeypair();

    /**
     * 一键重置弹性云服务器密码(企业项目)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ResetServerPassword
     */
    CommonResult ResetServerPassword();

    /**
     * 查询是否支持一键重置密码
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ShowResetPasswordFlag
     */
    CommonResult ShowResetPasswordFlag();

    /**
     * Windows云服务器获取密码(企业项目)(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ShowWindowsServerPassword
     */
//    CommonResult ShowWindowsServerPassword();
}
