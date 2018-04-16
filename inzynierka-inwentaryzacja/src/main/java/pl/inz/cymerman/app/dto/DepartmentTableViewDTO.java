package pl.inz.cymerman.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentTableViewDTO {
private Long id;
private String Name;
private Long numberOfWorkers;
}
