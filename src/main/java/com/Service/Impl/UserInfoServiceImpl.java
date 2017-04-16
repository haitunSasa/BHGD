package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.UsersEntity;
import com.Entity.UsersInfoEntity;
import com.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 2017/4/16.
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl<UsersInfoEntity> implements UserInfoService{
    @Autowired
    private BaseDaoI<UsersEntity> dao;

}
