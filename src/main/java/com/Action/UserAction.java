package com.Action;

import com.Entity.Authentication;
import com.Entity.Users;
import com.Entity.UsersInfo;
import com.Service.AuthenticateService;
import com.Service.UserInfoService;
import com.Service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liyan on 2017/4/9.
 */
public class UserAction extends BaseAction implements ServletResponseAware {

    private HttpServletResponse response = ServletActionContext.getResponse();

    private int flag = 0;
    private JSONObject returnJson = new JSONObject();

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private AuthenticateService authenticateService;
    private List<UserAction> list = new ArrayList<>();


    //登陆
    public void login() throws Exception {
        System.out.println("登陆");
        String userAccount, userPassword;
        try {
            JSONObject jsonObject = getJSONObjectFromJson();
            if (jsonObject == null) {
                userAccount = getStringFromPost("userAccount");
                userPassword = getStringFromPost("userPassword");
            } else {
                userAccount = jsonObject.getString("userAccount");
                userPassword = jsonObject.getString("userPassword");
            }
            if (checkString(userAccount, "userAccount") && checkString(userPassword, "userPassword")) {
                List<Users> userInfoList = this.userService.getByTagString(userAccount, "userAccount");
                if (userInfoList != null && userInfoList.size() > 0) {
                    System.out.println(userInfoList.get(0).getUserAccount());
                    if (userInfoList.get(0).getUserPassword().equals(userPassword)) {
                        UsersInfo userInfo = this.userInfoService.getByTagString(userAccount, "userAccount").get(0);
                        userInfo.setToken(String.valueOf(System.currentTimeMillis()));
                        this.userInfoService.update(userInfo);
                        returnJson.put("success", "登陆成功");
                        returnJson.put("data", userInfo);
                        flag = 1;
                    } else {
                        returnJson.put("errCode", WRONG_PASSWORD);
                        returnJson.put("cause", printErrCause(WRONG_PASSWORD));
                    }
                } else {
                    returnJson.put("errCode", NO_USER);
                    returnJson.put("cause", printErrCause(NO_USER));
                }
            } else {
                returnJson.put("errCode", NULL_PHONE_OR_NULL_PWD);
                returnJson.put("cause", printErrCause(NULL_PHONE_OR_NULL_PWD));
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnJson.put("errCode", 400);
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }

    //注册
    public void register() throws Exception {
        System.out.println("注册用户");
        String userAccount, userName, userPassword;
        try {
            JSONObject jsonObject = getJSONObjectFromJson();
            if (jsonObject == null) {
                userAccount = getStringFromPost("userAccount");
                userName = getStringFromPost("userName");
                userPassword = getStringFromPost("userPassword");
            } else {
                userAccount = jsonObject.getString("userAccount");
                userName = jsonObject.getString("userName");
                userPassword = jsonObject.getString("userPassword");
            }
            String phoneRegEx = "^1[3|4|5|7|8][0-9]\\d{8}$";
            Pattern pattern1 = Pattern.compile(phoneRegEx);
            Matcher phoneMatcher = pattern1.matcher(userAccount);
            String passwordRegEx = "^[a-zA-Z][\\w/^]{7,31}$";
            Pattern pattern2 = Pattern.compile(passwordRegEx);
            Matcher passwordMatcher = pattern2.matcher(userPassword);
            System.out.println("手机号匹配" + phoneMatcher.matches());
            System.out.println("密码匹配" + passwordMatcher.matches());
            if (phoneMatcher.matches() && passwordMatcher.matches()) {
                List<Users> checkUser = this.userService.getByTagString(userAccount, "userAccount");
                if (checkUser != null && checkUser.size() > 0) {
                    returnJson.put("errCode", USER_EXISTED);
                    returnJson.put("cause", printErrCause(USER_EXISTED));
                } else {
                    Users users = new Users();
                    users.setUserPassword(userPassword);
                    users.setUserAccount(userAccount);
                    UsersInfo usersInfo = new UsersInfo();
                    this.userService.save(users);
                    Users saveUser = this.userService.getByTagString(userAccount, "userAccount").get(0);

                    usersInfo.setUserRegisterTime(new Timestamp(System.currentTimeMillis()));
                    usersInfo.setUserName(userName);
                    usersInfo.setUserAccount(userAccount);
                    usersInfo.setToken(String.valueOf(System.currentTimeMillis()));
                    usersInfo.setUserId(saveUser.getUserId());
                    usersInfo.setRole(1);
                    this.userInfoService.save(usersInfo);
                    UsersInfo saveUserInfo = this.userInfoService.getByTagString(userAccount, "userAccount").get(0);

                    returnJson.put("users", saveUser);
                    returnJson.put("data", saveUserInfo);
                    returnJson.put("success", "注册成功");
                    flag = 1;
                }
            } else {
                returnJson.put("errCode", WRONG_FORMAT);
                returnJson.put("cause", printErrCause(WRONG_FORMAT));
            }

        } catch (Exception e) {
            e.printStackTrace();
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }

    //通过用户名搜索用户
    public void getByUserName() throws Exception {
        try {
            String userName = getStringFromGet("userName");
            List<UsersInfo> userInfos = this.userInfoService.getByTagString(userName, "userName");
            if (userInfos == null && userInfos.size() == 0) {
                returnJson.put("errCode", NO_USER);
                returnJson.put("cause", printErrCause(NO_USER));
            } else {
                flag = 1;
                returnJson.put("obj", userInfos.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }

    //通过用户账户搜索用户
    public void getByUserAccount() throws Exception {
        try {
            String userAccount = getStringFromGet("userAccount");
            List<UsersInfo> userInfos = this.userInfoService.getByTagString(userAccount, "userAccount");
            if (userInfos == null && userInfos.size() == 0) {
                returnJson.put("errCode", NO_USER);
                returnJson.put("cause", printErrCause(NO_USER));
            } else {
                returnJson.put("data", userInfos.get(0));
                flag = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }

    //获取用户信息
    public void getUserInfo() throws Exception {
        try {
            int userAccount = getIntFromGet("userId");
            UsersInfo usersInfo = userInfoService.getByTagId(userAccount, "userId").get(0);
            if (usersInfo != null) {
                returnJson.put("data", usersInfo);
                flag = 1;
            } else {
                returnJson.put("errCode", NO_USER);
                returnJson.put("cause", printErrCause(NO_USER));
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }

    //认证专家
    public void applyAuthenticate() throws Exception {
        try {
            int userId = getIntFromGet("userId");
            int typeId = getIntFromGet("typeId");
            List<UsersInfo> usersInfo = userInfoService.getByTagId(userId, "userId");
            if (usersInfo != null && usersInfo.size() != 0) {
                usersInfo.get(0).setRole(1);
                this.userInfoService.update(usersInfo.get(0));

                Authentication auEntity = new Authentication();
                auEntity.setTypeId(typeId);
                auEntity.setUserId(userId);
                auEntity.setAuthenticateTime(new Timestamp(System.currentTimeMillis()));
                authenticateService.save(auEntity);

                returnJson.put("data", usersInfo);
                flag = 1;
            } else {
                returnJson.put("errCode", NO_USER);
                returnJson.put("cause", printErrCause(NO_USER));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
