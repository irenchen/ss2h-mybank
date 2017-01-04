package com.ss2h.bank.dao;

import java.util.List;

import com.ss2h.bank.entity.Account;
import com.ss2h.bank.entity.TransactionLog;

public interface TxDAO {

	public Account getAccountById(int aid);
	
	public List<TransactionLog> getTxLogsByAccount(Account a);
	
	public void addTxLog(TransactionLog log);

	public void updateAccount(Account account);
	
}
