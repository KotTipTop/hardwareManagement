package pl.kurs.java.service;

import java.util.List;
import java.util.Set;

import pl.kurs.java.controller.chart.ChartGenerator;
import pl.kurs.java.model.Employee;
import pl.kurs.java.model.chart.Chart;

public interface ChartService {
	Chart generateChart(List<Employee> employees, String chartName);
	Set<ChartGenerator> getAllGenerators();
}
