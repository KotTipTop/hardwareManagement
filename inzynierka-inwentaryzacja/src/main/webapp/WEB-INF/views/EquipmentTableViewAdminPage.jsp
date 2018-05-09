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
		<a class="navbar-brand" href="/index/">Senecus System Menu</a>
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
				<li class="breadcrumb-item active">Sprzęt</li>
			</ol>
			<!-- Add new -->
			<div class="dropdown-divider"></div>
			<form action="/equipment/add" method="post">

				<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#AddNewModal">Dodaj nowy</button>
			</form>
			<!-- Add Modal-->
			<div class="modal fade" id="AddNewModal" tabindex="-1" role="dialog" aria-labelledby="AddNewModalLabel"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<form class="form-inline" action="/equipment/add" method="post">
						<input type="hidden" name="AddNewModal" value="AddNewModal" />
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="AddNewModalLabel">Dodaj nowy:</h5>
								<button class="close" type="button" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<label for="categoryName">Podaj kategorie: </label> 
									<select class="form-group"  id="sel1" name="categoryId">
										<c:forEach items="${categoryList}" var="c">
											<option value="${c.id}">${c.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="manufacturer">Podaj producenta: </label> <input type="text" class="form-control" id="manufacturer"
										placeholder="Producent" name="manufacturer">
								</div>
								<div class="form-group">
									<label for="model">Podaj model: </label> <input type="text" class="form-control" id="model" placeholder="Model"
										name="model">
								</div>
								<div class="form-group">
									<label for="dateOfPurchase">Podaj datę zakupu:</label> <input type="text" class="form-control"
										id="dateOfPurchase" placeholder="Data zakupu" name="dateOfPurchase">
								</div>
								<div class="form-group">
									<label for="serialNumber">Podaj numer seryjny:</label> <input type="text" class="form-control"
										id="serialNumber" placeholder="Numer seryjny" name="serialNumber">
								</div>
								<div class="form-group">
									<label for="software">Podaj oprogramowanie:</label> <input type="text" class="form-control" id="software"
										placeholder="Software" name="software">
								</div>
								<div class="form-group">
									<label for="technicalParameters">Podaj parametry techniczne:</label> <input type="text" class="form-control"
										id="technicalParameters" placeholder="Parametry techniczne" name="technicalParameters">
								</div>
								<div class="form-group">
									<label for="peripherials">Podaj peryferia:</label> <input type="text" class="form-control" id="peripherials"
										placeholder="Peryferia" name="peripherials">
								</div>
								<div class="form-group">
									<label for="price">Podaj cene:</label> <input type="text" class="form-control" id="price" placeholder="Cena"
										name="price">
								</div>
								<div class="form-group">
									<label for="warranty">Podaj gwarancje:</label> <input type="text" class="form-control" id="warranty"
										placeholder="Gwarancja" name="warranty">
								</div>
								<div class="form-group">
									<label for="project">Podaj projekt:</label> <select class="form-control" id="sel2" name="projectId">
										<c:forEach items="${projectList}" var="p">
											<option value="${p.id}">${p.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="location">Podaj lokalizacje:</label> <select class="form-control" id="sel3" name="locationId">
										<c:forEach items="${locationList}" var="l">
											<option value="${l.id}">${l.name}</option>
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
									<th>Kategoria</th>
									<th>Producent</th>
									<th>Model</th>
									<th>Data Zakupu</th>
									<th>S/N:</th>
									<th>Cena</th>
									<th>Przypisany:</th>
									<th>Aktywny:</th>
									<th>Akcja</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>id</th>
									<th>Kategoria</th>
									<th>Producent</th>
									<th>Model</th>
									<th>Data Zakupu</th>
									<th>S/N:</th>
									<th>Cena:</th>
									<th>Przypisany:</th>
									<th>Aktywny:</th>
									<th>Akcja</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${equipmentList}" var="e">

									<tr>
										<td>${e.id}</td>
										<td>${e.category.name}</td>
										<td>${e.manufacturer}</td>
										<td>${e.model}</td>
										<td>${e.dateOfPurchase}</td>
										<td>${e.serialNumber}</td>
										<td>${e.price}</td>
										<td>${e.owner.fullName}</td>
										<td><c:choose>
										
										<c:when test ="${e.active==true}">
										aktywny
										</c:when>
										<c:otherwise>
										nieaktywny
										</c:otherwise>
										</c:choose>
										</td>
										<td><c:choose>
												<c:when test="${e.owner.fullName==null}">
													<form action="/ownership/assign" method="post">
														<input type="hidden" name="id" value="${e.id}" />
														<button type="button" class="btn btn-success btn-xs" data-toggle="modal" data-target="#AssignNewModal_${e.id}">Powierz</button>
													</form>
												</c:when>
												<c:otherwise>
													<form action="/ownership/return" method="post">
														<input type="hidden" name="id" value="${e.id}" />
														<button type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#ReturnNewModal_${e.id}">Zdaj</button>
													</form>
												</c:otherwise>
											</c:choose>
											<div class="dropdown-divider"></div>
											<form action="/equipment/details" method="get">
												
												<input type="hidden" name="id" value="${e.id}" />
												<button type="submit" class="btn btn-info btn-xs">Szczegóły</button>
											</form>
											<div class="dropdown-divider"></div>
											<c:choose>
											<c:when test="${e.active==true}">
											<form action="/equipment/delete" method="get">
												<input type="hidden" name="id" value="${e.id}" />
												<button type="submit" class="btn btn-danger btn-xs">Usuń</button>
											</form>
											</c:when>
											<c:otherwise>
											<form action="/equipment/active" method="get">
												<input type="hidden" name="id" value="${e.id}" />
												<button type="submit" class="btn btn-success btn-xs">Aktywuj</button>
											</form>
											</c:otherwise>
											</c:choose>
											</td>
									</tr>
									<!-- Assign Modal-->
									<div class="modal fade" id="AssignNewModal_${e.id}" tabindex="-1" role="dialog" aria-labelledby="AssignNewModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<form class="form-inline" action="/ownership/assign" method="post">
												<input type="hidden" name="AssignNewModal" value="AssignNewModal" />
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="AssignNewModalLabel_${e.id}">Powierz:</h5>
														<button class="close" type="button" data-dismiss="modal" aria-label="Close">
															<span aria-hidden="true">×</span>
														</button>
													</div>
													<div class="modal-body">
														<div class="form-group">
															<label for="userName">Wybierz osobę: </label> <select class="form-control" data-live-search="true" id="sel1"
																name="ownerId">
																<c:forEach items="${userList}" var="c">
																	<option value="${c.id}">${c.fullName}</option>
																</c:forEach>
															</select>
														</div>
														<div class="form-group">
															<label for="alloctationStartDate">Podaj datę przekazania: </label> <input type="date" class="form-control"
																id="alloctationStartDate" placeholder="RRRR-MM-DD" name="allocationStartDate">
														</div>
														<div class="form-group">
															<label for="project">Podaj projekt:</label> <select class="form-control" data-live-search="true" id="sel2" name="projectId">
																<c:forEach items="${projectList}" var="p">
																	<option value="${p.id}">${p.name}</option>
																</c:forEach>
															</select>
														</div>
														<div class="form-group">
															<label for="location">Podaj lokalizacje:</label> <select class="form-control" id="sel3" name="locationId">
																<c:forEach items="${locationList}" var="l">
																	<option value="${l.id}">${l.name}</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="modal-footer">
														<input type="hidden" name="equipmentId" value="${e.id}" />	
														<button type="submit" class="btn btn-info btn-xs">Przekaż</button>
													</div>
												</div>
												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
											</form>
										</div>
									</div>
									<!-- Return Modal-->
									<div class="modal fade" id="ReturnNewModal_${e.id}" tabindex="-1" role="dialog" aria-labelledby="ReturnNewModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<form class="form-inline" action="/ownership/return" method="post">
												<input type="hidden" name="ReturnNewModal" value="ReturnNewModal" />
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="ReturnNewModalLabel_${e.id}">Wybierz date zdania:</h5>
														<button class="close" type="button" data-dismiss="modal" aria-label="Close">
															<span aria-hidden="true">×</span>
														</button>
													</div>
													<div class="modal-body">
														<div class="form-group">
															<label for="alloctationEndDate">Podaj datę przekazania: </label> <input type="date" class="form-control"
																id="alloctationEndDate" placeholder="Data zdania" name="allocationEndDate">
														</div>
													</div>
													<div class="modal-footer">
														<input type="hidden" name="ownerId" value="${e.owner.id}" />
														<input type="hidden" name="equipmentId" value="${e.id}" />
														<button type="submit" class="btn btn-info btn-xs">Zdaj</button>
													</div>
												</div>
												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
											</form>
										</div>
									</div>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="card-footer small text-muted">Ostatnia aktualizacja: ${lastModified}</div>
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
