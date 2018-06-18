package pl.kurs.java.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.kurs.java.model.chart.Chart;
import pl.kurs.java.service.ChartService;
import pl.kurs.java.service.EmployeeService;

@RestController
@RequestMapping("/charts")
public class ChartController {
	private final EmployeeService employeeService;
	private final ChartService chartService;

	public ChartController(EmployeeService employeeService, ChartService chartService) {
		this.employeeService = employeeService;
		this.chartService = chartService;
	}

	@GetMapping("/{chartName}")
	public HttpEntity<Chart> getChart(@PathVariable("chartName") String chartName) {
		return new ResponseEntity<>(chartService.generateChart(employeeService.findAll(), chartName), HttpStatus.OK);
	}

}
