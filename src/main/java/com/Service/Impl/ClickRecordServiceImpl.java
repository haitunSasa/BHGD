package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.ClickRecord;
import com.Service.ClickRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liyan on 2017/6/7.
 */
@Service
public class ClickRecordServiceImpl extends BaseServiceImpl<ClickRecord> implements ClickRecordService{

    @Autowired
    private BaseDaoI<ClickRecord> dao;
    private List<ClickRecord> list = new ArrayList<>();
    @Override
    public List<ClickRecord> check(int userId, int questionId) {
        Map<String,Object> params=new HashMap<>();
        params.put("userId",userId);
        params.put("questionId",questionId);
        String sql="from ClickRecord t where t.userId =:userId and t.questionId =:questionId";
        list=dao.find(sql,params);
        return list;
    }
}
