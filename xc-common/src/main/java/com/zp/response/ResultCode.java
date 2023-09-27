package com.zp.response;

/**
 * 10000-- 通用错误代码
 * 22000-- 媒资错误代码
 * 23000-- 用户中心错误代码
 * 24000-- cms错误代码
 * 25000-- 文件系统
 */
public enum ResultCode implements IErrorCode {

    /**
     * 成功
     */
    SUCCESS(200, "操作成功！"),

    FAIL(500, "操作失败"),
    SERVER_ERROR(9999, "系统繁忙请稍后重启！"),
    INVALID_PARAM(10003, "非法参数！"),
    SIGN_FAIL(10001, "签名错误"),
    TIME_FAIL(10002, "时间戳超时错误"),
    TOKEN_FAIL(10003, "token错误"),
    AUTH_FAIL(10004, "权限不足"),

    PARAM_FAIL(20000, "参数错误"),
    PARAM_EMPTY_ERROR(20001, "参数为空"),
    PARAM_PATTERN_ERROR(20002, "参数格式不对"),

    FAILED(99999, "系统繁忙，请稍后再试.");

    /**
     * 错误码
     */
    private long code;
    // 提示信息
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
