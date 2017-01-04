package com.ss2h.bank.entity;

public class AccountStatus {

	public static final String ACTIVE = "active";
	public static final String DISABLED = "disabled";
	
	private Integer id;
	private String statusName;
	
	public AccountStatus() { }

	public AccountStatus(String statusName) {
		this.statusName = statusName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}
