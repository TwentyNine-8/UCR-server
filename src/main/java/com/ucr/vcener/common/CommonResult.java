package com.ucr.vcener.common;

import lombok.Data;

/**
 * 返回数据
 *
 * @author mallplus
 * @email mallplus@163.com
 * @date 2018年05月27日 下午9:59:27
 */
@Data
public class CommonResult<T> {
    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;
    private T data;

    public CommonResult() {
        this.setCode("C0");
        this.setMsg("success");
    }

    public CommonResult(String code, String msg) {
        CommonResult<Object> r = new CommonResult<>();
        r.setCode(code);
        r.setMsg(msg);
    }

    public static CommonResult error(String code, String msg) {
        CommonResult<Object> r = new CommonResult<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static CommonResult error() {
        CommonResult<Object> r = new CommonResult<>();
        r.setCode("444");
        r.setMsg("操作失败,请联系管理员");
        return r;
    }

    public static CommonResult error(String msg) {
        CommonResult<Object> r = new CommonResult<>();
        r.setCode("444");
        r.setMsg(msg);
        return r;
    }

    public static CommonResult ok(Object object) {
        CommonResult r = new CommonResult();
        r.setData(object);
        return r;
    }

    public static CommonResult ok(Object object, String msg) {
        CommonResult r = new CommonResult();
        r.setData(object);
        r.setMsg(msg);
        return r;
    }

    public static CommonResult ok() {
        return new CommonResult();
    }
}
