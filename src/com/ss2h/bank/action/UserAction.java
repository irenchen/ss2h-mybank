package com.ss2h.bank.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ss2h.bank.biz.TxBiz;
import com.ss2h.bank.biz.UserBiz;
import com.ss2h.bank.entity.Account;
import com.ss2h.bank.entity.TransactionLog;
import com.ss2h.bank.entity.User;

public class UserAction extends ActionSupport implements RequestAware, SessionAware{

	private static final long serialVersionUID = 1L;

	private Map<String, Object> request;
	private Map<String, Object> session;
	private User user;
	private String depositAmount;
	private String withdrawAmount;
	private String transferAmount;
	private String toAccountId;
	private String oldPass;
	private String newPass;
	
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public void setWithdrawAmount(String withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

	private UserBiz userBiz;

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	private TxBiz txBiz;

	public void setTxBiz(TxBiz txBiz) {
		this.txBiz = txBiz;
	}

	public void validateLogin() {
		System.out.println("Search for username : " + user.getUsername());
		
		User u = userBiz.getUserByUsername(user.getUsername());
		System.out.println("user : " + u);
		if( u == null) {
			this.addFieldError("username", "incorrect username");
			return;
		} else {
			if(!u.getPassword().equals(user.getPassword())) {
				request.put("inputUsername", user.getUsername());
				this.addFieldError("password", "incorrect password");
				return;
			}
		}
		// assign user info from database into user 
		user = u;
		System.out.println("User validation successful...");
		System.out.println("User account id : " + user.getAccounts().get(0).getId());
		System.out.println("User balance : " + user.getAccounts().get(0).getBalance());
	}
	
	public String login() {
		System.out.println("inside action : login...");
		session.put("username", user.getUsername());
		session.put("aid", user.getAccounts().get(0).getId());
		session.put("balance", user.getAccounts().get(0).getBalance());
		session.put("status", user.getAccounts().get(0).getStatus().getStatusName());
		return SUCCESS;
	}

	public String deposit() {
		System.out.println("inside action : deposit...");
		int aid = (Integer)session.get("aid");
		double amount = Double.parseDouble(depositAmount);
		System.out.println("存款金額 : " + amount);
		
		try {
			txBiz.deposit(aid, amount);
		} catch(Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;

	}
	
	public String withdraw() {
		System.out.println("inside action : withdraw...");
		int aid = (Integer)session.get("aid");
		double amount = Double.parseDouble(withdrawAmount);
		System.out.println("提款金額 : " + amount);
		
		try {
			txBiz.withdraw(aid, amount);
		} catch(Exception ex) {
			//ex.printStackTrace();
			System.out.println("Withdraw Exception : " + ex.getMessage());
			request.put("msg", ex.getMessage());
			return ERROR;
		}
		return SUCCESS;

	}
	
	public String queryTxLogs() {
		System.out.println("inside action : queryTxLogs...");
		// 取得帳戶與交易明細
		int aid = (Integer)session.get("aid");
		Account a = txBiz.getAccountById(aid);
		List<TransactionLog> txLogs = txBiz.getTxLogsByAccount(a);
		request.put("account", a);
		request.put("logs", txLogs);
		return SUCCESS;
	}
	
	public String transfer() {
		int fromAid = (Integer)session.get("aid");
		int toAid = Integer.parseInt(toAccountId);
		double amount = Double.parseDouble(transferAmount);
		
		try {
			txBiz.transfer(fromAid, toAid, amount);
		} catch(Exception ex) {
			System.out.println("Deposit Exception : " + ex.getMessage());
			request.put("msg", ex.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String modifyUser() {
		System.out.println("inside action : modifyUser...");
		String name = (String)session.get("username");
		User user = userBiz.getUserByUsername(name);
		// 檢查舊密碼是否正確
		if(!oldPass.equals(user.getPassword())) {
			this.addFieldError("msg", "舊密碼輸入不正確");
			return INPUT;
		}
		// 更新使用者密碼 
		user.setPassword(newPass);
		userBiz.updateUser(user);
		request.put("msg", "修改密碼成功，下次登入請改用新密碼");
		return SUCCESS;
	}
	
	public String logout() {
		System.out.println("inside action : logout...");
		session.remove("username");
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;		
	}
	
	
}
