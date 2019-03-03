package com.dalei.freedom.service;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: micro-project
 * @description: MicroProjectServiceApplication
 * @author: weizl
 * @create: 2019-02-28 15:19
 **/
@Slf4j
@SpringBootApplication
//扫描com.dalei.freedom.service.message来进行运行消息队列
@ComponentScan({"com.dalei.freedom.service.impl","com.dalei.freedom.service.message"})
@ImportResource(value = {"classpath:dubbo/providers.xml"})
@MapperScan({"com.dalei.freedom.service.mapper"})
public class MicroProjectServiceApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(MicroProjectServiceApplication.class);
        springApplication.run(args);
        System.out.println("========== MicroProjectServiceApplication 启动成功 ==========");
    }
}
