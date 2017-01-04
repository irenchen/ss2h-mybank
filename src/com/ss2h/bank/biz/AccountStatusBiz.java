package com.ss2h.bank.biz;

import com.ss2h.bank.entity.AccountStatus;

public interface AccountStatusBiz {

	public AccountStatus getAccountStatusById(Integer id);
	
	public void addAccountStatus(AccountStatus as);
	
}
