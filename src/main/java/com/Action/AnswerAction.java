package com.Action;

import com.Entity.*;
import com.Service.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyan on 2017/4/16.
 */
public class AnswerAction extends BaseAction implements ServletResponseAware {
    private HttpServletResponse response = ServletActionContext.getResponse();

    private int flag = 0;
    private JSONObject returnJson = new JSONObject();
    @Autowired
    AnswerService answerService;
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    QuestionService questionService;
    @Autowired
    EavesdropperService eavesdropperAnswerService;
    public void getAnswerCount() throws Exception {
        try {
            int userId = getIntFromGet("userId");

            Long count = answerService.getAnswerCount(userId);
            returnJson.put("count", count);
            flag=1;
        } catch (Exception e) {
            e.printStackTrace();
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }

    //回答问题
    public void answerQuestion()throws Exception{
        int userId;
        int questionId;
        String answerContent;
        try {
            JSONObject jsonObject=getJSONObjectFromJson();
            if (jsonObject==null){
                userId=getIntFromPost("userId");
                questionId=getIntFromPost("questionId");
                answerContent=getStringFromPost("answerContent");
            }else {
                userId=jsonObject.getInteger("userId");
                questionId=jsonObject.getInteger("questionId");
                answerContent=jsonObject.getString("answerContent");
            }
            Users user=userService.getById(userId);
            Question question= questionService.getById(questionId);
            List<Answer> answerList= answerService.getByUserAndQuestion(userId,questionId);
            if (user==null||user.equals("")){
                returnJson.put("errCode",NO_USER);
                returnJson.put("cause",printErrCause(NO_USER));
            }else if (question==null||question.equals("")){
                returnJson.put("errCode",NO_QUESTION);
                returnJson.put("cause",printErrCause(NO_QUESTION));
            }else if (answerList.equals("")||answerList.size()==0){
                Answer answer=new Answer();
                answer.setAnswerContent(answerContent);
                answer.setUserId(userId);
                answer.setQuestionId(questionId);
                answer.setIsFree((short) 1);
                answer.setAnswerTime(new Timestamp(System.currentTimeMillis()));
                answerService.save(answer);
                flag=1;
                returnJson.put("Mode","save");
            }else {
                answerList.get(0).setAnswerContent(answerContent);
                answerService.update(answerList.get(0));
                flag=1;
                returnJson.put("Mode","update");
            }
        }catch (Exception e){
            returnJson.put("errCode",SERVICE_ERR_INSIDE);
            returnJson.put("cause",e.toString());
        }finally {
            returnJson.put("flag",flag);
            writeJson(returnJson);
        }
    }

    //获取问题的答案
    public void getAnswer() throws Exception {
        try {
            int questionId = getIntFromGet("questionId");
            //用户自己的Id
            int userId = getIntFromGet("userId");
            List<Answer> answerList = answerService.getByTagId(questionId, "questionId");
            List<AnswerUser> answerUserList = new ArrayList<>();

            if (answerList.isEmpty()) {
                returnJson.put("errCode", NO_ANSWER);
                returnJson.put("cause", printErrCause(NO_ANSWER));
            } else {
                for (Answer a : answerList) {
                    AnswerUser answerUser = new AnswerUser();
                    List<UsersInfo> usersInfo = userInfoService.getByTagId(a.getUserId(), "userId");
                    if (!usersInfo.isEmpty()) {
                        UsersInfo u=usersInfo.get(0);
                        answerUser.setUserImg(u.getUserImg());
                        answerUser.setUserName(u.getUserName());
                        answerUser.setRole(u.getRole());
                        if (a.getIsFree() == 1 || eavesdropperAnswerService.isAlreadyEavesdropper(userId, a.getAnswerId())) {
                            answerUser.setAnswerId(a.getAnswerId());
                            answerUser.setAnswerContent(a.getAnswerContent());
                            answerUser.setAnswerTime(a.getAnswerTime());
                            answerUser.setIsCouldListen(true);
                        } else {
                            answerUser.setAnswerId(a.getAnswerId());
                            answerUser.setAnswerTime(a.getAnswerTime());
                            answerUser.setIsCouldListen(false);
                        }
                        answerUserList.add(answerUser);
                    }else {
                        returnJson.put("errCode", NO_USER);
                        returnJson.put("cause", printErrCause(NO_USER));
                    }
                }
                returnJson.put("data", answerUserList);
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


    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
