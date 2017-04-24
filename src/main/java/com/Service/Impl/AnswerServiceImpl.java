package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.Answer;
import com.Service.AnswerService;
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
public class AnswerServiceImpl extends BaseServiceImpl<Answer> implements AnswerService {
    @Autowired
    BaseDaoI<Answer> dao;
    private List<Answer> answerList = new ArrayList<>();

    public Long getAnswerCount(int userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        String hql = "select count(*) from Answer t where t.userId=:userId";
        return this.dao.count(hql,params);
    }

    @Override
    public List<Answer> getByUserAndQuestion(int userId, int questionId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("questionId", questionId);
        String hql = "from Answer t where t.userId=:userId and t.questionId=:questionId";
        answerList=dao.find(hql,params);
        return answerList;
    }
}
