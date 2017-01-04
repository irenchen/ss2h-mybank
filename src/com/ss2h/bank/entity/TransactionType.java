package com.ss2h.bank.entity;

import java.util.Set;

public class TransactionType {

	public static final String DEPOSIT = "deposit";
	public static final String WITHDRAW = "withdraw";
	public static final String TRANSFER = "transfer";
	
	private Integer id;
	private String typeName;
	private Set<TransactionLog> transactionLogs;
	
	public TransactionType() { }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<TransactionLog> getTransactionLogs() {
		return transactionLogs;
	}

	public void setTransactionLogs(Set<TransactionLog> transactionLogs) {
		this.transactionLogs = transactionLogs;
	}
	
	
}
