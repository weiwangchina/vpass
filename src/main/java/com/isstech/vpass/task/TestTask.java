package com.isstech.vpass.task;

import com.alibaba.fastjson.JSONObject;
import com.isstech.vpass.service.FileQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestTask
 * @Description TODO
 * @Author issuser
 * @Date 2019/7/12 21:54
 * @Version 1.0.0
 */
@Slf4j
@Component
public class TestTask {

    @Value("${account.task-username}")
    public String username;

    @Value("${account.task-pwd}")
    public String password;

    @Autowired
    private FileQueueService fileQueueService;

//    @Scheduled(cron = "0/1 * * * * *")
    public void test() {
        JSONObject tmp  = new JSONObject();
        for (int i = 0; i < 1000; i++) {
            tmp.put("fileId", "aa" + System.currentTimeMillis());
            fileQueueService.sendMsg(tmp.toJSONString());
        }
    }
}
