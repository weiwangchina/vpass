package com.isstech.vpass.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.isstech.vpass.controller.BaseController;
import com.isstech.vpass.exception.GlobalException;
import com.isstech.vpass.service.FileQueueService;
import com.isstech.vpass.tools.CommonContext;
import com.isstech.vpass.tools.ContextMethod;
import com.isstech.vpass.tools.DateUtil;
import com.isstech.vpass.tools.RequestXML;
import com.isstech.vpass.utils.JsonXmlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName TestTask
 * @Description TODO
 * @Author issuser
 * @Date 2019/7/12 10:21
 * @Version 1.0.0
 */
@Slf4j
@Component
public class FileTask {

    @Value("${account.task-username}")
    public String username;

    @Value("${account.task-pwd}")
    public String password;

    @Autowired
    private FileQueueService fileQueueService;

//    @Scheduled(cron = "0/55 * * * * *") // 55秒执行一次
//    @Scheduled(cron = "* 0/5 * * * *") // 5分钟执行一次
//    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled() throws GlobalException {
        try {
            login();
            Long start_time = DateUtil.getTimeByParam(Calendar.MINUTE, -30); // 只能一小时内的分钟数， 这里设置30分钟
//        Long start_time = DateUtil.getTimeByParam(Calendar.MONTH, -1); // 12个月内
            getData(1, start_time, 0);
            logout();
        } catch (Exception e) {
            throw new GlobalException("运行自定义任务异常！ 异常内容是：" + e.getMessage(), 500);
        }
    }

    private void logout() throws Exception {
        String PATH = BaseController.PATH;
        String url = PATH + CommonContext.MANAGEMENT_APPLICATION_LOGOUT;
        String result = ContextMethod.login_post(url, "");
        log.info("result logou {}", result);
    }

    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
    }
    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
    }

    private void login() throws Exception {
        String PATH = BaseController.PATH;
        String url = PATH + CommonContext.MANAGEMENT_APPLICATION_LOGIN;
        String account = username;
        String pwd = password;
        String result = ContextMethod.login_post(url, "account=" + account + "&pwd=" + pwd);
        log.info("login {}", result);
    }

    private void getData(int no, Long start_time, int i) throws Exception {
        ++i;
        String PATH = BaseController.PATH;
        String url = "";
        String result = "";

        // 处理业务 这里处理的图片应该存在MQ中由另外一个服务单独处理下载操作
//        Date d = DateUtil.parse("2019-07-14", "yyyy-MM-dd");
//        String start_time = d.getTime() + "";

        String end_time = System.currentTimeMillis() + "";
        String size = "1000";
        String requestXML = RequestXML.getXMLRequest("smartSearch.xml");
        requestXML = requestXML.replace("{startTime}", start_time + "");
        requestXML = requestXML.replace("{endTime}", end_time);
        requestXML = requestXML.replace("{no}", no + "");
        requestXML = requestXML.replace("{size}", size);
        url = PATH + CommonContext.VIDEOANALYSIS_PEOPLEFACES_V1_5;
        result = ContextMethod.sendPost(url, requestXML);
        String jsonString = JsonXmlUtils.xmlToJson(result);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        if(jsonObject != null) {
            // vpass api规定，页数加每页条数不能大于10000， 所以这里如果大于1000条数据是获取不到的。可以根据修改请求的条件进行绕开限制
            if(!"0".equals(jsonObject.get("total"))) {
                if("1".equals(jsonObject.get("total"))) {
                    JSONObject tmp = (JSONObject) jsonObject.get("peoplefaces");
                    JSONObject ob = (JSONObject) tmp.get("peopleface");
                    fileQueueService.sendMsg(ob.toJSONString());
                } else {
                    // 等于1000的情况，很可能后面还有数据 小于一千后面没有数据了
                    if("1000".equals(jsonObject.get("total"))) {
                        JSONArray jsonArray = (JSONArray) jsonObject.get("peoplefaces");
                        for (Object object1 : jsonArray) {
                            JSONObject tmp = (JSONObject) object1;
//                            fileQueueService.sendMsg(tmp.toJSONString());
                        }

                        // 如果循环到第8页，减少一个月, i 重新计算
                        if(i == 8) {
                            start_time -= 1000 * 60 * 60 * 24 * 31;
                            i = 0;
                            no = 1;
                        }
                        getData(++ no, start_time, i);
                    } else {
                        JSONArray jsonArray = (JSONArray) jsonObject.get("peoplefaces");
                        for (Object object1 : jsonArray) {
                            JSONObject tmp = (JSONObject) object1;
                            fileQueueService.sendMsg(tmp.toJSONString());
                        }
                    }
                }
            }
        }
    }
}
