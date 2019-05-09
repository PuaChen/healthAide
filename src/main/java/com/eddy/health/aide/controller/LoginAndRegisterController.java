package com.eddy.health.aide.controller;

import com.eddy.health.aide.annotation.PassToken;
import com.eddy.health.aide.config.JwtConfiguration;
import com.eddy.health.aide.entity.HUser;
import com.eddy.health.aide.service.HUserService;
import com.eddy.health.aide.util.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Eddy·Chen
 * @Email 835033913@qq.com
 * @Create 2019-05-09 18:32
 * 用户的登录和注册
 */
@RestController
@RequestMapping("/api/main")
public class LoginAndRegisterController {

    @Autowired
    private HUserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private JwtConfiguration configuration;

    /**
     * 登录注册功能
     *
     * @param phone
     * @param password
     * @return
     */
    @PostMapping("/login")
    @PassToken
    public JsonResult login(String phone, String password) {
        if (!ObjectUtil.checkParamsNotNull(phone, password)) {
            return JsonResult.errorForEmpty();
        }
        userService.register(phone, password);
        JsonResult<HUser> login = userService.login(phone, password);
        if (!login.isSuccess()) {
            return login;
        }
        String tokenJwt = jwtHelper.generateTokenJwt(login.getResult().getId() + "");
        CustomMap data = CustomMap.create("token", tokenJwt)
                .put("time", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"))
                .put("expire", configuration.getExpire());
        return JsonResult.success(data);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @PostMapping("/getUserInfo")
    public JsonResult getUserInfo() {
        HUser user = ContextUtil.getUser();
        user.setPassword(null);
        return JsonResult.success(user);
    }


    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public JsonResult updateUser(@ModelAttribute HUser user) {
        if (user.getId() == null) {
            return JsonResult.errorForEmpty();
        }
        boolean state = userService.updateById(user);
        return state ? JsonResult.actionSuccess() : JsonResult.actionFailure();
    }

}
