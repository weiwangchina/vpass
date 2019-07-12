package com.isstech.vpass.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.isstech.vpass.code.ErrorCode;
import com.isstech.vpass.code.Resp;
import com.isstech.vpass.tools.CommonContext;
import com.isstech.vpass.tools.ContextMethod;
import com.isstech.vpass.tools.RequestXML;
import com.isstech.vpass.utils.HttpUtils;
import com.isstech.vpass.utils.HttpsUtil;
import com.isstech.vpass.utils.JsonXmlUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

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
        String gsonString = new Gson().toJson(result);
        if(type.equals("xml")) {
            return Resp.success(result);
        } else if (type.equals("json")) {
            return Resp.success(JsonXmlUtils.xmlToJson(result));
        } else if(type.equals("gsonString")) {
            return Resp.success(gsonString);
        }
        return Resp.fail(ErrorCode.SYSTEM_ERROR_416);
    }

    @RequestMapping(value = "down_load_image", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
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

    /**
     * 文件下载
     * @param response
     * @param file_id 文件Id
     * @throws UnsupportedEncodingException
     */
    @ResponseBody
    @RequestMapping(value = "/exportUI")
    public void exportUI(HttpServletResponse response, HttpServletRequest request, String file_id) throws Exception {
                String path = PATH + CommonContext.VIDEOANALYSIS_PEOPLEFACE_IMAGE + "?fileid=" + file_id + "&type=" + 1;
                String fileName = "a.jpg";
                response.reset();
                response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
                response.setHeader("Connection", "close");
                response.setHeader("Content-Type", "application/octet-stream");
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setContentType("application/OCTET-STREAM");
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                // 设置超时间为3秒
                conn.setConnectTimeout(15 * 1000);
                // 防止屏蔽程序抓取而返回403错误
                conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                // 得到输入流
//                InputStream inputStream = conn.getInputStream();
                ServletOutputStream out = response.getOutputStream();
                request.setCharacterEncoding("UTF-8");
                int BUFFER = 1024*10;
                byte data[] = new byte[BUFFER];
                BufferedInputStream bis = null;
                //获取文件输入流
                InputStream fis = conn.getInputStream();
                int read;
                bis = new BufferedInputStream(fis,BUFFER);
                while((read = bis.read(data)) != -1){
                    out.write(data, 0, read);
                }
                fis.close();
                bis.close();

    }
}
