package com.ucr.vcener.tencentCloud.serviceImpl;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.models.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import com.ucr.vcener.tencentCloud.service.TencentCloudImagesService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ymn
 * @date 2020/11/27 17:56
 */
public class TencentCloudImagesServiceImpl implements TencentCloudImagesService {
    @Autowired
    private TencentConfig tencentConfig;

    /**
     * 查看镜像列表
     * 本接口(DescribeImages) 用于查看镜像列表。
     *
     * 可以通过指定镜像ID来查询指定镜像的详细信息，或通过设定过滤器来查询满足过滤条件的镜像的详细信息。
     * 指定偏移(Offset)和限制(Limit)来选择结果中的一部分，默认返回满足条件的前20个镜像信息。
     * 默认接口请求频率限制：40次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15715
     */
    @Override
    public CommonResult DescribeImages(DescribeImagesRequest request) {
        try {
            DescribeImagesResponse response = tencentConfig.getCvmClient().DescribeImages(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 查看镜像分享信息
     * 本接口（DescribeImageSharePermission）用于查询镜像分享信息。
     *
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15712
     */
    @Override
    public CommonResult DescribeImageSharePermission(DescribeImageSharePermissionRequest request) {
        try {
            DescribeImageSharePermissionResponse response = tencentConfig.getCvmClient().DescribeImageSharePermission(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 查询外部导入镜像支持的OS列表
     * 查看可以导入的镜像操作系统信息。
     *
     * 默认接口请求频率限制：288次/秒。
     * @return
     * https://cloud.tencent.com/document/api/213/15718
     */
    @Override
    public CommonResult DescribeImportImageOs() {
        try {
            DescribeImportImageOsResponse response = tencentConfig.getCvmClient().DescribeImportImageOs(new DescribeImportImageOsRequest());
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 查询镜像配额上限
     * 本接口(DescribeImageQuota)用于查询用户帐号的镜像配额。
     *
     * 默认接口请求频率限制：10次/秒。
     *
     * @return
     * https://cloud.tencent.com/document/api/213/15719
     */
    @Override
    public CommonResult DescribeImageQuota() {
        try {
            DescribeImageQuotaResponse response = tencentConfig.getCvmClient().DescribeImageQuota(new DescribeImageQuotaRequest());
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 创建镜像
     * 本接口(CreateImage)用于将实例的系统盘制作为新镜像，创建后的镜像可以用于创建实例。
     *
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/16726
     */
    @Override
    public CommonResult CreateImage(CreateImageRequest request) {
        try {
            CreateImageResponse response = tencentConfig.getCvmClient().CreateImage(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 修改镜像分享信息
     * 本接口（ModifyImageSharePermission）用于修改镜像分享信息。
     *
     * 分享镜像后，被分享账户可以通过该镜像创建实例。
     * 每个自定义镜像最多可共享给50个账户。
     * 分享镜像无法更改名称，描述，仅可用于创建实例。
     * 只支持分享到对方账户相同地域。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15710
     */
    @Override
    public CommonResult ModifyImageSharePermission(ModifyImageSharePermissionRequest request) {
        try {
            ModifyImageSharePermissionResponse response = tencentConfig.getCvmClient().ModifyImageSharePermission(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     *同步镜像
     *本接口（SyncImages）用于将自定义镜像同步到其它地区。
     *
     * 该接口每次调用只支持同步一个镜像。
     * 该接口支持多个同步地域。
     * 单个帐号在每个地域最多支持存在10个自定义镜像。
     * @param request
     * @return
     *https://cloud.tencent.com/document/api/213/15711
     */
    @Override
    public CommonResult SyncImages(SyncImagesRequest request) {
        try {
            SyncImagesResponse response = tencentConfig.getCvmClient().SyncImages(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 修改镜像属性
     * 本接口（ModifyImageAttribute）用于修改镜像属性。
     *
     * 已分享的镜像无法修改属性。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15713
     */
    @Override
    public CommonResult ModifyImageAttribute(ModifyImageAttributeRequest request) {
        try {
            ModifyImageAttributeResponse response = tencentConfig.getCvmClient().ModifyImageAttribute(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 删除镜像
     * 本接口（DeleteImages）用于删除一个或多个镜像。
     *
     * 当镜像状态为创建中和使用中时, 不允许删除。镜像状态可以通过DescribeImages获取。
     * 每个地域最多只支持创建10个自定义镜像，删除镜像可以释放账户的配额。
     * 当镜像正在被其它账户分享时，不允许删除。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15716
     */
    @Override
    public CommonResult DeleteImages(DeleteImagesRequest request) {
        try {
            DeleteImagesResponse response = tencentConfig.getCvmClient().DeleteImages(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 外部镜像导入
     * 本接口(ImportImage)用于导入镜像，导入后的镜像可用于创建实例。
     *
     * 默认接口请求频率限制：10次/秒。
     *
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15717
     */
    @Override
    public CommonResult ImportImage(ImportImageRequest request) {
        try {
            ImportImageResponse response = tencentConfig.getCvmClient().ImportImage(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }
}
