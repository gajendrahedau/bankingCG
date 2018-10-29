<%@page import="com.cg.banking.beans.Account"%>
<%@page import="com.cg.banking.services.BankingServicesImpl"%>
<%@page import="com.cg.banking.services.BankingServices"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>
<style>
input[type=submit] {
	font-size: 20px;
}
input[type=button] {
	font-size: 20px;
}
.t1 {
	font-size: 20px;
	text-color: green;
}
</style>
</head>
<body style="background-color: maroon;">

	<div style="top: 20; left: 20; position: absolute;">
		<table>
			<tr>
				<td><img src="bghome.jpg" style="width: 1230px; height: 800px;"></td>
			</tr>
		</table>
	</div>
	<div style="top: 30; left: 100; position: absolute;">
		<img src="logo.jpg" style="width: 100px; height: 100px;">
	</div>
	<div style="top: 20; left: 50; position: absolute;">
		<table>
			<tr>
				<td><font size="7"><b>C G Bank</b></font></td>
				<td><img src="title2.jpg" style="width: 930px; height: 250px;"></td>
			</tr>
		</table>
	</div>
	<%
		Account account=(Account)session.getAttribute("account");
		long accountNumber=account.getAccountNumber();
		float amount=new BankingServicesImpl().getAccountDetails(accountNumber).getAccountBalance();
	%>

	<div style="top: 400; left: 560; position: absolute;">
		<table class="t1">
			<tr>
				<td>Account Type:</td>
				<td>${sessionScope.account.accountType}</td>
			</tr>
			<tr>
				<td>Account Balance:</td>
				<td><%=amount %></td>
			</tr>
			<tr>
				<td>Account Number:</td>
				<td>${sessionScope.account.accountNumber}</td>
			</tr>
			<tr>
				<td>Pin Number:</td>
				<td>${sessionScope.account.pinNumber}</td>
			</tr>
			<tr>
				<td>Account Status:</td>
				<td>${sessionScope.account.status}</td>
			</tr>
			<tr align="center">
				<td><a href="insideLoginPage.jsp"><input type="button"
						value="Back" /></a></td>
				<td colspan="2"><a href="HomePage.jsp"><input type="submit"
						value="Home" /></a></td>
			</tr>
		</table>
	</div>
</body>
</html>





















