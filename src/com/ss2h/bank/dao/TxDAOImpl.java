package com.ss2h.bank.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ss2h.bank.entity.Account;
import com.ss2h.bank.entity.TransactionLog;

public class TxDAOImpl extends HibernateDaoSupport implements TxDAO {

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<TransactionLog> getTxLogsByAccount(Account a) {
		String hql = "from TransactionLog t where t.toAccount "
				+ "= :account or t.fromAccount = :account"
				+ " order by t.txDate desc";
		List<TransactionLog> list = this.getSessionFactory().getCurrentSession().createQuery(hql)
				.setParameter("account", a)
				.setFirstResult(0)
				.setMaxResults(10)
				.list();
		return list;
	}

	@Override
	public Account getAccountById(int aid) {
		return this.getHibernateTemplate().get(Account.class, aid);
	}

	@Override
	public void addTxLog(TransactionLog log) {
		this.getHibernateTemplate().save(log);		
	}

	@Override
	public void updateAccount(Account account) {
		this.getHibernateTemplate().update(account);		
	}

}
