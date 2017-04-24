package com.Service;

import com.Entity.Answer;

import java.util.List;

/**
 * Created by liyan on 2017/4/16.
 */
public interface AnswerService extends BaseServiceI<Answer> {
    Long getAnswerCount(int userId);
    List<Answer> getByUserAndQuestion(int userId,int questionId);
}
