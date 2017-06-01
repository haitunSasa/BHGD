package com.Entity;

import java.sql.Timestamp;

/**
 * Created by liyan on 2017/4/25.
 */
public class AnswerUser {
    private int answerId;
    private String answerContent;
    private Integer questionId;
    private Integer userId;
    private Timestamp answerTime;

    private String userImg;
    private String userName;
    private Integer role;

    private boolean isCouldListen;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Timestamp answerTime) {
        this.answerTime = answerTime;
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

    public boolean isCouldListen() {
        return isCouldListen;
    }

    public void setIsCouldListen(boolean isCouldListen) {
        this.isCouldListen = isCouldListen;
    }
}
