package com.eddy.health.aide.util;

import com.eddy.health.aide.entity.HUser;
import com.eddy.health.aide.exception.LoginFailureException;
import org.apache.commons.collections.MapUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Eddy·Chen
 * @Email 835033913@qq.com
 * @Create 2019-03-09 14:34
 */
public final class ContextUtil {

    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = new ThreadLocal<>();

    public static final String USER_KEY = "USR_KEY";

    public static void setUser(HUser user) {
        if (user == null) {
            throw new RuntimeException("Invalid Params");
        }
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put(USER_KEY, user);
        THREAD_LOCAL.set(map);
    }

    /**
     * 获取用户
     *
     * @return
     */
    public static HUser getUser() {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (MapUtils.isEmpty(map)) {
            throw new LoginFailureException("请先登录");
        }
        return (HUser) map.get(USER_KEY);
    }


    public static Integer getUserId() {
        return getUser().getId();
    }

    public static void close() {
        THREAD_LOCAL.remove();
    }

}
