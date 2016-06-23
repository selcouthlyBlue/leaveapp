package com.orangeandbronze.leaveapp.domain;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class LeaveFilingTest {
	
	private Employee employee;
	private LeaveApplication newLeaveApplication;
	
	@Before
	public void setUp(){
		employee = generateEmployee();
		Calendar startDate = new GregorianCalendar(2016,11,2);
		Calendar endDate = new GregorianCalendar(2016,11,5);
		Employee supervisor = generateEmployee();
		newLeaveApplication = employee.fileLeave(startDate, endDate, LeaveType.SICK_LEAVE, supervisor);
	}

	private Employee generateEmployee() {
		return new Employee();
	}

	@Test
	public void employeeFilesALeave() {
		assertTrue("Employee's leave history should be updated upon filing a leave.", 
				employee.hasInLeaveHistoryA(newLeaveApplication));
	}
	
	@Test
	public void leaveFiledByAnEmployeeShouldBeInPendingStatus() throws Exception {
		assertTrue("Leave application status of a newly applied leave should be pending.", 
				newLeaveApplication.getStatus() == LeaveStatus.PENDING);
	}
	
	@Test
	public void employeeCancelsALeave() throws Exception {
		employee.cancel(newLeaveApplication);
		assertTrue("Leave Application status should be " 
				+ LeaveStatus.CANCELLED + "when the filer"
						+ " cancels the leave",
						newLeaveApplication.getStatus() == LeaveStatus.CANCELLED);
	}

}
