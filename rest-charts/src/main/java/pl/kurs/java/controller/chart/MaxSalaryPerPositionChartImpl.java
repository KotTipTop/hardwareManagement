package pl.kurs.java.controller.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.kurs.java.model.Employee;
import pl.kurs.java.model.chart.Axis;
import pl.kurs.java.model.chart.Chart;
import pl.kurs.java.model.chart.ChartData;
import pl.kurs.java.model.chart.ChartDataPoint;

@Service
public class MaxSalaryPerPositionChartImpl implements ChartGenerator {

	@Override
	public Chart create(List<Employee> employees) {
		Map<String, Optional<Employee>> maxSalary = employees.stream()
				.collect(Collectors.groupingBy(Employee::getPosition, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		List<ChartDataPoint> dataPoints = new ArrayList<>();
		maxSalary.forEach((position, employee) -> dataPoints.add(new ChartDataPoint(position, employee.get().getSalary())));
		List<ChartData> data = Arrays.asList(new ChartData("#,##0.0#\" % \"", "column", dataPoints));
		return new Chart(true, new Axis("Pensje", "PLN", true), Axis.builder().title("Stanowisko").build(), data);
	}

	@Override
	public String getName() {
		return "maxSalaryPerPosition";
	}

	@Override
	public String getVisibleName() {
		return "Rysuj wykres Stanowisko do max pensji";
	}

}
