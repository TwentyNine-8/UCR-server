package com.ucr.vcener.alibabaCloud.service;

import com.ucr.vcener.common.CommonResult;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 阿里云接口
 *
 * @author ymn
 * @date 2020/11/27 10:10
 */
public interface AlibabaECSCloudService {
    //获取ECS示例配置
    CommonResult DescribeInstances();

    //获取磁盘信息
    CommonResult DescribeDisks();

    //查询预付费示例自动续费状态
    CommonResult ECSOperate();

    //获取示例状态
    CommonResult DescribeInstanceStatus();

    //查询安全组信息
    CommonResult DescribeSecurityGroups();

    //查询安全组详情
    CommonResult DescribeSecurityGroupAttribute();

    //增加安全组规则(这里的SecurityGroupId根据自己的需求，自行配置)
    CommonResult addSecurityGroupRules(String SecurityGroupId);

    //修改实例的带宽配置(ECS实例ID自行配置)
    CommonResult ModifyInstanceNetworkSpec(String instanceId);

    //为ECS示例挂载已购买的按量付费的数据盘（ECS实例ID自行配置）
    CommonResult AttachDisk(String instanceId);

    //从实例中分离一个弹性网卡到新的实例（vpc类型）
    CommonResult VpcDemo(String dBinstanceId);

    //更新安全组规则
    CommonResult UpdateSecurityGroup();

    //创建并执行云助手命令（）
    CommonResult InvokeCommand(String command) throws UnsupportedEncodingException;

    //获取某实例磁盘的信息
    CommonResult getOneDescribeDisks();

    //创建ECS实例（包括创建VPC、交换机）
    CommonResult createECSDemo() throws InterruptedException;

    /**
     * 为ECS实例添加RAM角色
     * // 实例ID，最多支持100台实例。Json格式字符串(自行定义)
     * // 格式：["instanceId1", "instanceId2", "instanceId3"…]
     * // 实例RAM角色名称。您可以使用 RAM API ListRoles查询您已创建的实例RAM角色
     */
    CommonResult AttachInstanceRamRole(String InstanceIds, String RamRoleName);

    //查询创建ECS所需要的资源信息
    CommonResult DescribeInstanceRequredResource();

    /**
     * 查询ECS实例的监控信息和自定义数据
     * // 待查询的实例 ID
     * private static String instanceId = "i-bp13p7vlcb1uih******";
     * // 获取数据的起始时间点。按照 ISO8601 表示，并需要使用 UTC 时间，格式为：YYYY-MM-DDThh:mm:ssZ。如果指定的秒（ss）不是 00，则自动换算为下一分钟。
     * private static String startTime = "2019-11-11T07:00:00Z";
     * // 获取数据的结束时间点。按照 ISO8601 标准表示，并需要使用 UTC 时间，格式为：YYYY-MM-DDThh:mm:ssZ。 如果指定的秒（ss）不是 00，则自动换算为下一分钟。
     * private static String endTime = "2019-11-11T07:30:00Z";
     */
    CommonResult getECSDate(String instanceId, String startTime, String endTime);

    //获取某状态的所有ECS实例集合
    CommonResult someOneStatusECS();

    /**
     * 变更ECS实例规格
     * 已关机状态的ECS实例
     * private static String instancenId = "i-bp1gh*****";
     */
    CommonResult ModifyInstance(String instancenId);

    //TODO 创建与管理无保护期抢占式实例
    CommonResult NoDurationSpotSample();
}
