package com.dalei.freedom.service.message;

import com.dalei.freedom.model.UserInfoModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @Author weizl
 * @Description 用户相关的消息队列操作
 * @Date 23:16 2019/3/4
 * @Param
 **/
@Component
public class UserMessageQueue {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEmail(UserInfoModel userInfoModel) throws Exception {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(System.currentTimeMillis()+"$"+userInfoModel.getUserid());
        rabbitTemplate.convertAndSend(
                "user-exchange",//消息队列
                "user.abc", //匹配规则key
                userInfoModel,
                correlationData
        );
    }
}
