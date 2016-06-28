package com.orangeandbronze.leaveapp.service;

import java.util.Collection;

import com.orangeandbronze.leaveapp.domain.*;
import com.orangeandbronze.leaveapp.repository.*;

public class EmployeeService {
	EmployeeRepository employeeDao;
	LeaveApplicationRepository leaveApplicationDao;

	public void fileLeave(int employeeId) {
		Employee employee = employeeDao.findBy(employeeId);
		//LeaveApplication leaveApplication =  employee.fileLeave(startDate, endDate, leaveType, approver); 
		//TODO: finalize fileLeave parameters
		//leaveApplicationDao.create(leaveApplication);
	}

	public void cancelLeaveApplication(int employeeId, int leaveId) {
		Employee employee = employeeDao.findBy(employeeId);
		LeaveApplication leaveApplication = leaveApplicationDao.findBy(leaveId);
		employee.cancel(leaveApplication);
		leaveApplicationDao.updateLeaveStatus(leaveApplication);
	}

	public void approveLeaveApplication(int approverId, int leaveId) {
		Employee approver = employeeDao.findBy(approverId);
		LeaveApplication leaveApplication = leaveApplicationDao.findBy(leaveId);
		approver.approve(leaveApplication);
		leaveApplicationDao.updateLeaveStatus(leaveApplication);
	}

	public void disapproveLeaveApplication(int approverId, int leaveId) {
		Employee approver = employeeDao.findBy(approverId);
		LeaveApplication leaveApplication = leaveApplicationDao.findBy(leaveId);
		approver.disapprove(leaveApplication);
		leaveApplicationDao.updateLeaveStatus(leaveApplication);
	}

	public void changeLeaveApplicationToNotTaken(int approverId, int leaveId) {
		Employee approver = employeeDao.findBy(approverId);
		LeaveApplication leaveApplication = leaveApplicationDao.findBy(leaveId);
		approver.changeToNotTaken(leaveApplication);
		leaveApplicationDao.updateLeaveStatus(leaveApplication);
	}

	public void findLeaveApplicationsForSupervisor(int supervisorId) {
		//Employee supervisor = employeeDao.findBy(supervisorId);
		Collection<LeaveApplication> leaveApplications = leaveApplicationDao.findLeaveApplicationsForSupervisor(supervisorId);
	}

	public void createEmployee() {
		Employee employee = new Employee(); //TODO: finalize Employee parameters
		employeeDao.create(employee);
	}


}
