package com.eddy.health.aide.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eddy.health.aide.entity.HUser;
import com.eddy.health.aide.dao.HUserMapper;
import com.eddy.health.aide.service.HUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eddy.health.aide.util.EntityParamsAutoWrite;
import com.eddy.health.aide.util.JsonResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Eddy Chen
 * @since 2019-05-09
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HUserServiceImpl extends ServiceImpl<HUserMapper, HUser> implements HUserService {

    /**
     * 登录操作
     *
     * @param phone
     * @param password
     * @return
     */
    @Override
    public JsonResult login(String phone, String password) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("phone", phone);
        HUser user = this.getOne(wrapper);
        if (user == null) {
            return JsonResult.error("该用户未注册");
        }
        if (user.getPassword().equals(password)) {
            user.setPassword(null);
            return JsonResult.success(user);
        }
        return JsonResult.error("密码输入错误");
    }

    /**
     * 注册用户
     *
     * @param phone
     * @param password
     * @return
     */
    @Override
    public JsonResult register(String phone, String password) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("phone", phone);
        HUser user = this.getOne(wrapper);
        if (user != null) {
            return JsonResult.error("该手机号已被注册");
        }
        HUser hUser = new HUser();
        hUser.setPassword(password);
        hUser.setPhone(phone);
        hUser.setUserName(phone);
        EntityParamsAutoWrite.addForPc(hUser);
        boolean save = this.save(hUser);
        return save ? JsonResult.actionSuccess() : JsonResult.actionFailure();
    }

}
