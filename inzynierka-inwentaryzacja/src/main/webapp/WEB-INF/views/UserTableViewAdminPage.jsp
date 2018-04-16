<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<sec:authorize var="isAdmin" access="hasAnyRole('ADMIN')" />

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Senecus - Admin Page</title>
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
<link href="/resources/css/sis-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
		<a class="navbar-brand" href="EquipmentAdminPage.jsp">Senecus System Menu</a>
		<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Strona Główna"><a class="nav-link"
					href="/index/"> <i class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Strona Główna</span>
				</a></li>
				<c:if test="${isAdmin}">
					<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Sprzęt"><a class="nav-link"
						href="/equipment/"> <i class="fa fas fa-desktop"></i> <span class="nav-link-text">Sprzęt</span>
					</a></li>
					<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Pracownicy"><a class="nav-link"
						href="/employees/"> <i class="fa fas fa-users"></i> <span class="nav-link-text">Pracownicy</span>
					</a></li>
					<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Działy"><a class="nav-link"
						href="/departments/"> <i class="fa far fa-building"></i> <span class="nav-link-text">Działy</span>
					</a></li>
				</c:if>
			</ul>
			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center" id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link">Witaj, ${userLoggedIn.fullName}</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="modal" data-target="#exampleModal"> <i
						class="fa fa-fw fa-sign-out"></i>Wyloguj
				</a></li>
			</ul>
		</div>
	</nav>
	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/index/">Strona Główna</a></li>
				<li class="breadcrumb-item active">Pracownicy</li>
			</ol>
			<!-- Add new -->
			<div class="dropdown-divider"></div>
			<form action="/employees/add" method="post">

				<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#AddNewModal">Dodaj nowego</button>
			</form>
			<!-- Add Modal-->
			<div class="modal fade" id="AddNewModal" tabindex="-1" role="dialog" aria-labelledby="AddNewModalLabel"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<form class="form-inline" action="/employees/add" method="post">
						<input type="hidden" name="AddNewModal" value="AddNewModal" />
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="AddNewModalLabel">Dodaj nowego pracownika:</h5>
								<button class="close" type="button" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<label for="name">Podaj imie:</label>
									 <input type="text" class="form-control"
										id="name" placeholder="Imię" name="name">
								</div>
								<div class="form-group">
									<label for="surname">Podaj nazwisko: </label> 
									<input type="text" class="form-control" id="surname"
										placeholder="Nazwisko" name="surname">
								</div>
								<div class="form-group">
									<label for="phoneNumber">Podaj numer telefonu: </label>
									 <input type="text" class="form-control" id="phoneNumber" placeholder="Numer telefonu"
										name="phoneNumber">
								</div>
								<div class="form-group">
									<label for="email">Podaj adres email:</label>
									 <input type="text" class="form-control"
										id="email" placeholder="Adres email" name="email">
								</div>
								<div class="form-group">
									<label for="departmentName">Podaj dział: </label> 
									<select class="form-control" id="sel1" name="departmentId">
										<c:forEach items="${departmentList}" var="c">
											<option value="${c.id}">${c.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="roleName">Podaj rolę: </label> 
									<select class="form-control" id="sel1" name="roleId">
										<c:forEach items="${roleList}" var="c">
											<option value="${c.id}">${c.roleName}</option>
										</c:forEach>
									</select>
								</div>
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-info btn-xs">Dodaj</button>
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
			</div>
			<div class="dropdown-divider"></div>
			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Baza sprzętu
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable">
							<thead>
								<tr>
									<th>id</th>
									<th>Imie i nazwisko</th>
									<th>Numer telefonu</th>
									<th>Adres e-mail</th>
									<th>Dział</th>
									<th>Akcja</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>id</th>
									<th>Imie i nazwisko</th>
									<th>Numer telefonu</th>
									<th>Adres e-mail</th>
									<th>Dział</th>
									<th>Akcja</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${employeeList}" var="e">

									<tr>
										<td>${e.id}</td>
										<td>${e.fullName}</td>
										<td>${e.phoneNumber}</td>
										<td>${e.email}</td>
										<td>${e.departmentName.name}</td>
										<td>
											<form action="/employees/details" method="get">
												<input type="hidden" name="id" value="${e.id}" />
												<button type="submit" class="btn btn-info btn-xs">Szczegóły</button>
											</form>
										</td>
									</tr>

								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="card-footer small text-muted">Ostatnia aktualizacja: wczoraj 14.02 23:00</div>
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<footer class="sticky-footer">
			<div class="container">
				<div class="text-center">
					<small>Copyright © Patryk Cymerman 2018</small>
				</div>
			</div>
		</footer>
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i class="fa fa-angle-up"></i>
		</a>
		<!-- Logout Modal-->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Wylogować?</h5>
						<button class="close" type="button" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Wybierz wyloguj by zakończyć sesje</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button" data-dismiss="modal">Anuluj</button>
						<a class="btn btn-primary" href="/login?logout=true">Wyloguj</a>
					</div>
				</div>
			</div>
		</div>

		<script src="/resources/vendor/jquery/jquery.min.js"></script>
		<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
		<script src="/resources/vendor/datatables/jquery.dataTables.js"></script>
		<script src="/resources/vendor/datatables/dataTables.bootstrap4.js"></script>
		<script src="/resources/js/sis-admin.min.js"></script>
		<script src="/resources/js/sis-admin-datatables.min.js"></script>
	</div>
</body>

</html>
