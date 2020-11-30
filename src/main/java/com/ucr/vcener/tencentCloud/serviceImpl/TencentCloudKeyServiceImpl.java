package com.ucr.vcener.tencentCloud.serviceImpl;

import cn.hutool.core.collection.CollectionUtil;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.models.*;
import com.ucr.vcener.common.CommonResult;
import com.ucr.vcener.config.yunSDKConfig.TencentConfig;
import com.ucr.vcener.tencentCloud.service.TencentCloudKeyService;
import com.ucr.vcener.util.TencentUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ymn
 * @date 2020/11/27 20:36
 */
public class TencentCloudKeyServiceImpl implements TencentCloudKeyService {
    @Autowired
    private TencentConfig tencentConfig;

    /**
     * 查询密钥对列表
     * 本接口 (DescribeKeyPairs) 用于查询密钥对信息。
     * <p>
     * 密钥对是通过一种算法生成的一对密钥，在生成的密钥对中，一个向外界公开，称为公钥；另一个用户自己保留，称为私钥。密钥对的公钥内容可以通过这个接口查询，但私钥内容系统不保留。
     * 默认接口请求频率限制：10次/秒。
     *
     * @param keyIds  密钥对ID,参数不支持同时指定 KeyIds 和 Filters。密钥对ID可以通过登录控制台查询。
     * @param filters project-id 按照项目ID过滤。可以通过项目列表查询项目ID，或者调用接口 DescribeProject，取返回信息中的projectId获取项目ID。
     *                key-name   按照密钥对名称过滤。参数不支持同时指定 KeyIds 和 Filters。
     * @param offset
     * @param limit
     * @return https://cloud.tencent.com/document/api/213/15699
     */
    @Override
    public CommonResult DescribeKeyPairs(List<String> keyIds, List<Filter> filters, Long offset, Long limit) {
        if (CollectionUtil.isNotEmpty(keyIds) && CollectionUtil.isNotEmpty(filters)) {
            return CommonResult.error("不能同时使用密钥对和自定义过滤条件");
        }
        DescribeKeyPairsRequest req = new DescribeKeyPairsRequest();
        if (CollectionUtil.isNotEmpty(filters)) {
            if (!TencentUtil.checkFilterList(filters)) {
                return CommonResult.error("自定义筛选条件不能超过10个,且每个条件中每个值不能超过5个");
            }
            req.setFilters(TencentUtil.toObjectArray(filters));
        }
        if (offset != null) {
            req.setOffset(offset);
        }
        if (limit != null) {
            req.setLimit(limit);
        }
        try {
            DescribeKeyPairsResponse response = tencentConfig.getCvmClient().DescribeKeyPairs(req);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 创建密钥对
     * 本接口 (CreateKeyPair) 用于创建一个 OpenSSH RSA 密钥对，可以用于登录 Linux 实例。
     *
     * 开发者只需指定密钥对名称，即可由系统自动创建密钥对，并返回所生成的密钥对的 ID 及其公钥、私钥的内容。
     * 密钥对名称不能和已经存在的密钥对的名称重复。
     * 私钥的内容可以保存到文件中作为 SSH 的一种认证方式。
     * 腾讯云不会保存用户的私钥，请妥善保管。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15702
     */
    @Override
    public CommonResult CreateKeyPair(CreateKeyPairRequest request) {
        try {
            CreateKeyPairResponse response = tencentConfig.getCvmClient().CreateKeyPair(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 绑定密钥对
     * 本接口 (AssociateInstancesKeyPairs) 用于将密钥绑定到实例上。
     *
     * 将密钥的公钥写入到实例的SSH配置当中，用户就可以通过该密钥的私钥来登录实例。
     * 如果实例原来绑定过密钥，那么原来的密钥将失效。
     * 如果实例原来是通过密码登录，绑定密钥后无法使用密码登录。
     * 支持批量操作。每次请求批量实例的上限为100。如果批量实例存在不允许操作的实例，操作会以特定错误码返回。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15698
     */
    @Override
    public CommonResult AssociateInstancesKeyPairs(AssociateInstancesKeyPairsRequest request) {
        try {
            AssociateInstancesKeyPairsResponse response = tencentConfig.getCvmClient().AssociateInstancesKeyPairs(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 解绑密钥对
     * 本接口 (DisassociateInstancesKeyPairs) 用于解除实例的密钥绑定关系。
     *
     * 只支持STOPPED状态的Linux操作系统的实例。
     * 解绑密钥后，实例可以通过原来设置的密码登录。
     * 如果原来没有设置密码，解绑后将无法使用 SSH 登录。可以调用 ResetInstancesPassword 接口来设置登录密码。
     * 支持批量操作。每次请求批量实例的上限为100。如果批量实例存在不允许操作的实例，操作会以特定错误码返回。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15697
     */
    @Override
    public CommonResult DisassociateInstancesKeyPairs(DisassociateInstancesKeyPairsRequest request) {
        try {
            DisassociateInstancesKeyPairsResponse response = tencentConfig.getCvmClient().DisassociateInstancesKeyPairs(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 删除密钥对
     * 本接口 (DeleteKeyPairs) 用于删除已在腾讯云托管的密钥对。
     *
     * 可以同时删除多个密钥对。
     * 不能删除已被实例或镜像引用的密钥对，所以需要独立判断是否所有密钥对都被成功删除。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15700
     */
    @Override
    public CommonResult DeleteKeyPairs(DeleteKeyPairsRequest request) {
        try {
            DeleteKeyPairsResponse response = tencentConfig.getCvmClient().DeleteKeyPairs(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 修改密钥对属性
     * 本接口 (ModifyKeyPairAttribute) 用于修改密钥对属性。
     *
     * 修改密钥对ID所指定的密钥对的名称和描述信息。
     * 密钥对名称不能和已经存在的密钥对的名称重复。
     * 密钥对ID是密钥对的唯一标识，不可修改。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15701
     */
    @Override
    public CommonResult ModifyKeyPairAttribute(ModifyKeyPairAttributeRequest request) {
        try {
            ModifyKeyPairAttributeResponse response = tencentConfig.getCvmClient().ModifyKeyPairAttribute(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }

    /**
     * 导入密钥对
     * 本接口 (ImportKeyPair) 用于导入密钥对。
     *
     * 本接口的功能是将密钥对导入到用户账户，并不会自动绑定到实例。如需绑定可以使用AssociasteInstancesKeyPair接口。
     * 需指定密钥对名称以及该密钥对的公钥文本。
     * 如果用户只有私钥，可以通过 SSL 工具将私钥转换成公钥后再导入。
     * 默认接口请求频率限制：10次/秒。
     * @param request
     * @return
     * https://cloud.tencent.com/document/api/213/15703
     */
    @Override
    public CommonResult ImportKeyPair(ImportKeyPairRequest request) {
        try {
            ImportKeyPairResponse response = tencentConfig.getCvmClient().ImportKeyPair(request);
            CommonResult.ok(response);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return CommonResult.error();
    }
}
