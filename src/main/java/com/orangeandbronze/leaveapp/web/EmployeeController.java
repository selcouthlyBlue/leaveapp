package com.orangeandbronze.leaveapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController{
	
	@RequestMapping("/add_employee")
	public ModelAndView addEmployee() {
		
		ModelAndView model = new ModelAndView("add_employee");
		
		return model;
	}
	
	@RequestMapping("/view_all_employees")
	public ModelAndView viewAllEmployees() {
		
		ModelAndView model = new ModelAndView("employee_list");
		
		return model;
	}
	
}