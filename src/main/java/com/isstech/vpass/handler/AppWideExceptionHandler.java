package com.isstech.vpass.handler;

import com.alibaba.fastjson.JSON;
//import com.soft.config.ConnectionConstant;
//import com.soft.entity.ExceptionEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
import com.isstech.vpass.entity.ExceptionEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AppWideExceptionHandler
 * @Description 全局请求异常类
 * @Author issuser
 * @Date 2019/7/10 22:16
 * @Version 1.0.0
 */
@ControllerAdvice
@Component
public class AppWideExceptionHandler {

//    @Autowired
//    private MongoTemplate mongoTemplate;

//    public String CONNECTION = ConnectionConstant.CONNECTION_EXCEPTION;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(HttpServletRequest request, Exception ex) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setMessage(ex.getMessage());
        exceptionEntity.setClassName(ex.getStackTrace()[0].getClassName());
        exceptionEntity.setExceptionName(ex.getClass() + "");
        exceptionEntity.setLineNumber(ex.getStackTrace()[0].getLineNumber());
        exceptionEntity.setCreateTime(System.currentTimeMillis());
        exceptionEntity.setClientIP(request.getRemoteAddr());
//        exceptionEntity = mongoTemplate.save(exceptionEntity, CONNECTION);
        return JSON.toJSONString(exceptionEntity);
    }
}
