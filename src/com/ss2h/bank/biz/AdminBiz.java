package com.ss2h.bank.biz;

import com.ss2h.bank.entity.Admin;

public interface AdminBiz {

	public Admin getAdminByName(String name);
	
	public void addAdmin(Admin a);

	public void updateAdmin(Admin admin);
	
}
