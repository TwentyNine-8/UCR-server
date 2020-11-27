package com.ucr.vcener.util;

import com.tencentcloudapi.cvm.v20170312.models.Filter;
import java.lang.reflect.Array;
import java.util.List;

/**
 * 腾讯云工具类
 *
 * @author ymn
 * @date 2020/11/27 14:12
 */
public class TencentUtil {

    /**
     * 判断接口是否返回成功
     *
     * @return
     */
    public boolean isSuccess() {
        return false;
    }

    /**
     * 集合转数组
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T[] toObjectArray(List<T> list) {
        Array[] array = new Array[list.size()];
        list.toArray(array);
        return (T[]) array;
    }

    /**
     * 每次请求的Filters的上限为10，Filter.Values的上限为5。
     *
     * @param list
     * @return
     */
    public static boolean checkFilterList(List<Filter> list) {
        if (list.size() > 10) {
            return false;
        }
        for (Filter filter : list) {
            if (filter.getValues().length > 10) {
                return false;
            }
        }
        return true;
    }
}
