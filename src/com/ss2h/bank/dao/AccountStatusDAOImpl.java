package com.ss2h.bank.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ss2h.bank.entity.AccountStatus;

public class AccountStatusDAOImpl extends HibernateDaoSupport implements AccountStatusDAO {

	@Override
	public AccountStatus getAccountStatusById(Integer id) {
		return this.getHibernateTemplate().load(AccountStatus.class, id);
	}

	@Override
	public void addAccountStatus(AccountStatus as) {
		
		this.getHibernateTemplate().save(as);
		
	}

}
