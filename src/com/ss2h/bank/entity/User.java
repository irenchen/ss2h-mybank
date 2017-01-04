package com.ss2h.bank.entity;

import java.util.List;

public class User {

	private Integer id;
	private String username;
	private String password;
	private String realname;
	private String pid;
	private String phone;
	
	private List<Account> accounts;
	
	public User() { }
	
	public User(String username, String password, String realname, String pid, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.pid = pid;
		this.phone = phone;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", realname=" + realname
				+ ", pid=" + pid + ", phone=" + phone + ", accounts=" + accounts + "]";
	}
	
	
}
