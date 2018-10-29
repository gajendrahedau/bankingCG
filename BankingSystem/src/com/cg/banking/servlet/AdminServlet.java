package com.cg.banking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pinNumber=Integer.parseInt(request.getParameter("pinNumber"));
		if(pinNumber==1234){
			try {
				BankingServices bankingServices=new BankingServicesImpl();
				List<Account>listOfAllAccounts=bankingServices.getAllAccountDetails();
				request.setAttribute("listOfAllAccounts",listOfAllAccounts);
				request.getRequestDispatcher("adminPage.jsp").forward(request, response);
			} catch (BankingServicesDownException e) {
				request.setAttribute("listOfAllAccounts",e.getMessage());
				request.getRequestDispatcher("adminPage.jsp").forward(request, response);
			} 
		}	
		else{
			request.setAttribute("listOfAllAccounts", "Invalid PIN ");
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
		}
	}

}
