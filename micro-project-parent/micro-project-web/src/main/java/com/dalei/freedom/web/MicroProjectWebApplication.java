package com.dalei.freedom.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@Slf4j
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,})
@ImportResource(value = {"classpath:dubbo/consumers.xml"})
public class MicroProjectWebApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(MicroProjectWebApplication.class);
        springApplication.run(args);
        System.out.println("========== MicroProjectWebApplication 启动成功 ==========");
    }
}