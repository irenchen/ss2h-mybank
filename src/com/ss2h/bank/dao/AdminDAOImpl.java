package com.ss2h.bank.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ss2h.bank.entity.Admin;

public class AdminDAOImpl extends HibernateDaoSupport implements AdminDAO {

	//@Override
	//public Admin getAdminByName(String name) {
	//	List list = this.getHibernateTemplate()
	//			.findByNamedParam("from Admin where username = :name", "name", name);
	//	return list.size() == 0 ? null : (Admin)list.get(0);
	//	
	//}

	//@Override
	//public Admin getAdminByName(String name) {
	//	Admin admin = new Admin();
	//	admin.setUsername(name);

	//	List<Admin> list = this.getHibernateTemplate().findByExample(admin);
	//	return (list.size()==0) ? null : (Admin)list.get(0);
		
	//}
	
	@Override
	public Admin getAdminByName(String name) {
		return this.getHibernateTemplate().execute(new HibernateCallback<Admin>() {

			@SuppressWarnings("rawtypes")
			@Override
			public Admin doInHibernate(Session session) throws HibernateException {
				List list = session.createCriteria(Admin.class)
						.add(Restrictions.eq("username", name))
						.list();
				return list.size()==0 ? null : (Admin)list.get(0);
			}
			
		});
		
	}

	@Override
	public void addAdmin(Admin a) {
		
		this.getHibernateTemplate().save(a);
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		this.getHibernateTemplate().update(admin);
		
	}
}
