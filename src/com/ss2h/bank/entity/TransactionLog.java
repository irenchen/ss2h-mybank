package com.ss2h.bank.entity;

import java.util.Date;

public class TransactionLog {

	private Integer id;
	private Date txDate;
	private Account fromAccount;
	private Account toAccount;
	private Double txAmount;
	private TransactionType txType;
	
	public TransactionLog() { }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	public Double getTxAmount() {
		return txAmount;
	}
	public void setTxAmount(Double txAmount) {
		this.txAmount = txAmount;
	}
	public TransactionType getTxType() {
		return txType;
	}
	public void setTxType(TransactionType txType) {
		this.txType = txType;
	}
	
	
}
