<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts Details</title>
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
		</form>
	</div>
	<div style="top: 500; left: 450; position: absolute;">
	<table align="center">
					<tr>
						<td align="center"><a href="HomePage.jsp"><input
								type="button" value="Home" /></a></td>
					</tr>
				</table>
		<table border="1">
			<tr>
				<th>Account Number</th>
				<th>Account Status</th>
				<th>Account Balance</th>
				<th>Account Type</th>
			</tr>
			<c:forEach var="listOfAllAccount"
				items="${requestScope.listOfAllAccounts}">
				<tr>
					<td>${listOfAllAccount.accountNumber}</td>
					<td>${listOfAllAccount.status}</td>
					<td>${listOfAllAccount.accountBalance}</td>
					<td>${listOfAllAccount.accountType}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>