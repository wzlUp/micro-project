package com.dalei.freedom.service.test;

import com.dalei.freedom.commoninterface.UserService;
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
 * @create: 2019-03-01 10:50
 **/
@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void timeTest() {
        String nowTime = userService.getNowDateTime();
        System.out.println(nowTime);
    }

}
