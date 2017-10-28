package com.jd.logistics.cloud.data.dashboard.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/23 15:08
 */

@Configuration
public class DefaultConfiguration {
    @Configuration
    @Profile("prod")
    @PropertySource({"classpath:important.properties", "classpath:common.properties"})
    static class Production {
    }


    @Configuration
    @Profile("dev")
    @PropertySource(value = {"classpath:dev.properties", "classpath:dev-local.properties"},
            ignoreResourceNotFound = true)
    static class Development {
    }
}