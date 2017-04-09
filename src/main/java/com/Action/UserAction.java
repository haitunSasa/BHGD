package com.Action;

import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by liyan on 2017/4/9.
 */
public class UserAction extends BaseAction implements ServletResponseAware {
    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {

    }
}
