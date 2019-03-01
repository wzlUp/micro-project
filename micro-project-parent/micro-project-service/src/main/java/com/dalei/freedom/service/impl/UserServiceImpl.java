package com.dalei.freedom.service.impl;

import com.dalei.freedom.common.base.utils.DateToolUtil;
import com.dalei.freedom.commoninterface.UserService;
import com.dalei.freedom.model.UserInfoModel;
import com.dalei.freedom.service.mapper.UserServiceImplMapper;
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

    @Override
    public UserInfoModel findUserByPhone(String phone) {
        UserInfoModel result = userServiceImplMapper.findUserByPhone(phone);
        System.out.println("UserServiceImpl findUserByPhone");
        return result;
    }

    @Override
    public String getNowDateTime() {
        String nowDate = DateToolUtil.getNowDate();
        System.out.println("当前时间：" + nowDate);
        System.out.println("当前时间：" + nowDate);
        return nowDate;
    }
}
