package pl.inz.cymerman.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.inz.cymerman.app.converter.ObjectConverter;
import pl.inz.cymerman.app.dto.UserDetailsAdminPageInfoDTO;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.service.EquipmentService;
import pl.inz.cymerman.app.service.UserService;

@Controller
@RequestMapping("/index")
public class IndexController {
	private final EquipmentService equipmentService;
	private final ObjectConverter converter;
	private final UserService userService;

	@Autowired
	public IndexController(EquipmentService equipmentService, ObjectConverter converter, UserService userService) {
		this.equipmentService = equipmentService;
		this.converter = converter;
		this.userService = userService;
	}

	@GetMapping("/")
	public String enter(ModelMap model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 model.addAttribute("userLoggedIn", converter.convert(userService.findOne(user.getId()), UserDetailsAdminPageInfoDTO.class));
		 model.addAttribute("numberOfLaptops", equipmentService.countForUserByCategoryName(user.getId(), "laptop"));
		 model.addAttribute("numberOfTablets", equipmentService.countForUserByCategoryName(user.getId(), "tablet"));
		return "IndexPage";
	   
		
	}

}
