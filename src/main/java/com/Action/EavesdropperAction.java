package com.Action;

import com.Entity.*;
import com.Service.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by liyan on 2017/4/16.
 */
public class EavesdropperAction extends BaseAction implements ServletResponseAware {
    private HttpServletResponse response = ServletActionContext.getResponse();

    private int flag = 0;
    private JSONObject returnJson = new JSONObject();
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;
    @Autowired
    EavesdropperService eavesdropperService;

    public void eavesdropper()throws Exception{
        int userId,questionId,answerId;
        try {
            JSONObject jsonObject = getJSONObjectFromJson();
            if (jsonObject == null) {
                userId = getIntFromPost("userId");
                questionId = getIntFromPost("questionId");
                answerId = getIntFromPost("answerId");
            } else {
                userId = jsonObject.getInteger("userId");
                questionId = jsonObject.getInteger("questionId");
                answerId = jsonObject.getInteger("answerId");
            }
            List<UsersInfo> u=userInfoService.getByTagId(userId,"userId");

            if(u==null&&u.size()==0) {
                returnJson.put("errCode", NO_USER);
                returnJson.put("cause", printErrCause(NO_USER));
                return;
            }
            Question question=questionService.getById(questionId);
            Answer a=answerService.getById(answerId);
            if(question==null&&a==null) {
                returnJson.put("errCode", QUES_ANS_DEL);
                returnJson.put("cause", printErrCause(QUES_ANS_DEL));
                return;
            }
            if(eavesdropperService.isAlreadyEavesdropper(userId,answerId)){
                returnJson.put("errCode", ALREADY_LISTENER);
                returnJson.put("cause", printErrCause(ALREADY_LISTENER));
                return;
            }
            EavesdropperAnswer eavesdropper= new EavesdropperAnswer();
            eavesdropper.setAnswerId(answerId);
            eavesdropper.setUserId(userId);
            eavesdropper.setEavesdroppingTime(new Timestamp(System.currentTimeMillis()));
            eavesdropper.setIsPaid((short)1);
            eavesdropperService.save(eavesdropper);

            AnswerUser answerUser=new AnswerUser();
            answerUser.setUserImg(u.get(0).getUserImg());
            answerUser.setUserName(u.get(0).getUserName());
            answerUser.setRole(u.get(0).getRole());
            answerUser.setAnswerId(a.getAnswerId());
            answerUser.setAnswerContent(a.getAnswerContent());
            answerUser.setAnswerTime(a.getAnswerTime());
            answerUser.setIsCouldListen(true);
            flag=1;
            returnJson.put("data",answerUser);
        }catch (Exception e){
            returnJson.put("errCode", SERVICE_ERR_INSIDE);
            returnJson.put("cause", e.toString());
        }finally {
            returnJson.put("flag",flag);
            writeJson(returnJson);
        }
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response=response;
    }

}
