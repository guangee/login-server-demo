package com.coding.common;

import com.coding.domain.User;
import lombok.Data;

/**
 * @author guanweiming
 */
@Data
public class MyResult<T> {

    /**
     * 当结果不成功的时候给出错误信息
     */
    private String msg;

    /**
     * 返回结果状态 0-成功 非0-失败
     */
    private int status;

    /**
     * 结果内容
     */
    private T data;


    public static <T> MyResult<T> success(T data) {
        MyResult<T> myResult = new MyResult<T>();
        myResult.setData(data);
        myResult.setStatus(MyResultCodeEnum.SUCCESS.getCode());
        return myResult;
    }

    public static <T> MyResult<T> error(String msg) {
        MyResult<T> myResult = new MyResult<>();
        myResult.setStatus(MyResultCodeEnum.ERROR.getCode());
        myResult.setMsg(msg);
        return myResult;
    }

    public static <T> MyResult<T> error(int status, String msg) {
        MyResult<T> myResult = new MyResult<>();
        myResult.setStatus(status);
        myResult.setMsg(msg);
        return myResult;
    }
}
