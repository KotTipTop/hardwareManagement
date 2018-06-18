package pl.kurs.java.controller.chart;

import java.util.List;

import pl.kurs.java.model.Employee;
import pl.kurs.java.model.chart.Chart;

public interface ChartGenerator {
	 Chart create(List<Employee> employees);
	 String getName();
	 String getVisibleName();
}
