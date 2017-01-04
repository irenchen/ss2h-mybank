package com.ss2h.bank.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ss2h.bank.entity.TransactionType;

public class TxTypeDAOImpl extends HibernateDaoSupport implements TxTypeDAO {

	@Override
	public TransactionType getTxTypeByName(String name) {
		String hql = "from TransactionType t where t.typeName = '" + name + "'";
		List<?> list = this.getHibernateTemplate().find(hql);
		return (list.size()==0) ? null : (TransactionType)list.get(0);
	}

}
