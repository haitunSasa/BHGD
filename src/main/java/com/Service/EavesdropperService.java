package com.Service;

import com.Entity.EavesdropperAnswer;

import java.util.List;

/**
 * Created by liyan on 2017/4/16.
 */
public interface EavesdropperService extends BaseServiceI<EavesdropperAnswer> {
    boolean isAlreadyEavesdropper(int userId,int answerId);
    List<EavesdropperAnswer> eavesdropper(int userId, int answerId);
}
