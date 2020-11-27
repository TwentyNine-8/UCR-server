package com.ucr.vcener.tencentCloud.req;

import com.tencentcloudapi.cvm.v20170312.models.*;
import java.util.List;
import lombok.Data;

/**
 * 实例询价 请求类
 *
 * @author ymn
 * @date 2020/11/27 15:58
 */
@Data
public class InquiryPriceRunInstancesReq {
    /**
     * https://cloud.tencent.com/document/api/213/15753#Placement
     */
    private Placement placement;
    /**
     * 指定有效的镜像ID，格式形如img-xxx。镜像类型分为四种：
     * 公共镜像
     * 自定义镜像
     * 共享镜像
     * 服务市场镜像
     * <p>
     * 可通过以下方式获取可用的镜像ID：
     * 公共镜像、自定义镜像、共享镜像的镜像ID可通过登录控制台查询；服务镜像市场的镜像ID可通过云市场查询。
     * 通过调用接口 DescribeImages ，取返回信息中的ImageId字段。
     */
    private String ImageId;
    /**
     * 实例计费类型。
     * PREPAID：预付费，即包年包月
     * POSTPAID_BY_HOUR：按小时后付费
     * SPOTPAID：竞价付费
     * 默认值：POSTPAID_BY_HOUR。
     */
    private String InstanceChargeType;
    /**
     * 预付费模式，即包年包月相关参数设置。通过该参数可以指定包年包月实例的购买时长、是否设置自动续费等属性。若指定实例的付费模式为预付费则该参数必传。
     * https://cloud.tencent.com/document/api/213/15753#InstanceChargePrepaid
     */
    private InstanceChargePrepaid instanceChargePrepaid;
    /**
     * 实例机型。不同实例机型指定了不同的资源规格，具体取值可通过调用接口DescribeInstanceTypeConfigs来获得最新的规格表或参见实例规格描述。若不指定该参数，则默认机型为S1.SMALL1。
     */
    private String instanceType;
    /**
     * 实例系统盘配置信息。若不指定该参数，则按照系统默认值进行分配。
     * https://cloud.tencent.com/document/api/213/15753#SystemDisk
     */
    private SystemDisk systemDisk;
    /**
     * 实例数据盘配置信息。若不指定该参数，则默认不购买数据盘。支持购买的时候指定21块数据盘，
     * 其中最多包含1块LOCAL_BASIC数据盘或者LOCAL_SSD数据盘，
     * 最多包含20块CLOUD_BASIC数据盘、CLOUD_PREMIUM数据盘或者CLOUD_SSD数据盘。
     * <p>
     * https://cloud.tencent.com/document/api/213/15753#DataDisk
     */
    private List<DataDisk> dataDisks;
    /**
     * 私有网络相关信息配置。通过该参数可以指定私有网络的ID，子网ID等信息。
     * 若不指定该参数，则默认使用基础网络。若在此参数中指定了私有网络IP，那么InstanceCount参数只能为1。
     * https://cloud.tencent.com/document/api/213/15753#VirtualPrivateCloud
     */
    private VirtualPrivateCloud virtualPrivateCloud;
    /**
     * 公网带宽相关信息设置。若不指定该参数，则默认公网带宽为0Mbps。
     * https://cloud.tencent.com/document/api/213/15753#InternetAccessible
     */
    private InternetAccessible internetAccessible;

    private Integer instanceCount;
}
