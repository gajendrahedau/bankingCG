<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Details</title>
<style>
input[type=submit] {
	font-size: 20px;
}

input[type=button] {
	font-size: 20px;
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
	<div style="top: 400; left: 520; position: absolute;">
		<form action="GetAccountAllTransactionServlet" method="post">
			<div align="center">
				<table>
					<tr align="center">
						<td colspan="2"><input type="submit"
							value="Get Transactions Details"></td>
					</tr>
					<tr>
						<td align="right"><a href="insideLoginPage.jsp"><input
								type="button" value="Back" /></a></td>
						<td align="left"><a href="HomePage.jsp"><input
								type="button" value="Home" /></a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<div style="top: 500; left: 450; position: absolute;">
		<table border="1">
			<tr>
				<th>TransactionId</th>
				<th>Transaction Amount</th>
				<th>Transaction Type</th>
			</tr>
			<c:forEach var="transaction"
				items="${requestScope.listOfAllTransactions}">
				<tr>
					<td>${transaction.transactionId}</td>
					<td>${transaction.amount}</td>
					<td>${transaction.transactionType}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>