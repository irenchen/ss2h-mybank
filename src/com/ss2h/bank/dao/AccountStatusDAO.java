package com.ss2h.bank.dao;

import com.ss2h.bank.entity.AccountStatus;

public interface AccountStatusDAO {

	public AccountStatus getAccountStatusById(Integer id);
	
	public void addAccountStatus(AccountStatus as);
	
}
