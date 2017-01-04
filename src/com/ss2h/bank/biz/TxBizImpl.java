package com.ss2h.bank.biz;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ss2h.bank.dao.TxDAO;
import com.ss2h.bank.dao.TxTypeDAO;
import com.ss2h.bank.entity.Account;
import com.ss2h.bank.entity.TransactionLog;

@Transactional
public class TxBizImpl implements TxBiz {

	private TxDAO txDAO;
	private TxTypeDAO txTypeDAO;
	
	public void setTxTypeDAO(TxTypeDAO txTypeDAO) {
		this.txTypeDAO = txTypeDAO;
	}

	public void setTxDAO(TxDAO txDAO) {
		this.txDAO = txDAO;
	}

	@Override
	public Account getAccountById(int aid) {
		return txDAO.getAccountById(aid);
	}

	@Override
	public List<TransactionLog> getTxLogsByAccount(Account a) {
		return txDAO.getTxLogsByAccount(a);
	}

	@Override
	public void addTxLog(TransactionLog log) {
		txDAO.addTxLog(log);
	}

	// TxBiz存款交易
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deposit(Integer aid, Double amount) {
		// 更新Account
		Account account = txDAO.getAccountById(aid);
		// 將account balance加上deposit amount
		account.setBalance(account.getBalance() + amount);
		txDAO.updateAccount(account);
		
		// 新增一筆交易紀錄
		TransactionLog txLog = new TransactionLog();
		txLog.setTxType(txTypeDAO.getTxTypeByName("deposit"));
		txLog.setFromAccount(account);
		txLog.setToAccount(account);
		txLog.setTxAmount(amount);
		txLog.setTxDate(new Date());		
		
		txDAO.addTxLog(txLog);
		
	}

	// TxBiz存款交易
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void withdraw(Integer aid, Double amount) throws Exception {
		// 更新Account
		Account account = txDAO.getAccountById(aid);
		if(amount > account.getBalance()) {
			throw new Exception("餘額不足...");
		}
		// 將account balance減去withdraw amount
		account.setBalance(account.getBalance() - amount);
		txDAO.updateAccount(account);
		
		// 新增一筆交易紀錄
		TransactionLog txLog = new TransactionLog();
		txLog.setTxType(txTypeDAO.getTxTypeByName("withdraw"));
		txLog.setFromAccount(account);
		txLog.setToAccount(account);
		txLog.setTxAmount(amount);
		txLog.setTxDate(new Date());		
		
		txDAO.addTxLog(txLog);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void transfer(Integer fromAid, Integer toAid, Double amount) throws Exception {
		// 檢查兩個帳戶是否相同
		if(fromAid == toAid) {
			throw new Exception("不需要轉帳給自己");
		}
		// 檢查toAccount是否存在
		Account toAccount = txDAO.getAccountById(toAid);
		if(toAccount == null) {
			throw new Exception("轉入帳戶 : " + toAid + "不存在...");
		}
		// 檢查fromAccount餘額是否足夠
		Account fromAccount = txDAO.getAccountById(fromAid);
		if(amount > fromAccount.getBalance()) {
			throw new Exception("餘額不足...");
		}
		// 更新Account	
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);
		txDAO.updateAccount(fromAccount);
		txDAO.updateAccount(toAccount);
		
		// 新增一筆轉帳交易紀錄
		TransactionLog txLog = new TransactionLog();
		txLog.setTxType(txTypeDAO.getTxTypeByName("transfer"));
		txLog.setFromAccount(fromAccount);
		txLog.setToAccount(toAccount);
		txLog.setTxAmount(amount);
		txLog.setTxDate(new Date());		
		
		txDAO.addTxLog(txLog);
		
	}

}
