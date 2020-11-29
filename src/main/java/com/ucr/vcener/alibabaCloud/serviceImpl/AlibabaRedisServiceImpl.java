package com.ucr.vcener.alibabaCloud.serviceImpl;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.r_kvstore.model.v20150101.*;
import com.google.gson.Gson;
import com.ucr.vcener.alibabaCloud.service.AlibabaRedisService;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.AlibabaConfig;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

public class AlibabaRedisServiceImpl implements AlibabaRedisService {
    @Autowired
    private AlibabaConfig alibabaConfig;

    @Override
    public CommonResult CreateInstance() {
        IAcsClient client = alibabaConfig.getClient();
        // 配置请求参数
        CreateInstanceRequest request = new CreateInstanceRequest();
        // 实例规格，详细信息请参见实例规格族
        // 说明 调用此接口需至少传递Capacity或InstanceClass中的一个参数。
        request.setInstanceClass("redis.logic.sharding.drredissdb2g.1db.0rodb.4proxy.default");
        // 实例名称
        // 名称为2-128个字符，以大小写字母或中文开头，不支持字符@/:=”<>{[]}和空格。
        request.setInstanceName("<your-instanceName>");
        // 实例密码 长度为8－32位，需包含大写字母、小写字母、特殊字符和数字中的至少三种，允许的特殊字符包括!@#$%^&*()_+-=。
        request.setPassword("<your-passwrod>");
        // 实例存储容量，单位为MB
        // 说明 调用此接口需至少传递Capacity或InstanceClass中的一个参数。
        request.setCapacity(16384L);
        // 随机字符串，用于保证请求的幂等性。要保证在不同请求间唯一
        request.setToken(UUID.randomUUID().toString());
        // 实例类型 取值：Redis  Memcache
        // 说明 默认为Redis。
        request.setInstanceType("Redis");
        // 版本类型取值：2.8  4.0   5.0
        // 说明 默认值为2.8。
        request.setEngineVersion("2.8");
        // 可用区ID，可以调用DescribeRegions接口查询，此参数指定创建实例的可用区
        request.setZoneId("<your-zoneId>");
        // 实例的详细配置，Json格式的字符串
        request.setConfig(
            "{\"EvictionPolicy\":\"volatile-lru\"," +
            "\"hash-max-ziplist-entries\":512," +
            "\"zset-max-ziplist-entries\":128," +
            "\"zset-max-ziplist-value\":64," +
            "\"set-max-intset-entries\":512," +
            "\"hash-max-ziplist-value\":64}"
        );
        // 付费类型
        // PrePaid（预付费）PostPaid（按量付费）说明 默认为PostPaid。
        request.setChargeType("PrePaid");
        // 节点类型
        // STAND_ALONE（单节点）；MASTER_SLAVE（多节点）；说明 默认值为MASTER_SLAVE。
        request.setNodeType("MASTER_SLAVE");
        // 网络类型
        // CLASSIC（经典网络）VPC（专有网络）说明 默认为经典网络。
        request.setNetworkType("VPC");
        // VPC网络的ID
        request.setVpcId("vpc-2zeugdd0wut2rh9gs0m8y");
        // 虚拟交换机的ID
        request.setVSwitchId("vrt-2zefso23vmu6xi3jeiw0z");
        // 付费周期
        // ChargeType（付费类型）为PrePaid时为必选参数，单位为月，可选值：1-9，12，24，36 。
        request.setPeriod("12");
        // 活动ID，业务ID
        request.setBusinessInfo("");
        // 优惠码默认值为youhuiquan_promotion_option_id_for_blank
        request.setSrcDBInstanceId("youhuiquan_promotion_option_id_for_blank");
        // 制定新势力的内网ID地址
        // request.setPrivateIpAddress("");
        // 是否开启自动续费
        // true（开启）false（不开启）说明 默认值：false。
        request.setAutoRenew("true");
        // 自动续费周期单位为月 可选值1、2、3、6、12
        // 说明 当AutoRenew为true时该参数必选。
        request.setAutoRenewPeriod("12");
        // 是否使用代金券
        // true（使用）false（不使用）说明 默认值：false。
        request.setAutoUseCoupon("false");
        try {
            CreateInstanceResponse response = client.getAcsResponse(request);
            return CommonResult.ok(new Gson().toJson(response));
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return CommonResult.error();
    }

    @Override
    public CommonResult DeleteInstance() {
        IAcsClient client = alibabaConfig.getClient();
        DeleteInstanceRequest request = new DeleteInstanceRequest();
        // 实例ID
        request.setInstanceId("r-2zec835iume0kbhgb4");
        try {
            // 发送请求获取返回结果
            DeleteInstanceResponse response = client.getAcsResponse(request);
            // 处理返回结果
            return CommonResult.ok(new HashMap<Object, Object>(1).put("处理返回结果", new Gson().toJson(response)));
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return CommonResult.error();
    }

    @Override
    public CommonResult ModifyInstanceAttribute() {
        IAcsClient client = alibabaConfig.getClient();
        // 配置请求参数
        ModifyInstanceAttributeRequest request = new ModifyInstanceAttributeRequest();
        // 实例ID
        request.setInstanceId("<your-InstanceId>");
        // 新的实例名称
        request.setInstanceName("test123");
        // 新的实例密码
        request.setNewPassword("Test123456");
        try {
            // 发送请求获取返回结果
            ModifyInstanceAttributeResponse response = client.getAcsResponse(request);
            // 处理返回结果
            return CommonResult.ok(new HashMap<Object, Object>(1).put("处理返回结果", new Gson().toJson(response)));
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return CommonResult.error();
    }

    @Override
    public CommonResult DescribeInstanceAttribute() {
        IAcsClient client = alibabaConfig.getClient();
        // 查询Redis实例列表（可做筛选）
        List<DescribeInstancesResponse.KVStoreInstance> instances = DescribeInstances(client);
        // 去Redis实例集合中的某一个进行详细信息查询
        //TODO 请根据实例情况进行选取，或者配合前端
        DescribeInstancesResponse.KVStoreInstance instance = instances.get(0);
        // 要查询详细信息的实例Id
        String instanceId = instance.getInstanceId();
        //查询Redis实例的详细信息
        String result = testDescribeInstanceAttribute(client, instanceId);
        return CommonResult.ok(new HashMap<Object, Object>(1).put("Redis实例的详细信息", result));
    }

    /**
     * 查询Redis实例列表（可做筛选）
     * 筛选条件可参考API：DescribeInstances
     */
    private static List<DescribeInstancesResponse.KVStoreInstance> DescribeInstances(IAcsClient client) {
        DescribeInstancesRequest request = new DescribeInstancesRequest();
        // 实例状态：
        // Normal（正常）
        // Creating（创建中）
        // Changing（修改中）
        // Inactive（被禁用）
        // Flushing（清除中）
        // Released（已释放）
        // Transforming（转换中）
        // Unavailable（服务停止）
        // Error（创建失败）
        // Migrating（迁移中）
        // BackupRecovering（备份恢复中）
        // MinorVersionUpgrading（小版本升级中）
        // NetworkModifying（网络变更中）
        // SSLModifying（SSL变更中）
        // MajorVersionUpgrading （大版本升级中，可正常访问）
        request.setInstanceStatus("Normal");
        try {
            DescribeInstancesResponse response = client.getAcsResponse(request);
            // 获取到Redis实例的集合
            return response.getInstances();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    /**
     * DescribeInstanceAttribute    查询单个Redis实例的详细信息
     */
    private static String testDescribeInstanceAttribute(IAcsClient client, String instanceId) {
        DescribeInstanceAttributeRequest request = new DescribeInstanceAttributeRequest();
        // 实例ID
        request.setInstanceId(instanceId);
        try {
            DescribeInstanceAttributeResponse response = client.getAcsResponse(request);
            // 处理单个Redis实例详细信息
            return new Gson().toJson(response.getInstances());
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    @Override
    public CommonResult DescribeRedis(
        String instanceId,
        String describeBackupsStartTime,
        String describeBackupsEndTime,
        String startTime,
        String endTime
    ) {
        IAcsClient client = alibabaConfig.getClient();
        // 查看Redis实例的审计日志
        List<DescribeAuditRecordsResponse.SQL> items = describeAuditRecords(client, instanceId, startTime, endTime);
        // 查询Redis实例的备份文件信息
        List<DescribeBackupsResponse.Backup> backups = describeBackups(
            client,
            instanceId,
            describeBackupsStartTime,
            describeBackupsEndTime
        );
        return null;
    }

    /**
     * DescribeAuditRecords    查看Redis实例的审计日志
     */
    private static List<DescribeBackupsResponse.Backup> describeBackups(
        IAcsClient client,
        String instanceId,
        String describeBackupsStartTime,
        String describeBackupsEndTime
    ) {
        DescribeBackupsRequest request = new DescribeBackupsRequest();
        // 目标实例的ID。
        request.setInstanceId(instanceId);
        // 查询开始时间，例如：2018-12-21T18:10Z。
        request.setStartTime(describeBackupsStartTime);
        // 查询结束时间，例如：2018-12-28T18:10Z。
        request.setEndTime(describeBackupsEndTime);
        try {
            DescribeBackupsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
            return response.getBackups();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    /**
     * DescribeBackups    查询Redis实例的备份文件信息
     */
    private static List<DescribeAuditRecordsResponse.SQL> describeAuditRecords(
        IAcsClient client,
        String instanceId,
        String startTime,
        String endTime
    ) {
        DescribeAuditRecordsRequest request = new DescribeAuditRecordsRequest();
        // 需要查询的实例的ID。
        request.setInstanceId(instanceId);
        // 查询开始时间，格式：YYYY-MM-DDTHH:mm:ssZ。
        request.setStartTime(startTime);
        // 查询结束时间，必须晚于查询开始时间，格式：YYYY-MM-DDTHH:mm:ssZ。
        request.setEndTime(endTime);
        try {
            DescribeAuditRecordsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
            return response.getItems();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }
}
