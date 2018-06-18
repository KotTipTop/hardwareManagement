package pl.kurs.java.model.chart;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Chart {
	private boolean animationEnabled;
	private Axis axisY;
	private Axis axisX;
	private List<ChartData> data;
}
