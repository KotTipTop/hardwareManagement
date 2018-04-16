package pl.inz.cymerman.app.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.inz.cymerman.app.converter.ObjectConverter;
import pl.inz.cymerman.app.dto.CategoryNameOnlyDTO;
import pl.inz.cymerman.app.dto.EquipmentAddFormDTO;
import pl.inz.cymerman.app.dto.EquipmentViewDetailsDTO;
import pl.inz.cymerman.app.dto.EquipmentTableViewDTO;
import pl.inz.cymerman.app.dto.LocationNameOnlyDTO;
import pl.inz.cymerman.app.dto.OwnershipEquipmentHistoryDetailsDTO;
import pl.inz.cymerman.app.dto.ProjectNameOnlyDTO;
import pl.inz.cymerman.app.dto.UserDetailsAdminPageInfoDTO;
import pl.inz.cymerman.app.dto.UserNameOnlyDTO;
import pl.inz.cymerman.app.model.Category;
import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.service.CategoryService;
import pl.inz.cymerman.app.service.EquipmentService;
import pl.inz.cymerman.app.service.LocationService;
import pl.inz.cymerman.app.service.ProjectService;
import pl.inz.cymerman.app.service.UserService;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	private final EquipmentService equipmentService;
	private final ObjectConverter converter;
	private final CategoryService categoryService;
	private final UserService userService;
	private final ProjectService projectService;
	private final LocationService locationService;
	
	@Autowired
	public EquipmentController(EquipmentService equipmentService, ObjectConverter converter, CategoryService categoryService,
			UserService userService, ProjectService projectService, LocationService locationService) {
		this.equipmentService = equipmentService;
		this.converter = converter;
		this.categoryService = categoryService;
		this.userService = userService;
		this.projectService = projectService;
		this.locationService = locationService;
	}
	@GetMapping("/")
	public String enter(ModelMap model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userList", converter.convertAll(userService.findAll(), UserNameOnlyDTO.class));
	    model.addAttribute("userLoggedIn", converter.convert(userService.findOne(user.getId()), UserDetailsAdminPageInfoDTO.class));
		model.addAttribute("categoryList", converter.convertAll(categoryService.findAll(), CategoryNameOnlyDTO.class));
		model.addAttribute("equipmentList", converter.convertAll(equipmentService.findAll(), EquipmentTableViewDTO.class));
		model.addAttribute("projectList", converter.convertAll(projectService.findAll(), ProjectNameOnlyDTO.class));
		model.addAttribute("locationList", converter.convertAll(locationService.findAll(), LocationNameOnlyDTO.class));	
		
		return "EquipmentTableViewAdminPage";
	}
	@PostMapping("/edit")
	public String edit(ModelMap model, @ModelAttribute EquipmentViewDetailsDTO equipment) {
		model.addAttribute("projectList", converter.convertAll(projectService.findAll(), ProjectNameOnlyDTO.class));
		model.addAttribute("locationList", converter.convertAll(locationService.findAll(), LocationNameOnlyDTO.class));
		model.addAttribute("categoryList", converter.convertAll(categoryService.findAll(), CategoryNameOnlyDTO.class));
		Equipment e = equipmentService.findOne(equipment.getId());
		Category c = categoryService.findOne(equipment.getCategoryName().getId());
		e.setCategory(c);
		e.setManufacturer(equipment.getManufacturer());
		e.setModel(equipment.getModel());
		e.setDateOfPurchase(equipment.getDateOfPurchase());
		e.setSerialNumber(equipment.getSerialNumber());
		e.setSoftware(equipment.getSoftware());
		e.setTechnicalParameters(equipment.getTechnicalParameters());
		e.setPeripherials(equipment.getPeripherials());
		e.setPrice(equipment.getPrice());
		e.setWarranty(equipment.getWarranty());
		e.setProject(projectService.findOne(equipment.getProject().getId()));
		e.setLocation(locationService.findOne(equipment.getLocation().getId()));
		equipmentService.save(e);
		return "redirect:/equipment/details?id="+e.getId();
	}
	@GetMapping("/details")
	public String details(ModelMap model,Long id) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("projectList", converter.convertAll(projectService.findAll(), ProjectNameOnlyDTO.class));
		model.addAttribute("locationList", converter.convertAll(locationService.findAll(), LocationNameOnlyDTO.class));
	    model.addAttribute("userLoggedIn", converter.convert(userService.findOne(user.getId()), UserDetailsAdminPageInfoDTO.class));
		model.addAttribute("categoryList", converter.convertAll(categoryService.findAll(), CategoryNameOnlyDTO.class));
		model.addAttribute("equipmentDetails",converter.convert(equipmentService.findOne(id), EquipmentViewDetailsDTO.class));
		model.addAttribute("currentEquipmentHistory",converter.convertAll(equipmentService.findOne(id).getHistory().stream().collect(Collectors.toList()), OwnershipEquipmentHistoryDetailsDTO.class));
		return "EquipmentDetailsPage";
	}
	@PostMapping("/add")
	public String add(ModelMap model, @ModelAttribute("AddNewModal") EquipmentAddFormDTO e) {
		Equipment equipment = converter.convert(e, Equipment.class);
		equipmentService.save(equipment);
		return "redirect:/equipment/";
	}

	
}
