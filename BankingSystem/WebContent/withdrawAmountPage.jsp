<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw Amount</title>
<style>
input[type=text] {
	width: 100%;
	padding: 10px 15px;
	margin: 8px 0;
	box-sizing: border-box;
	border: medium;
	border-color: black;
	background-color: silver;
	color: black;
}

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
	<div style="top: 400; left: 300; position: absolute;">
		<font size="6" face="Comic Sans MS,Lucida Console" color="brown">Withdraw
			Money :</font>
	</div>
	<div style="top: 500; left: 480; position: absolute;">
		<form name="withdrawAmountPage" action="WithdrawAmountServlet"
			method="post">
			<div align="center">
				<table>
					<tr>
						<td><font size="4">Enter Amount:</font></td>
						<td><input type="text" placeholder="amount to be withdrawn"
							name="amount" id="amount" required min="0"></td>
					</tr>
					<tr>
						<td><font size="4">Enter pin number:</font></td>
						<td><input type="number" placeholder="****" name="pinNumber"
							id="pinNumber" required autocomplete="off"></td>
					</tr>
					<tr align="center">
						<td align="right"><input type="submit" name="Submit"></td>
							<td><a href="insideLoginPage.jsp"><input type="button"
								value="Back" /></a></td>
						<td><a href="HomePage.jsp"><input type="button"
								value="Home" /></a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<div style="top: 700; left: 500; position: absolute;">
		<table>
			<tr>
				<td><font color="green" size="5">${requestScope.withdraw}</font></td>
			</tr>
		</table>
	</div>
</body>
</html>