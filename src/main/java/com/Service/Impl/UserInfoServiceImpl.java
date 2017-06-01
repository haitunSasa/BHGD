package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.UsersInfo;
import com.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liyan on 2017/4/16.
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl<UsersInfo> implements UserInfoService{
    @Autowired
    private BaseDaoI<UsersInfo> dao;
    private List<UsersInfo> usersInfoList = new ArrayList<>();

    @Override
    public List<UsersInfo> getUserInfo(int userId, String token) {
        Map<String,Object> params=new HashMap<>();
        params.put("userId",userId);
        params.put("token",token);
        String sql="from UsersInfo t where t.userId:=userId and token:=token";
        usersInfoList=dao.find(sql,params);
        return usersInfoList;
    }

    @Override
    public List<UsersInfo> findUserByKey(String key) {
        String sql="select t from UsersInfo t where t.userName like '%"+key+"%')";
        usersInfoList = this.dao.find(sql);
        return usersInfoList;
    }
}
