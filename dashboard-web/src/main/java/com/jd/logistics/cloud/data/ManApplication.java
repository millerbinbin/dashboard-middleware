package com.jd.logistics.cloud.data;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


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