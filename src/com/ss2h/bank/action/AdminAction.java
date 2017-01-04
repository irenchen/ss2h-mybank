package com.ss2h.bank.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ss2h.bank.biz.AccountStatusBiz;
import com.ss2h.bank.biz.AdminBiz;
import com.ss2h.bank.biz.UserBiz;
import com.ss2h.bank.entity.Account;
import com.ss2h.bank.entity.AccountStatus;
import com.ss2h.bank.entity.Admin;
import com.ss2h.bank.entity.User;

public class AdminAction extends ActionSupport implements RequestAware, SessionAware{

	private static final long serialVersionUID = 1L;

	private Map<String, Object> request;
	private Map<String, Object> session;
	private User user;
	private Account account;
	private int accountStatus;
	
	private AdminBiz adminBiz;
	private UserBiz userBiz;
	private AccountStatusBiz accountStatusBiz;
	
	private String old_password;
	private String new_password;

	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	public AccountStatusBiz getAccountStatusBiz() {
		return accountStatusBiz;
	}

	public void setAccountStatusBiz(AccountStatusBiz accountStatusBiz) {
		this.accountStatusBiz = accountStatusBiz;
	}

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}

	public void init() {
		if(adminBiz.getAdminByName("allen") == null) {
			Admin a = new Admin("allen", "123");
			adminBiz.addAdmin(a);
			AccountStatus as1 = new AccountStatus("active");
			AccountStatus as2 = new AccountStatus("disabled");
			accountStatusBiz.addAccountStatus(as1);
			accountStatusBiz.addAccountStatus(as2);
		}		
	}
	
	Admin admin = null;
	public void validateLogin() {
		
		admin = adminBiz.getAdminByName(user.getUsername());
		if(admin == null) {
			this.addFieldError("username", "incorrect username");
			return;
		} else {
			if(!user.getPassword().equals(admin.getPassword()))
				this.addFieldError("password", "incorrect password");
		}		
	}
	
	public String login() {
		System.out.println("inside admin login action...");
		session.put("admin", user.getUsername());
		return SUCCESS;
	}
	
	public String logout() {
		System.out.println("inside admin logout action...");
		session.remove("admin");
		return LOGIN;
	}

	public void validateAddUser() {
		User u = userBiz.getUserByUsername(user.getUsername());
		if(u != null) {
			this.addFieldError("username", "username already exists...choose another name");
		}
	}
	
	public String addUser() {
		System.out.println("accountStatus : " + accountStatus);
		System.out.println("user : " + user);
		if(accountStatus == 1) {
			account.setStatus(accountStatusBiz.getAccountStatusById(1));
		} else {
			account.setStatus(accountStatusBiz.getAccountStatusById(2));
		}
		account.setOwner(user);
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account);
		user.setAccounts(accounts);
		// 將新的User與Account寫入資料庫中
		userBiz.addUser(user);
		
		request.put("message", "User : " + user.getUsername() + " is successfully added...");
		return SUCCESS;
	}
	
	public String listAllUsers() {
		System.out.println("list all users...");
		List<User> users = userBiz.getAllUsers();
		
		request.put("users", users);
		
		return SUCCESS;
	}
	
	public void validateModifyPassword() {
		admin = adminBiz.getAdminByName(session.get("admin").toString());
		System.out.println("old password : " + old_password);
		System.out.println("new password : " + new_password);
		if(!admin.getPassword().equals(old_password)) {
			this.addFieldError("password", "incorrect password...");
		}		
	}
	
	public String modifyPassword() {
		try {
			admin.setPassword(new_password);
			adminBiz.updateAdmin(admin);
		} catch(Exception e) {
			e.printStackTrace();
			request.put("message", "Admin password update fails...");
			return SUCCESS;
		}
		request.put("message", "Admin : " + admin.getUsername() + " password updated...");
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;		
	}
	
	
}

