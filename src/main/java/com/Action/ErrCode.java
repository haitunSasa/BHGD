package com.Action;

/**
 * Created by liyan on 2017/4/16.
 */
public class ErrCode {
    protected static final int WRONG_PASSWORD = 0x01;
    protected static final int NO_USER = 0x02;
    protected static final int USER_EXISTED = 0x03;
    protected static final int NULL_PHONE_OR_NULL_PWD = 0x04;
    protected static final int WRONG_FORMAT = 0x05;
    protected static final int NO_QUESTION = 0x06;
    protected static final int NULL_PARAMS = 0x55;
    protected static final int SERVICE_ERR_INSIDE = 500;


    protected String printErrCause(int errCode) {
        String cause ;
        switch (errCode) {
            case WRONG_PASSWORD:
                cause = "用户密码错误";
                break;
            case NO_USER:
                cause = "用户不存在";
                break;
            case USER_EXISTED:
                cause = "该手机号已被注册";
                break;
            case NULL_PHONE_OR_NULL_PWD:
                cause = "手机号或密码不能为空";
                break;
            case WRONG_FORMAT:
                cause = "手机号或密码格式不正确";
                break;
            case NO_QUESTION:
                cause = "无此问题或此问题已删";
                break;
            case NULL_PARAMS:
                cause = "参数为空";
                break;

            case SERVICE_ERR_INSIDE:
                cause = "服务器内部错误";
                break;

            default:
                cause = "未知错误";
                break;
        }
        return cause;
    }

}
