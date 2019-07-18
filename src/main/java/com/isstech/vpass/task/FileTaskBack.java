package com.isstech.vpass.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.isstech.vpass.controller.BaseController;
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

import java.util.Calendar;

/**
 * @ClassName TestTask
 * @Description TODO
 * @Author issuser
 * @Date 2019/7/12 10:21
 * @Version 1.0.0
 */
@Slf4j
@Component
public class FileTaskBack {

    @Value("${account.task-username}")
    public String username;

    @Value("${account.task-pwd}")
    public String password;

    @Autowired
    private FileQueueService fileQueueService;

//    @Scheduled(cron = "0/30 * * * * *")
    public void scheduled() throws Exception {
        String PATH = BaseController.PATH;
        // 登录
        String url = PATH + CommonContext.MANAGEMENT_APPLICATION_LOGIN;
        String account = username;
        String pwd = password;
        String result = ContextMethod.login_post(url, "account=" + account + "&pwd=" + pwd);
        log.info("login {}", result);

        // 处理业务 这里处理的图片应该存在MQ中由另外一个服务单独处理下载操作
//        Date d = DateUtil.parse("2019-07-14", "yyyy-MM-dd");
//        String start_time = d.getTime() + "";

//        String start_time = DateUtil.getTimeByParam(Calendar.MINUTE, -30) + ""; // 只能一小时内的分钟数， 这里设置30分钟
        String start_time = DateUtil.getTimeByParam(Calendar.MONTH, -2) + "";
        String end_time = System.currentTimeMillis() + "";
        String no = "1";
        String size = "1000";
        String requestXML = RequestXML.getXMLRequest("smartSearch.xml");
        requestXML = requestXML.replace("{startTime}", start_time);
        requestXML = requestXML.replace("{endTime}", end_time);
        requestXML = requestXML.replace("{no}", no);
        requestXML = requestXML.replace("{size}", size);
        url = PATH + CommonContext.VIDEOANALYSIS_PEOPLEFACES_V1_5;
        result = ContextMethod.sendPost(url, requestXML);
        String jsonString = JsonXmlUtils.xmlToJson(result);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        if(!jsonObject.get("total").equals("0")) {
            if(jsonObject.get("total").equals("1")) {
                JSONObject tmp = (JSONObject) jsonObject.get("peoplefaces");
                JSONObject ob = (JSONObject) tmp.get("peopleface");
                fileQueueService.sendMsg(ob.toJSONString());
            } else {
                JSONArray jsonArray = (JSONArray) jsonObject.get("peoplefaces");
                for (Object object1 : jsonArray) {
                    JSONObject tmp = (JSONObject) object1;
                    fileQueueService.sendMsg(tmp.toJSONString());
//                    Object fileId = tmp.get("fileId");
//                    log.info("fileId : {}", fileId);
//                    url = PATH + CommonContext.VIDEOANALYSIS_PEOPLEFACE_IMAGE + "?fileid=" + fileId + "&type=1";
//                    byte[] bt = ContextMethod.stream(url);
//                    File file = new File("D:/tmp/camera_img/" + fileId + ".jpg");
//                    if(file.exists()) {
//                        break;
//                    }
//                    FileOutputStream os = new FileOutputStream("D:/tmp/camera_img/" + fileId + ".jpg");
//                    os.write(bt, 0, bt.length - 1);
//                    os.flush();
//                    os.close();
                }
            }
        }

        // logout
        url = PATH + CommonContext.MANAGEMENT_APPLICATION_LOGOUT;
        result = ContextMethod.login_post(url, "");
//        log.info("result logou {}", result);
    }
    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
    }
    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
    }
}
