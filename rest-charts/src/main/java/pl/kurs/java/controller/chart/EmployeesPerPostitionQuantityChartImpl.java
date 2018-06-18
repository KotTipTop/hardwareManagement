package pl.kurs.java.controller.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.kurs.java.model.Employee;
import pl.kurs.java.model.chart.Axis;
import pl.kurs.java.model.chart.Chart;
import pl.kurs.java.model.chart.ChartData;
import pl.kurs.java.model.chart.ChartDataPoint;

@Service
public class EmployeesPerPostitionQuantityChartImpl implements ChartGenerator {

	@Override
	public Chart create(List<Employee> employees) {
		Map<String, Long> positionQuantity = employees.stream()
				.collect(Collectors.groupingBy(Employee::getPosition, Collectors.counting()));
		List<ChartDataPoint> dataPoints = new ArrayList<>();
		positionQuantity.forEach((position, qunatity) -> dataPoints.add(new ChartDataPoint(position, qunatity)));
		List<ChartData> data = Arrays.asList(new ChartData("#,##0.0#\" % \"", "column", dataPoints));
		return new Chart(true, new Axis("Ilość", "szt", true), Axis.builder().title("Stanowisko").build(), data);
	}

	@Override
	public String getName() {
		return "employeesPerPostitionQuantity";
	}

	@Override
	public String getVisibleName() {
		return "Rysuj wykres ilosc pracowników do stanowiska";
	}

}
