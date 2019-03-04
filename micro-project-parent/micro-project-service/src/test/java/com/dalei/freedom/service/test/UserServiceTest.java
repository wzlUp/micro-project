package com.dalei.freedom.service.test;

import com.dalei.freedom.commoninterface.UserService;
import com.dalei.freedom.model.UserInfoModel;
import com.dalei.freedom.service.message.MqProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @program: micro-project
 * @description:
 * @author: weizl
 * @create: 2019-03-01 10:50
 **/
@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private MqProvider mqProvider;

    private static Logger logger = LogManager.getLogger(UserServiceTest.class);

    @Test
    public void timeTest() {
        String nowTime = userService.getNowDateTime();
        System.out.println(nowTime);
    }

    @Test
    public void userTest() {
        String phone = "13888888888";
        UserInfoModel model = userService.findUserByPhone(phone);
        System.out.println(model.getNikename());
        System.out.println(model.getPassword());
        System.out.println(model.getPhone());
    }

    @Test
    public void testLog() {
        logger.info("测试info日志");
        logger.error("测试error日志");
        logger.debug("测试debug日志");
        logger.warn("测试warn日志");
    }

    @Test
    public void rabbitmqTest() {
        UserInfoModel user = new UserInfoModel();
        user.setUserid(2);
        user.setUsername("weizl");
        try {
            mqProvider.send(user);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
