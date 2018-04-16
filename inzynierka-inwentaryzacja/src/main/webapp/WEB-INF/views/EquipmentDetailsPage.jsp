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
				<li class="breadcrumb-item active">Dashboard</li>
			</ol>
			<div class="row">
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-primary o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fas fa-desktop"></i>
							</div>
							<div class="mr-5">Sprzęt</div>
							<div class="dropdown-divider"></div>
							<p>Kategoria: ${equipmentDetails.categoryName.name}</p>
							<p>Producent: ${equipmentDetails.manufacturer}</p>
							<p>Model: ${equipmentDetails.model}</p>
							<p>Data zakupu: ${equipmentDetails.dateOfPurchase}</p>
							<p>Numer seryjny: ${equipmentDetails.serialNumber}</p>
							<p>Software: ${equipmentDetails.software}</p>
							<p>Parametry techniczne: ${equipmentDetails.technicalParameters}</p>
							<p>Peryferia: ${equipmentDetails.peripherials}</p>
							<p>Cena: ${equipmentDetails.price}</p>
							<p>Przynależność: ${equipmentDetails.owner.fullName}</p>
							<p>Gwarancja: ${equipmentDetails.warranty}</p>
							<p>Projekt: ${equipmentDetails.project.name}</p>
							<p>Lokalizacja: ${equipmentDetails.location.name}</p>
							<p>Data ostatniej modyfikacji: ${equipmentDetails.lastModifiedDate}</p>
							<p>Ostatnia modyfikacja przez: ${equipmentDetails.lastModifiedBy}</p>
							<form action="/equipment/edit" method="post">
								<input type="hidden" name="id" value="${equipmentDetails.id}" />
								<button type="button" class="btn btn-default btn-xs" data-toggle="modal"
									data-target="#editModal_${equipmentDetails.id}">Edytuj</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-xl-8">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-table"></i> Historia
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable">
									<thead>
										<tr>
											<th>id</th>
											<th>Przypisany</th>
											<th>Data powierzenia</th>
											<th>Data zdania</th>
											<th>Projekt</th>
											<th>Lokalizacja</th>
											<th>Dokument</th>

										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>id</th>
											<th>Przypisany</th>
											<th>Data powierzenia</th>
											<th>Data zdania</th>
											<th>Projekt</th>
											<th>Lokalizacja</th>
											<th>Dokument</th>

										</tr>
									</tfoot>
									<tbody>
										<c:forEach items="${currentEquipmentHistory}" var="e">

											<tr>
												<td>${e.id}</td>
												<td>${e.owner.fullName}</td>
												<td>${e.allocationStartDate}</td>
												<td><c:if test="${e.allocationEndDate!=null}">
											${e.allocationEndDate}
											</c:if> <c:if test="${e.allocationEndDate==null}">
											Nie zdano.
											</c:if></td>
												<td>${e.location.name}</td>
												<td>${e.project.name}</td>
												
												<td>
													<form action="/ownership/givingReport" method="get">
														<input type="hidden" name="id" value="${e.id}" />
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
														<button type="submit" class="btn btn-success btn-xs">Dokument powierzenia</button>
														
													</form>
													<div class="dropdown-divider"></div>
													<form action="/ownership/passingReport" method="get">
														<input type="hidden" name="id" value="${e.id}" />
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
														<button type="submit" class="btn btn-danger btn-xs">Dokument zdania</button>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="card-footer small text-muted">Ostatnia aktualizacja: ${lastModified}</div>
					</div>
				</div>
			</div>
			<div class="dropdown-divider"></div>
			<button onclick="goBack()" class="btn btn-default btn-xs">Powrót</button>
			<script>
				function goBack() {
					window.history.back();
				}
			</script>

			<div class="dropdown-divider"></div>

			<!-- Edit Modal-->
			<div class="modal fade" id="editModal_${equipmentDetails.id}" tabindex="-1" role="dialog"
				aria-labelledby="editModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<form action="/equipment/edit" method="post">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="editModalLabel_${equipmentDetails.id}">Edycja</h5>
								<button class="close" type="button" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">

								<div class="form-group">
									<label for="categoryName">Podaj kategorie:</label> <select class="form-control" id="sel1"
										name="categoryName.id">
										<c:forEach items="${categoryList}" var="c">
											<c:if test="${c.id==equipmentDetails.categoryName.id}">
												<option selected="selected" value="${c.id}">${c.name}</option>
											</c:if>
											<c:if test="${c.id!=equipmentDetails.categoryName.id}">
												<option value="${c.id}">${c.name}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="manufacturer">Podaj producenta:</label> <input type="text" class="form-control"
										id="manufacturer_${equipmentDetails.id}" placeholder="manufacturer" name="manufacturer"
										value="${equipmentDetails.manufacturer}">
								</div>
								<div class="form-group">
									<label for="model">Podaj model:</label> <input type="text" class="form-control"
										id="model_${equipmentDetails.id}" placeholder="model" name="model" value="${equipmentDetails.model}">
								</div>
								<div class="form-group">
									<label for="dateOfPurchase">Podaj date zakupu:</label> <input type="text" class="form-control"
										id="dateOfPurchase_${equipmentDetails.id}" placeholder="dateOfPurchase" name="dateOfPurchase"
										value="${equipmentDetails.dateOfPurchase}">
								</div>
								<div class="form-group">
									<label for="serialNumber">Podaj numer seryjny:</label> <input type="text" class="form-control"
										id="serialNumber_${equipmentDetails.id}" placeholder="serialNumber" name="serialNumber"
										value="${equipmentDetails.serialNumber}">
								</div>
								<div class="form-group">
									<label for="software">Podaj software:</label> <input type="text" class="form-control"
										id="software_${equipmentDetails.id}" placeholder="software" name="software"
										value="${equipmentDetails.software}">
								</div>
								<div class="form-group">
									<label for="technicalParameters">Podaj software:</label> <input type="text" class="form-control"
										id="technicalParameters_${equipmentDetails.id}" placeholder="technicalParameters" name="technicalParameters"
										value="${equipmentDetails.technicalParameters}">
								</div>
								<div class="form-group">
									<label for="peripherials">Podaj software:</label> <input type="text" class="form-control"
										id="peripherials_${equipmentDetails.id}" placeholder="peripherials" name="peripherials"
										value="${equipmentDetails.peripherials}">
								</div>
								<div class="form-group">
									<label for="price">Podaj cene:</label> <input type="text" class="form-control"
										id="price_${equipmentDetails.id}" placeholder="price" name="price" value="${equipmentDetails.price}">
								</div>
								<div class="form-group">
									<label for="warranty">Podaj gwarancje:</label> <input type="text" class="form-control"
										id="warranty_${equipmentDetails.id}" placeholder="warranty" name="warranty"
										value="${equipmentDetails.warranty}">
								</div>
								<div class="form-group">
									<label for="project">Podaj projekt:</label> <select class="form-control" id="sel1" name="project.id">
										<c:forEach items="${projectList}" var="c">
											<c:if test="${c.id==equipmentDetails.project.id}">
												<option selected="selected" value="${c.id}">${c.name}</option>
											</c:if>
											<c:if test="${c.id!=equipmentDetails.project.id}">
												<option value="${c.id}">${c.name}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="location">Podaj lokalizacje:</label> <select class="form-control" id="sel1" name="location.id">
										<c:forEach items="${locationList}" var="c">
											<c:if test="${c.id==equipmentDetails.location.id}">
												<option selected="selected" value="${c.id}">${c.name}</option>
											</c:if>
											<c:if test="${c.id!=equipmentDetails.location.id}">
												<option value="${c.id}">${c.name}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="modal-footer">
								<input type="hidden" name="id" value="${equipmentDetails.id}" />
								<button type="submit" class="btn btn-info btn-xs">Edytuj</button>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
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
