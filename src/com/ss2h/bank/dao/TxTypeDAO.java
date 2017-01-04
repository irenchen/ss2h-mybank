package com.ss2h.bank.dao;

import com.ss2h.bank.entity.TransactionType;

public interface TxTypeDAO {

	public TransactionType getTxTypeByName(String name);
	
}
