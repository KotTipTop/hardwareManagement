package pl.inz.cymerman.app.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTableViewDTO {
private Long id;
private String fullName;
private String phoneNumber;
private String email;
private DepartmentNameOnlyDTO departmentName;
}
