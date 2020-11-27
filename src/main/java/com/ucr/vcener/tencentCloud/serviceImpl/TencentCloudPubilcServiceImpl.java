package com.ucr.vcener.tencentCloud.serviceImpl;

import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import com.ucr.vcener.tencentCloud.service.TencentCloudPublicService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ymn
 * @date 2020/11/27 14:14
 */
public class TencentCloudPubilcServiceImpl implements TencentCloudPublicService {
    @Autowired
    private TencentConfig tencentConfig;

    @Override
    public Map<String, Object> describeProject(Integer asList) {
        return null;
    }
}
