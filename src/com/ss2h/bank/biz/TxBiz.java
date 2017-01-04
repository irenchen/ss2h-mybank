package com.ss2h.bank.biz;

import java.util.List;

import com.ss2h.bank.entity.Account;
import com.ss2h.bank.entity.TransactionLog;

public interface TxBiz {

	public Account getAccountById(int aid);
	
	public List<TransactionLog> getTxLogsByAccount(Account a);
	
	public void addTxLog(TransactionLog log);
	
	public void deposit(Integer aid, Double amount);

	public void withdraw(Integer aid, Double amount) throws Exception;
	
	public void transfer(Integer fromAid, Integer toAid, Double amount) throws Exception;
	
}
