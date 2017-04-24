package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.Users;
import com.Entity.UsersInfo;
import com.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liyan on 2017/4/16.
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl<UsersInfo> implements UserInfoService{
    @Autowired
    private BaseDaoI<Users> dao;

}
