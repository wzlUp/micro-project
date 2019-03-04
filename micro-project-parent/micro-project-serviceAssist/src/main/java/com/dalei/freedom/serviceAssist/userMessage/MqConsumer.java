package com.dalei.freedom.serviceAssist.userMessage;

import com.dalei.freedom.model.UserInfoModel;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MqConsumer {
    // 【切记】此处需要在启动主函数处扫描userMessage包，否则不会对消息队列按注释进行初始化

    // 使用注解方式来设置监听哪个queue
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "user-queue",durable = "true"),
                    exchange = @Exchange(value = "user-exchange",type = "topic",durable = "true"),
                    key = "user.*"
            )
    )
    @RabbitHandler
    public void onUserMessage(@Payload UserInfoModel userInfoModel,
                              @Headers Map<String, Object> headers,
                              Channel channel) throws Exception {
        // 编写消费者代码
        System.out.println("------------ 收到消息，开始消费 --------------");
        System.out.println("userId："+ userInfoModel.getUserid());
        System.out.println("userName："+ userInfoModel.getUsername());

        // 手动告诉exchange消费完毕（因为使用的是手动模式）
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);//此处需要手动进行告知queue，否则不会允许下一个消息进入
        System.out.println("------------ 消费完成，已通知服务端 --------------");
    }
}
