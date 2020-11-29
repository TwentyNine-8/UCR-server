package com.ucr.vcener.alibabaCloud.serviceImpl;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.drds.model.v20171016.DescribeDrdsDBsRequest;
import com.aliyuncs.drds.model.v20171016.DescribeDrdsDBsResponse;
import com.aliyuncs.drds.model.v20171016.DescribeDrdsInstanceRequest;
import com.aliyuncs.drds.model.v20171016.DescribeDrdsInstanceResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.polardb.model.v20170801.DescribeDBClusterAttributeRequest;
import com.aliyuncs.polardb.model.v20170801.DescribeDBClusterAttributeResponse;
import com.aliyuncs.polardb.model.v20170801.DescribeDBClustersRequest;
import com.aliyuncs.polardb.model.v20170801.DescribeDBClustersResponse;
import com.google.gson.Gson;
import com.ucr.vcener.alibabaCloud.service.AlibabaDateService;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.AlibabaConfig;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;
import org.springframework.beans.factory.annotation.Autowired;

public class AlibabaDateServiceImpl implements AlibabaDateService {
    @Autowired
    private AlibabaConfig alibabaConfig;

    @Override
    public CommonResult DescribeDBClusterAttribute() {
        int i = 0;
        HashMap<Object, Object> result = new HashMap<>();
        IAcsClient client = alibabaConfig.getClient();
        // 查询运行中的MySQL集群列表
        List<DescribeDBClustersResponse.DBCluster> dbClusters = DescribeDBClusters(client);
        // 获取需要的集群ID
        for (DescribeDBClustersResponse.DBCluster dbCluster : dbClusters) {
            // 集群ID
            String dbClusterId = dbCluster.getDBClusterId();
            // 查看MySQL集群的详细属性
            DescribeDBClusterAttributeResponse describeDBClusterAttributeResponse = DescribeDBClusterAttribute(client, dbClusterId);
            // 处理返回参数和业务逻辑
            result.put("处理返回参数和业务逻辑" + i, new Gson().toJson(describeDBClusterAttributeResponse));
        }
        return CommonResult.ok(result);
    }

    /**
     * DescribeDBClusterAttribute    查看指定POLARDB集群的详细属性
     */
    private static DescribeDBClusterAttributeResponse DescribeDBClusterAttribute(IAcsClient client, String dbClusterId) {
        DescribeDBClusterAttributeRequest request = new DescribeDBClusterAttributeRequest();
        // 集群ID
        request.setDBClusterId(dbClusterId);
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
     * DescribeDBClusters    查询运行中的MySQL集群列表
     */
    private static List<DescribeDBClustersResponse.DBCluster> DescribeDBClusters(IAcsClient client) {
        DescribeDBClustersRequest request = new DescribeDBClustersRequest();

        // 数据库类型，取值
        // MySQL
        // PostgreSQL
        // Oracle
        request.setDBType("MySQL");
        // 集群状态
        // Creating    创建中
        // Running    运行中
        // Deleting    释放中
        // Rebooting    重启中
        // DBNodeCreating    正在增加节点
        // DBNodeDeleting    正在删除节点
        // ClassChanging    正在变更节点规格
        // NetAddressCreating    正在创建网络连接
        // NetAddressDeleting    正在删除网络连接
        // NetAddressModifying    正在修改网络连接
        request.setDBClusterStatus("Running");
        try {
            DescribeDBClustersResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
            return response.getItems();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    @Override
    public CommonResult DescribeDrdsInstanceDemo(String drdsInstanceId) {
        HashMap<Object, Object> result = new HashMap<>();
        IAcsClient client = alibabaConfig.getClient();
        // 查询数据库列表
        DescribeDrdsDBsResponse describeDrdsDBsResponse = describeDrdsDBs(client, drdsInstanceId);
        // 查看DRDS实例详情
        DescribeDrdsInstanceResponse describeDrdsInstanceResponse = describeDrdsInstance(client, drdsInstanceId);
        // 处理业务逻辑
        result.put("查询数据库列表", new Gson().toJson(describeDrdsDBsResponse));
        result.put("查看DRDS实例详情", new Gson().toJson(describeDrdsInstanceResponse));
        return CommonResult.ok(result);
    }

    /**
     * DescribeDrdsInstance    查看DRDS实例详情
     */
    private static DescribeDrdsInstanceResponse describeDrdsInstance(IAcsClient client, String drdsInstanceId) {
        DescribeDrdsInstanceRequest request = new DescribeDrdsInstanceRequest();
        request.setDrdsInstanceId(drdsInstanceId);
        try {
            DescribeDrdsInstanceResponse response = client.getAcsResponse(request);
            return response;
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }

    /**
     * DescribeDrdsDBs        查询数据库列表
     */
    private static DescribeDrdsDBsResponse describeDrdsDBs(IAcsClient client, String drdsInstanceId) {
        DescribeDrdsDBsRequest request = new DescribeDrdsDBsRequest();
        // DRDS实例ID
        request.setDrdsInstanceId(drdsInstanceId);
        try {
            DescribeDrdsDBsResponse response = client.getAcsResponse(request);
            return response;
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            throw new RuntimeException();
        }
    }
}
