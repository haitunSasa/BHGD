package com.Entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by liyan on 2017/4/24.
 */
public class QuestionUser {
    private int questionId;

    private Integer userId;
    private String userImg;
    private String userName;
    private Integer role;

    private String questionTitle;
    private String questionContent;
    private Integer questionTypeId;
    private Integer questionReward;
    private Integer questionIsAnswer;
    private Timestamp questionTime;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public Integer getQuestionReward() {
        return questionReward;
    }

    public void setQuestionReward(Integer questionReward) {
        this.questionReward = questionReward;
    }

    public Integer getQuestionIsAnswer() {
        return questionIsAnswer;
    }

    public void setQuestionIsAnswer(Integer questionIsAnswer) {
        this.questionIsAnswer = questionIsAnswer;
    }

    public Timestamp getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Timestamp questionTime) {
        this.questionTime = questionTime;
    }
}
