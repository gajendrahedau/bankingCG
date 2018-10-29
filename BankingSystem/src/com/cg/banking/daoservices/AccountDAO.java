package com.cg.banking.daoservices;
import java.util.List;
import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
public interface AccountDAO {
	Account save(Account account);
	Account creditAmount(long accountNumber, float amount);
	Account extractAmount(long accountNumber, float amount);
	Account findOne(long accountNumber);
	List<Account> findAll();
	void saveTransaction(long accountNumber, float amount,String type);
	List<Transaction> getTransactionAll(long accountNumber);
	void changeStatus(long accountNumber);
}