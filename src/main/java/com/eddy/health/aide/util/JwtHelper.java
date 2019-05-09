package com.eddy.health.aide.util;

import com.eddy.health.aide.config.JwtConfiguration;
import com.eddy.health.aide.entity.HUser;
import com.eddy.health.aide.exception.LoginFailureException;
import com.eddy.health.aide.exception.TCException;
import com.eddy.health.aide.service.HUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author Eddy·Chen
 * @Email 835033913@qq.com
 * @Create 2019-04-15 10:19
 */
@Component
public class JwtHelper {

    @Autowired
    private JwtConfiguration configuration;

    @Autowired
    private HUserService userService;

    /**
     * 生成JWT
     *
     * @param userId
     * @return
     */
    public String generateTokenJwt(String userId) {
        if (StringUtils.isBlank(userId)) {
            throw new TCException("用户编号不可为空");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, configuration.getExpire().intValue());
        //设置过期时间
        Date date = calendar.getTime();

        //设置Claims
        CustomMap claims = CustomMap.create()
                .put("iss", "OPS_SERVER")
                .put("uid", userId);
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS256, configuration.getSecret())
                .compact();
        return token;
    }


    /**
     * 检查验证Token 并且获取用户信息
     *
     * @param token
     * @return
     */
    public HUser validateTokenAndGetClaims(String token) {
        Claims body = null;
        try {
            body = Jwts.parser()
                    .setSigningKey(configuration.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new LoginFailureException("凭证失效,请重新登录");
        }

        if (MapUtils.isEmpty(body)) {
            return null;
        }
        String uid = (String) body.get("uid");
        if (StringUtils.isBlank(uid)) {
            return null;
        }
        return userService.getById(uid);
    }

}
