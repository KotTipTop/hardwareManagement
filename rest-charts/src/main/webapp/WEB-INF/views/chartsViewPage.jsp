<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript">
	function drawChart() {
		var myArray= [];
		
		//for po wierszach i kolumnach w tabeli
		//pierwszy wiersz = nazwa
		//drugi wiersz = wartosc
		myArray.push({
			label: "aaaa",
			y : 100,
		});
		
		var options = {
			animationEnabled : true,
			title : {
				text : "Pensje pracowników sektora IT"
			},
			axisY : {
				title : "Pensje",
				suffix : "PLN",
				includeZero : true
			},
			axisX : {
				title : "Stanowisko"
			},
			data : [ {
				type : "column",
				yValueFormatString : "#,##0.0#" % "",
				dataPoints : [ {
					label : "Programista",
					y : parseInt($("#programmer").val())
				}, {
					label : "Analityk",
					y : parseInt($("#analyst").val())
				}, {
					label : "Tester",
					y : parseInt($("#tester").val())
				}, {
					label : "Manager",
					y : parseInt($("#manager").val())
				}, {
					label : "Consultant",
					y : parseInt($("#consultant").val())
				}

				]
			} ]
		};
		$("#chartContainer").CanvasJSChart(options);

	}
</script>
<script>
function myCreateFunction() {
    var table = document.getElementById("dataTable");
    var row = table.insertRow(table.rows.lenght);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    cell1.innerHTML = '<input type="text" name="position"/>';
    cell2.innerHTML = '<input type="text" name="salary"/>';
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Charts</title>
</head>
<body>
	<table class="table table-bordered" id="dataTable">
		<thead>
			<tr>
				<th>Stanowisko</th>
				<th>Pensja</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td><input type="text" name="position"/></td>
				<td><input type="text" name="salary"/></td>
			</tr>
			<tr>
				<td><input type="text" name="position"/></td>
				<td><input type="text" name="salary"/></td>
			</tr>
			<tr>
				<td><input type="text" name="position"/></td>
				<td><input type="text" name="salary"/></td>
			</tr>
			<tr>
				<td><input type="text" name="position"/></td>
				<td><input type="text" name="salary"/></td>
			</tr>
			<tr>
				<td><input type="text" name="position"/></td>
				<td><input type="text" name="salary"/></td>
			</tr>

		</tbody>

	</table>
	<button onclick="drawChart()">Rysuj</button>
	<button onclick="myCreateFunction()">Dodaj</button>

	<div id="chartContainer" style="height: 370px; width: 100%;"></div>

	<script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
	<script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
</body>
</html>