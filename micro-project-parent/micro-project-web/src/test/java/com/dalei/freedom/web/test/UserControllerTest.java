package com.dalei.freedom.web.test;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Test
    public void test1() {
        System.out.println("weizl up ");
    }
}
