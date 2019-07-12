package com.isstech.vpass.controller;

import com.isstech.vpass.tools.CommonContext;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author issuser
 * @Date 2019/7/9 10:00
 * @Version 1.0.0
 */
@Component
@Data
public class BaseController {

    @Value("${uname}")
    public String username;

    @Value("${pwd}")
    public String password;

    // 适用与特殊拦截外的少数场合
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String HTTPS = "https://";

    public static final String PATH = HTTPS + CommonContext.IP + ":" + CommonContext.POST;
}
