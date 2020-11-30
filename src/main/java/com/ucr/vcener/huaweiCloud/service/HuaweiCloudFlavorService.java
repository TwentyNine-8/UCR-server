package com.ucr.vcener.huaweiCloud.service;

import com.ucr.vcener.common.CommonResult;

/**
 * 华为云 规格管理接口
 * @author xuww
 * @date 2020/11/29 17:50
 */
public interface HuaweiCloudFlavorService {
    /**
     * 查询规格详情和规格扩展信息列表
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ListFlavors
     */
    CommonResult ListFlavors();

    /**
     * 查询云服务器规格变更支持列表
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=ListResizeFlavors
     */
    CommonResult ListResizeFlavors();

    /**
     * 查询云服务器规格列表(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaListFlavors
     */
//    CommonResult NovaListFlavors();

    /**
     * 查询云服务器规格详情列表(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaListFlavorsDetails
     */
//    CommonResult NovaListFlavorsDetails();

    /**
     * 查询云服务器规格详情(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaShowFlavor
     */
//    CommonResult NovaShowFlavor();

    /**
     * 查询云服务器规格extra_specs的详情(暂时找不到这个方法)
     * @return
     * https://apiexplorer.developer.huaweicloud.com/apiexplorer/sdk?product=ECS&api=NovaShowFlavorExtraSpecs
     */
//    CommonResult NovaShowFlavorExtraSpecs();

}
