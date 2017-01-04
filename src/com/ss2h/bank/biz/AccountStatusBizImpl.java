package com.ss2h.bank.biz;

import com.ss2h.bank.dao.AccountStatusDAO;
import com.ss2h.bank.entity.AccountStatus;

public class AccountStatusBizImpl implements AccountStatusBiz {

	private AccountStatusDAO accountStatusDAO;
	
	
	public AccountStatusDAO getAccountStatusDAO() {
		return accountStatusDAO;
	}

	public void setAccountStatusDAO(AccountStatusDAO accountStatusDAO) {
		this.accountStatusDAO = accountStatusDAO;
	}

	@Override
	public AccountStatus getAccountStatusById(Integer id) {
		return accountStatusDAO.getAccountStatusById(id);
	}

	@Override
	public void addAccountStatus(AccountStatus as) {
		
		accountStatusDAO.addAccountStatus(as);
		
	}

}
