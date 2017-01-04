package com.ss2h.bank.dao;

import com.ss2h.bank.entity.Admin;

public interface AdminDAO {

	public Admin getAdminByName(String name);
	
	public void addAdmin(Admin a);

	public void updateAdmin(Admin admin);
	
}
