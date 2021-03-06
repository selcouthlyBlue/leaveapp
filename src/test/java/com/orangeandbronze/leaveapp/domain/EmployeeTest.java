package com.orangeandbronze.leaveapp.domain;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

	private Employee employee;
	private Supervisor supervisor;
	private Admin admin;
	private LeaveApplication leaveApplication; 
	private LeaveApplication newLeaveApplication;
	private Calendar startDate;
	private Calendar endDate;

	@Before
	public void setUp() {
		employee = new Employee();
		supervisor = new Supervisor();
		admin = new Admin();
		startDate = new GregorianCalendar(2016,11,5);
		endDate = new GregorianCalendar(2016,11,12);
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
	public void employeeCancelsALeave() throws Exception {
		employee.cancel(newLeaveApplication);
		assertTrue("Leave Application status should be " 
				+ LeaveStatus.CANCELLED + "when the filer"
				+ " cancels the leave",
				newLeaveApplication.getStatus() == LeaveStatus.CANCELLED);
	}

	@Test
	public void supervisorApprovesALeaveApplicationOfAnEmployee() 
			throws Exception {
		supervisor.approve(newLeaveApplication);
		assertTrue("Leave Application status should be " 
				+ LeaveStatus.SUPERVISOR_APPROVED + " when "
				+ "the supervisor approves the leave.", 
				newLeaveApplication.getStatus() == LeaveStatus.SUPERVISOR_APPROVED);
	}

	@Test
	public void adminApprovesALeaveApplicationApprovedByASupervisor() throws Exception {
		supervisor.approve(newLeaveApplication);
		admin.approve(newLeaveApplication);
		assertTrue("Leave Application status should be " 
				+ LeaveStatus.ADMIN_APPROVED + " when "
				+ "the admin approves the leave.", 
				newLeaveApplication.getStatus() == LeaveStatus.ADMIN_APPROVED);
	}

	@Test
	public void approveLeaveApplicationBySupervisor() {
		leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.PENDING, employee, supervisor);
		supervisor.approve(leaveApplication);

		assertEquals(LeaveStatus.SUPERVISOR_APPROVED, leaveApplication.getStatus());
	}

	@Test
	public void approveLeaveApplicationByAdmin() {
		leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.SUPERVISOR_APPROVED, employee, supervisor);
		admin.approve(leaveApplication);

		assertEquals(LeaveStatus.ADMIN_APPROVED, leaveApplication.getStatus());
	}

	@Test
	public void disapproveLeaveApplicationBySupervisor() {
		leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.PENDING, employee, supervisor);
		supervisor.disapprove(leaveApplication);

		assertEquals(LeaveStatus.SUPERVISOR_DISAPPROVED, leaveApplication.getStatus());
	}

	@Test
	public void disapproveLeaveApplicationByAdmin() {
		leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.SUPERVISOR_APPROVED, employee, supervisor);
		admin.disapprove(leaveApplication);

		assertEquals(LeaveStatus.ADMIN_DISAPPROVED, leaveApplication.getStatus());
	}

	@Test
	public void changeLeaveApplicationToNotTakenByAdmin() {
		leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.ADMIN_APPROVED, employee, supervisor);
		admin.changeToNotTaken(leaveApplication);
		assertEquals(LeaveStatus.NOT_TAKEN, leaveApplication.getStatus());
	}

	@Test
	public void aNonRegularEmployeeShouldHaveAProbationaryStatus() throws Exception {
		assertTrue(employee.getStatus() == EmploymentStatus.PROBATIONARY);
	}

	@Test
	public void adminRegularizingAnEmployee() throws Exception {
		admin.regularize(employee);
		assertTrue(employee.getStatus() == EmploymentStatus.REGULAR);
	}
}
