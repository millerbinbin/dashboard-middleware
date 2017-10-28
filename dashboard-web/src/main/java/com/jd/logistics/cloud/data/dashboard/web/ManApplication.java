package com.jd.logistics.cloud.data.dashboard.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/23 15:08
 */

@SpringBootApplication
//@ImportResource("classpath:META-INF/spring/*.xml")
public class ManApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ManApplication.class, args);
    }

}