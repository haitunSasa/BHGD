package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.Follow;
import com.Entity.Interest;
import com.Service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liyan on 2017/6/27.
 */
@Service
public class InterestServiceImpl extends BaseServiceImpl<Interest> implements InterestService {
    @Autowired
    private BaseDaoI<Interest> dao;
    private List<Interest> interestList = new ArrayList<>();
    @Override
    public List<Interest> getByUIAndQI(int userId, int question) {
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userId);
        params.put("question",question);
        String sql="select t from Interest t where t.userId:=userId and t.questionId:=questionId";
        interestList = this.dao.find(sql,params);
        return interestList;
    }

    @Override
    public List<Interest> getByNU(int userId) {
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userId);

        String sql="select t from Interest t where t.userId !="+userId+" order by interestWeight desc";
        interestList = this.dao.find(sql);
        return interestList;
    }
}
