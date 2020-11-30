package com.ucr.vcener.alibabaCloud.service;

import com.ucr.vcener.common.CommonResult;

public interface AlibabaDateService {
    //查看POLARDB集群的详细属性
    CommonResult DescribeDBClusterAttribute();

    //查询DRDS实例详情(drds实例ID drdsInstanceId = "";)
    CommonResult DescribeDrdsInstanceDemo(String drdsInstanceId);
}
