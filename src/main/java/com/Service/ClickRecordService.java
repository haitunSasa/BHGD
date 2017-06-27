package com.Service;

import com.Entity.ClickRecord;

import java.util.List;

/**
 * Created by liyan on 2017/6/7.
 */
public interface ClickRecordService extends BaseServiceI<ClickRecord>{
    List<ClickRecord> check(int userId, int questionId);
}
