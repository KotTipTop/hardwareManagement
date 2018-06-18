package pl.kurs.java.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.kurs.java.controller.chart.ChartGenerator;
import pl.kurs.java.model.Employee;
import pl.kurs.java.model.chart.Chart;
import pl.kurs.java.service.ChartService;

@Service
public class ChartServiceImpl implements ChartService {

	private final Map<String, ChartGenerator> chartGenerators;
	private final Set<ChartGenerator> generators;

	public ChartServiceImpl(Set<ChartGenerator> generators) {
		this.generators = generators;
		this.chartGenerators = generators.stream().collect(Collectors.toMap(ChartGenerator::getName, Function.identity()));
	}

	@Override
	public Chart generateChart(List<Employee> employees, String chartName) {
		return chartGenerators.get(chartName).create(employees);
	}

	@Override
	public Set<ChartGenerator> getAllGenerators() {
		return generators;
	}
}
