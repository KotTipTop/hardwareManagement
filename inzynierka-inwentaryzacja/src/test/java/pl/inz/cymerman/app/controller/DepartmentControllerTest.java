package pl.inz.cymerman.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.inz.cymerman.app.converter.ObjectConverter;
import pl.inz.cymerman.app.dto.DepartmentTableViewDTO;
import pl.inz.cymerman.app.dto.DepartmentViewDetailsDTO;
import pl.inz.cymerman.app.dto.UserDetailsAdminPageInfoDTO;
import pl.inz.cymerman.app.dto.UserViewDetailsDTO;
import pl.inz.cymerman.app.model.Department;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.service.DepartmentService;
import pl.inz.cymerman.app.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DepartmentControllerTest.DepartmentControllerTestConfiguration.class)
@WebAppConfiguration
public class DepartmentControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private UserService mockUserService;
	@Autowired
	private DepartmentService mockDepartmentService;
	@Autowired
	private ObjectConverter mockObjectConverter;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		Authentication authentication = Mockito.mock(Authentication.class);
		Mockito.when(authentication.getPrincipal()).thenReturn(User.builder().id(100L).build());
		SecurityContext securityContext = Mockito.mock(SecurityContext.class);
		Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
		SecurityContextHolder.setContext(securityContext);

	}

	// redirect i post
	
	//add
	@Test
	public void shouldGetDepartmentsPageWithAddedNewDepartment() throws Exception {
		mockMvc.perform(post("/departments/add?name=ST"))//
				.andExpect(status().is3xxRedirection())//
				.andExpect(redirectedUrl("/departments/"));//
	}

	//enter
	@Test
	public void shouldGetDepartmentListandUserLoggedIn() throws Exception {
		//mocks
		List<Department> departments = Arrays.asList(Department.builder().id(10L).name("ST").build(), //
				Department.builder().id(11L).name("DO").build()//
		);
		Mockito.when(mockDepartmentService.findAll()).thenReturn(departments);
		User u = User.builder().id(100L).build();
		Mockito.when(mockUserService.findOne(u.getId())).thenReturn(u);

		Mockito.when(mockObjectConverter.convert(u, UserDetailsAdminPageInfoDTO.class))
				.thenReturn(UserDetailsAdminPageInfoDTO.builder().id(u.getId()).build());
		Mockito.when(mockObjectConverter.convertAll(departments, DepartmentTableViewDTO.class))//
				.thenReturn(Arrays.asList(DepartmentTableViewDTO.builder().id(100L).build(), //
						DepartmentTableViewDTO.builder().id(101L).build()));
		//assert
		mockMvc.perform(get("/departments/"))//
				.andExpect(status().isOk())
				.andExpect(model().attribute("userLoggedIn", UserDetailsAdminPageInfoDTO.builder().id(u.getId()).build()))
				.andExpect(model().attribute("departmentList", Arrays.asList(DepartmentTableViewDTO.builder().id(100L).build(), //
						DepartmentTableViewDTO.builder().id(101L).build())));//
	}
	//detail
	@Test
	public void shouldGetDepartmentDetail() throws Exception {
		Department d = Department.builder().id(101L).build();
		User u = User.builder().id(100L).build();
		Mockito.when(mockDepartmentService.findOne(d.getId())).thenReturn(d);
		Mockito.when(mockObjectConverter.convert(d, DepartmentViewDetailsDTO.class))
		.thenReturn(DepartmentViewDetailsDTO.builder().id(d.getId()).build());
		Mockito.when(mockObjectConverter.convert(u, UserDetailsAdminPageInfoDTO.class))
		.thenReturn(UserDetailsAdminPageInfoDTO.builder().id(u.getId()).build());
		Mockito.when(mockObjectConverter.convertAll(mockDepartmentService.findOne(d.getId()).getWorkers().stream().collect(Collectors.toList()), UserViewDetailsDTO.class))
		.thenReturn(Arrays.asList());
		
		//MockMVC
		mockMvc.perform(get("/details"))//
		.andExpect(status().isOk());//
	}

	@Configuration
	@EnableWebMvc
	public static class DepartmentControllerTestConfiguration extends WebMvcConfigurerAdapter {
		@Bean
		public DepartmentController departmentController() {
			return new DepartmentController(mockDepartmentService(), mockObjectConverter(), mockUserService());
		}

		@Bean
		public UserService mockUserService() {
			return Mockito.mock(UserService.class);
		}

		@Bean
		public DepartmentService mockDepartmentService() {
			return Mockito.mock(DepartmentService.class);
		}

		@Bean
		public ObjectConverter mockObjectConverter() {
			return Mockito.mock(ObjectConverter.class);
		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		}

		@Bean
		public ViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}
	}
}
