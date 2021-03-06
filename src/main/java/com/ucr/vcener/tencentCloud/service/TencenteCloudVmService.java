package com.ucr.vcener.tencentCloud.service;

import com.tencentcloudapi.cvm.v20170312.models.*;
import com.ucr.vcener.common.CommonResult;
import java.util.List;
import java.util.Map;

/**
 * 实例相关接口
 *
 * @author ymn
 * @date 2020/11/27 14:07
 */
public interface TencenteCloudVmService {
    /**
     * 查看实例列表
     * 本接口 (DescribeInstances) 用于查询一个或多个实例的详细信息。
     * 可以根据实例ID、实例名称或者实例计费模式等信息来查询实例的详细信息。过滤信息详细请见过滤器Filter。
     * 如果参数为空，返回当前用户一定数量（Limit所指定的数量，默认为20）的实例。
     * 支持查询实例的最新操作（LatestOperation）以及最新操作状态(LatestOperationState)。
     *
     * @param instanceIds
     * @param filters
     * @param offset
     * @param limit
     * @return https://cloud.tencent.com/document/api/213/15728
     */
    CommonResult describeInstances(List<String> instanceIds, List<Filter> filters, Long offset, Long limit);

    /**
     * 查询所支持的实例机型族信息
     *
     * @return https://cloud.tencent.com/document/api/213/15748
     */
    CommonResult describeInstanceFamilyConfigs();

    /**
     * 获取可用区机型配置信息
     *
     * @param filters zone 按照【可用区】进行过滤
     *                instance-family 实例机型系列形如：S1、I1、M1等。
     *                instance-type 可通过调用接口 DescribeInstanceTypeConfigs 来获得最新的规格表或参见实例类型描述。若不指定该参数，则默认机型为S1.SMALL1。
     *                instance-charge-type (PREPAID：表示预付费，即包年包月 | POSTPAID_BY_HOUR：表示后付费，即按量计费 | CDHPAID：表示CDH付费，即只对CDH计费，不对CDH上的实例计费。)
     * @return https://cloud.tencent.com/document/api/213/17378
     */
    CommonResult describeZoneInstanceConfigInfos(List<Filter> filters);

    /**
     * 查询实例机型列表
     *
     * @param filters zone 可用区
     *                instance-family 按照【实例机型系列】进行过滤。实例机型系列形如：S1、I1、M1等。
     *                每次请求的Filters的上限为10，Filter.Values的上限为1。
     * @return https://cloud.tencent.com/document/api/213/15749
     */
    CommonResult describeInstanceTypeConfigs(List<Filter> filters);

    /**
     * 查询实例操作限制
     *
     * @param instanceIds 按照一个或者多个实例ID查询，可通过DescribeInstancesAPI返回值中的InstanceId获取。每次请求的实例的上限为100。
     * @param operation   INSTANCE_DEGRADE：实例降配操作
     * @return
     * https://cloud.tencent.com/document/api/213/34316
     */
    CommonResult describeInstancesOperationLimit(List<String> instanceIds, String operation);

    /**
     * 查询实例管理终端地址
     * 本接口 ( DescribeInstanceVncUrl ) 用于查询实例管理终端地址，获取的地址可用于实例的 VNC 登录。
     *
     * 处于 STOPPED 状态的机器无法使用此功能。
     * 管理终端地址的有效期为 15 秒，调用接口成功后如果 15 秒内不使用该链接进行访问，管理终端地址自动失效，您需要重新查询。
     * 管理终端地址一旦被访问，将自动失效，您需要重新查询。
     * 如果连接断开，每分钟内重新连接的次数不能超过 30 次。
     * 获取到 InstanceVncUrl 后，您需要在链接 https://img.qcloud.com/qcloud/app/active_vnc/index.html? 末尾加上参数 InstanceVncUrl=xxxx 。
     *
     * 参数 InstanceVncUrl ：调用接口成功后会返回的 InstanceVncUrl 的值。
     *
     * @param instanceIds 按照一个或者多个实例ID查询，可通过DescribeInstancesAPI返回值中的InstanceId获取。每次请求的实例的上限为100。
     * @return
     * https://cloud.tencent.com/document/api/213/18150
     */
    CommonResult describeInstanceVncUrl(List<String> instanceIds);

    /**
     * 创建实例询价
     * @param inquiryPriceRunInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15726
     */
    CommonResult inquiryPriceRunInstances(InquiryPriceRunInstancesRequest inquiryPriceRunInstancesRequest);

    /**
     * 续费实例询价
     * @param inquiryPriceRunInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15725
     */
    CommonResult inquiryPriceRenewInstances(InquiryPriceRenewInstancesRequest inquiryPriceRunInstancesRequest);

    /**
     * 重装实例询价
     * 本接口 (InquiryPriceResetInstance) 用于重装实例询价。
     *
     * 如果指定了ImageId参数，则使用指定的镜像进行重装询价；否则按照当前实例使用的镜像进行重装询价。
     * 目前只支持系统盘类型是CLOUD_BASIC、CLOUD_PREMIUM、CLOUD_SSD类型的实例使用该接口实现Linux和Windows操作系统切换的重装询价。
     * 目前不支持境外地域的实例使用该接口实现Linux和Windows操作系统切换的重装询价。
     * @param inquiryPriceResetInstanceRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15747
     */
    CommonResult inquiryPriceResetInstance(InquiryPriceResetInstanceRequest inquiryPriceResetInstanceRequest);

    /**
     * 调整实例配置询价
     * @param inquiryPriceResetInstancesTypeRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15733
     */
    CommonResult inquiryPriceResetInstancesType(InquiryPriceResetInstancesTypeRequest inquiryPriceResetInstancesTypeRequest);

    /**
     *扩容实例磁盘询价
     * 本接口 (InquiryPriceResizeInstanceDisks) 用于扩容实例的数据盘询价。
     *
     * 目前只支持扩容非弹性数据盘（DescribeDisks接口返回值中的Portable为false表示非弹性）询价，且数据盘类型为：CLOUD_BASIC、CLOUD_PREMIUM、CLOUD_SSD。
     * 目前不支持CDH实例使用该接口扩容数据盘询价。 仅支持包年包月实例随机器购买的数据盘。 目前只支持扩容一块数据盘询价。
     * @param inquiryPriceResizeInstanceDisksRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15751
     */
    CommonResult inquiryPriceResizeInstanceDisks(InquiryPriceResizeInstanceDisksRequest inquiryPriceResizeInstanceDisksRequest);

    /**
     *修改实例计费模式询价
     *接口请求域名： cvm.tencentcloudapi.com 。
     *
     * 本接口 (InquiryPriceModifyInstancesChargeType) 用于切换实例的计费模式询价。
     *
     * 只支持从 POSTPAID_BY_HOUR 计费模式切换为PREPAID计费模式。
     * 关机不收费的实例、BC1和BS1机型族的实例、设置定时销毁的实例、竞价实例不支持该操作。
     * @param inquiryPriceResizeInstanceDisksRequest
     * @return
     * https://cloud.tencent.com/document/api/213/17965
     */
    CommonResult inquiryPriceModifyInstancesChargeType(InquiryPriceModifyInstancesChargeTypeRequest inquiryPriceResizeInstanceDisksRequest);

    /**
     * 创建实例
     * 本接口 (RunInstances) 用于创建一个或多个指定配置的实例。
     *
     * 实例创建成功后将自动开机启动，实例状态变为“运行中”。
     * 预付费实例的购买会预先扣除本次实例购买所需金额，按小时后付费实例购买会预先冻结本次实例购买一小时内所需金额，在调用本接口前请确保账户余额充足。
     * 本接口允许购买的实例数量遵循CVM实例购买限制，所创建的实例和官网入口创建的实例共用配额。
     * 本接口为异步接口，当创建实例请求下发成功后会返回一个实例ID列表和一个RequestId，此时创建实例操作并未立即完成。在此期间实例的状态将会处于“PENDING”，实例创建结果可以通过调用 DescribeInstances 接口查询，如果实例状态(InstanceState)由“PENDING”变为“RUNNING”，则代表实例创建成功，“LAUNCH_FAILED”代表实例创建失败。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15730
     */
    CommonResult runInstances(RunInstancesRequest runInstancesRequest);

    /**
     * 启动实例
     * 本接口 (StartInstances) 用于启动一个或多个实例。
     *
     * 只有状态为STOPPED的实例才可以进行此操作。
     * 接口调用成功时，实例会进入STARTING状态；启动实例成功时，实例会进入RUNNING状态。
     * 支持批量操作。每次请求批量实例的上限为100。
     * 本接口为异步接口，启动实例请求发送成功后会返回一个RequestId，此时操作并未立即完成。实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表启动实例操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15735
     */
    CommonResult startInstances(StartInstancesRequest runInstancesRequest);

    /**
     * 重启实例
     * 本接口 (RebootInstances) 用于重启实例。
     *
     * 只有状态为RUNNING的实例才可以进行此操作。
     * 接口调用成功时，实例会进入REBOOTING状态；重启实例成功时，实例会进入RUNNING状态。
     * 支持强制重启。强制重启的效果等同于关闭物理计算机的电源开关再重新启动。强制重启可能会导致数据丢失或文件系统损坏，请仅在服务器不能正常重启时使用。
     * 支持批量操作，每次请求批量实例的上限为100。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15742
     */
    CommonResult rebootInstances(RebootInstancesRequest runInstancesRequest);

    /**
     *关闭实例
     * 本接口 (StopInstances) 用于关闭一个或多个实例。
     *
     * 只有状态为RUNNING的实例才可以进行此操作。
     * 接口调用成功时，实例会进入STOPPING状态；关闭实例成功时，实例会进入STOPPED状态。
     * 支持强制关闭。强制关机的效果等同于关闭物理计算机的电源开关。强制关机可能会导致数据丢失或文件系统损坏，请仅在服务器不能正常关机时使用。
     * 支持批量操作。每次请求批量实例的上限为100。
     * 本接口为异步接口，关闭实例请求发送成功后会返回一个RequestId，此时操作并未立即完成。实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表关闭实例操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15743
     */
    CommonResult StopInstances(StopInstancesRequest runInstancesRequest);

    /**
     * 续费实例
     * 本接口 (RenewInstances) 用于续费包年包月实例。
     *
     * 只支持操作包年包月实例。
     * 续费时请确保账户余额充足。可通过DescribeAccountBalance接口查询账户余额。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15740
     */
    CommonResult RenewInstances(RenewInstancesRequest runInstancesRequest);

    /**
     * 重装实例
     * 本接口 (ResetInstance) 用于重装指定实例上的操作系统。
     *
     * 如果指定了ImageId参数，则使用指定的镜像重装；否则按照当前实例使用的镜像进行重装。
     * 系统盘将会被格式化，并重置；请确保系统盘中无重要文件。
     * Linux和Windows系统互相切换时，该实例系统盘ID将发生变化，系统盘关联快照将无法回滚、恢复数据。
     * 密码不指定将会通过站内信下发随机密码。
     * 目前只支持系统盘类型是CLOUD_BASIC、CLOUD_PREMIUM、CLOUD_SSD类型的实例使用该接口实现Linux和Windows操作系统切换。
     * 目前不支持境外地域的实例使用该接口实现Linux和Windows操作系统切换。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15724
     */
    CommonResult ResetInstance(ResetInstanceRequest runInstancesRequest);

    /**
     * 调整实例配置
     * 本接口 (ResetInstancesType) 用于调整实例的机型。
     *
     * 目前只支持系统盘类型是CLOUD_BASIC、CLOUD_PREMIUM、CLOUD_SSD类型的实例使用该接口进行机型调整。
     * 目前不支持CDH实例使用该接口调整机型。对于包年包月实例，使用该接口会涉及扣费，请确保账户余额充足。可通过DescribeAccountBalance接口查询账户余额。
     * 本接口为异步接口，调整实例配置请求发送成功后会返回一个RequestId，此时操作并未立即完成。实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表调整实例配置操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15744
     */
    CommonResult ResetInstancesType(ResetInstancesTypeRequest runInstancesRequest);

    /**
     * 扩容实例磁盘
     * 本接口 (ResizeInstanceDisks) 用于扩容实例的数据盘。
     *
     * 目前只支持扩容非弹性数据盘（DescribeDisks接口返回值中的Portable为false表示非弹性），且数据盘类型为：CLOUD_BASIC、CLOUD_PREMIUM、CLOUD_SSD和CDH实例的LOCAL_BASIC、LOCAL_SSD类型数据盘。
     * 对于包年包月实例，使用该接口会涉及扣费，请确保账户余额充足。可通过DescribeAccountBalance接口查询账户余额。
     * 目前只支持扩容一块数据盘。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15731
     */
    CommonResult ResizeInstanceDisks(ResizeInstanceDisksRequest runInstancesRequest);

    /**
     * 重置实例密码
     * 本接口 (ResetInstancesPassword) 用于将实例操作系统的密码重置为用户指定的密码。
     *
     * *如果是修改系统管理云密码：实例的操作系统不同，管理员帐号也会不一样(Windows为Administrator，Ubuntu为ubuntu，其它系统为root)。
     *
     * 重置处于运行中状态的实例密码，需要设置关机参数ForceStop为TRUE。如果没有显式指定强制关机参数，则只有处于关机状态的实例才允许执行重置密码操作。
     * 支持批量操作。将多个实例操作系统的密码重置为相同的密码。每次请求批量实例的上限为100。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15736
     */
    CommonResult ResetInstancesPassword(ResetInstancesPasswordRequest runInstancesRequest);

    /**
     * 修改实例的属性
     *本接口 (ModifyInstancesAttribute) 用于修改实例的属性（目前只支持修改实例的名称和关联的安全组）。
     *
     * “实例名称”仅为方便用户自己管理之用，腾讯云并不以此名称作为提交工单或是进行实例管理操作的依据。
     * 支持批量操作。每次请求批量实例的上限为100。
     * 修改关联安全组时，子机原来关联的安全组会被解绑。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15739
     */
    CommonResult ModifyInstancesAttribute(ModifyInstancesAttributeRequest runInstancesRequest);

    /**
     * 修改实例所属项目
     * 本接口 (ModifyInstancesProject) 用于修改实例所属项目。
     *
     * 项目为一个虚拟概念，用户可以在一个账户下面建立多个项目，每个项目中管理不同的资源；将多个不同实例分属到不同项目中，后续使用 DescribeInstances接口查询实例，项目ID可用于过滤结果。
     * 绑定负载均衡的实例不支持修改实例所属项目，请先使用DeregisterInstancesFromLoadBalancer接口解绑负载均衡。
     * 支持批量操作。每次请求批量实例的上限为100。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15746
     */
    CommonResult ModifyInstancesProject(ModifyInstancesProjectRequest runInstancesRequest);

    /**
     *修改实例计费模式
     *本接口 (ModifyInstancesChargeType) 用于切换实例的计费模式。
     *
     * 只支持从 POSTPAID_BY_HOUR 计费模式切换为PREPAID计费模式。
     * 关机不收费的实例、BC1和BS1机型族的实例、设置定时销毁的实例不支持该操作。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     *https://cloud.tencent.com/document/api/213/17964
     */
    CommonResult ModifyInstancesChargeType(ModifyInstancesChargeTypeRequest runInstancesRequest);

    /**
     * 修改实例续费标识
     * 本接口 (ModifyInstancesRenewFlag) 用于修改包年包月实例续费标识。
     *
     * 实例被标识为自动续费后，每次在实例到期时，会自动续费一个月。
     * 支持批量操作。每次请求批量实例的上限为100。
     * 实例操作结果可以通过调用 DescribeInstances 接口查询，如果实例的最新操作状态(LatestOperationState)为“SUCCESS”，则代表操作成功。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15752
     */
    CommonResult ModifyInstancesRenewFlag(ModifyInstancesRenewFlagRequest runInstancesRequest);

    /**
     *退还实例
     *本接口 (TerminateInstances) 用于主动退还实例。
     *
     * 不再使用的实例，可通过本接口主动退还。
     * 按量计费的实例通过本接口可直接退还；包年包月实例如符合退还规则，也可通过本接口主动退还。
     * 包年包月实例首次调用本接口，实例将被移至回收站，再次调用本接口，实例将被销毁，且不可恢复。按量计费实例调用本接口将被直接销毁
     * 支持批量操作，每次请求批量实例的上限为100。
     * 默认接口请求频率限制：10次/秒。
     * @param runInstancesRequest
     * @return
     * https://cloud.tencent.com/document/api/213/15723
     */
    CommonResult TerminateInstances(TerminateInstancesRequest runInstancesRequest);

    /**
     * 查看实例状态列表
     * 本接口 (DescribeInstancesStatus) 用于查询一个或多个实例的状态。
     *
     * 可以根据实例ID来查询实例的状态。
     * 如果参数为空，返回当前用户一定数量（Limit所指定的数量，默认为20）的实例状态。
     * 默认接口请求频率限制：40次/秒。
     * @param instanceIds 按照一个或者多个实例ID查询。
     * @param offset
     * @param limit
     * @return
     * https://cloud.tencent.com/document/api/213/15738
     */
    CommonResult DescribeInstancesStatus(List<String> instanceIds, Long offset, Long limit);

    /**
     * 本接口(InquirePricePurchaseReservedInstancesOffering)用于创建预留实例询价。本接口仅允许针对购买限制范围内的预留实例配置进行询价。预留实例当前只针对国际站白名单用户开放。
     *
     * 默认接口请求频率限制：20次/秒。
     * @return
     * https://cloud.tencent.com/document/api/213/48127
     */
    CommonResult InquirePricePurchaseReservedInstancesOffering();

    /**
     * 本接口(DescribeReservedInstancesConfigInfos)供用户列出可购买预留实例机型配置。预留实例当前只针对国际站白名单用户开放。
     *
     * 默认接口请求频率限制：20次/秒。
     * @return
     * https://cloud.tencent.com/document/api/213/48128
     */
    CommonResult DescribeReservedInstancesConfigInfos();
}
