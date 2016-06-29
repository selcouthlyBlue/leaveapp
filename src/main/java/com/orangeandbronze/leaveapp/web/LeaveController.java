package com.orangeandbronze.leaveapp.web;

import java.text.ParseException;
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

	@RequestMapping("/apply_leave")
	public ModelAndView applyLeave() {

		ModelAndView model = new ModelAndView("apply_leave");

		return model;
	}
	@RequestMapping(value = "/submit_leave_application", method = RequestMethod.POST)
	public String applyLeave(@RequestParam Map<String, String> reqParam, Model model) throws ParseException {
		//Employee employee = employeeRepository.findBy(
		//		Integer.parseInt(reqParam.map("employeeId")));
		//Supervisor approver = (Supervisor) employeeRepository.findBy(
		//		Integer.parseInt(reqParam.map("approverId")));
		reqParam.get();
		Employee employee = new Employee();
		Supervisor approver = new Supervisor();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd");
		Date start = simpleDateFormat.parse(reqParam.map("startDate"));
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(start);
		Date end = simpleDateFormat.parse(reqParam.map("startDate"));
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(end);
		//LeaveApplication leaveApplication = employee.fileLeave(startDate, endDate, reqParam.map("approverId"), approver);
		LeaveType leaveType = LeaveType.EMERGENCY_LEAVE;
		LeaveApplication leaveApplication = new LeaveApplication(startDate, endDate, leaveType, employee, approver);
		model.addAttribute("leaveApplication", leaveApplication);
		//model.addAttribute("leaveApplication", leaveApplication);

		return "leave_history";
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("view_leave_history");
	}
}