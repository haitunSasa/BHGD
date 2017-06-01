package com.Service;

import com.Entity.UsersInfo;

import java.util.List;

/**
 * Created by liyan on 2017/4/16.
 */
public interface UserInfoService extends BaseServiceI<UsersInfo>{
    List<UsersInfo> getUserInfo(int userId, String token);
    List<UsersInfo> findUserByKey(String key);

}
