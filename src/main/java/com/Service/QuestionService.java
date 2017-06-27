package com.Service;

import com.Entity.Question;

import java.util.List;

/**
 * Created by liyan on 2017/4/16.
 */
public interface QuestionService extends BaseServiceI<Question>{
    List<Question> getQuestionOrderByTime();
    List<Question> getQuestionByKey(String key);
}
