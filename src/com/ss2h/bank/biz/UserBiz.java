package com.ss2h.bank.biz;

import java.util.List;

import com.ss2h.bank.entity.User;

public interface UserBiz {

	public void addUser(User user);
	
	public User getUserByUsername(String name);
	
	public User getUserById(Integer id);
	
	public List<User> getAllUsers();
	
	public void updateUser(User user);
	
}
