package com.ss2h.bank.bean;

public class UserData {

	private Integer id;
	private String username;
	private String password;
	private String realname;
	private String pid;
	private String phone;
	private Integer accountStatus;
	
	public UserData() {}
	
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

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", username=" + username + ", password=" + password + ", realname=" + realname
				+ ", pid=" + pid + ", phone=" + phone + ", accountStatus=" + accountStatus + "]";
	}

	
	
}
