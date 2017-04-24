package com.Action;

import com.Entity.Answer;
import com.Entity.Question;
import com.Entity.Users;
import com.Service.AnswerService;
import com.Service.QuestionService;
import com.Service.UserService;
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
public class AnswerAction extends BaseAction implements ServletResponseAware {
    private HttpServletResponse response = ServletActionContext.getResponse();

    private int flag = 0;
    private JSONObject returnJson = new JSONObject();
    @Autowired
    AnswerService answerService;
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;
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
                answerList.get(0).setAnswerContent(answerContent);
                answerService.update(answerList.get(0));
                flag=1;
                returnJson.put("Mode","update");
            }else {
                Answer answer=new Answer();
                answer.setAnswerContent(answerContent);
                answer.setUserId(userId);
                answer.setQuestionId(questionId);
                answer.setAnswerTime(new Timestamp(System.currentTimeMillis()));
                answerService.save(answer);
                flag=1;
                returnJson.put("Mode","save");
            }
        }catch (Exception e){
            returnJson.put("errCode",SERVICE_ERR_INSIDE);
            returnJson.put("cause",e.toString());
        }finally {
            returnJson.put("flag",flag);
            writeJson(returnJson);
        }
    }


    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
