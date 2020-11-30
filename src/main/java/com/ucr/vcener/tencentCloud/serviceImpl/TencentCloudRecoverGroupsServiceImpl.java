package com.ucr.vcener.tencentCloud.serviceImpl;

import cn.hutool.core.collection.CollectionUtil;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.models.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import com.ucr.vcener.tencentCloud.service.TencentCloudRecoverGroupsService;
import com.ucr.vcener.util.TencentUtil;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ymn
 * @date 2020/11/27 17:43
 */
public class TencentCloudRecoverGroupsServiceImpl implements TencentCloudRecoverGroupsService {
    @Autowired
    private TencentConfig tencentConfig;

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
    @Override
    public CommonResult DescribeDisasterRecoverGroups(List<String> disasterRecoverGroupIds, String name, Long offset, Long limit) {
        DescribeDisasterRecoverGroupsRequest req = new DescribeDisasterRecoverGroupsRequest();
        if (CollectionUtil.isNotEmpty(disasterRecoverGroupIds)) {
            if (disasterRecoverGroupIds.size() > 100) {
                return CommonResult.error("分散置放群组ID列表上限是100");
            }
            req.setDisasterRecoverGroupIds(TencentUtil.toObjectArray(disasterRecoverGroupIds));
        }

        if (StringUtils.isNotBlank(name)) {
            req.setName(name);
        }
        if (offset != null) {
            req.setOffset(offset);
        }
        if (limit != null) {
            req.setLimit(limit);
        }
        try {
            DescribeDisasterRecoverGroupsResponse describeHostsResponse = tencentConfig.getCvmClient().DescribeDisasterRecoverGroups(req);
            CommonResult.ok(describeHostsResponse);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 查询置放群组配额
     * 本接口 (DescribeDisasterRecoverGroupQuota)用于查询分散置放群组配额。
     *
     * 默认接口请求频率限制：20次/秒。
     * @return
     * https://cloud.tencent.com/document/api/213/17811
     */
    @Override
    public CommonResult DescribeDisasterRecoverGroupQuota() {
        DescribeDisasterRecoverGroupQuotaRequest req = new DescribeDisasterRecoverGroupQuotaRequest();
        try {
            DescribeDisasterRecoverGroupQuotaResponse response = tencentConfig.getCvmClient().DescribeDisasterRecoverGroupQuota(req);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 创建分散置放群组
     * 本接口 (CreateDisasterRecoverGroup)用于创建分散置放群组。创建好的置放群组，可在创建实例时指定。
     *
     * 默认接口请求频率限制：10次/秒。
     * @param createDisasterRecoverGroupRequest
     * @return
     * https://cloud.tencent.com/document/api/213/17813
     */
    @Override
    public CommonResult CreateDisasterRecoverGroup(CreateDisasterRecoverGroupRequest createDisasterRecoverGroupRequest) {
        try {
            CreateDisasterRecoverGroupResponse response = tencentConfig
                .getCvmClient()
                .CreateDisasterRecoverGroup(createDisasterRecoverGroupRequest);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 修改分散置放群组属性
     * 本接口 (ModifyDisasterRecoverGroupAttribute)用于修改分散置放群组属性。
     *
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/17809
     */
    @Override
    public CommonResult ModifyDisasterRecoverGroupAttribute(ModifyDisasterRecoverGroupAttributeRequest request) {
        try {
            ModifyDisasterRecoverGroupAttributeResponse response = tencentConfig
                .getCvmClient()
                .ModifyDisasterRecoverGroupAttribute(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 删除分散置放群组
     * 本接口 (DeleteDisasterRecoverGroups)用于删除分散置放群组。只有空的置放群组才能被删除，非空的群组需要先销毁组内所有云服务器，才能执行删除操作，不然会产生删除置放群组失败的错误。
     *
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     *  https://cloud.tencent.com/document/api/213/17812
     */
    @Override
    public CommonResult DeleteDisasterRecoverGroups(DeleteDisasterRecoverGroupsRequest request) {
        try {
            DeleteDisasterRecoverGroupsResponse response = tencentConfig.getCvmClient().DeleteDisasterRecoverGroups(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }
}
