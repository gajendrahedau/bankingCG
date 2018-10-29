package com.cg.banking.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;
@WebServlet("/WithdrawAmountServlet")
public class WithdrawAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BankingServices bankingServices=new BankingServicesImpl();
			Account account=(Account)request.getSession(false).getAttribute("account");
			float amount=Float.parseFloat(request.getParameter("amount"));
			int pinNumber=Integer.parseInt(request.getParameter("pinNumber"));
			amount=bankingServices.withdrawAmount(account.getAccountNumber(), amount, pinNumber);
			request.setAttribute("withdraw", "Amount Debited. Current Balance : "+amount);
			
		} catch (InsufficientAmountException | AccountNotFoundException
				| InvalidPinNumberException | BankingServicesDownException
				| AccountBlockedException e) {
			request.setAttribute("withdraw", e.getMessage());	
		}
		finally{
			request.getRequestDispatcher("withdrawAmountPage.jsp").forward(request, response);
		}
	}
}
