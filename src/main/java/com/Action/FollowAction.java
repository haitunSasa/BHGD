package com.Action;

import com.Entity.Follow;
import com.Entity.UsersInfo;
import com.Service.FollowService;
import com.Service.UserInfoService;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by liyan on 2017/4/16.
 */
public class FollowAction extends BaseAction implements ServletResponseAware{
    private HttpServletResponse response = ServletActionContext.getResponse();

    private int flag = 0;
    private JSONObject returnJson = new JSONObject();

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private FollowService followService;


    public void followOrNot() throws Exception{
        try{
            int userId = getIntFromGet("userId");
            int followId=getIntFromGet("followId");
            List<UsersInfo> usersInfoList=this.userInfoService.getByTagId(userId,"userId");
            List<UsersInfo> followInfoList=this.userInfoService.getByTagId(followId,"userId");
            List<Follow> followList=this.followService.findByUIdAndFId(userId,followId);
            if (usersInfoList == null && usersInfoList.size() == 0
                    &&followInfoList == null && followInfoList.size() == 0) {
                returnJson.put("errCode", NO_USER);
                returnJson.put("cause", printErrCause(NO_USER));
            }else if (followList == null && followList.size() == 0){
                Follow follow = new Follow();
                follow.setToUserId(followId);
                follow.setFromUserId(userId);
                followService.save(follow);
                flag=1;
            }else {
                followService.delete(followList.get(0));
                flag=2;
            }
        }catch (Exception e){
            returnJson.put("errCode", SERVICE_ERR_INSIDE);
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }

    public void getFollowList() throws Exception{
        try{
            int userId=getIntFromGet("userId");
            List<UsersInfo> usersInfoList=this.userInfoService.getByTagId(userId,"userId");
            List<Follow> followList=this.followService.getByTagId(userId,"userId");

            if (usersInfoList == null && usersInfoList.size() == 0) {
                returnJson.put("errCode", NO_USER);
                returnJson.put("cause", printErrCause(NO_USER));
            }else if (followList == null && followList.size() == 0){

            }
        }catch (Exception e){
            returnJson.put("errCode", SERVICE_ERR_INSIDE);
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }

    public void getFans() throws Exception{
        try{
            int userId=getIntFromGet("userId");
            List<UsersInfo> usersInfoList=this.userInfoService.getByTagId(userId,"userId");
            List<Follow> followList=this.followService.getByTagId(userId,"followId");

            if (usersInfoList == null && usersInfoList.size() == 0) {
                returnJson.put("errCode", NO_USER);
                returnJson.put("cause", printErrCause(NO_USER));
            }else if (followList == null && followList.size() == 0){

            }
        }catch (Exception e){
            returnJson.put("errCode", SERVICE_ERR_INSIDE);
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }
    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response=response;
    }
}
