<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:url var="edit" value="/edit" />
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
<style type="text/css">
.col-move {
	padding: 2px;
	padding-left: 10px;
	padding-right: 10px;
	margin: 10px;
}

.col-move1 {
	padding: 3px;
	padding-top: 3px;
	padding-left: 10px;
	padding-right: 10px;
	margin: 10px;
}
</style>
<title>List Users</title>
</head>
<body>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">User</h3>
				<a title="List" class="btn btn-default pull-right col-move1"
					data-toggle="tooltip" href="<c:url value="/list" />">Back to
					List</a>
				<c:url var="logoutUrl" value="/logout" />
				<form action="${logoutUrl}" method="post">
					<input type="submit" value="Logout" class="pull-right col-move" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</div>
			<div class="panel-body">
				<div class="col-lg-3"></div>
				<div class="col-lg-6">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-sm-2" for="email">Username:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="username" readonly="readonly"
									value="${user.getUsername()}">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="pwd">Password:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="password" readonly="readonly"
									value="${user.getPassword()}">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label><input type="checkbox" name="admin" disabled="disabled"
										<c:if test="${isAdmin}">checked="checked"</c:if>>
										Admin</label>&nbsp;
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="col-lg-3"></div>
			</div>
		</div>
	</div>
</body>
</html>