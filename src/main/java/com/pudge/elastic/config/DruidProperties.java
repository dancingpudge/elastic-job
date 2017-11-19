package com.pudge.elastic.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 只提供了常用的属性，如果有需要，自己添加
 *
 * @author liuzh
 * @since 2017/2/5.
 */
@ConfigurationProperties(prefix = "druid")
@Data
public class DruidProperties {
    private String url;
    private String username;
    private String password;

    private int     maxActive;
    private int     maxIdle;
    private int     initialSize;
    private int     maxWait;
    private int     minIdle;
    private int     timeBetweenEvictionRunsMillis;
    private int     minEvictableIdleTimeMillis;
    private boolean testOnBorrow;
    private boolean poolPreparedStatements;
    private int     maxOpenPreparedStatements;
}
