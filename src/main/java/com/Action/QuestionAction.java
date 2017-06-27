package com.Action;

import com.Entity.*;
import com.Service.AnswerService;
import com.Service.InterestService;
import com.Service.QuestionService;
import com.Service.UserInfoService;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by liyan on 2017/4/16.
 */
public class QuestionAction extends BaseAction implements ServletResponseAware {
    private HttpServletResponse response = ServletActionContext.getResponse();

    private int flag = 0;
    private JSONObject returnJson = new JSONObject();

    @Autowired
    QuestionService questionService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    AnswerService answerService;
    @Autowired
    private InterestService interestService;

    //提问问题
    public void askQuestion() throws Exception {
        int userId;
        int questionTypeId;
        String questionContent;
        // String questionTitle;
        int questionReward;
        try {
            JSONObject jsonObject = getJSONObjectFromJson();
            if (jsonObject == null) {
                userId = getIntFromPost("userId");
                questionTypeId = getIntFromPost("questionTypeId");
                questionContent = getStringFromPost("questionContent");
                // questionTitle = getStringFromPost("questionTitle");
                questionReward = getIntFromPost("questionReward");
            } else {
                userId = jsonObject.getInteger("userId");
                questionTypeId = jsonObject.getInteger("questionTypeId");
                questionContent = jsonObject.getString("questionContent");
                //questionTitle = jsonObject.getString("questionTitle");
                questionReward = jsonObject.getInteger("questionReward");
            }
            List<UsersInfo> usersInfo = userInfoService.getByTagId(userId, "userId");
            if (usersInfo.size() == 0 || usersInfo.equals(null)) {
                returnJson.put("errCode", NO_USER);
                returnJson.put("cause", printErrCause(NO_USER));
            } else {
                Question question = new Question();
                question.setUserId(userId);
                question.setQuestionTypeId(questionTypeId);
                question.setQuestionContent(questionContent);
                //question.setQuestionTitle(questionTitle);
                question.setQuestionReward(questionReward);
                question.setQuestionTime(new Timestamp(System.currentTimeMillis()));
                question.setQuestionIsAnswer(0);
                this.questionService.save(question);
                flag = 1;
            }
        } catch (Exception e) {
            returnJson.put("errCode", SERVICE_ERR_INSIDE);
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }

    //获取最新问题列表
    public void getLastQuestions() throws Exception {
        try {
            List<Question> questions = questionService.getQuestionOrderByTime();
            List<QuestionUser> questionUserList = new ArrayList<>();

            for (Question q : questions) {
                QuestionUser questionUser = new QuestionUser();
                questionUser.setUserId(q.getUserId());
                questionUser.setQuestionContent(q.getQuestionContent());
                questionUser.setQuestionIsAnswer(q.getQuestionIsAnswer());
                questionUser.setQuestionTitle(q.getQuestionTitle());
                questionUser.setQuestionId(q.getQuestionId());
                questionUser.setQuestionReward(q.getQuestionReward());
                questionUser.setQuestionTime(q.getQuestionTime());

                UsersInfo u = userInfoService.getByTagId(q.getUserId(), "userId").get(0);
                questionUser.setUserImg(u.getUserImg());
                questionUser.setUserName(u.getUserName());
                questionUser.setRole(u.getRole());
                questionUserList.add(questionUser);
            }
            returnJson.put("data", questionUserList);
            flag = 1;
        } catch (Exception e) {
            returnJson.put("errCode", SERVICE_ERR_INSIDE);
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }

    //查看问题详情
    public void getQuestionDetail() throws Exception {
        try {
            int questionId = getIntFromGet("questionId");
            Question q = questionService.getById(questionId);
            if (q == null || q.equals("")) {
                returnJson.put("errCode", NO_QUESTION);
                returnJson.put("cause", printErrCause(NO_QUESTION));
            } else {
                QuestionUser questionUser = new QuestionUser();

                questionUser.setUserId(q.getUserId());
                questionUser.setQuestionContent(q.getQuestionContent());
                questionUser.setQuestionIsAnswer(q.getQuestionIsAnswer());
                questionUser.setQuestionTitle(q.getQuestionTitle());
                questionUser.setQuestionId(q.getQuestionId());
                questionUser.setQuestionReward(q.getQuestionReward());
                questionUser.setQuestionTime(q.getQuestionTime());

                UsersInfo u = userInfoService.getByTagId(q.getUserId(), "userId").get(0);
                questionUser.setUserImg(u.getUserImg());
                questionUser.setUserName(u.getUserName());
                questionUser.setRole(u.getRole());

                returnJson.put("question", q);
                returnJson.put("usersInfo", questionUser);
                flag = 1;

            }
        } catch (Exception e) {
            returnJson.put("errCode", SERVICE_ERR_INSIDE);
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }


    public void recommend() throws Exception {
        try {
            int userId = getIntFromGet("userId");
            List<Interest> interestList = this.interestService.getByNU(userId);
            if (interestList != null && !interestList.isEmpty()) {
                //过滤问题
                Set<Integer> set = new TreeSet<>();
                for (Interest interest : interestList) {
                    set.add(interest.getQuestionId());
                }
                List<QuestionUser> questionUserList = new ArrayList<>();
                for (Integer i : set) {
                    Question q = questionService.getByTagId(i, "questionId").get(0);

                    QuestionUser questionUser = new QuestionUser();
                    questionUser.setUserId(q.getUserId());
                    questionUser.setQuestionContent(q.getQuestionContent());
                    questionUser.setQuestionIsAnswer(q.getQuestionIsAnswer());
                    questionUser.setQuestionTitle(q.getQuestionTitle());
                    questionUser.setQuestionId(q.getQuestionId());
                    questionUser.setQuestionReward(q.getQuestionReward());
                    questionUser.setQuestionTime(q.getQuestionTime());

                    UsersInfo u = userInfoService.getByTagId(q.getUserId(), "userId").get(0);
                    questionUser.setUserImg(u.getUserImg());
                    questionUser.setUserName(u.getUserName());
                    questionUser.setRole(u.getRole());
                    questionUserList.add(questionUser);
                }
                returnJson.put("data", questionUserList);
                flag = 1;
            } else {
                returnJson.put("errCode", NO_RECOMMEND);
                returnJson.put("cause", printErrCause(NO_RECOMMEND));
            }
        } catch (Exception e) {
            returnJson.put("errCode", SERVICE_ERR_INSIDE);
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }


    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
