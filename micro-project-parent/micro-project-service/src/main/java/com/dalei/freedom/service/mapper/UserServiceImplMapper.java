package com.dalei.freedom.service.mapper;

import com.dalei.freedom.model.UserInfoModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program: micro-project
 * @description: 用户接口实现类的mapper文件
 * @author: weizl
 * @create: 2019-02-28 15:46
 **/
@Mapper
public interface UserServiceImplMapper {

    @Select("SELECT * FROM tb_user WHERE PHONE = #{phone}")
    UserInfoModel findUserByPhone(@Param("phone") String phone);
}
