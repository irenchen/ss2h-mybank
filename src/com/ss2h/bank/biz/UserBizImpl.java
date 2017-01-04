package com.ss2h.bank.biz;

import java.util.List;

import com.ss2h.bank.dao.UserDAO;
import com.ss2h.bank.entity.User;

public class UserBizImpl implements UserBiz {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	public User getUserByUsername(String name) {
		return userDAO.getUserByUsername(name);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();		
	}

	@Override
	public User getUserById(Integer id) {
		return userDAO.getUserById(id);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);		
	}

}
