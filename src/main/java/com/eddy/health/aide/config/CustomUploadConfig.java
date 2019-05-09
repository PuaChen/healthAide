package com.eddy.health.aide.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author PuaChen
 * @Create 2018-09-18
 */
@ConfigurationProperties(prefix = "upload")
@Component
public class CustomUploadConfig {
    private String dirFilePath;
    private String url;

    public String getDirFilePath() {
        return dirFilePath;
    }

    public void setDirFilePath(String dirFilePath) {
        this.dirFilePath = dirFilePath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
