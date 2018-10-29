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
@WebServlet("/openAccountServlet")
public class OpenAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BankingServices bankingServices=new BankingServicesImpl();
			String accountType=request.getParameter("accountType");
			float accountBalance=Float.parseFloat(request.getParameter("accountBalance"));
			int pinNumber=Integer.parseInt(request.getParameter("pinNumber"));
			long accountNumber=bankingServices.openAccount(accountType, accountBalance,pinNumber);
			Account account=bankingServices.getAccountDetails(accountNumber);
			request.getSession().setAttribute("account",account );
		} catch (InvalidAmountException | InvalidAccountTypeException
				| BankingServicesDownException | AccountNotFoundException e) {
			request.setAttribute("account", e.getMessage());
		}
		finally{
			request.getRequestDispatcher("insideLoginPage.jsp").forward(request, response);
		}
	}
}
