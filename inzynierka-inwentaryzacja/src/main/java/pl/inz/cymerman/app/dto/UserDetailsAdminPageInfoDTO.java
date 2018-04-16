package pl.inz.cymerman.app.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsAdminPageInfoDTO {
	private Long id;
	private String fullName;
	private Set<RoleDTO> roles;
	private DepartmentNameOnlyDTO department;
}
