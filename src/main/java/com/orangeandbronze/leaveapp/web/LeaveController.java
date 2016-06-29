package com.orangeandbronze.leaveapp.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.orangeandbronze.leaveapp.repository.*;
import com.sun.javafx.collections.MappingChange.Map;
import com.orangeandbronze.leaveapp.domain.*;

@Controller
public class LeaveController{

	EmployeeRepository employeeRepository;
	LeaveApplicationRepository leaveApplicationRepository;

	/*@Autowired
	public LeaveController(EmployeeRepository employeeRepository, LeaveApplicationRepository leaveApplicationRepository) {
		this.employeeRepository = employeeRepository;
		this.leaveApplicationRepository = leaveApplicationRepository;
	}*/

	@RequestMapping("/view_all_leave_histories")
	public ModelAndView showAllLeaveHistories() {

		ModelAndView model = new ModelAndView("leave_list");

		return model;
	}

	@RequestMapping("/view_leave_history")
	public ModelAndView showOwnLeaveHistory() {

		ModelAndView model = new ModelAndView("leave_history");

		return model;
	}

	/*@RequestMapping("/apply_leave")
	public ModelAndView applyLeave() {

		ModelAndView model = new ModelAndView("apply_leave");

		return model;
	}*/
	@RequestMapping(value = "/apply_leave", method = RequestMethod.POST)
	public String applyLeave(@RequestParam Map<String, String> reqParam, Model model) {
		Employee employee = employeeRepository.findBy(
				Integer.parseInt(reqParam.map("employeeId")));
		Supervisor approver = (Supervisor) employeeRepository.findBy(
				Integer.parseInt(reqParam.map("approverId")));
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(string);
		Date start = simpleDateFormat.parse(reqParam.map("startDate"));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		LeaveApplication leaveApplication = employee.fileLeave(startDate, endDate, reqParam.map("approverId"), approver);

		model.addAttribute("employee", employee);
		model.addAttribute("leaveApplication", leaveApplication);

		return "apply_leave";
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("view_leave_history");
	}
}