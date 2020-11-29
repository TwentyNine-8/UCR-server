package com.ucr.vcener.alibabaCloud.service;

import com.ucr.vcener.common.CommonResult;

public interface AlibabaRedisService {
    //创建Redis实例
    CommonResult CreateInstance();

    //释放Redis实例
    CommonResult DeleteInstance();

    //修改RDS实例
    CommonResult ModifyInstanceAttribute();

    //查询RDS实例信息
    CommonResult DescribeInstanceAttribute();

    /**
     * 查询Redis实例的审计日志和备份信息
     * // 需要查询的实例ID
     * private static String instanceId = "";
     * // 备份文件查询开始时间
     * private static String describeBackupsStartTime = "";
     * // 备份文件查询结束时间
     * private static String describeBackupsEndTime = "";
     * // 审计日志查询开始时间
     * private static String startTime = "";
     * // 审计日志查询结束时间
     * private static String endTime = "";
     */
    CommonResult DescribeRedis(
        String instanceId,
        String describeBackupsStartTime,
        String describeBackupsEndTime,
        String startTime,
        String endTime
    );
}
