<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>
<script type="text/javascript">
	function draw(chartName) {
		$.ajax({
			url : "/charts/" + chartName,
			success : function(result) {
				$("#chartContainer").CanvasJSChart(result);
			}
		});
	}
</script>
</head>
<body>
	<form action="/employee/add" method="post">

		<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#employee">Dodaj nowy</button>
	</form>
	<!-- Add Modal-->
	<div class="modal fade" id="employee" tabindex="-1" role="dialog" aria-labelledby="employeeLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<form class="form" action="/employee/add" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="employeeLabel">Dodaj nowego pracownika:</h5>
						<button class="close" type="button" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="name">Podaj imie:</label> <input type="text" class="form-control" id="name"
								placeholder="Imie pracownika" name="name">
						</div>
						<div class="form-group">
							<label for="name">Podaj nazwisko:</label> <input type="text" class="form-control" id="surname"
								placeholder="Nazwisko pracownika" name="surname">
						</div>
						<div class="form-group">
							<label for="name">Podaj stanowisko:</label> <input type="text" class="form-control" id="position"
								placeholder="Stanowisko" name="position">
						</div>
						<div class="form-group">
							<label for="name">Podaj pensja:</label> <input type="text" class="form-control" id="salary" placeholder="Pensja"
								name="salary">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-info btn-xs">Dodaj</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- Table  -->
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>Imie</th>
					<th>Nazwisko</th>
					<th>Pozycja</th>
					<th>Pensja</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>id</th>
					<th>Imie</th>
					<th>Nazwisko</th>
					<th>Pozycja</th>
					<th>Pensja</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach items="${employeeList}" var="e">

					<tr>
						<td>${e.id}</td>
						<td>${e.name}</td>
						<td>${e.surname}</td>
						<td>${e.position}</td>
						<td>${e.salary}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

	</div>

	<c:forEach items="${generators}" var="g">
		<button type="button" class="btn btn-info btn-xs" onclick="draw('${g.name}');">${g.visibleName}</button>
	</c:forEach>



	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
</body>
</html>