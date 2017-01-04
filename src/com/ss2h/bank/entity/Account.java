package com.ss2h.bank.entity;

import java.util.Set;

public class Account {

	private Integer id;
	private Double balance;
	private User owner;
	private Set<TransactionLog> txLogs;
	private AccountStatus status;
	private Integer version;
	
	public Account() { }

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<TransactionLog> getTxLogs() {
		return txLogs;
	}

	public void setTxLogs(Set<TransactionLog> txLogs) {
		this.txLogs = txLogs;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
}
