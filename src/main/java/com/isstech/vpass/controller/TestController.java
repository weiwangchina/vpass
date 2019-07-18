package com.isstech.vpass.controller;

import com.isstech.vpass.exception.GlobalException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName TestController
 * @Description 测试控制器
 * @Author issuser
 * @Date 2019/7/9 10:01
 * @Version 1.0.0
 */
@RestController
@RequestMapping("{api}/{open}/{version}/test")
public class TestController extends BaseController {

    @RequestMapping("test")
    @CrossOrigin(origins = "*")
    public String test() {
        logger.info("request: {}", "test".toString());
        return "test";
    }

    @RequestMapping("exception")
    @CrossOrigin(origins = "*")
    public String exception() throws Exception {
        throw new Exception("测试异常...");
    }

    public static void main(String[] args) {
        String url = "https://10.128.184.4:443/sdk_service/rest/videoanalysis/peopleface/image?type=1&fileid=6d4407fc5cd94dccb8eec0943d819275%23170332180180726016%4010";
        downloadPicture(url);
    }
    //链接url下载图片
    private static void downloadPicture(String urlList) {
        URL url = null;
        int imageNumber = 0;

        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            String imageName =  "D:/test.jpg";

            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context=output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
