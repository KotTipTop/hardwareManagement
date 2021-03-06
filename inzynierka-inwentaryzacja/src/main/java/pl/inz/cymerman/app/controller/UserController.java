package pl.inz.cymerman.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.inz.cymerman.app.converter.ObjectConverter;
import pl.inz.cymerman.app.dto.DepartmentNameOnlyDTO;
import pl.inz.cymerman.app.dto.RoleDTO;
import pl.inz.cymerman.app.dto.UserAddFormDTO;
import pl.inz.cymerman.app.dto.UserDetailsAdminPageInfoDTO;
import pl.inz.cymerman.app.dto.UserEditFormDTO;
import pl.inz.cymerman.app.dto.UserTableViewDTO;
import pl.inz.cymerman.app.dto.UserViewDetailsDTO;
import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.model.Equipment;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.service.DepartmentService;
import pl.inz.cymerman.app.service.RoleService;
import pl.inz.cymerman.app.service.UserService;

import org.apache.commons.lang3.StringUtils;

@Controller
@RequestMapping("/employees")
public class UserController {
	private final UserService userService;
	private final ObjectConverter converter;
	private final DepartmentService departmentService;
	private final RoleService roleService;

	@Autowired
	public UserController(UserService userService, ObjectConverter converter, DepartmentService departmentService,
			RoleService roleService) {
		this.userService = userService;
		this.converter = converter;
		this.departmentService = departmentService;
		this.roleService = roleService;
	}

	@GetMapping("/")
	public String enter(ModelMap model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userLoggedIn", converter.convert(userService.findOne(user.getId()), UserDetailsAdminPageInfoDTO.class));
		model.addAttribute("employeeList", converter.convertAll(userService.findAll(), UserTableViewDTO.class));
		model.addAttribute("departmentList", converter.convertAll(departmentService.findAll(), DepartmentNameOnlyDTO.class));
		model.addAttribute("roleList", converter.convertAll(roleService.findAll(), RoleDTO.class));
		return "UserTableViewAdminPage";
	}

	@PostMapping("/add")
	public String add(ModelMap model, @ModelAttribute("AddNewModal") UserAddFormDTO e) {
		User user = converter.convert(e, User.class);
		userService.setPassword(user);
		userService.save(user);
		return "redirect:/employees/";
	}

	@GetMapping("/details")
	public String details(ModelMap model, Long id) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userLoggedIn", converter.convert(userService.findOne(user.getId()), UserDetailsAdminPageInfoDTO.class));
		model.addAttribute("departmentList", converter.convertAll(departmentService.findAll(), DepartmentNameOnlyDTO.class));
		model.addAttribute("roleList", converter.convertAll(roleService.findAll(), RoleDTO.class));
		model.addAttribute("userDetails", converter.convert(userService.findOne(id), UserViewDetailsDTO.class));
		return "UserDetailsPage";
	}

	@PostMapping("/edit")
	public String edit(ModelMap model, @ModelAttribute UserEditFormDTO user) {
		User userLoggedin = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userLoggedIn", converter.convert(userService.findOne(userLoggedin.getId()), UserDetailsAdminPageInfoDTO.class));
		model.addAttribute("departmentList", converter.convertAll(departmentService.findAll(), DepartmentNameOnlyDTO.class));
		model.addAttribute("roleList", converter.convertAll(roleService.findAll(), RoleDTO.class));
		User u = userService.findOne(user.getId());
		Department d = departmentService.findOne(user.getDepartmentId());
		userService.editUserDetails(user, u, d);
		userService.save(u);
		return "redirect:/employees/details?id=" + u.getId();
	}

	@GetMapping("/reset")
	public String reset(ModelMap model, Long id) {
		Boolean b = false;
		User user = userService.findOne(id);
		String nameLowCase = StringUtils.stripAccents(user.getName().toLowerCase());
		user.setPassword(new BCryptPasswordEncoder().encode(nameLowCase));
		b = true;
		model.addAttribute("info", b);
		return "redirect:/employees/details?id=" + user.getId();
	}
	@GetMapping("/delete")
	public String delete(ModelMap model,Long id ) {
		userService.delete(id);
		return "redirect:/employees/";
	}
	@GetMapping("/active")
	public String active(ModelMap model,Long id ) {
		User e = userService.findOne(id);
		e.setActive(true);
		userService.save(e);
		return "redirect:/employees/";
	}
}
