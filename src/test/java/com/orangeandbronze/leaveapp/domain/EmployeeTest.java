package com.orangeandbronze.leaveapp.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	
	private Employee filer;
	private Employee supervisor;
	private Employee admin;
	private LeaveApplication leaveApplication; 
	private LeaveApplication newLeaveApplication;
	
	@Before
	public void setUp() {
		filer = new Employee();
		supervisor = new Employee();
		admin = new Employee();
		Calendar startDate = new GregorianCalendar(2016,11,5);
		Calendar endDate = new GregorianCalendar(2016,11,12);
		newLeaveApplication = filer.fileLeave(startDate, endDate, LeaveType.SICK_LEAVE);
	}

	@Test
	public void employeeFilesALeave() {
		assertTrue("Leave of filer should appear "
				+ "in leave employee's leave history.", 
				filer.getLeaveHistory().contains(newLeaveApplication));
	}
	
	@Test
	public void employeeCancelsALeave() throws Exception {
		filer.cancel(newLeaveApplication);
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
		 GregorianCalendar startDate = new GregorianCalendar(2015, 1, 6);
		 GregorianCalendar endDate = new GregorianCalendar(2015, 1, 8);
		 Employee supervisor = new Employee();
		 LeaveApplication leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.PENDING);
		 supervisor.approve(leaveApplication);
		 
		 assertEquals(LeaveStatus.SUPERVISOR_APPROVED, leaveApplication.getStatus());
	 }
	 
	 @Test
	 public void approveLeaveApplicationByAdmin() {
		 GregorianCalendar startDate = new GregorianCalendar(2015, 1, 6);
		 GregorianCalendar endDate = new GregorianCalendar(2015, 1, 8);
		 Employee admin = new Employee();
		 LeaveApplication leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.SUPERVISOR_APPROVED);
		 admin.approve(leaveApplication);
		 
		 assertEquals(LeaveStatus.ADMIN_APPROVED, leaveApplication.getStatus());
	 }
	 
	 @Test
	 public void disapproveLeaveApplicationBySupervisor() {
		 GregorianCalendar startDate = new GregorianCalendar(2015, 1, 6);
		 GregorianCalendar endDate = new GregorianCalendar(2015, 1, 8);
		 Employee supervisor = new Employee();
		 LeaveApplication leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.PENDING);
		 supervisor.disapprove(leaveApplication);
		 
		 assertEquals(LeaveStatus.SUPERVISOR_DISAPPROVED, leaveApplication.getStatus());
	 }
	 
	 @Test
	 public void disapproveLeaveApplicationByAdmin() {
		 GregorianCalendar startDate = new GregorianCalendar(2015, 1, 6);
		 GregorianCalendar endDate = new GregorianCalendar(2015, 1, 8);
		 Employee admin = new Employee();
		 LeaveApplication leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.SUPERVISOR_APPROVED);
		 admin.disapprove(leaveApplication);
		 
		 assertEquals(LeaveStatus.ADMIN_DISAPPROVED, leaveApplication.getStatus());
	 }
	 
	 @Test
	 public void changeLeaveApplicationToNotTakenByAdmin() {
		 GregorianCalendar startDate = new GregorianCalendar(2015, 1, 6);
		 GregorianCalendar endDate = new GregorianCalendar(2015, 1, 8);
		 Employee admin = new Employee();
		 LeaveApplication leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.ADMIN_APPROVED);
		 admin.changeToNotTaken(leaveApplication);
		 
		 assertEquals(LeaveStatus.NOT_TAKEN, leaveApplication.getStatus());
	 }
	 
	 @Test
	 public void resetLeavePointsToZero() {
		 Employee regular = new Employee();
		 regular.resetLeaveCredits();
		 
		 assertTrue(3.75 == regular.getSickLeaveCredits());
		 assertTrue(3.75 == regular.getVacationLeaveCredits());
		 assertTrue(3.00 == regular.getEmergencyLeaveCredits());
	 }
	 
	 @Test
	 public void incrementLeavePointOfEmployee() {
		 Employee regular = new Employee();
		 regular.gainLeavePoints();

		 assertTrue(1.25 == regular.getSickLeaveCredits());
		 assertTrue(1.25 == regular.getVacationLeaveCredits());
	 }
	 
	 @Test
	 public void incrementLeavePointOfEmployeeButHasReachedMaximum() {
		 Employee regular = new Employee();
		 regular.setSickLeaveCredits(LeaveType.SICK_LEAVE.getMaxValue());
		 regular.setEmergencyLeaveCredits(LeaveType.EMERGENCY_LEAVE.getMaxValue());
		 regular.setVacationLeaveCredits(LeaveType.VACATION_LEAVE.getMaxValue());
		 regular.gainLeavePoints();
		 
		 assertTrue(15.0 == regular.getSickLeaveCredits());
		 assertTrue(15.0 == regular.getVacationLeaveCredits());
		 assertTrue(3.0 == regular.getEmergencyLeaveCredits());
	 }

}
