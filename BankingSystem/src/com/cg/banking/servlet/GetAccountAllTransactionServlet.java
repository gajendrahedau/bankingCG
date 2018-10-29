package com.cg.banking.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;
@WebServlet("/GetAccountAllTransactionServlet")
public class GetAccountAllTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BankingServices bankingServices=new BankingServicesImpl();
			Account account=(Account)request.getSession(false).getAttribute("account");
			List<Transaction>listOfAllTransactions=null;
			listOfAllTransactions=bankingServices.getAccountAllTransaction(account.getAccountNumber());
			request.setAttribute("listOfAllTransactions",listOfAllTransactions);
		} catch (BankingServicesDownException | AccountNotFoundException e) {
			request.setAttribute("listOfAllTransactions",e.getMessage());
		}
		finally{
			request.getRequestDispatcher("getAccountAllTransactionPage.jsp").forward(request, response);
		}
	}
}
