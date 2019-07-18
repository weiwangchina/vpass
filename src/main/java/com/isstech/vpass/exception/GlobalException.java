package com.isstech.vpass.exception;

import lombok.Data;

/**
 * @ClassName GlobalException
 * @Description 后端自定义异常抛出类
 * @Author issuser
 * @Date 2019/7/18 13:40
 * @Version 1.0.0
 */
@Data
public class GlobalException extends Exception {

    private String message;
    private int value;
    public GlobalException() {
        super();
    }

    public GlobalException(String msg,int value) {
        this.message = msg;
        this.value = value;
    }
}
