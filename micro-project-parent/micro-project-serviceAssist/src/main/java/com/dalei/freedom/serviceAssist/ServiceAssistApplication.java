package com.dalei.freedom.serviceAssist;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@Slf4j
@SpringBootApplication
//扫描com.dalei.freedom.service.message来进行运行消息队列
@ComponentScan({"com.dalei.freedom.serviceAssist.userMessage"})
//@ImportResource(value = {"classpath:dubbo/providers.xml"})
//@MapperScan({"com.dalei.freedom.service.mapper"})
public class ServiceAssistApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ServiceAssistApplication.class);
        springApplication.run(args);
        System.out.println("========== ServiceAssistApplication 启动成功 ==========");
    }
}
