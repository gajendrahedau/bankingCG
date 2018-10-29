<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
<style>
.t1 {
	border: 1px solid black;
	border-style: inset;
	background-color: #004d66;
}

.t2 {
	border: 1px solid black;
	border-style: inset;
	background-color: teal;
}

input[type=number] {
	width: 80%;
	padding: 10px 15px;
	margin: 8px 0;
	box-sizing: border-box;
	border: medium;
	border-color: black;
	background-color: silver;
	color: black;
}

input[type=submit] {
	font-size: 15px;
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
	<div style="top: 400; left: 500; position: absolute;">
		<form name="userAccount" action="getAccountDetailsServlet"
			method="post">
			<table class="t1">
				<tr align="center">
					<td><br> <br> <input type="number"
						placeholder="Enter account number" size="30" name="accountNumber"
						required="required" min="1"></td>
				</tr>
				<tr align="center">
					<td><input type="number" placeholder="Enter PIN Number"
						name="pinNumber" id="pinNumber" min="1000" max="9999" required "></td>
				</tr>
				<tr align="center">
					<td><input type="submit" name="Log In" value="Log In"></td>
				</tr>
				<tr>
					<td align="center"><br>
						<hr> <a href="openAccountPage.jsp"><font size="4"
							color="white">New User? Create A New Account</font></a></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="top: 700; left: 500; position: absolute;">
		<table>
			<tr>
				<td><font color="red" size="5">${requestScope.message}</font></td>
			</tr>
		</table>
	</div>
	<div style="top: 50; left: 300; position: absolute;">
		<form name="adminAccount" action="AdminServlet" method="post">
			<table class="t2">
				<tr>
					<td><font size="4" color="black">Admin LogIn:</font></td>
				</tr>
				<tr align="center">
					<td><input type="number" placeholder="Password"
						name="pinNumber" id="pinNumber" required></td>
				</tr>
				<tr align="center">
					<td><input type="submit" name="Log In" value="Log In"></td>
				</tr>
				<tr>
					<td align="center"><br>
						<hr> <font size="2">**only for admin use</font></td>
				</tr>
			</table>
		</form>
		<div style="top: 110; left: 50; position: absolute;">
		<table>
			<tr>
				<td><font color="black" size="2">${requestScope.listOfAllAccounts}</font></td>
			</tr>
		</table>
	</div>
	</div>
</body>
</html>



