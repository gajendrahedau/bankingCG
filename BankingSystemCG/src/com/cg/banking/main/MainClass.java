package com.cg.banking.main;

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
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {
	public static void main(String[] args) {
		BankingServices bservices=new BankingServicesImpl();
		try {
			bservices.openAccount("Saving", 1000);
			List<Account>list=bservices.getAllAccountDetails();
			for (Account account : list) {
				System.out.println(account);
			}
			System.out.println("Single details\n\n\n");
			Account ac=bservices.getAccountDetails(10040);
			System.out.println(ac);
			
			 float amount=bservices.depositAmount(10044,5000);
			 System.out.println("Total Amount  "+amount);
			 
			 float amount1=bservices.withdrawAmount(10044,2000,1022);
			 System.out.println("Rest Amount  "+amount1);
			 
			 List<Transaction> l=bservices.getAccountAllTransaction(10044);
			 for (Transaction transaction : l) {
				System.out.println(transaction);
			}
			// System.out.println("Status ->"+bservices.accountStatus(546));
			 
			System.out.println("Completed");
		} catch (InvalidAmountException e) {
			e.printStackTrace();
		} catch (InvalidAccountTypeException e) {
			e.printStackTrace();
		} catch (BankingServicesDownException e) {
			e.printStackTrace();
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		} catch (AccountBlockedException e) {
			e.printStackTrace();
		} catch (InsufficientAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPinNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			
		}
	}
}
