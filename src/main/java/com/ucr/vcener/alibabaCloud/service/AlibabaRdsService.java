package com.ucr.vcener.alibabaCloud.service;

import com.ucr.vcener.common.CommonResult;

public interface AlibabaRdsService {
    //创建实例
    CommonResult CreateRDS();

    //创建数据库账号
    CommonResult CreateAccount();
}
