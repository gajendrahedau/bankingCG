package com.cg.banking.services;
import java.sql.SQLException;
import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.AccountDAOImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

public class BankingServicesImpl implements BankingServices {
	AccountDAO dao=new AccountDAOImpl();
	@Override
	public long openAccount(String accountType, float initBalance,int pinNumber)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		Account account=null;
		if(initBalance<1000) throw new InvalidAmountException("Minimum Amount for opening an account is 1000.");
		account=new Account(accountType,initBalance,pinNumber);
		account=dao.save(account);
		return account.getAccountNumber();
	}

	@Override
	public float depositAmount(long accountNumber, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account account=getAccountDetails(accountNumber);
		if(accountStatus(accountNumber).equals("Blocked")) throw new AccountBlockedException("Account is Blocked");			
		account=dao.creditAmount(accountNumber,amount);
		dao.saveTransaction(accountNumber,amount,"Deposit");
		return account.getAccountBalance();
	}

	@Override
	public float withdrawAmount(long accountNumber, float amount, int pinNumber) throws InsufficientAmountException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account account=getAccountDetails(accountNumber);
		if(accountStatus(accountNumber).equals("Blocked")) throw new AccountBlockedException("Account is Blocked");
		if(account.getPinNumber()!=pinNumber)
			throw new InvalidPinNumberException("Pin is Incorrect");
		if((account.getAccountBalance()-1000)<amount) throw new InsufficientAmountException("Balance is low.");
		account=dao.extractAmount(accountNumber,amount);
		dao.saveTransaction(accountNumber,amount,"Withdraw");
		return account.getAccountBalance();
	}

	@Override
	public boolean fundTransfer(long accountNumberTo, long accountNumberFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		//Account accountTo=getAccountDetails(accountNumberTo);
		//Account accountFrom=getAccountDetails(accountNumberFrom);
		withdrawAmount(accountNumberFrom, transferAmount, pinNumber);
		depositAmount(accountNumberTo, transferAmount);
		return true;
	}

	@Override
	public Account getAccountDetails(long accountNumber) throws AccountNotFoundException, BankingServicesDownException {
		Account account=dao.findOne(accountNumber);
		if(account==null) throw new AccountNotFoundException("Account Not Exist");
		return account;
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		return dao.findAll();
	}
	@Override
	public List<Transaction> getAccountAllTransaction(long accountNumber)
			throws BankingServicesDownException, AccountNotFoundException {
		return dao.getTransactionAll(accountNumber);
	}
	@Override
	public String accountStatus(long accountNumber)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Account account=getAccountDetails(accountNumber);
		return account.getStatus();
	}
}
