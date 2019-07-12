package com.isstech.vpass.controller;

import com.alibaba.fastjson.JSON;
import com.isstech.vpass.code.ErrorCode;
import com.isstech.vpass.code.Resp;
import com.isstech.vpass.tools.CommonContext;
import com.isstech.vpass.tools.ContextMethod;
import com.isstech.vpass.tools.RequestXML;
import com.isstech.vpass.utils.Base64Util;
import com.isstech.vpass.utils.FileUtil;
import com.isstech.vpass.utils.JsonXmlUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ClassName VideoAnalysisController
 * @Description 4.3.2 智能搜索
 * @Author issuser
 * @Date 2019/7/9 13:40
 * @Version 1.0.0
 */
@RestController
@RequestMapping("{api}/{open}/{version}/smart_search")
public class SmartSearchController extends BaseController {

    /**
     * 搜索人脸人体信息。
     * 1、可指定或者不指定图片搜索人脸信息；
     * 2、可指定或者不指定图片搜索人体信息；
     * 3、增加检索时间段。
     * 4、支持size=0，当size=0是只返回总数，且是精确的
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public Resp peoplefaces(@RequestParam(name = "no", defaultValue = "1") String no,
                            @RequestParam(name = "size", defaultValue = "1") String size,
                            @RequestParam(name = "start_time", defaultValue = "1562653142516") String start_time,
                            @RequestParam(name = "end_time", defaultValue = "1562654142517") String end_time,
                            @RequestParam(name = "type", defaultValue = "xml") String type) throws Exception {
        String requestXML = RequestXML.getXMLRequest("smartSearch.xml");
        requestXML = requestXML.replace("{startTime}", start_time);
        requestXML = requestXML.replace("{endTime}", end_time);
        requestXML = requestXML.replace("{no}", no);
        requestXML = requestXML.replace("{size}", size);
        String url = PATH + CommonContext.VIDEOANALYSIS_PEOPLEFACES_V1_5;
        String result = ContextMethod.sendPost(url, requestXML);
        String jsonString = JsonXmlUtils.xmlToJson(result);
        if(type.equals("xml")) {
            return Resp.success(result);
        } else if (type.equals("json")) {
            System.out.println(JSON.toJSON(jsonString));
            return Resp.success(JSON.toJSON(jsonString));
        } else if(type.equals("jsonString")) {
            return Resp.success(jsonString);
        }
        return Resp.fail(ErrorCode.SYSTEM_ERROR_416);
    }

    /**
     * 人脸对比1：1
     * TODO 暂时支持file
     * 支持file_id 和 图片对比
     * @param request
     * @param type 传递 file 或 file_id 默认file_id
     * @param file_1 如果时文件，传递文件全路径加文件全名称加后缀,如果ID传递ID
     * @param file_2 如果时文件，传递文件全路径加文件全名称加后缀,如果ID传递ID
     */
    @RequestMapping(value = "facematch", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Resp facematch(
            HttpServletRequest request,
            @RequestParam(name = "type", defaultValue = "file_id") String type,
            @RequestParam(name = "file_1") String file_1,
            @RequestParam(name = "file_2") String file_2) throws Exception {
        String url = PATH + CommonContext.FACEMATCH_1V1;
        if("file_id".equals(type)) {
            String requestXML = RequestXML.getXMLRequest("facematch.xml");
            requestXML = requestXML.replace("{file_id_1}", file_1);
            requestXML = requestXML.replace("{file_id_2}", file_2);
            requestXML = requestXML.replace("{file_1}", "");
            requestXML = requestXML.replace("{file_2}", "");
            String result = ContextMethod.sendPost(url, requestXML);
            result = JsonXmlUtils.xmlToJson(result);
            return Resp.success(result);
        } else if("file".equals(type)){
            String requestXML = RequestXML.getXMLRequest("facematch.xml");
            byte[] bytes1 = FileUtil.readFileByBytes(file_1);
            byte[] bytes2 = FileUtil.readFileByBytes(file_2);
            String image1 = Base64Util.encode(bytes1);
            String image2 = Base64Util.encode(bytes2);
            requestXML = requestXML.replace("{file_1}", image1);
            requestXML = requestXML.replace("{file_2}", image2);
            requestXML = requestXML.replace("{file_id_1}", "");
            requestXML = requestXML.replace("{file_id_2}", "");
            String result = ContextMethod.sendPost(url, requestXML);
            result = JsonXmlUtils.xmlToJson(result);
            return Resp.success(result);
        }
        return Resp.fail(ErrorCode.SYSTEM_ERROR_999999);
     }

    /**
     * 人脸下载
     * @param response
     * @param file_id
     * @param type
     * @throws Exception
     */
    @RequestMapping(value = "down_load_image", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    @SuppressWarnings("all")
    public void downLoad(HttpServletResponse response,
                         @RequestParam(name = "file_id", defaultValue = "6d4407fc5cd94dccb8eec0943d819275%237159918467892474112@10") String file_id,
                         @RequestParam(name = "type", defaultValue = "1") String type) throws Exception {
        String url = PATH + CommonContext.VIDEOANALYSIS_PEOPLEFACE_IMAGE + "?fileid=" + file_id + "&type=" + type;
        byte[] result = ContextMethod.stream(url);
        String fileName = java.net.URLEncoder.encode(System.currentTimeMillis() + ".jpg", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        OutputStream sos = response.getOutputStream();
        sos.write(result,0, result.length - 1);
        sos.flush();
        sos.close();
    }
}
