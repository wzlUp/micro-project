package com.dalei.freedom.web.test;


import com.dalei.freedom.model.UserInfoModel;
import com.dalei.freedom.web.controller.UserController;
import com.dalei.freedom.web.message.MqProvider;
import com.rabbitmq.client.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @program: micro-project
 * @description:
 * @author: weizl
 * @create: 2019-03-01 14:40
 **/
@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class UserControllerTest {

    /*
     * 该web模块的单元测试需要依赖service模块，所以单元测试时，要先把service模块进行启动，否则会报错
     */

    @Autowired
    private UserController userController;
    @Autowired
    private MqProvider mqProvider;

    @Test
    public void test1() {
        System.out.println("weizl up ");
    }

    @Test
    public void test2() {
        String result = userController.getUserInfo();
        System.out.println(result);
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
