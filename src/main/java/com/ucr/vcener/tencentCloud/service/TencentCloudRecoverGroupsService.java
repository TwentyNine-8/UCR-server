package com.ucr.vcener.tencentCloud.service;

import com.tencentcloudapi.cvm.v20170312.models.*;
import com.ucr.vcener.common.CommonResult;
import java.util.List;

/**
 * 置放集群组相关接口
 * @author ymn
 * @date 2020/11/27 17:42
 */
public interface TencentCloudRecoverGroupsService {
    /**
     * 查询分散置放群组信息
     * 本接口 (DescribeDisasterRecoverGroups)用于查询分散置放群组信息。
     * 默认接口请求频率限制：10次/秒。
     * @param disasterRecoverGroupIds 分散置放群组ID列表。每次请求允许操作的分散置放群组数量上限是100。
     * @param name                    分散置放群组名称，支持模糊匹配。
     * @param offset
     * @param limit
     * @return
     * https://cloud.tencent.com/document/api/213/17810
     */
    CommonResult DescribeDisasterRecoverGroups(List<String> disasterRecoverGroupIds, String name, Long offset, Long limit);

    /**
     * 查询置放群组配额
     * 本接口 (DescribeDisasterRecoverGroupQuota)用于查询分散置放群组配额。
     *
     * 默认接口请求频率限制：20次/秒。
     * @return
     * https://cloud.tencent.com/document/api/213/17811
     */
    CommonResult DescribeDisasterRecoverGroupQuota();

    /**
     * 创建分散置放群组
     * 本接口 (CreateDisasterRecoverGroup)用于创建分散置放群组。创建好的置放群组，可在创建实例时指定。
     *
     * 默认接口请求频率限制：10次/秒。
     * @param createDisasterRecoverGroupRequest
     * @return
     * https://cloud.tencent.com/document/api/213/17813
     */
    CommonResult CreateDisasterRecoverGroup(CreateDisasterRecoverGroupRequest createDisasterRecoverGroupRequest);

    /**
     * 修改分散置放群组属性
     * 本接口 (ModifyDisasterRecoverGroupAttribute)用于修改分散置放群组属性。
     *
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/17809
     */
    CommonResult ModifyDisasterRecoverGroupAttribute(ModifyDisasterRecoverGroupAttributeRequest request);

    /**
     * 删除分散置放群组
     * 本接口 (DeleteDisasterRecoverGroups)用于删除分散置放群组。只有空的置放群组才能被删除，非空的群组需要先销毁组内所有云服务器，才能执行删除操作，不然会产生删除置放群组失败的错误。
     *
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     *  https://cloud.tencent.com/document/api/213/17812
     */
    CommonResult DeleteDisasterRecoverGroups(DeleteDisasterRecoverGroupsRequest request);
}
