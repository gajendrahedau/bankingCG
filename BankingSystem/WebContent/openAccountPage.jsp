<html>
<head>
<title>Opening a new Account</title>
<style>
input[type=number] {
	width: 100%;
	padding: 10px 15px;
	margin: 8px 0;
	box-sizing: border-box;
	border: medium;
	border-color: black;
	background-color: silver;
	color: black;
}
input[type=button] {
	font-size: 20px;
}
input[type=submit] {
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
	<div style="top: 400; left: 300; position: absolute;">
		<font size="6" face="Comic Sans MS,Lucida Console" color="brown">Create
			new account :</font>
	</div>
	<div style="top: 500; left: 480; position: absolute;">
		<form name="openAccountPage" action="openAccountServlet" method="post">
			<div align="center">
				<table>
					<tr>
						<td><font size="4">Enter Account Type</font></td>
						<td><input type="radio" name="accountType" value="Savings"
							checked> Savings <input type="radio" name="accountType"
							value="Current"> Current</td>
					</tr>
					<tr>
						<td><font size="4">Enter Initial Balance</font></td>
						<td><input type="number" placeholder="Minimum Rs.1000"
							name="accountBalance" id="accountBalance" min="1000" required></td>
					</tr>
					<tr>
						<td><font size="4">Enter PIN Number</font></td>
						<td><input type="number" min="1000" max="9999" required
							name="pinNumber" id="pinNumber"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr align="center">
						<td align="right"><input type="submit" name="Submit"></td>
						<td><a href="HomePage.jsp"><input type="button"
								value="Home" /></a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<table>
		<tr>
			<td>${requestScope.accountNumber}</td>
		<tr>
	</table>
</body>
</html>













