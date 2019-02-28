package com.dalei.freedom.commoninterface;

import com.dalei.freedom.model.UserInfoModel;

/**
 * @program: micro-project
 * @description: 用户接口类
 * @author: weizl
 * @create: 2019-02-28 15:30
 **/
public interface UserService {

    /**
     * 根据手机号查询user
     * @param phone
     * @return
     */
    UserInfoModel findUserByPhone(String phone);
}
