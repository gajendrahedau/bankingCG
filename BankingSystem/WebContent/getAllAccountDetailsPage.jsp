<%@page import="com.cg.banking.beans.Account"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>get All Account Details</title>
</head>
<div>
	<table>
		<tr>
			<td><c:forEach var="account"
					items="${requestScope.listOfAllAccounts}">
  		${account}
        </c:forEach></td>
		</tr>
	</table>
</div>
</body>
</html>