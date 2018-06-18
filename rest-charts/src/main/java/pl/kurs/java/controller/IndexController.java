package pl.kurs.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class IndexController {

	@GetMapping("/")
	public String enter() {
		
		return "chartsViewPage";
	}
}
