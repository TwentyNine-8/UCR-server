package com.ucr.vcener.tencentCloud.serviceImpl;

import cn.hutool.core.collection.CollectionUtil;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.models.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import com.ucr.vcener.tencentCloud.service.TencentCloudCDHService;
import com.ucr.vcener.util.TencentUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ymn
 * @date 2020/11/27 17:00
 */
public class TencentCloudCDHServiceImpl implements TencentCloudCDHService {
    @Autowired
    private TencentConfig tencentConfig;

    /**
     * 查看CDH实例列表
     * 本接口 (DescribeHosts) 用于获取一个或多个CDH实例的详细信息。
     *
     * 默认接口请求频率限制：10次/秒。
     * @param filters
     * @param offset
     * @param limit
     * @return
     * https://cloud.tencent.com/document/api/213/16474
     */
    @Override
    public CommonResult DescribeHosts(List<Filter> filters, Long offset, Long limit) {
        DescribeHostsRequest req = new DescribeHostsRequest();
        if (CollectionUtil.isNotEmpty(filters)) {
            if (!TencentUtil.checkFilterList(filters)) {
                return CommonResult.error("自定义筛选条件不能超过10个,且每个条件中每个值不能超过5个");
            }
            req.setFilters(TencentUtil.toObjectArray(filters));
        }

        if (offset != null) {
            req.setOffset(offset);
        }
        if (limit != null) {
            req.setLimit(limit);
        }
        try {
            DescribeHostsResponse describeHostsResponse = tencentConfig.getCvmClient().DescribeHosts(req);
            CommonResult.ok(describeHostsResponse);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 创建CDH实例
     *本接口 (AllocateHosts) 用于创建一个或多个指定配置的CDH实例。
     *
     * 当HostChargeType为PREPAID时，必须指定HostChargePrepaid参数。
     * 默认接口请求频率限制：10次/秒。
     * @param allocateHostsRequest
     * @return
     * https://cloud.tencent.com/document/api/213/16473
     */
    @Override
    public CommonResult AllocateHosts(AllocateHostsRequest allocateHostsRequest) {
        try {
            AllocateHostsResponse response = tencentConfig.getCvmClient().AllocateHosts(allocateHostsRequest);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 修改CDH实例的属性
     *本接口（ModifyHostsAttribute）用于修改CDH实例的属性，如实例名称和续费标记等。参数HostName和RenewFlag必须设置其中一个，但不能同时设置。
     *
     * 默认接口请求频率限制：10次/秒。
     * @param modifyHostsAttributeRequest
     * @return
     * https://cloud.tencent.com/document/api/213/16475
     */
    @Override
    public CommonResult ModifyHostsAttribute(ModifyHostsAttributeRequest modifyHostsAttributeRequest) {
        try {
            ModifyHostsAttributeResponse response = tencentConfig.getCvmClient().ModifyHostsAttribute(modifyHostsAttributeRequest);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 续费CDH实例
     * 本接口 (RenewHosts) 用于续费包年包月CDH实例。
     *
     * 只支持操作包年包月实例，否则操作会以特定错误码返回。
     * 续费时请确保账户余额充足。可通过DescribeAccountBalance接口查询账户余额。
     * 默认接口请求频率限制：10次/秒。
     * @param renewHostsRequest
     * @return
     * https://cloud.tencent.com/document/api/213/16476
     */
    @Override
    public CommonResult RenewHosts(RenewHostsRequest renewHostsRequest) {
        try {
            RenewHostsResponse response = tencentConfig.getCvmClient().RenewHosts(renewHostsRequest);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }
}
