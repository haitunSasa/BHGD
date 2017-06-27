package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.Follow;
import com.Service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liyan on 2017/4/16.
 */
@Service
public class FollowServiceImpl extends BaseServiceImpl<Follow> implements FollowService {
    @Autowired
    private BaseDaoI<Follow> dao;
    private List<Follow> followList = new ArrayList<>();

    @Override
    public List<Follow> findByUIdAndFId(int userId, int followId) {
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userId);
        params.put("followId",followId);
        String sql="select t from Follow t where t.fromUserId:=userId and t.toUserId:=followId";
        followList = this.dao.find(sql,params);
        return followList;
    }
}
