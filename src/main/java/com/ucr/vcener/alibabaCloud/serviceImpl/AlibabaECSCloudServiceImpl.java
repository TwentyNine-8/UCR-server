package com.ucr.vcener.alibabaCloud.serviceImpl;

import cn.hutool.core.collection.CollectionUtil;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vpc.model.v20160428.CreateVSwitchRequest;
import com.aliyuncs.vpc.model.v20160428.CreateVSwitchResponse;
import com.aliyuncs.vpc.model.v20160428.CreateVpcRequest;
import com.aliyuncs.vpc.model.v20160428.CreateVpcResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.ucr.vcener.alibabaCloud.service.AlibabaECSCloudService;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.AlibabaConfig;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import liquibase.pro.packaged.O;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ymn
 * @date 2020/11/27 10:19
 */
public class AlibabaECSCloudServiceImpl implements AlibabaECSCloudService {
    @Autowired
    private AlibabaConfig alibabaConfig;

    @Override
    public CommonResult DescribeInstances() {
        int i = 0;
        HashMap<String, Object> returnResult = new HashMap<>();
        // 创建API请求并设置参数
        DescribeInstancesRequest request = new DescribeInstancesRequest();
        request.setPageSize(10);
        request.setConnectTimeout(5000); //设置连接超时为5000毫秒
        request.setReadTimeout(5000); //设置读超时为5000毫秒
        // 发起请求并处理应答或异常
        DescribeInstancesResponse response;
        try {
            response = alibabaConfig.getClient().getAcsResponse(request);
            for (DescribeInstancesResponse.Instance instance : response.getInstances()) {
                i++;
                returnResult.put("imageId" + i, instance.getImageId());
                returnResult.put("instanceId" + i, instance.getInstanceId());
                returnResult.put("publicIpAddress" + i, instance.getPublicIpAddress());
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return CommonResult.ok(returnResult);
    }

    @Override
    public CommonResult DescribeDisks() {
        HashMap<Object, Object> result = new HashMap<>();
        // 创建请求接口
        DescribeDisksRequest request = new DescribeDisksRequest();
        // 云盘或本地盘挂载的实例ID。
        request.setInstanceId("i-bp67acfmxazb4q****");
        try {
            // 发起请求并获取返回值
            DescribeDisksResponse response = alibabaConfig.getClient().getAcsResponse(request);
            // 处理业务逻辑
            result.put("DescribeDisksResponse", new Gson().toJson(response));
            return CommonResult.ok(result);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return CommonResult.error();
    }

    @Override
    public CommonResult ECSOperate() {
        HashMap<String, Object> result = new HashMap<>();
        // 创建请求接口
        DescribeInstanceAutoRenewAttributeRequest request = new DescribeInstanceAutoRenewAttributeRequest();
        request.setInstanceId("<Instance-Id>");
        try {
            // 发起请求并获取返回值
            DescribeInstanceAutoRenewAttributeResponse response = alibabaConfig.getClient().getAcsResponse(request);
            // 处理业务逻辑
            result.put("业务逻辑response", new Gson().toJson(response));
            return CommonResult.ok(result);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return CommonResult.error();
    }

    @Override
    public CommonResult DescribeInstanceStatus() {
        HashMap<Object, Object> result = new HashMap<>();
        // 创建请求接口
        DescribeInstanceStatusRequest request = new DescribeInstanceStatusRequest();
        try {
            // 发起请求并获取返回值
            DescribeInstanceStatusResponse response = alibabaConfig.getClient().getAcsResponse(request);
            // 处理业务逻辑
            result.put("状态返回response", new Gson().toJson(response));
            return CommonResult.ok(result);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return CommonResult.error();
    }

    @Override
    public CommonResult DescribeSecurityGroups() {
        HashMap<Object, Object> result = new HashMap<>();
        // 创建请求接口
        DescribeSecurityGroupsRequest request = new DescribeSecurityGroupsRequest();
        request.setSecurityGroupId("安全组ID");
        try {
            // 发起请求并获取返回值
            DescribeSecurityGroupsResponse response = alibabaConfig.getClient().getAcsResponse(request);
            // 处理业务逻辑
            result.put("安全组信息response", new Gson().toJson(response));
            return CommonResult.ok(result);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return CommonResult.error();
    }

    @Override
    public CommonResult DescribeSecurityGroupAttribute() {
        HashMap<Object, Object> result = new HashMap<>();
        // 创建请求接口
        DescribeSecurityGroupAttributeRequest request = new DescribeSecurityGroupAttributeRequest();
        request.setSecurityGroupId("安全组ID");
        try {
            // 发起请求并获取返回值
            DescribeSecurityGroupAttributeResponse response = alibabaConfig.getClient().getAcsResponse(request);
            // 处理业务逻辑
            result.put("安全组详情response", new Gson().toJson(response));
            return CommonResult.ok(result);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return CommonResult.error();
    }

    @Override
    public CommonResult addSecurityGroupRules(String SecurityGroupId) {
        IAcsClient client = alibabaConfig.getClient();
        //查询可以使用的阿里云地域
        List<DescribeRegionsResponse.Region> regions = DescribeRegions(client);
        //这里取集合的第一个元素（请按照您的实际需求进行选取）
        String regionId = regions.get(0).getBizRegionId();
        //查询安全组的详情
        String securityGroupId = DescribeSecurityGroupAttribute(client, SecurityGroupId);
        //修改安全组入方向规则
        HashMap<Object, Object> returnResult = AuthorizeSecurityGroup(securityGroupId, client);
        return CommonResult.ok(returnResult);
    }

    /**
     * AuthorizeSecurityGroup    增加一条安全组入方向规则
     */
    private HashMap<Object, Object> AuthorizeSecurityGroup(String securityGroupId, IAcsClient client) {
        HashMap<Object, Object> result = new HashMap<>();
        AuthorizeSecurityGroupRequest request = new AuthorizeSecurityGroupRequest();
        // 目标安全组地域ID。
        // request.setRegionId(regionId);
        // 目标安全组ID。
        request.setSecurityGroupId(securityGroupId);
        // 传输层协议。取值大小写敏感。取值范围：tcp udp icmp gre all：支持所有协议。
        request.setIpProtocol("udp");
        // SecurityGroupId方开放的传输层协议相关的端口范围。取值范围。
        // TCP/UDP协议：取值范围为1~65535。使用斜线（/）隔开起始端口和终止端口。正确示范：1/200；错误示范：200/1。
        // ICMP协议：-1/-1。
        // GRE协议：-1/-1。
        // IpProtocol取值为all：-1/-1。
        request.setPortRange("1/200");
        // 网卡类型。取值范围：
        // internet：公网网卡。
        // intranet：内网网卡。
        request.setNicType("intranet");
        // 设置访问权限。取值范围：
        // accept（默认）：接受访问。
        // drop：拒绝访问，不返回拒绝信息。
        request.setPolicy("accept");
        // 安全组规则优先级。取值范围：1~100。
        request.setPriority("1");
        // 源端IPv4 CIDR地址段。支持CIDR格式和IPv4格式的IP地址范围。
        // 需要设置访问权限的源端安全组ID。至少设置一项SourceGroupId或者SourceCidrIp参数。
        // 如果指定了SourceGroupId没有指定参数SourceCidrIp，则参数NicType取值只能为intranet。
        // 如果同时指定了SourceGroupId和SourceCidrIp，则默认以SourceCidrIp为准。
        request.setSourceCidrIp("10.0.0.0/8");
        try {
            AuthorizeSecurityGroupResponse response = client.getAcsResponse(request);
            result.put("success", "--------------------入方向安全组新增成功--------------------");
            result.put("response", new Gson().toJson(response));
            return result;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    /**
     * DescribeSecurityGroupAttribute    查询一个安全组的详情
     */
    private String DescribeSecurityGroupAttribute(IAcsClient client, String securityGroupId) {
        DescribeSecurityGroupAttributeRequest request = new DescribeSecurityGroupAttributeRequest();
        request.setSecurityGroupId(securityGroupId);
        request.setDirection("all");
        try {
            DescribeSecurityGroupAttributeResponse response = client.getAcsResponse(request);
            System.out.println("--------------------安全组的详情查询成功--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getSecurityGroupId();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    /**
     * DescribeRegions    查询您可以使用的阿里云地域
     */
    private List<DescribeRegionsResponse.Region> DescribeRegions(IAcsClient client) {
        DescribeRegionsRequest request = new DescribeRegionsRequest();
        try {
            DescribeRegionsResponse response = client.getAcsResponse(request);
            System.out.println("--------------------地域信息集合查询成功--------------------");
            System.out.println(new Gson().toJson(response.getRegions()));
            return response.getRegions();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    @Override
    public CommonResult ModifyInstanceNetworkSpec(String instanceId) {
        IAcsClient client = alibabaConfig.getClient();
        //修改实例的宽带配置
        ModifyInstanceNetworkSpec(client, instanceId);
        //查询一台或多台实例的详细信息
        HashMap<Object, Object> returnResult = DescribeInstances(client, instanceId);
        return CommonResult.ok(returnResult);
    }

    private HashMap<Object, Object> DescribeInstances(IAcsClient client, String instanceId) {
        HashMap<Object, Object> result = new HashMap<>();
        DescribeInstancesRequest request = new DescribeInstancesRequest();
        JsonArray elements = new JsonArray();
        elements.add(instanceId);
        request.setInstanceIds(elements.toString());
        try {
            DescribeInstancesResponse response = client.getAcsResponse(request);
            result.put("----实例的详细信息----", new Gson().toJson(response));
            return result;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    private void ModifyInstanceNetworkSpec(IAcsClient client, String instanceId) {
        ModifyInstanceNetworkSpecRequest request = new ModifyInstanceNetworkSpecRequest();
        // 需要修改网络配置的实例ID。
        request.setInstanceId(instanceId);
        // 公网入带宽最大值，单位：Mbps（Megabit per second）。取值范围：1~200
        request.setInternetMaxBandwidthIn(50);
        // 公网出带宽最大值，单位：Mbps（Megabit per second）。取值范围：0~100
        request.setInternetMaxBandwidthOut(50);
        // 转换网络计费方式。取值范围：
        // PayByTraffic：按使用流量计费
        // PayByBandwidth：按固定带宽计费
        request.setNetworkChargeType("PayByTraffic");
        // 临时带宽升级开始时间。按照ISO8601标准表示，并使用UTC +0时间，格式为yyyy-MM-ddThh:mmZ。精确到分钟（mm）。
        request.setStartTime("2019-09-16T16:00Z");
        // 临时带宽升级结束时间。按照ISO8601标准表示，并使用UTC +0时间，格式为yyyy-MM-ddThhZ。精确到小时（hh）。
        request.setEndTime("2019-09-17T16:00Z");
        // 是否分配公网 IP 地址。默认值：false
        request.setAllocatePublicIp(false);
        // 是否自动支付。取值范围：
        // true：变更带宽配置后，自动扣费。当您将参数Autopay置为true时，您需要确保账户余额充足，如果账户余额不足会生成异常订单，此订单暂时不支持通过ECS控制台支付，只能作废。
        // false：变更带宽配置后，只生成订单不扣费。如果您的支付方式余额不足，可以将参数Autopay置为false，即取消自动支付，此时调用该接口会生成正常的未支付订单，此订单可登录ECS管理控制台支付。
        // 默认值：true
        request.setAutoPay(true);
        try {
            ModifyInstanceNetworkSpecResponse response = client.getAcsResponse(request);
            System.out.println("--------------------实例的带宽配置修改成功--------------------");
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

    @Override
    public CommonResult AttachDisk(String instanceId) {
        IAcsClient client = alibabaConfig.getClient();
        List<DescribeDisksResponse.Disk> disks = DescribeDisks(client);
        // 本示例只做简单处理来获取云盘ID，请您按照实际情况来修改此处代码
        try {
            // 获取云盘或本地盘ID。
            String diskId = disks.get(0).getDiskId();
            HashMap<Object, Object> result = AttachDisk(client, instanceId, diskId);
            return CommonResult.ok(result);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("--------------------没有获取到可用云盘--------------------");
            System.out.println(e);
        }
        return CommonResult.error();
    }

    /**
     * AttachDisk    为一台ECS实例挂载一块按量付费数据盘。
     */
    private HashMap<Object, Object> AttachDisk(IAcsClient client, String instanceId, String diskId) {
        HashMap<Object, Object> result = new HashMap<>();
        AttachDiskRequest request = new AttachDiskRequest();
        // 待挂载的ECS实例ID。
        request.setInstanceId(instanceId);
        // 待挂载的云盘ID。云盘（DiskId）和实例（InstanceId）必须在同一个可用区。
        request.setDiskId(diskId);
        // 释放实例时，该云盘是否随实例一起释放。
        // 默认值：False。
        request.setDeleteWithInstance(false);
        try {
            AttachDiskResponse response = client.getAcsResponse(request);
            result.put("-----云盘挂载成功-------", new Gson().toJson(response));
            return result;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    /**
     * DescribeDisks    查询一块或多块您已经创建的云盘以及本地盘。
     */
    private List<DescribeDisksResponse.Disk> DescribeDisks(IAcsClient client) {
        DescribeDisksRequest request = new DescribeDisksRequest();
        // 云盘种类。取值范围：
        // all：所有云盘以及本地盘
        // cloud：普通云盘
        // cloud_efficiency：高效云盘
        // cloud_ssd：SSD盘
        // cloud_essd：ESSD云盘
        // local_ssd_pro：I/O密集型本地盘
        // local_hdd_pro：吞吐密集型本地盘
        // ephemeral：（已停售）本地盘
        // ephemeral_ssd：（已停售）本地SSD盘
        // 默认值：all
        request.setCategory("cloud_ssd");
        // 云盘或本地盘的计费方式。取值范围：
        // PrePaid：包年包月
        // PostPaid：按量付费
        request.setDiskChargeType("PrePaid");
        request.setStatus("Available");
        try {
            DescribeDisksResponse response = client.getAcsResponse(request);
            System.out.println("--------------------可用云盘的详细信息--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getDisks();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    @Override
    public CommonResult VpcDemo(String dBinstanceId) {
        IAcsClient client = alibabaConfig.getClient();
        // 查看弹性网卡（ENI）列表
        List<DescribeNetworkInterfacesResponse.NetworkInterfaceSet> networkInterfaceSets = DescribeNetworkInterfaces(client);
        // 请根据实际需求选择要分离的弹性网卡
        DescribeNetworkInterfacesResponse.NetworkInterfaceSet networkInterfaceSet = networkInterfaceSets.get(0);
        // 弹性网卡ID
        String networkInterfaceId = networkInterfaceSet.getNetworkInterfaceId();
        // 原弹性网卡所在实例ID
        String instanceId = networkInterfaceSet.getInstanceId();
        // 从一台实例上分离一个弹性网卡（ENI）
        int i = DetachNetworkInterface(client, instanceId, networkInterfaceId);
        if (i == 1) {
            // 附加弹性网卡（ENI）到专有网络（VPC）类型实例上
            AttachNetworkInterface(client, networkInterfaceId, dBinstanceId);
            // 为一块弹性网卡分配一个或多个辅助私有IP地址
            HashMap<Object, Object> result = AssignPrivateIpAddresses(client, networkInterfaceId);
            return CommonResult.ok(result);
        }
        return CommonResult.error();
    }

    /**
     * AssignPrivateIpAddresses    为一块弹性网卡分配一个或多个辅助私有IP地址
     */
    private HashMap<Object, Object> AssignPrivateIpAddresses(IAcsClient client, String networkInterfaceId) {
        HashMap<Object, Object> result = new HashMap<>();
        AssignPrivateIpAddressesRequest request = new AssignPrivateIpAddressesRequest();
        request.setNetworkInterfaceId(networkInterfaceId);
        List<String> privateIpAddressList = new ArrayList<String>();
        //TODO 这里到时候需要修改
        privateIpAddressList.add("172.30.**.***");
        privateIpAddressList.add("172.16.**.***");
        request.setPrivateIpAddresss(privateIpAddressList);
        try {
            AssignPrivateIpAddressesResponse response = client.getAcsResponse(request);
            result.put("----为附加的弹性网卡分配IP地址-------", new Gson().toJson(response));
            return result;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    /**
     * AttachNetworkInterface    附加弹性网卡（ENI）到专有网络（VPC）类型实例上
     */
    private static void AttachNetworkInterface(IAcsClient client, String networkInterfaceId, String dBinstanceId) {
        AttachNetworkInterfaceRequest request = new AttachNetworkInterfaceRequest();
        // 实例ID。
        request.setInstanceId(dBinstanceId);
        // 弹性网卡ID
        request.setNetworkInterfaceId(networkInterfaceId);
        try {
            AttachNetworkInterfaceResponse response = client.getAcsResponse(request);
            System.out.println("--------------------附加弹性网卡到VPC类型的实例--------------------");
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

    /**
     * DetachNetworkInterface    从一台实例上分离一个弹性网卡（ENI）
     */
    private static int DetachNetworkInterface(IAcsClient client, String instanceId, String networkInterfaceId) {
        DetachNetworkInterfaceRequest request = new DetachNetworkInterfaceRequest();
        // 实例ID
        request.setInstanceId(instanceId);
        // 弹性网卡ID
        request.setNetworkInterfaceId(networkInterfaceId);
        try {
            DetachNetworkInterfaceResponse response = client.getAcsResponse(request);
            System.out.println("--------------------从ECS实例上分离一个弹性网卡（ENI）--------------------");
            System.out.println(new Gson().toJson(response));
            return 1;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return 0;
    }

    /**
     * DescribeNetworkInterfaces    查看弹性网卡（ENI）列表
     */
    private static List<DescribeNetworkInterfacesResponse.NetworkInterfaceSet> DescribeNetworkInterfaces(IAcsClient client) {
        DescribeNetworkInterfacesRequest request = new DescribeNetworkInterfacesRequest();
        // 弹性网卡类型。取值范围：Primary  Secondary
        request.setType("Secondary");
        try {
            DescribeNetworkInterfacesResponse response = client.getAcsResponse(request);
            System.out.println("--------------------查询弹性网卡（ENI）列表--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getNetworkInterfaceSets();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    @Override
    public CommonResult UpdateSecurityGroup() {
        IAcsClient client = alibabaConfig.getClient();
        // 查询安全组基本信息集合
        List<DescribeSecurityGroupsResponse.SecurityGroup> securityGroups = DescribeSecurityGroups(client);
        if (securityGroups.size() != 0) {
            // 获取您所需要的安全组对象
            DescribeSecurityGroupsResponse.SecurityGroup securityGroup = securityGroups.get(0);
            String securityGroupId = securityGroup.getSecurityGroupId();
            // 查询其中一个安全组详情
            DescribeSecurityGroupAttribute(client, securityGroupId);
            // 增加一条安全组入方向规则
            AuthorizeSecurityGroup(securityGroupId, client);
            // 删除一条安全组入方向规则
            RevokeSecurityGroup(client, securityGroupId);
            return CommonResult.ok();
        }
        return CommonResult.error();
    }

    /**
     * RevokeSecurityGroup    删除一条安全组入方向规则
     * 必须有以下参数才能定位到一条安全组规则，进行精确删除
     * IpProtocol、PortRange、（可选）SourcePortRange、NicType、Policy、DestCidrIp 和 （可选）SourceCidrIp
     */
    private void RevokeSecurityGroup(IAcsClient client, String securityGroupId) {
        RevokeSecurityGroupRequest request = new RevokeSecurityGroupRequest();
        // 传输层协议。参数值大小写敏感。取值范围：
        // icmp
        // gre
        // tcp
        // udp
        // all：支持所有协议
        request.setIpProtocol("udp");
        // 目的端安全组开放的传输层协议相关的端口范围。取值范围：
        // TCP/UDP协议：取值范围为1~65535。使用斜线（/）隔开起始端口和终止端口。正确示范：1/200；错误示范：200/1。
        // ICMP协议：-1/-1。
        // GRE协议：-1/-1。
        // all：-1/-1。
        request.setPortRange("1/200");
        // 网卡类型。取值范围：
        // internet：公网网卡。
        // intranet：内网网卡。
        // 当撤销安全组之间互相访问时，即指定了SourceGroupId且没有指定SourceCidrIp时，参数NicType取值只能为intranet。 默认值：internet
        request.setNicType("intranet");
        // 访问权限。取值范围：
        // accept：接受访问。
        // drop：拒绝访问，不发回拒绝信息。
        // 默认值：accept
        request.setPolicy("accept");
        // 目的端IP地址范围。支持CIDR格式和IPv4格式的IP地址范围。默认值：0.0.0.0/0
        request.setDestCidrIp("127.30.XX.XX");
        // 源端IP地址范围。支持CIDR格式和IPv4格式的IP地址范围。默认值：0.0.0.0/0
        request.setSourceCidrIp("10.X.X.X");
        // 目的端安全组ID。
        request.setSecurityGroupId(securityGroupId);
        try {
            RevokeSecurityGroupResponse response = client.getAcsResponse(request);
            System.out.println("--------------------入方向安全组删除成功--------------------");
            System.out.println(new Gson().toJson(response));
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

    /**
     * DescribeSecurityGroups    查询您创建的安全组的基本信息集合
     */
    private List<DescribeSecurityGroupsResponse.SecurityGroup> DescribeSecurityGroups(IAcsClient client) {
        DescribeSecurityGroupsRequest request = new DescribeSecurityGroupsRequest();
        // 网络类型
        request.setNetworkType("vpc");
        // TODO 安全组名称
        request.setSecurityGroupName("sg-bp168k8XXXXX");
        try {
            DescribeSecurityGroupsResponse response = client.getAcsResponse(request);
            List<DescribeSecurityGroupsResponse.SecurityGroup> securityGroups = response.getSecurityGroups();
            System.out.println("--------------------查询安全组列表--------------------");
            System.out.println(new Gson().toJson(response));
            return securityGroups;
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    @Override
    public CommonResult InvokeCommand(String command) throws UnsupportedEncodingException {
        IAcsClient client = alibabaConfig.getClient();
        // 对需要新建的云助手命令进行base64编码
        String CommandContent = Base64CommandContent(command);
        // 新建一条云助手命令
        String commandId = CreateCommand(client, CommandContent);
        // 为一台或多台ECS实例触发一条云助手命令
        TestInvokeCommand(client, commandId);
        return CommonResult.ok();
    }

    /**
     * InvokeCommand    为一台或多台ECS实例触发一条云助手命令
     */
    private HashMap<Object, Object> TestInvokeCommand(IAcsClient client, String commandId) {
        HashMap<Object, Object> result = new HashMap<>();
        InvokeCommandRequest request = new InvokeCommandRequest();
        request.setCommandId(commandId);
        // TODO 实例ID集合，这里到时候需要根据实际情况来添加
        List<String> instanceIds = new ArrayList<>();
        instanceIds.add("i-bp1cu83ktXXXXXXX");
        request.setInstanceIds(instanceIds);
        request.setTimed(false);
        try {
            InvokeCommandResponse response = client.getAcsResponse(request);
            result.put("创建执行命令结果", new Gson().toJson(response));
            return result;
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    /**
     * CreateCommand    新建一条云助手命令
     */
    private static String CreateCommand(IAcsClient client, String CommandContent) {
        CreateCommandRequest request = new CreateCommandRequest();
        // 命令名称，支持全字符集。长度不得超过128个字符
        request.setName("test");
        // 创建的命令是否使用自定义参数。默认值：false
        request.setEnableParameter(true);
        // 命令的类型。取值范围：
        // RunBatScript：创建一个在Windows实例中运行的 Bat 脚本
        // RunPowerShellScript：创建一个在Windows实例中运行的PowerShell脚本
        // RunShellScript：创建一个在Linux实例中运行的Shell脚本
        request.setType("RunShellScript");
        // 命令描述，支持全字符集。长度不得超过512个字符
        request.setDescription("Test1");
        // 您创建的命令在ECS实例中执行时最大的超时时间，单位为秒。当因为某种原因无法运行您创建的命令时，会出现超时现象。超时后，会强制终止命令进程，即取消命令的PID。
        // 默认值：3600
        request.setTimeout(3600L);
        // 您创建的命令在ECS实例中运行的目录。默认值：
        // 对于Linux实例，默认在管理员root用户的home目录下，具体为/root目录
        // 对于Windows实例，默认在云助手客户端进程所在目录，例如，C:\ProgramData\aliyun\assist\$(version)
        request.setWorkingDir("/home/");
        // 命令Base64编码后的内容。
        // 该参数的值必须使用Base64编码后传输，且脚本内容的大小在Base64编码之后不能超过16KB
        // 命令内容支持使用自定义参数形式，具体通过指定参数EnableParameter=true启用自定义参数功能：
        //      自定义参数用{{}}包含的方式定义，在{{}}内参数名前后的空格以及换行符会被忽略
        //      自定义参数个数不能超过20个
        //      自定义参数名允许a-zA-Z0-9-_的组合，不支持其余字符，参数名不区分大小写
        //      单个参数名不能超过64字节
        request.setCommandContent(CommandContent);
        try {
            CreateCommandResponse response = client.getAcsResponse(request);
            System.out.println("--------------------新建云助手命令--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getCommandId();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    /**
     * base64 编码
     */
    private static String Base64CommandContent(String command) throws UnsupportedEncodingException {
        byte[] strByte = command.getBytes("UTF-8");
        // 编码
        return Base64.getEncoder().encodeToString(strByte);
        // 解码
        // return new String(Base64.getDecoder().decode(strByte), "UTF-8");
    }

    @Override
    public CommonResult getOneDescribeDisks() {
        IAcsClient client = alibabaConfig.getClient();
        // 按条件查询实例的详细信息
        List<DescribeInstancesResponse.Instance> instances = DescribeInstances(client);
        // 获取其中需要查询磁盘信息的实例对象
        DescribeInstancesResponse.Instance instance = instances.get(0);
        // 获取实例ID
        String instanceId = instance.getInstanceId();
        TestDescribeDisks(client, instanceId);
        return CommonResult.ok();
    }

    private HashMap<Object, Object> TestDescribeDisks(IAcsClient client, String instanceId) {
        HashMap<Object, Object> result = new HashMap<>();
        DescribeDisksRequest request = new DescribeDisksRequest();
        request.setInstanceId(instanceId);
        try {
            DescribeDisksResponse response = client.getAcsResponse(request);
            result.put("---查询实例下磁盘详细信息----", new Gson().toJson(response));
            return result;
        } catch (ClientException e) {
            System.out.println(e.getErrCode());
            System.out.println(e.getErrMsg());
            System.out.println(e.getRequestId());
        }
        return null;
    }

    private static List<DescribeInstancesResponse.Instance> DescribeInstances(IAcsClient client) {
        DescribeInstancesRequest request = new DescribeInstancesRequest();
        // 实例名称，支持使用通配符*进行模糊搜索
        request.setInstanceName("*001");
        try {
            DescribeInstancesResponse response = client.getAcsResponse(request);
            System.out.println("--------------------查询实例的详细信息--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getInstances();
        } catch (ClientException e) {
            System.out.println(e.getErrCode());
            System.out.println(e.getErrMsg());
            System.out.println(e.getRequestId());
            throw new RuntimeException();
        }
    }

    @Override
    public CommonResult createECSDemo() throws InterruptedException {
        IAcsClient client = alibabaConfig.getClient();
        // 创建一个专有网络（VPC）
        String VPCId = CreateVpc(client);
        Thread.sleep(5000);
        // 创建一个交换机
        String VSwitchId = CreateVSwitch(client, VPCId);
        Thread.sleep(5000);
        // 创建一台ECS实例
        HashMap<Object, Object> result = RunInstances(client, VSwitchId);
        return CommonResult.ok(result);
    }

    /**
     * RunInstances    创建一台ECS实例
     */
    private HashMap<Object, Object> RunInstances(IAcsClient client, String vSwitchId) {
        HashMap<Object, Object> result = new HashMap<>();
        RunInstancesRequest request = new RunInstancesRequest();
        // 镜像文件ID，启动实例时选择的镜像资源。如需使用云市场镜像，您可以在云市场镜像商详情页查看ImageId。
        request.setImageId("centos_7_06_64_20G_alibase_20190711.vhd");
        // 实例的名称。长度为2~128个英文或中文字符。必须以大小字母或中文开头，不能以 http:// 和 https:// 开头。可以包含数字、半角冒号（:）、下划线（_）或者连字符（-）。如果没有指定该参数，默认值为实例的InstanceId。
        request.setInstanceName("DOM_ECS_TEST");
        // 实例的资源规格。更多详情，请参见实例规格族，也可以调用DescribeInstanceTypes接口获得最新的规格表。
        request.setInstanceType("ecs.g5.large");
        // 指定新创建实例所属于的安全组ID，同一个安全组内的实例之间可以互相访问。
        request.setSecurityGroupId("sg-uf6h7bxba3d1zelb0619");
        // 网络计费类型。取值范围：
        // PayByBandwidth：按固定带宽计费
        // PayByTraffic（默认）：按使用流量计费
        request.setInternetChargeType("PayByBandwidth");
        // 公网入带宽最大值，单位为Mbit/s。取值范围：1~200
        // 默认值：200
        request.setInternetMaxBandwidthIn(100);
        // 公网出带宽最大值，单位为Mbit/s。取值范围：0~100
        // 默认值：0
        request.setInternetMaxBandwidthOut(1);
        // 云服务器的主机名。
        // 点号（.）和短横线（-）不能作为首尾字符，更不能连续使用。
        // Windows实例：字符长度为2~15，不支持点号（.），不能全是数字。允许大小写英文字母、数字和短横线（-）。
        // 其他类型实例（Linux等）：字符长度为2~64，支持多个点号（.），点之间为一段，每段允许大小写英文字母、数字和短横线（-）。
        request.setHostName("LocalHost");
        // 实例的密码。长度为8至30个字符，必须同时包含大小写英文字母、数字和特殊符号中的三类字符。特殊符号可以是：
        //          ()`~!@#$%^&*-_+=|{}[]:;'<>,.?/
        // 其中，Windows实例不能以斜线号（/）为密码首字符。
        // 说明 如果传入Password参数，建议您使用HTTPS协议发送请求，避免密码泄露。
        request.setPassword("EcsV587!");
        // 实例所属的可用区ID。更多详情，请参见DescribeZones获取可用区列表。
        // 默认值：空，表示随机选择。
        request.setZoneId("cn-shanghai-f");
        // 实例的付费方式。取值范围：
        // PrePaid：包年包月。选择该类付费方式时，您必须确认自己的账号支持余额支付/信用支付，否则将返回 InvalidPayMethod的错误提示。
        // PostPaid（默认）：按量付费。
        request.setInstanceChargeType("PostPaid");
        // 系统盘大小，单位为GiB。取值范围：20~500
        // 该参数的取值必须大于或者等于max{20, ImageSize}。
        // 默认值：max{40, ImageSize}
        request.setSystemDiskSize("40");
        // 系统盘的云盘种类。已停售的实例规格且非I/O优化实例默认值为cloud，否则默认值为cloud_efficiency。取值范围：
        // cloud：普通云盘
        // cloud_efficiency：高效云盘
        // cloud_ssd：SSD云盘
        // ephemeral_ssd：本地SSD盘
        // cloud_essd：ESSD云盘。
        request.setSystemDiskCategory("cloud_ssd");
        // 系统盘名称。长度为2~128个英文或中文字符。必须以大小字母或中文开头，不能以 http:// 和 https:// 开头。可以包含数字、半角冒号（:）、下划线（_）或者连字符（-）。默认值：空。
        request.setSystemDiskDiskName("SystemDisk");
        // 系统盘描述。长度为2~256个英文或中文字符，不能以 http:// 和 https:// 开头。默认值：空。
        request.setSystemDiskDescription("SystemDisk_test");
        // 实例的描述。长度为2~256个英文或中文字符，不能以 http:// 和 https:// 开头。默认值：空。
        request.setDescription("测试中.....");
        // 如果是创建VPC类型的实例，需要指定虚拟交换机ID。
        request.setVSwitchId(vSwitchId);
        try {
            RunInstancesResponse response = client.getAcsResponse(request);
            System.out.println("--------------------ECS实例创建成功--------------------");
            System.out.println(new Gson().toJson(response));
            result.put("---ECS实例创建成功---", new Gson().toJson(response));
            return result;
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    /**
     * CreateVSwitch    创建一个交换机
     */
    private static String CreateVSwitch(IAcsClient client, String vpcId) {
        HashMap<Object, Object> result = new HashMap<>();
        CreateVSwitchRequest request = new CreateVSwitchRequest();
        // 交换机所属的VPC ID。
        request.setVpcId(vpcId);
        // 交换机的网段。交换机网段要求如下：
        // 交换机网段的掩码长度范围为16-29位
        // 交换机的网段必须从属于所在VPC的网段
        // 交换机的网段不能与所在VPC中路由条目的目标网段相同，但可以是目标网段的子集
        // 如果交换机的网段与所在VPC的网段相同时，VPC只能有一个交换机
        request.setCidrBlock("192.168.0.0/16");
        // 交换机所属区的ID。 您可以通过调用DescribeZones接口获取地域ID
        request.setZoneId("cn-shanghai-b");
        // 交换机的描述信息
        // 长度为 2-256个字符，必须以字母或中文开头，但不能以http:// 或https://开头
        request.setDescription("DOCTestlalala");
        // 交换机的名称。
        // 长度为 2-128个字符，必须以字母或中文开头，但不能以http:// 或https://开头。
        request.setVSwitchName("DOCTest");
        try {
            CreateVSwitchResponse response = client.getAcsResponse(request);
            System.out.println("--------------------交换机创建成功--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getVSwitchId();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    /**
     * CreateVpc    创建一个专有网络（VPC）
     */
    private static String CreateVpc(IAcsClient client) {
        HashMap<Object, Object> result = new HashMap<>();
        CreateVpcRequest request = new CreateVpcRequest();
        // VPC的网段。您可以使用以下网段或其子集：
        // 10.0.0.0/8
        // 172.16.0.0/12（默认值）
        // 192.168.0.0/16
        request.setCidrBlock("192.168.0.0/16");
        // VPC的描述信息
        // 长度为2-256个字符，必须以字母或中文开头，但不能以http://或https://开头
        request.setDescription("DOCTest");
        //TODO 资源组ID（！！！导入包的问题？？）
        request.setResourceGroupId("rg-acfmxazb4ph6aiy");
        // VPC的名称
        // 长度为2-128个字符，必须以字母或中文开头，可包含数字，点号（.），下划线（_）和短横线（-），但不能以http:// 或https://开头
        request.setVpcName("DOCTestlalala");
        try {
            CreateVpcResponse response = client.getAcsResponse(request);
            System.out.println("--------------------VPC创建成功--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getVpcId();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    @Override
    public CommonResult AttachInstanceRamRole(String InstanceIds, String RamRoleName) {
        HashMap<Object, Object> result = new HashMap<>();
        IAcsClient client = alibabaConfig.getClient();
        HashMap<Object, Object> testAttachInstanceRamRole = testAttachInstanceRamRole(client, InstanceIds, RamRoleName);
        HashMap<Object, Object> describeInstanceRamRole = DescribeInstanceRamRole(client, InstanceIds);
        result.putAll(testAttachInstanceRamRole);
        result.putAll(describeInstanceRamRole);
        return CommonResult.ok(result);
    }

    /**
     * DescribeInstanceRamRole    查询一台或者多台ECS实例上的已赋予的实例RAM角色
     */
    private HashMap<Object, Object> DescribeInstanceRamRole(IAcsClient client, String InstanceIds) {
        HashMap<Object, Object> result = new HashMap<>();
        DescribeInstanceRamRoleRequest request = new DescribeInstanceRamRoleRequest();
        request.setInstanceIds(InstanceIds);
        try {
            DescribeInstanceRamRoleResponse response = client.getAcsResponse(request);
            result.put("-----查询ECS实例上已赋予的RAM角色-----", new Gson().toJson(response));
            return result;
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    /**
     * AttachInstanceRamRole    为一台或多台ECS实例授予 实例RAM角色
     */
    private HashMap<Object, Object> testAttachInstanceRamRole(IAcsClient client, String InstanceIds, String RamRoleName) {
        HashMap<Object, Object> result = new HashMap<>();
        AttachInstanceRamRoleRequest request = new AttachInstanceRamRoleRequest();
        // 实例ID，最多支持100台实例。Json格式字符串
        request.setInstanceIds(InstanceIds);
        // 实例RAM角色名称。您可以使用 RAM API ListRoles查询您已创建的实例RAM角色
        request.setRamRoleName("AliyunECSImageExportDefaultRole");
        try {
            AttachInstanceRamRoleResponse response = client.getAcsResponse(request);
            result.put("----为ECS实例赋予RAM角色----" + RamRoleName, new Gson().toJson(response));
            return result;
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    @Override
    public CommonResult DescribeInstanceRequredResource() {
        HashMap<Object, Object> result = new HashMap<>();
        IAcsClient client = alibabaConfig.getClient();
        //     查询一个阿里云地域下的可用区
        List<DescribeZonesResponse.Zone> zones = DescribeZones(client);
        result.put("查询一个阿里云地域下的可用区", zones);
        // 查询云服务器ECS提供的实例规格资源
        List<DescribeInstanceTypesResponse.InstanceType> instanceTypeList = DescribeInstanceTypes(client);
        result.put("查询云服务器ECS提供的实例规格资源", instanceTypeList);
        // 查询可以使用的镜像资源
        List<DescribeImagesResponse.Image> images = DescribeImages(client);
        result.put("查询可以使用的镜像资源", images);
        // 查询已创建的VPC
        List<DescribeVpcsResponse.Vpc> vpcs = DescribeVpcs(client);
        result.put("查询已创建的VPC", vpcs);
        // 查询已创建的交换机
        List<DescribeVSwitchesResponse.VSwitch> vSwitches = DescribeVSwitches(client);
        result.put("查询已创建的交换机", vSwitches);
        // 查询创建的安全组的基本信息
        List<DescribeSecurityGroupsResponse.SecurityGroup> securityGroups = DescribeSecurityGroups1(client);
        result.put("查询创建的安全组的基本信息", securityGroups);
        return CommonResult.ok(result);
    }

    /**
     * DescribeSecurityGroups    查询创建的安全组的基本信息
     */
    private static List<DescribeSecurityGroupsResponse.SecurityGroup> DescribeSecurityGroups1(IAcsClient client) {
        DescribeSecurityGroupsRequest request = new DescribeSecurityGroupsRequest();
        // 网络类型
        request.setNetworkType("vpc");
        try {
            DescribeSecurityGroupsResponse response = client.getAcsResponse(request);
            System.out.println("--------------------查询已创建的安全组基本信息--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getSecurityGroups();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            return null;
        }
    }

    /**
     * DescribeVSwitches    查询已创建的交换机
     */
    private static List<DescribeVSwitchesResponse.VSwitch> DescribeVSwitches(IAcsClient client) {
        DescribeVSwitchesRequest request = new DescribeVSwitchesRequest();
        //
        request.setIsDefault(false);
        try {
            DescribeVSwitchesResponse response = client.getAcsResponse(request);
            System.out.println("--------------------查询已创建的交换机--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getVSwitches();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            return null;
        }
    }

    /**
     * DescribeVpcs    查询已创建的VPC
     */
    private static List<DescribeVpcsResponse.Vpc> DescribeVpcs(IAcsClient client) {
        DescribeVpcsRequest request = new DescribeVpcsRequest();
        // 是否查询指定地域下的默认VPC，取值：
        // true（默认值）：查询指定地域下的所有VPC。
        // false：不查询默认VPC。
        request.setIsDefault(false);
        try {
            DescribeVpcsResponse response = client.getAcsResponse(request);
            System.out.println("--------------------查询已创建的VPC--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getVpcs();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            return null;
        }
    }

    /**
     * DescribeImages    查询可以使用的镜像资源
     */
    private static List<DescribeImagesResponse.Image> DescribeImages(IAcsClient client) {
        DescribeImagesRequest request = new DescribeImagesRequest();
        // 镜像的体系架构。取值范围：
        // i386
        // x86_64
        request.setArchitecture("x86_64");
        // 镜像来源。取值范围：
        // system：阿里云提供的公共镜像。
        // self：您创建的自定义镜像。
        // others：其他阿里云用户共享给您的镜像。
        // marketplace：镜像市场提供的镜像。您查询到的云市场镜像可以直接使用，无需提前订阅。您需要自行留意云市场镜像的收费详情
        // 默认值：空，空表示返回取值为system、self以及others的结果。
        request.setImageOwnerAlias("system");
        // 镜像需要被使用到的场景。取值范围：
        // CreateEcs（默认）：创建实例
        // ChangeOS：更换系统盘/更换操作系统
        request.setActionType("CreateEcs");
        // 镜像的操作系统类型。取值范围：
        // windows
        // linux
        request.setOSType("linux");
        try {
            DescribeImagesResponse response = client.getAcsResponse(request);
            System.out.println("--------------------查询可以使用的镜像资源--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getImages();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            return null;
        }
    }

    /**
     * DescribeInstanceTypes    查询云服务器ECS提供的实例规格资源
     */
    private static List<DescribeInstanceTypesResponse.InstanceType> DescribeInstanceTypes(IAcsClient client) {
        DescribeInstanceTypesRequest request = new DescribeInstanceTypesRequest();
        // 实例规格所属的规格族。此参数可选，不填写时返回所有实例规格
        // request.setInstanceTypeFamily("ecs.t1");
        try {
            DescribeInstanceTypesResponse response = client.getAcsResponse(request);
            System.out.println("--------------------查询ECS提供的实例规格资源--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getInstanceTypes();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            return null;
        }
    }

    /**
     * DescribeZones    查询一个阿里云地域下的可用区
     */
    private static List<DescribeZonesResponse.Zone> DescribeZones(IAcsClient client) {
        DescribeZonesRequest request = new DescribeZonesRequest();
        // 可用区所在的地域ID。您可以调用DescribeRegions查看最新的阿里云地域列表
        request.setRegionId("cn-shanghai");
        // 根据汉语、英语和日语筛选返回结果。更多详情，请参见RFC7231
        // 取值范围：
        // zh-CN
        // en-US
        // ja
        // 默认值：zh-CN。
        request.setAcceptLanguage("zh-CN");
        try {
            DescribeZonesResponse response = client.getAcsResponse(request);
            System.out.println("--------------------查询地域下的可用区--------------------");
            System.out.println(new Gson().toJson(response));
            return response.getZones();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }

    @Override
    public CommonResult getECSDate(String instanceId, String startTime, String endTime) {
        HashMap<Object, Object> result = new HashMap<>();
        IAcsClient client = alibabaConfig.getClient(); // 查询一台 ECS 实例所有相关的监控信息
        List<DescribeInstanceMonitorDataResponse.InstanceMonitorData> monitorDataList = DescribeInstanceMonitorData(
            client,
            instanceId,
            startTime,
            endTime
        );
        // 处理业务返回的监控信息数据。（请根据您的实际业务需求来进行处理）
        result.put("处理业务返回的监控信息数据", new Gson().toJson(monitorDataList));
        // 查询一台ECS实例的自定义数据
        String userData = DescribeUserData(client, instanceId);
        // 处理业务返回的实例自定义数据。（请根据您的实际业务需求来进行处理）
        result.put("处理业务返回的实例自定义数据", userData);
        return CommonResult.ok(result);
    }

    /**
     * DescribeUserData    查询一台ECS实例的自定义数据
     */
    private static String DescribeUserData(IAcsClient client, String instanceId) {
        DescribeUserDataRequest request = new DescribeUserDataRequest();
        request.setInstanceId(instanceId);
        try {
            DescribeUserDataResponse response = client.getAcsResponse(request);
            System.out.println("--------------------查询ECS自定义数据--------------------");
            return response.getUserData();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            return null;
        }
    }

    /**
     * DescribeInstanceMonitorData    查询一台 ECS 实例所有相关的监控信息
     */
    private static List<DescribeInstanceMonitorDataResponse.InstanceMonitorData> DescribeInstanceMonitorData(
        IAcsClient client,
        String instanceId,
        String startTime,
        String endTime
    ) {
        DescribeInstanceMonitorDataRequest request = new DescribeInstanceMonitorDataRequest();
        // 待查询的实例 ID
        request.setInstanceId(instanceId);
        // 获取数据的起始时间点。按照 ISO8601 标准表示，并需要使用 UTC 时间，格式为：YYYY-MM-DDThh:mm:ssZ。如果指定的秒（ss）不是 00，则自动换算为下一分钟。
        request.setStartTime(startTime);
        // 获取数据的结束时间点。按照 ISO8601 标准表示，并需要使用 UTC 时间，格式为：YYYY-MM-DDThh:mm:ssZ。 如果指定的秒（ss）不是 00，则自动换算为下一分钟。
        request.setEndTime(endTime);
        try {
            DescribeInstanceMonitorDataResponse response = client.getAcsResponse(request);
            System.out.println("--------------------查询ECS所有相关的监控信息--------------------");
            return response.getMonitorData();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            return null;
        }
    }

    @Override
    public CommonResult someOneStatusECS() {
        HashMap<Object, Object> result = new HashMap<>();
        Gson gson = new Gson();
        // 初始化请求参数
        IAcsClient client = alibabaConfig.getClient();
        // 用来存放实例ID
        List<String> instanceIds = new ArrayList<>();
        // 获取所有ECS实例的状态信息
        List<DescribeInstanceStatusResponse.InstanceStatus> instanceStatuses = TestDescribeInstanceStatus(client);
        for (DescribeInstanceStatusResponse.InstanceStatus instanceStatu : instanceStatuses) {
            // 获取所有状态为运行中的实例ID
            if (instanceStatu.getStatus().equals("Running")) {
                // 将符合条件的实例ID放入instanceIds集合中
                instanceIds.add(instanceStatu.getInstanceId());
            }
        }
        // 因为DescribeInstances接口中需要的实例ID为Json格式的字符串
        // 所以在此处需要把instanceIds转化为Json格式的字符串
        String instanceIdsForJson = gson.toJson(instanceIds);
        result.put("运行状态的实例id集合", instanceIdsForJson);
        // 查询状态为Running的实例详情
        List<DescribeInstancesResponse.Instance> instances = DescribeInstances1(client, instanceIdsForJson);
        result.put("运行中的所有的实例详细信息", gson.toJson(instances));
        return CommonResult.ok(result);
    }

    /**
     * DescribeInstances    查询一台或多台实例的详细信息
     */
    private static List<DescribeInstancesResponse.Instance> DescribeInstances1(IAcsClient client, String instanceIdsForJson) {
        DescribeInstancesRequest request = new DescribeInstancesRequest();
        // 实例ID。取值可以由多个实例ID组成一个JSON数组，最多支持100个ID，ID之间用半角逗号（,）隔开
        // 参数示例： ["i-xxxxxxxxx", "i-yyyyyyyyy", … "i-zzzzzzzzz"]
        request.setInstanceIds(instanceIdsForJson);
        try {
            DescribeInstancesResponse response = client.getAcsResponse(request);
            // 获取到实例详细信息集合并返回
            return response.getInstances();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    /**
     * DescribeInstanceStatus    获取一台或多台ECS实例的状态信息
     */
    private static List<DescribeInstanceStatusResponse.InstanceStatus> TestDescribeInstanceStatus(IAcsClient client) {
        DescribeInstanceStatusRequest request = new DescribeInstanceStatusRequest();
        // 实例状态列表的页码。起始值：1。
        // 默认值：1。
        request.setPageNumber(1);
        // 分页查询时设置的每页行数。取值范围：1~50
        // 默认值：10。
        // 为了可以一次取到所有，这里尽量选最大
        request.setPageSize(50);
        try {
            DescribeInstanceStatusResponse response = client.getAcsResponse(request);
            // 获取所有实例状态和实例ID
            return response.getInstanceStatuses();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    @Override
    public CommonResult ModifyInstance(String instancenId) {
        HashMap<Object, Object> result = new HashMap<>();
        Gson gson = new Gson();
        IAcsClient client = alibabaConfig.getClient();
        // 查询某实例升级实例规则时的可用资源信息
        List<DescribeResourcesModificationResponse.AvailableZone> availableZones = DescribeResourcesModification(client, instancenId);
        result.put("---Available resource information for instance rules---", gson.toJson(availableZones));
        // 获取实例的可用资源信息
        // （此处应根据实际情况或者结合前端业务来进行）
        DescribeResourcesModificationResponse.AvailableZone.AvailableResource.SupportedResource supportedResource = availableZones
            .get(0)
            .getAvailableResources()
            .get(0)
            .getSupportedResources()
            .get(0);
        // 支持的可供创建的具体资源
        ModifyInstanceSpecResponse response = ModifyInstanceSpec(client, supportedResource.getValue(), instancenId);
        result.put("-----Instance specification changes successfully-----", gson.toJson(response));
        return CommonResult.ok(result);
    }

    /**
     * ModifyInstanceSpec    调整一台按量付费ECS实例的实例规格和公网带宽大小
     */
    private static ModifyInstanceSpecResponse ModifyInstanceSpec(IAcsClient client, String value, String instancenId) {
        ModifyInstanceSpecRequest request = new ModifyInstanceSpecRequest();
        // 指定的实例ID
        request.setInstanceId(instancenId);
        /**
         * 是否支持跨集群升级实例规格。默认值：false
         * 当参数AllowMigrateAcrossZone取值为true时，一旦您根据返回信息升级了云服务器，请留意以下注意事项：
         *
         * 经典网络类型实例：
         * 对于已停售的实例规格，非I/O优化实例变配到I/O优化实例时，实例私网IP地址、磁盘设备名和软件授权码会发
         * 生变化。对于Linux实例，普通云盘（cloud）会被识别为xvda或者xvdb等，高效云盘（cloud_efficiency）
         * 和SSD云盘（cloud_ssd）会被识别为vda或者vdb等。
         * 对于正常售卖的实例规格族，实例的私网IP地址会发生变化。
         *
         * 专有网络VPC类型实例：
         * 对于已停售的实例规格，非I/O优化实例变配到I/O优化实例时，云服务器磁盘设备名和软件授权码会发生变化。Linux
         * 实例的普通云盘（cloud）会被识别为xvda或者xvdb等，高效云盘（cloud_efficiency）和SSD云盘（cloud_ssd）
         * 会被识别为vda或者vdb等。
         */
        request.setAllowMigrateAcrossZone(false);
        request.setAsync(true);
        request.setInstanceType(value);
        try {
            return client.getAcsResponse(request);
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    /**
     * DescribeResourcesModification    查询升级和降配实例规格或者系统盘时，某一可用区的可用资源信息
     */
    private static List<DescribeResourcesModificationResponse.AvailableZone> DescribeResourcesModification(
        IAcsClient client,
        String instancenId
    ) {
        DescribeResourcesModificationRequest request = new DescribeResourcesModificationRequest();
        //
        request.setDestinationResource("InstanceType");
        request.setResourceId(instancenId);
        try {
            DescribeResourcesModificationResponse response = client.getAcsResponse(request);
            return response.getAvailableZones();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    @Override
    public CommonResult NoDurationSpotSample() {
        HashMap<Object, Object> result = new HashMap<>();
        IAcsClient client = alibabaConfig.getClient();

        return null;
    }
}
