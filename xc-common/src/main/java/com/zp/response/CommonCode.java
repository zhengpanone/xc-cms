package com.zp.response;

import lombok.ToString;

@ToString
public enum CommonCode implements ResultCode {
    /**
     * 成功
     */
    SUCCESS(true, 10000, "操作成功！"),

    FAIL(false, 11111, "操作失败"),
    SERVER_ERROR(false,9999,"系统繁忙请稍后重启！"),
    INVALID_PARAM(false, 10003,"非法参数！"),
    SIGN_FAIL(false,10001, "签名错误"),
    TIME_FAIL(false,10002, "时间戳超时错误"),
    TOKEN_FAIL(false,10003, "token错误"),
    AUTH_FAIL(false,10004, "权限不足"),

    PARAM_FAIL(false,20000, "参数错误"),
    PARAM_EMPTY_ERROR(false,20001, "参数为空"),
    PARAM_PATTERN_ERROR(false,20002, "参数格式不对"),

    FAILED(false,99999, "系统繁忙，请稍后再试.");
    //操作是否成功
    boolean success;
    /**
     * 错误码
     */
     int code;
    //提示信息
      String message;

    private CommonCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
