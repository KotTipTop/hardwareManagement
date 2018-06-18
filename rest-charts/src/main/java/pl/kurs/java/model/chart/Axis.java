package pl.kurs.java.model.chart;

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
public class Axis {
	private String title;
	private String suffix;
	private boolean includingZero;
}
