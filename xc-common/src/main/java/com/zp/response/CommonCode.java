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
    INVALID_PARAM(false, 10003,"非法参数！");
    //操作是否成功
    boolean success;
    // 操作代码
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
