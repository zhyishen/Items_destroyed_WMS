package com.safetychina.items_destroyed_wms.common;

import lombok.Data;

@Data
public class CommRes {
    private int code;
    private String msg;
    private Object data;

    // 手动设置返回vo
    public CommRes(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 默认返回成功状态码，数据对象
    public CommRes(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    // 返回指定状态码，数据对象
    public CommRes(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    // 只返回状态码
    public CommRes(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }
}
