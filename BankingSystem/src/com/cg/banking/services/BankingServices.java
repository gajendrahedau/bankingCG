package com.cg.banking.services;

import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

public interface BankingServices {

	long openAccount(String accountType,float initBalance,int PinNumber)
			throws InvalidAmountException,InvalidAccountTypeException,BankingServicesDownException;

	float depositAmount(long accountNumber,float amount)
			throws
			AccountNotFoundException,BankingServicesDownException, AccountBlockedException;

	float withdrawAmount(long accountNumber,float amount,int pinNumber)
			throws InsufficientAmountException,
			AccountNotFoundException,InvalidPinNumberException,
			BankingServicesDownException ,AccountBlockedException;

	boolean fundTransfer(long accountNumberTo,long accountNumberFrom,float transferAmount,int pinNumber)
			throws InsufficientAmountException,AccountNotFoundException,InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException  ;

	Account getAccountDetails(long accountNumber)
			throws  AccountNotFoundException,BankingServicesDownException;

	List<Account> getAllAccountDetails()
			throws BankingServicesDownException;

	List<Transaction> getAccountAllTransaction(long accountNumber)
			throws BankingServicesDownException,
			AccountNotFoundException;

	public String accountStatus(long accountNumber)
			throws BankingServicesDownException,
			AccountNotFoundException, AccountBlockedException;
}