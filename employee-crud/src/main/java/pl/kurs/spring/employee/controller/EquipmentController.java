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
import pl.kurs.spring.employee.command.EquipmentAddCommand;
import pl.kurs.spring.employee.command.EquipmentEditCommand;
import pl.kurs.spring.employee.dto.EquipmentDTO;
import pl.kurs.spring.employee.exception.EquipmentNotFoundException;
import pl.kurs.spring.employee.model.Equipment;
import pl.kurs.spring.employee.service.EquipmentService;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
	private final EquipmentService equipmentService;
	private final ObjectConverter objectConverter;

	@Autowired
	public EquipmentController(EquipmentService equipmentService, ObjectConverter objectConverter) {
		this.equipmentService = equipmentService;
		this.objectConverter = objectConverter;
	}

	@GetMapping("/")
	public ResponseEntity<Page<EquipmentDTO>> getEquipment(@RequestParam(value = "q", required = false) String query,
			@PageableDefault(size = 3, page = 0) Pageable pageable) {
		return new ResponseEntity<Page<EquipmentDTO>>(
				equipmentService.findAllAcitves(pageable,query).map(e -> objectConverter.convert(e, EquipmentDTO.class)), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EquipmentDTO> getEquipmentById(@PathVariable("id") Long id) {
		return new ResponseEntity<EquipmentDTO>(objectConverter.convert(equipmentService.findOneActive(id) //
				.orElseThrow(() -> new EquipmentNotFoundException(id)), EquipmentDTO.class), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEquipmentById(@PathVariable("id") Long id) {
		equipmentService.findOne(id).orElseThrow(() -> new EquipmentNotFoundException(id));
		equipmentService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/")
	public ResponseEntity<EquipmentDTO> save(@RequestBody @Valid EquipmentAddCommand addCommand) {
		Equipment equipment = objectConverter.convert(addCommand, Equipment.class);
		Equipment saved = equipmentService.save(equipment);
		return new ResponseEntity<EquipmentDTO>(objectConverter.convert(saved, EquipmentDTO.class), HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<EquipmentDTO> editEquipment(@RequestBody @Valid EquipmentEditCommand editCommand) {
		Equipment equipment = objectConverter.convert(editCommand, Equipment.class);
		Equipment saved = equipmentService.save(equipment);
		return new ResponseEntity<EquipmentDTO>(objectConverter.convert(saved, EquipmentDTO.class), HttpStatus.OK);

	}
}
