package com.coding.common;


/**
 * @author guanweiming
 */

public enum MyResultCodeEnum {

    /**
     * 返回结果状态枚举
     */
    SUCCESS(0, "成功"),
    ERROR(1, "失败");

    private final int code;
    private final String name;

    MyResultCodeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
