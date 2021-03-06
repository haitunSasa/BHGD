package com.Entity;

import javax.persistence.*;
//import java.sql.Date;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by liyan on 2017/5/18.
 */
@Entity
@Table(name = "users_info", schema = "knowledge_sharing", catalog = "")
public class UsersInfo {
    private int userInfoId;
    private Integer userId;
    private String userAccount;
    private Short userSex;
    private Date userbirthday;
    private String userIntroduction;
    private Timestamp userRegisterTime;
    private String userImg;
    private String token;
    private Double userReward;
    private String userName;
    private Integer role;

    public void setUserbirthday(java.sql.Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    @Id
    @Column(name = "userInfoId")
    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userAccount")
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "userSex")
    public Short getUserSex() {
        return userSex;
    }

    public void setUserSex(Short userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "userbirthday")
    public Date getUserbirthday() {
        return userbirthday;
    }

    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    @Basic
    @Column(name = "userIntroduction")
    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    @Basic
    @Column(name = "userRegisterTime")
    public Timestamp getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Timestamp userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    @Basic
    @Column(name = "userImg")
    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "userReward")
    public Double getUserReward() {
        return userReward;
    }

    public void setUserReward(Double userReward) {
        this.userReward = userReward;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "Role")
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersInfo usersInfo = (UsersInfo) o;

        if (userInfoId != usersInfo.userInfoId) return false;
        if (userId != null ? !userId.equals(usersInfo.userId) : usersInfo.userId != null) return false;
        if (userAccount != null ? !userAccount.equals(usersInfo.userAccount) : usersInfo.userAccount != null)
            return false;
        if (userSex != null ? !userSex.equals(usersInfo.userSex) : usersInfo.userSex != null) return false;
        if (userbirthday != null ? !userbirthday.equals(usersInfo.userbirthday) : usersInfo.userbirthday != null)
            return false;
        if (userIntroduction != null ? !userIntroduction.equals(usersInfo.userIntroduction) : usersInfo.userIntroduction != null)
            return false;
        if (userRegisterTime != null ? !userRegisterTime.equals(usersInfo.userRegisterTime) : usersInfo.userRegisterTime != null)
            return false;
        if (userImg != null ? !userImg.equals(usersInfo.userImg) : usersInfo.userImg != null) return false;
        if (token != null ? !token.equals(usersInfo.token) : usersInfo.token != null) return false;
        if (userReward != null ? !userReward.equals(usersInfo.userReward) : usersInfo.userReward != null) return false;
        if (userName != null ? !userName.equals(usersInfo.userName) : usersInfo.userName != null) return false;
        if (role != null ? !role.equals(usersInfo.role) : usersInfo.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userInfoId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        result = 31 * result + (userbirthday != null ? userbirthday.hashCode() : 0);
        result = 31 * result + (userIntroduction != null ? userIntroduction.hashCode() : 0);
        result = 31 * result + (userRegisterTime != null ? userRegisterTime.hashCode() : 0);
        result = 31 * result + (userImg != null ? userImg.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (userReward != null ? userReward.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
