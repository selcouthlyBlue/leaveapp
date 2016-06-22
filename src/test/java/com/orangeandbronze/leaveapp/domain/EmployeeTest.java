package com.orangeandbronze.leaveapp.domain;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	
	private Employee filer;
	private Employee supervisor;
	private Employee admin;
	private LeaveApplication newLeaveApplication;
	
	@Before
	public void setUp() {
		filer = new Employee();
		supervisor = new Employee();
		admin = new Employee();
		Calendar startDate = new GregorianCalendar(2016,11,5);
		Calendar endDate = new GregorianCalendar(2016,11,12);
		LeaveType leaveType = LeaveType.SL;
		newLeaveApplication = filer.fileLeave(startDate, endDate, leaveType);
	}

	@Test
	public void employeeFilesALeave() {
		assertTrue("Leave of filer should appear "
				+ "in leave employee's leave history.", 
				filer.getLeaveHistory().contains(newLeaveApplication));
	}
	
	@Test
	public void employeeCancelsALeave() throws Exception {
		filer.cancelLeave(newLeaveApplication);
		assertTrue("Leave Application status should be " 
				+ LeaveStatus.CANCELLED + "when the filer"
						+ " cancels the leave",
						newLeaveApplication.getStatus() == LeaveStatus.CANCELLED);
	}
	
	@Test
	public void supervisorApprovesALeaveApplicationOfAnEmployee() 
			throws Exception {
		supervisor.approveLeave(newLeaveApplication);
		assertTrue("Leave Application status should be " 
				+ LeaveStatus.SUPERVISOR_APPROVED + " when "
						+ "the supervisor approves the leave.", 
						newLeaveApplication.getStatus() == LeaveStatus.SUPERVISOR_APPROVED);
	}
	
	@Test
	public void adminApprovesALeaveApplicationApprovedByASupervisor() throws Exception {
		supervisor.approveLeave(newLeaveApplication);
		admin.approveLeave(newLeaveApplication);
		assertTrue("Leave Application status should be " 
				+ LeaveStatus.ADMIN_APPROVED + " when "
						+ "the admin approves the leave.", 
						newLeaveApplication.getStatus() == LeaveStatus.ADMIN_APPROVED);
	}

}
