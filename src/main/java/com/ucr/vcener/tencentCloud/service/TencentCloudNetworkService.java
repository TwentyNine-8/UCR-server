package com.ucr.vcener.tencentCloud.service;

import com.tencentcloudapi.cvm.v20170312.models.*;
import com.ucr.vcener.common.CommonResult;

/**
 * 网络相关接口
 *
 * @author ymn
 * @date 2020/11/27 20:58
 */
public interface TencentCloudNetworkService {
    /**
     * 查询实例带宽配置
     * 本接口 (DescribeInstanceInternetBandwidthConfigs) 用于查询实例带宽配置。
     * <p>
     * 只支持查询BANDWIDTH_PREPAID（ 预付费按带宽结算 ）计费模式的带宽配置。
     * 接口返回实例的所有带宽配置信息（包含历史的带宽配置信息）。
     * 默认接口请求频率限制：10次/秒。
     *
     * @param request
     * @return CommonResult
     * https://cloud.tencent.com/document/api/213/15734
     */
    CommonResult DescribeInstanceInternetBandwidthConfigs(DescribeInstanceInternetBandwidthConfigsRequest request);

    /**
     * 查询网络计费类型
     * 本接口（DescribeInternetChargeTypeConfigs）用于查询网络的计费类型。
     *
     * 默认接口请求频率限制：10次/秒。
     *
     * @return
     * https://cloud.tencent.com/document/api/213/15729
     */
    CommonResult DescribeInternetChargeTypeConfigs();

    /**
     * 调整实例带宽上限询价
     * 本接口 (InquiryPriceResetInstancesInternetMaxBandwidth) 用于调整实例公网带宽上限询价。
     *
     * 不同机型带宽上限范围不一致，具体限制详见公网带宽上限。
     * 对于BANDWIDTH_PREPAID计费方式的带宽，目前不支持调小带宽，且需要输入参数StartTime和EndTime，指定调整后的带宽的生效时间段。在这种场景下会涉及扣费，请确保账户余额充足。可通过DescribeAccountBalance接口查询账户余额。
     * 对于 TRAFFIC_POSTPAID_BY_HOUR、 BANDWIDTH_POSTPAID_BY_HOUR 和 BANDWIDTH_PACKAGE 计费方式的带宽，使用该接口调整带宽上限是实时生效的，可以在带宽允许的范围内调大或者调小带宽，不支持输入参数 StartTime 和 EndTime 。
     * 接口不支持调整BANDWIDTH_POSTPAID_BY_MONTH计费方式的带宽。
     * 接口不支持批量调整 BANDWIDTH_PREPAID 和 BANDWIDTH_POSTPAID_BY_HOUR 计费方式的带宽。
     * 接口不支持批量调整混合计费方式的带宽。例如不支持同时调整TRAFFIC_POSTPAID_BY_HOUR和BANDWIDTH_PACKAGE计费方式的带宽。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15732
     */
    CommonResult InquiryPriceResetInstancesInternetMaxBandwidth(InquiryPriceResetInstancesInternetMaxBandwidthRequest request);

    /**
     * 调整实例带宽上限
     * 本接口 (ResetInstancesInternetMaxBandwidth) 用于调整实例公网带宽上限。
     *
     * 不同机型带宽上限范围不一致，具体限制详见公网带宽上限。
     * 对于 BANDWIDTH_PREPAID 计费方式的带宽，需要输入参数 StartTime 和 EndTime ，指定调整后的带宽的生效时间段。在这种场景下目前不支持调小带宽，会涉及扣费，请确保账户余额充足。可通过 DescribeAccountBalance 接口查询账户余额。
     * 对于 TRAFFIC_POSTPAID_BY_HOUR 、 BANDWIDTH_POSTPAID_BY_HOUR 和 BANDWIDTH_PACKAGE 计费方式的带宽，使用该接口调整带宽上限是实时生效的，可以在带宽允许的范围内调大或者调小带宽，不支持输入参数 StartTime 和 EndTime 。
     * 接口不支持调整 BANDWIDTH_POSTPAID_BY_MONTH 计费方式的带宽。
     * 接口不支持批量调整 BANDWIDTH_PREPAID 和 BANDWIDTH_POSTPAID_BY_HOUR 计费方式的带宽。
     * 接口不支持批量调整混合计费方式的带宽。例如不支持同时调整 TRAFFIC_POSTPAID_BY_HOUR 和 BANDWIDTH_PACKAGE 计费方式的带宽。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15721
     */
    CommonResult ResetInstancesInternetMaxBandwidth(ResetInstancesInternetMaxBandwidthRequest request);

    /**
     * 修改实例vpc属性
     * 本接口(ModifyInstancesVpcAttribute)用于修改实例vpc属性，如私有网络ip。
     *
     * 此操作默认会关闭实例，完成后再启动。
     * 当指定私有网络ID和子网ID（子网必须在实例所在的可用区）与指定实例所在私有网络不一致时，会将实例迁移至指定的私有网络的子网下。执行此操作前请确保指定的实例上没有绑定弹性网卡和负载均衡。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15750
     */
    CommonResult ModifyInstancesVpcAttribute(ModifyInstancesVpcAttributeRequest request);
}
