package com.ss2h.bank.dwr;

import java.util.List;

import com.ss2h.bank.bean.UserData;
import com.ss2h.bank.biz.AccountStatusBiz;
import com.ss2h.bank.biz.AdminBiz;
import com.ss2h.bank.biz.UserBiz;
import com.ss2h.bank.entity.Account;
import com.ss2h.bank.entity.User;

public class AdminDWR {

	private AdminBiz adminBiz;
	private UserBiz userBiz;
	private AccountStatusBiz accountStatusBiz;
	
	public AdminDWR() {}
	
	public AdminBiz getAdminBiz() {
		return adminBiz;
	}

	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public AccountStatusBiz getAccountStatusBiz() {
		return accountStatusBiz;
	}

	public void setAccountStatusBiz(AccountStatusBiz accountStatusBiz) {
		this.accountStatusBiz = accountStatusBiz;
	}

	public List<User> listAllUsers() {

		List<User> users = userBiz.getAllUsers();
		// TxLogs 預設是lazy fetch
		// 將TxLogs設為null之後再輸出到client端
		for(User user : users) {
			for(Account a : user.getAccounts()) {
				a.setTxLogs(null);
			}
		}
		return users;
	}
	
	public User updateUser(UserData ud) {
		
		System.out.println(ud);
		
		User u = userBiz.getUserById(ud.getId());
		// 逐一更新User data
		u.setUsername(ud.getUsername());
		u.setPassword(ud.getPassword());
		u.setRealname(ud.getRealname());
		u.setPhone(ud.getPhone());
		u.setPid(ud.getPid());
		if(ud.getAccountStatus() == 1) {
			u.getAccounts().get(0).setStatus(accountStatusBiz.getAccountStatusById(1));
		} else {
			u.getAccounts().get(0).setStatus(accountStatusBiz.getAccountStatusById(2));
		}
		
		try {
			userBiz.updateUser(u);
			u = userBiz.getUserById(ud.getId());
			// 先將txLogs設為null再回傳
			for(Account a : u.getAccounts()) {
				a.setTxLogs(null);
			}
			System.out.println("status : " + u.getAccounts().get(0).getBalance());
			
		} catch(Exception e) {
			return null;
		}
		
		

		return u;
	}
}
