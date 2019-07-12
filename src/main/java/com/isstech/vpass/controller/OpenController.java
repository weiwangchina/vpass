package com.isstech.vpass.controller;

import com.isstech.vpass.code.Resp;
import com.isstech.vpass.global.Config;
import com.isstech.vpass.tools.CommonContext;
import com.isstech.vpass.tools.ContextMethod;
import com.isstech.vpass.utils.HttpUtils;
import com.isstech.vpass.utils.JsonXmlUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OpenController
 * @Description TODO
 * @Author issuser
 * @Date 2019/7/9 10:14
 * @Version 1.0.0
 */
@RestController
@RequestMapping("{api}/{open}/{public}/{version}/open")
public class OpenController extends BaseController {

    /**
     * 登陆华为接口
     *
     * @param account 账户
     * @param pwd     密码
     * @return 返回JSON标识
     */
    @RequestMapping(value = "login")
    @CrossOrigin(origins = "*")
    public Resp login(@RequestParam(name = "account", required = false) String account,
                      @RequestParam(name = "pwd", required = false) String pwd) throws Exception {
        String url = PATH + CommonContext.MANAGEMENT_APPLICATION_LOGIN;
        account = (StringUtils.isEmpty(account)) ? super.username : account;
        pwd = (StringUtils.isEmpty(pwd)) ? super.password : pwd;
        String result = ContextMethod.login_post(url, "account=" + account + "&pwd=" + pwd);
        return Resp.success(JsonXmlUtils.xmlToJson(result));
    }

    /**
     * 退出登录
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "log_out", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public Resp logOut() throws Exception {
        String url = PATH + CommonContext.MANAGEMENT_APPLICATION_LOGOUT;
        String result = ContextMethod.login_post(url, "");
        return Resp.success(JsonXmlUtils.xmlToJson(result));
    }
}
