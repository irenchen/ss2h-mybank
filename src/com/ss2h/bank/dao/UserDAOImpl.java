package com.ss2h.bank.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ss2h.bank.entity.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@SuppressWarnings("rawtypes")
	@Override
	public User getUserByUsername(String name) {
		String hql = "from User u where u.username = '" + name + "'";
		List list = this.getHibernateTemplate().find(hql);
		return list.size()==0 ? null : (User)list.get(0);
	}
	
	@Override
	public void addUser(User user) {

		this.getHibernateTemplate().save(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		
		List<User> result = (List<User>) this.getHibernateTemplate().findByCriteria(dc);
		return result;
	}

	@Override
	public User getUserById(Integer id) {
		return this.getHibernateTemplate().get(User.class, id);
		///return (User)this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
		///	public Object doInHibernate(Session session) {
		///		return (User)session.createCriteria(User.class)
		///				.add(Restrictions.eq("id", id))
		///				.setFetchMode("accounts", FetchMode.EAGER)
		///				.uniqueResult();
		///	}
		///});
	}

	@Override
	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}	

}
