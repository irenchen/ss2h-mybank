package com.ss2h.bank.dao;

import java.util.List;

import com.ss2h.bank.entity.User;

public interface UserDAO {

	public void addUser(User user);
	
	public User getUserByUsername(String name);
	
	public List<User> getAllUsers();

	public User getUserById(Integer id);

	public void updateUser(User user);
	
}
