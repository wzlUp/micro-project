package com.dalei.freedom.service.impl;

import com.dalei.freedom.common.base.utils.DateToolUtil;
import com.dalei.freedom.commoninterface.UserService;
import com.dalei.freedom.model.UserInfoModel;
import com.dalei.freedom.service.mapper.UserServiceImplMapper;
import com.dalei.freedom.service.message.UserMessageQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: micro-project
 * @description: 用户接口类的实现类
 * @author: weizl
 * @create: 2019-02-28 15:45
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserServiceImplMapper userServiceImplMapper;
    @Autowired
    private UserMessageQueue userMessageQueue;

    @Override
    public UserInfoModel findUserByPhone(String phone) {
        UserInfoModel result = userServiceImplMapper.findUserByPhone(phone);
        System.out.println("UserServiceImpl findUserByPhone");
        try {
            userMessageQueue.sendEmail(result);
            System.out.println("使用消息队列进行发送邮件");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getNowDateTime() {
        String nowDate = DateToolUtil.getNowDate();
        System.out.println("当前时间：" + nowDate);
        return nowDate;
    }
}
