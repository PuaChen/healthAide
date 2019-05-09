package com.eddy.health.aide.service;

import com.eddy.health.aide.entity.HUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eddy.health.aide.util.JsonResult;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Eddy Chen
 * @since 2019-05-09
 */
public interface HUserService extends IService<HUser> {

    JsonResult login(String phone, String password);

    JsonResult register(String phone, String password);
}
