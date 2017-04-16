package com.Action;

import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liyan on 2017/4/16.
 */
public class QuestionAction extends BaseAction implements ServletResponseAware{
    private HttpServletResponse response = ServletActionContext.getResponse();

    private int flag = 0;
    private JSONObject returnJson = new JSONObject();

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response=response;
    }
}
