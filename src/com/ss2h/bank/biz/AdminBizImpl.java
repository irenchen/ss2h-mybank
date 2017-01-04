package com.ss2h.bank.biz;

import com.ss2h.bank.dao.AdminDAO;
import com.ss2h.bank.entity.Admin;

public class AdminBizImpl implements AdminBiz {

	private AdminDAO adminDAO;
	
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public Admin getAdminByName(String name) {
		return adminDAO.getAdminByName(name);
	}

	@Override
	public void addAdmin(Admin a) {
		
		adminDAO.addAdmin(a);
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminDAO.updateAdmin(admin);
		
	}

}
