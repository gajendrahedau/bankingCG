package com.cg.banking.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;
@WebServlet("/DepositAmountServlet")
public class DepositAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BankingServices bankingServices=new BankingServicesImpl();
			Account account=(Account)request.getSession(false).getAttribute("account");
			float amount=Float.parseFloat(request.getParameter("amount"));
			amount=bankingServices.depositAmount(account.getAccountNumber(), amount);
			request.setAttribute("deposit", "Amount Credited. Current Balance : "+amount);
		} catch (AccountNotFoundException | BankingServicesDownException
				| AccountBlockedException e) {
			request.setAttribute("deposit", e.getMessage());
		}
		finally{
			request.getRequestDispatcher("depositAmountPage.jsp").forward(request, response);
		}
	}
}
