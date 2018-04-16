package pl.inz.cymerman.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.inz.cymerman.app.converter.ObjectConverter;
import pl.inz.cymerman.app.dto.EquipmentTableViewDTO;
import pl.inz.cymerman.app.dto.UserDetailsAdminPageInfoDTO;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.service.EquipmentService;
import pl.inz.cymerman.app.service.UserService;

@Controller
@RequestMapping("/equipmentDetails")
public class EquipmentDetailsController {
	private final EquipmentService equipmentService;
	private final ObjectConverter converter;
	private final UserService userService;
	
	@Autowired
	public EquipmentDetailsController(EquipmentService equipmentService, ObjectConverter converter, UserService userService) {
		this.equipmentService = equipmentService;
		this.converter = converter;
		this.userService = userService;
	}
	@GetMapping("/category")
	public String detailsComputer(@RequestParam("categoryName") String categoryName,ModelMap model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userLoggedIn", converter.convert(userService.findOne(user.getId()), UserDetailsAdminPageInfoDTO.class));
		model.addAttribute("equipmentByUser", converter.convertAll(equipmentService.EquipmentForUserByCategoryName(user.getId(), categoryName), EquipmentTableViewDTO.class));
		return "EquipmentbyUserIdAndCategoryDetails";
	}
	
	
	
}
