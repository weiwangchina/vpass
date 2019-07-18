package com.isstech.vpass.entity;

import lombok.Data;
//import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @ClassName ExceptionEntity
 * @Description 系统拦截的异常类
 * @Author issuser
 * @Date 2019/7/11 8:52
 * @Version 1.0.0
 */
@Data
//@Document(collection = "exception")
public class ExceptionEntity implements Serializable {

    private String message;

    private String className;

    private String methodName;

    private String exceptionName;

    private Integer lineNumber;

    private Long createTime;

    private String clientIP;
}
