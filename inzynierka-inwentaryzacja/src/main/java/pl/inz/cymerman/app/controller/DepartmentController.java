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
import pl.inz.cymerman.app.dto.DepartmentAddFormDTO;
import pl.inz.cymerman.app.dto.DepartmentEditFormDTO;
import pl.inz.cymerman.app.dto.DepartmentTableViewDTO;
import pl.inz.cymerman.app.dto.DepartmentViewDetailsDTO;
import pl.inz.cymerman.app.dto.UserDetailsAdminPageInfoDTO;
import pl.inz.cymerman.app.dto.UserViewDetailsDTO;
import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.service.DepartmentService;
import pl.inz.cymerman.app.service.UserService;
/*
 * Department controller for department view and tables. We have:
 * - / enter page of departmens
 * - add department, custom name, id generated
 * - edit department, simple name editor
 * - details page of every department we choose. 
 * 
 * 
 */
@Controller
@RequestMapping("/departments")
public class DepartmentController {

	private final DepartmentService departmentService;
	private final ObjectConverter converter;
	private final UserService userService;
 
	@Autowired
	public DepartmentController(DepartmentService departmentService, ObjectConverter converter, UserService userService) {
		this.departmentService = departmentService;
		this.converter = converter;
		this.userService = userService;
	}

	@PostMapping("/edit")
	public String edit(ModelMap model, @ModelAttribute DepartmentEditFormDTO department) {
		Department d = departmentService.findOne(department.getId());
		d.setName(department.getName());
		departmentService.save(d);
		return "redirect:/departments/details?id="+d.getId();
		
	}
	
	@GetMapping("/")
	public String enter(ModelMap model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("userLoggedIn", converter.convert(userService.findOne(user.getId()), UserDetailsAdminPageInfoDTO.class));
		model.addAttribute("departmentList", converter.convertAll(departmentService.findAll(), DepartmentTableViewDTO.class));
		return "DepartmentTableViewAdminPage";
	}
	@PostMapping("/add")
	public String add(ModelMap model, @ModelAttribute("AddNewModal") DepartmentAddFormDTO d) {
		Department department = converter.convert(d, Department.class);
		departmentService.save(department);
		return "redirect:/departments/";
	}
	@GetMapping("/details")
	public String details(ModelMap model,Long id) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("userLoggedIn", converter.convert(userService.findOne(user.getId()), UserDetailsAdminPageInfoDTO.class));
	    model.addAttribute("departmentDetails",converter.convert(departmentService.findOne(id), DepartmentViewDetailsDTO.class));
	    model.addAttribute("workers", converter.convertAll(departmentService.findOne(id).getWorkers().stream().collect(Collectors.toList()), UserViewDetailsDTO.class));
		return "DepartmentDetailsPage";
	}
	@GetMapping("/delete")
	public String delete(ModelMap model,Long id ) {
		departmentService.delete(id);
		return "redirect:/departments/";
	}
	@GetMapping("/active")
	public String active(ModelMap model,Long id ) {
		Department e = departmentService.findOne(id);
		e.setActive(true);
		departmentService.save(e);
		return "redirect:/departments/";
	}

}
