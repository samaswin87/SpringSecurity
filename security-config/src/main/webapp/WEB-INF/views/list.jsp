<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<title>List Users</title>
</head>
<body>

	<h2>Users</h2>
	<h6>
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
			<input type="submit" value="Logout" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</h6>

	<table class="data">
		<tr>
			<th>Name</th>
			<th>Password</th>
		</tr>
		<tr>
			<td>admin</td>
			<td>admin</td>
		</tr>
		<tr>
			<td>user</td>
			<td>user</td>
		</tr>
	</table>

</body>
</html>