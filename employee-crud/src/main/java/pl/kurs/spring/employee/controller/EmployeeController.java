package pl.kurs.spring.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.kurs.spring.converter.ObjectConverter;
import pl.kurs.spring.employee.command.EmployeeAddCommand;
import pl.kurs.spring.employee.command.EmployeeEditCommand;
import pl.kurs.spring.employee.dto.EmployeeDTO;
import pl.kurs.spring.employee.exception.EmployeeNotFoundException;
import pl.kurs.spring.employee.exception.EquipmentNotFoundException;
import pl.kurs.spring.employee.exception.OwnershipNotFoundException;
import pl.kurs.spring.employee.model.Employee;
import pl.kurs.spring.employee.model.Equipment;
import pl.kurs.spring.employee.service.EmployeeService;
import pl.kurs.spring.employee.service.EquipmentService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	private final ObjectConverter objectConverter;
	private final EquipmentService equipmentService;

	@Autowired
	public EmployeeController(EmployeeService employeeService, ObjectConverter objectConverter, EquipmentService equipmentService) {
		this.employeeService = employeeService;
		this.objectConverter = objectConverter;
		this.equipmentService = equipmentService;
	}

	@GetMapping("/")
	public ResponseEntity<Page<EmployeeDTO>> getEmployees(@PageableDefault(size = 3, page = 0) Pageable pageable,
			@RequestParam(value = "q", required = false) String query) {
		return new ResponseEntity<Page<EmployeeDTO>>(
				employeeService.findAllAcitves(pageable, query).map(e -> objectConverter.convert(e, EmployeeDTO.class)), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id) {
		return new ResponseEntity<EmployeeDTO>(objectConverter.convert(employeeService.findOneActive(id) //
				.orElseThrow(() -> new EmployeeNotFoundException(id)), EmployeeDTO.class), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long id) {
		employeeService.findOne(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		employeeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/")
	public ResponseEntity<EmployeeDTO> save(@RequestBody @Valid EmployeeAddCommand addCommand) {
		Employee employee = objectConverter.convert(addCommand, Employee.class);
		Employee saved = employeeService.save(employee);
		return new ResponseEntity<EmployeeDTO>(objectConverter.convert(saved, EmployeeDTO.class), HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<EmployeeDTO> editEmployee(@RequestBody @Valid EmployeeEditCommand editCommand) {
		Employee employee = objectConverter.convert(editCommand, Employee.class);
		Employee saved = employeeService.save(employee);
		return new ResponseEntity<EmployeeDTO>(objectConverter.convert(saved, EmployeeDTO.class), HttpStatus.OK);

	}

	@PutMapping("/{employeeId}/addEquipment/{equipmentId}")
	public ResponseEntity<EmployeeDTO> addEquipmentToUser(@PathVariable("employeeId") Long employeeId,
			@PathVariable("equipmentId") Long equipmentId) {

		Employee emp = employeeService.findOne(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		Equipment e = equipmentService.findOne(equipmentId).orElseThrow(() -> new EquipmentNotFoundException(equipmentId));
		emp.addEquipment(e);
		Employee saved = employeeService.save(emp);
		return new ResponseEntity<EmployeeDTO>(objectConverter.convert(saved, EmployeeDTO.class), HttpStatus.OK);

	}

	@DeleteMapping("/{employeeId}/removeEquipment/{equipmentId}")
	public ResponseEntity<EmployeeDTO> deleteEquipmentFromUser(@PathVariable("employeeId") Long employeeId,
			@PathVariable("equipmentId") Long equipmentId) {
		Employee emp = employeeService.findOne(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
		Equipment e = equipmentService.findOne(equipmentId).orElseThrow(() -> new EquipmentNotFoundException(equipmentId));

		if (!emp.removeEquipment(e)) {
			new OwnershipNotFoundException(e.getId());
		}

		Employee saved = employeeService.save(emp);
		return new ResponseEntity<EmployeeDTO>(objectConverter.convert(saved, EmployeeDTO.class), HttpStatus.OK);

	}
}
