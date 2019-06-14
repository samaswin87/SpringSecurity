<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>List Users</title>
</head>
<body>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Users</h3>
				<span class="pull-right"> <c:url var="logoutUrl"
						value="/logout" />
					<form action="${logoutUrl}" method="post">
						<input type="submit" value="Logout" /> <input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</span>
			</div>
			<table class="table table-bordered table-hover">
				<tr>
					<th class="col-md-1"><small>Username</small></th>
					<th class="col-md-2"><small>Password</small></th>
					<th class="col-md-3"><small>Status</small></th>
					<sec:authorize access="hasRole('ADMIN')">
						<th class="col-md-3"><small>Actions</small></th>
					</sec:authorize>
				</tr>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td><small><c:out value="${user.getUsername()}"></c:out></small></td>
						<td><small><c:out value="${user.getPassword()}"></c:out></small></td>
						<td><small><c:out value="${user.getEnabledValue()}"></c:out></small></td>
						<sec:authorize access="hasRole('ADMIN')">
							<td>
								<a title="Add" data-toggle="tooltip" href="<c:url value="/add" />"><i class="fa fa-plus"></i></a> 
								<a title="Edit" data-toggle="tooltip" href="<c:url value="/show?username=${user.getUsername()}" />"><i class="fa fa-pencil-square-o"></i></a>
							</td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>