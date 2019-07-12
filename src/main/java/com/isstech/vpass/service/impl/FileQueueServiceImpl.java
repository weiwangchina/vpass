package com.isstech.vpass.service.impl;

import com.isstech.vpass.config.Producer;
import com.isstech.vpass.service.FileQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName JournalServiceImpl
 * @Description TODO
 * @Author issuser
 * @Date 2019/7/12 14:36
 * @Version 1.0.0
 */
@Service
public class FileQueueServiceImpl implements FileQueueService {

    @Value("${queuefile}")
    String queue;

    @Autowired
    private Producer producer;

    @Override
    public void sendMsg(String msg) {
        producer.sendTo(queue, msg);
    }
}
