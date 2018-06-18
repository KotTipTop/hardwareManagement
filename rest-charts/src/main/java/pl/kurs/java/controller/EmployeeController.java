package pl.kurs.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kurs.java.model.Employee;
import pl.kurs.java.service.ChartService;
import pl.kurs.java.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	private final ChartService chartService;
	

	public EmployeeController(EmployeeService employeeService, ChartService chartService) {
		this.employeeService = employeeService;
		this.chartService = chartService;
	}

	@GetMapping("/")
	public String enter(ModelMap model) {
		model.addAttribute("employeeList", employeeService.findAll());
		model.addAttribute("generators", chartService.getAllGenerators());
		return "EmployeePage";
	}
	
	@PostMapping("/add")
	public String add(ModelMap model, @ModelAttribute Employee e) {
		employeeService.save(e);
		return "redirect:/employee/";
	}
}
