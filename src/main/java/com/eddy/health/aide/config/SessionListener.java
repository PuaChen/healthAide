package com.eddy.health.aide.config;


import com.eddy.health.aide.util.ContextUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author Eddy·Chen
 * @Email 835033913@qq.com
 * @Create 2019-04-15 11:03
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ContextUtil.close();
    }
}
