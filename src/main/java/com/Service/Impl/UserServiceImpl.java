package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.Users;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<Users> implements UserService {
	@Autowired 
	private BaseDaoI<Users> dao;
	private List<Users> list = new ArrayList<Users>();
	@Override
	public List<Users> getUserByUserName(String userName) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        
        String hql = "from Users t where t.userName =:userName";
        list = this.dao.find(hql, params);
		return list;
	}
	

}
