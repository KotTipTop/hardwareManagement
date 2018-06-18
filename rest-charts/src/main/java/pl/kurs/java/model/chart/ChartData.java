package pl.kurs.java.model.chart;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChartData {
	private String yValueFormatString;
	private String type;
	private List<ChartDataPoint> dataPoints;
}
