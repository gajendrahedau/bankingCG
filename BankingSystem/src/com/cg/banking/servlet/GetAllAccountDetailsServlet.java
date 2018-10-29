package com.cg.banking.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;
@WebServlet("/getAllAccountDetailsServlet")
public class GetAllAccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BankingServices bankingServices=new BankingServicesImpl();
			 List<Account> listOfAllAccounts= bankingServices.getAllAccountDetails();
			request.setAttribute("listOfAllAccounts", listOfAllAccounts);
		} catch (BankingServicesDownException e) {
			request.setAttribute("listOfAllAccounts",e.getMessage());
		}
		finally{
			request.getRequestDispatcher("getAllAccountDetailsPage.jsp").forward(request, response);
		}
	}
}
