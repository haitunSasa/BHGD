package com.Service;

import com.Entity.Users;

import java.util.List;

public interface UserService extends BaseServiceI<Users> {
	public  List<Users>  getUserByUserName(String userName);
}
