<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Senecus Inventory System</title>
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
<link href="/resources/css/sis-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Login</div>
			<div class="card-body">
				<c:url var="loginUrl" value="/login" />
				<form action="${loginUrl}" method="POST">
					<div class="form-group">
						<label for="username">Nazwa użytkownika: </label> <input class="form-control" id="username" type="text"
							aria-describedby="username" placeholder="Podaj nazwę użytkownika" name="username">
					</div>
					<div class="form-group">
						<label for="password">Hasło: </label> <input class="form-control" id="password" type="password"
							placeholder="Hasło" name="password">
					</div>
					<div class="form-group">
						<div class="form-check">
							<label class="form-check-label" for="remember">  Zapamiętaj hasło</label>
							<input id="remember" type="checkbox" name="remember-me" value="true">
						</div>
					</div>
					<button type="submit" class="btn btn-info">Zaloguj</button>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</div>
		<c:if test="${param.logout != null}">
			<div class="alert alert-success alert-dismissable">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> <strong>Sukces! Wylogowano
					poprawnie</strong>
			</div>
		</c:if>
		<c:if test="${param.errorLogin != null}">
			<div class="alert alert-danger alert-dismissable">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> <strong>Błąd! Złe dane, spróbuj ponownie</strong>
			</div>
		</c:if>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
