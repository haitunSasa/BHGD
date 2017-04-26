package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.EavesdropperAnswer;
import com.Service.EavesdropperAnswerService;
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
public class EavesdropperServiceImpl extends BaseServiceImpl<EavesdropperAnswer>implements EavesdropperAnswerService{
    @Autowired
    private BaseDaoI<EavesdropperAnswer> dao;
    private List<EavesdropperAnswer> list = new ArrayList<>();
    @Override
    public boolean isAlreadyEavesdropper(int userId, int answerId) {
        Map<String,Object> params=new HashMap<>();
        params.put("userId",userId);
        params.put("answerId",answerId);
        String sql="from EavesdropperAnswer t where t.userId =:userId and t.answerId =:answerId order by t.eavesdroppingTime";
        list=dao.find(sql,params);
        if(list.isEmpty()) {
            return false;
        }else {
            return true;
        }
    }
}
