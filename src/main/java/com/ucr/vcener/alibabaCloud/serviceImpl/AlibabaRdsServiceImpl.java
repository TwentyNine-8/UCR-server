package com.ucr.vcener.alibabaCloud.serviceImpl;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.rds.model.v20140815.CreateAccountRequest;
import com.aliyuncs.rds.model.v20140815.CreateAccountResponse;
import com.aliyuncs.rds.model.v20140815.CreateDBInstanceRequest;
import com.aliyuncs.rds.model.v20140815.CreateDBInstanceResponse;
import com.google.gson.Gson;
import com.ucr.vcener.alibabaCloud.service.AlibabaRdsService;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.AlibabaConfig;
import java.util.HashMap;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

public class AlibabaRdsServiceImpl implements AlibabaRdsService {
    @Autowired
    private AlibabaConfig alibabaConfig;

    @Override
    public CommonResult CreateRDS() {
        IAcsClient client = alibabaConfig.getClient();
        CreateDBInstanceRequest request = new CreateDBInstanceRequest();
        // 数据库类型取值：MySQL；SQLServer；PostgreSQL；PPAS；MariaDB。
        request.setEngine("MySQL");
        // 数据库版本，取值：
        // MySQL：5.5/5.6/5.7/8.0；
        // SQL Server：2008r2/2012/2012_ent_ha/2012_std_ha/2012_web/2016_ent_ha/2016_std_ha/2016_web/2017_ent；
        // PostgreSQL：9.4/10.0；
        // PPAS：9.3/10.0；
        // MariaDB：10.3。
        request.setEngineVersion("5.7");
        // 实例规格，详见实例规格表。
        request.setDBInstanceClass("mysql.n4.xlarge.1");
        // 实例存储空间，单位：GB。每5GB进行递增，详见实例规格表。
        request.setDBInstanceStorage(20);
        // 实例的网络连接类型，取值：
        // Internet：公网连接；
        // Intranet：内网连接。
        request.setDBInstanceNetType("Internet");
        // 实例的付费类型，取值：
        // Postpaid：后付费（按量付费）；
        // Prepaid：预付费（包年包月）。
        request.setPayType("Postpaid");
        // 该实例的IP白名单，多个IP地址请以英文逗号（,）隔开，不可重复，最多1000个。支持如下两种格式：
        // IP地址形式，例如：10.23.12.24；
        // CIDR形式，例如：10.23.12.24/24（无类域间路由，24表示了地址中前缀的长度，范围为1~32）。
        request.setSecurityIPList("30.40.53.25");
        // 字符集，取值：
        // MySQL/MariaDB实例：utf8、gbk、latin1、utf8mb4；
        // SQL Server实例：Chinese_PRC_CI_AS、Chinese_PRC_CS_AS、SQL_Latin1_General_CP1_CI_AS、SQL_Latin1_General_CP1_CS_AS、Chinese_PRC_BIN。
        request.setSystemDBCharset("utf8");
        // 实例名称，长度为2~256个字符。以中文、英文字母开头，可以包含数字、中文、英文、下划线（_）、短横线（-）。
        request.setDBInstanceDescription("测试数据库");
        // 用于保证请求的幂等性，防止重复提交请求。
        // 由客户端生成该参数值，要保证在不同请求间唯一，最大值不超过64个ASCII字符，且该参数值中不能包含非ASCII字符。
        request.setClientToken(UUID.randomUUID().toString());
        // 可用区ID。多可用区用英文冒号（:）分隔。
        // 指定了VPC和交换机时，为匹配交换机对应的可用区，该参数必填。
        //request.setZoneId("cn-hangzhou-b:cn-hangzhou-a:cn-hangzhou-h");
        request.setZoneId("cn-hangzhou-b");
        // 实例的网络类型，取值：
        // VPC：VPC网络；
        // Classic：经典网络。
        request.setInstanceNetworkType("Classic");
        // 实例的访问模式，取值：
        // Standard：标准访问模式；
        // Safe：数据库代理模式。
        request.setConnectionMode("Standard");
        // 实例存储类型，取值：
        // local_ssd/ephemeral_ssd：本地SSD盘（推荐）；
        // cloud_ssd：SSD云盘；
        // cloud_essd：ESSD云盘。
        request.setDBInstanceStorageType("cloud_ssd");

        try {
            // 发起请求并获取返回值
            CreateDBInstanceResponse response = client.getAcsResponse(request);
            //  处理业务逻辑
            return CommonResult.ok(new HashMap<>(1).put("处理业务逻辑结果", new Gson().toJson(response)));
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
    public CommonResult CreateAccount() {
        IAcsClient client = alibabaConfig.getClient();
        // 创建APi请求并获取参数
        CreateAccountRequest request = new CreateAccountRequest();
        // 实例ID
        request.setDBInstanceId("<your-DBInstanceId>");
        // 数据库账号名称
        request.setAccountName("<your-AccountName>");
        // 数据库账号的密码
        request.setAccountPassword("<your-AccountPassword>");
        // 账号描述
        request.setAccountDescription("测试账号A");
        // 账号类型
        // Normal：普通账号；Super：高权限账号。默认值：Normal。
        request.setAccountType("Normal");

        try {
            // 发请求获取返回结果
            CreateAccountResponse response = client.getAcsResponse(request);
            // 处理返回结果
            System.out.println(new Gson().toJson(response));
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }
}
