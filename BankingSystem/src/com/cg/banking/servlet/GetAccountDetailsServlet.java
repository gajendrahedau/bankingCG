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
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;
@WebServlet("/getAccountDetailsServlet")
public class GetAccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BankingServices bankingServices=new BankingServicesImpl();
			long accountNumber=Long.parseLong(request.getParameter("accountNumber"));
			int pinNumber=Integer.parseInt(request.getParameter("pinNumber"));
			Account account=bankingServices.getAccountDetails(accountNumber);
			if(account.getAccountNumber()==accountNumber && account.getPinNumber()==pinNumber){
				request.getSession(false).setAttribute("account", account);
				request.getRequestDispatcher("insideLoginPage.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "Account Number or password is incorrect");
				request.getRequestDispatcher("HomePage.jsp").forward(request, response);
			}
		} catch (AccountNotFoundException | BankingServicesDownException e) {
			request.setAttribute("message", "Account does not exist");
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
		}
	}
}
