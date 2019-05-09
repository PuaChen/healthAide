package com.eddy.health.aide.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Eddy·Chen
 * @Email 835033913@qq.com
 * @Create 2019-04-15 10:16
 */
@ConfigurationProperties(prefix = "jwt")
@Data
@Component
public class JwtConfiguration {

    private String secret;
    private Long expire;
    private String head;
}
