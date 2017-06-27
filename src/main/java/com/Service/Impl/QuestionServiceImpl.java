package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.Question;
import com.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 2017/4/16.
 */
@Service
public class QuestionServiceImpl extends BaseServiceImpl<Question>implements QuestionService {
    @Autowired
    BaseDaoI<Question> dao;
    List<Question> questionList=new ArrayList<>();
    @Override
    public List<Question> getQuestionOrderByTime() {
        String sql="from Question t order by questionTime desc";
        questionList=dao.find(sql);
        return questionList;
    }

    @Override
    public List<Question> getQuestionByKey(String key) {
        String sql="select t from Question t where t.questionContent like '%"+key+"%')";
        questionList = this.dao.find(sql);
        return questionList;
    }
}
