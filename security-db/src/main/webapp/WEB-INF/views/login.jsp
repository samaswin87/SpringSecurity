<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
</head>
<body onload='document.loginForm.username.focus();'
	style="background-color: #4b5257">
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="margin-top: 150px">
				<h3>Login</h3>
				<form name="loginForm"
					action="<c:url value='j_spring_security_check'/>" method="POST">
					<div class="form-group">
						<input type="text" name='username' class="form-control"
							placeholder="Username">
					</div>
					<div class="form-group">
						<input type="password" name='password' class="form-control"
							placeholder="Password">
					</div>
					<div class="form-group">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</div>
					<button type="submit" class="btn-primary form-control">Login</button>
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>