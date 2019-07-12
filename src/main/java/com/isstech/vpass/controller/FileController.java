package com.isstech.vpass.controller;

import com.isstech.vpass.tools.CommonContext;
import com.isstech.vpass.tools.ContextMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @ClassName FileController
 * @Description 文件服务
 * @Author issuser
 * @Date 2019/7/9 15:03
 * @Version 1.0.0
 */
@Controller
@RequestMapping("{api}/{open}/{version}/file")
public class FileController extends BaseController {

    /**
     * 下载人体人脸图片
     *
     * @param file_id 过人过脸搜索系统返回的图片id
     * @param type 下载类型（0人体缩略图、1人体全图、2人脸缩略图、3人脸全图
     * @return
     */
    @SuppressWarnings("all")
    @RequestMapping(value = "download_peopleface_image", method = RequestMethod.GET)
    public void downloadPeoplefaceImage(
            HttpServletResponse response,
            @RequestParam(name = "file_id") String file_id,
            @RequestParam(name = "type", defaultValue = "1") String type) throws Exception {
        String url = PATH + CommonContext.VIDEOANALYSIS_PEOPLEFACE_IMAGE + "?" + "fileid=" + file_id + "&" + "type=" + type;
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
