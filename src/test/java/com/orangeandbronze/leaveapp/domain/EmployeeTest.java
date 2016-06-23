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
	private Calendar startDate;
	private Calendar endDate;
	
	@Before
	public void setUp() {
		filer = new Employee();
		supervisor = new Employee();
		admin = new Employee();
		startDate = new GregorianCalendar(2016,11,5);
		endDate = new GregorianCalendar(2016,11,12);
		newLeaveApplication = filer.fileLeave(startDate, endDate, LeaveType.SICK_LEAVE, supervisor);
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
		 leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.PENDING, filer, supervisor);
		 supervisor.approve(leaveApplication);
		 
		 assertEquals(LeaveStatus.SUPERVISOR_APPROVED, leaveApplication.getStatus());
	 }
	 
	 @Test
	 public void approveLeaveApplicationByAdmin() {
		 leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.SUPERVISOR_APPROVED, filer, supervisor);
		 admin.approve(leaveApplication);
		 
		 assertEquals(LeaveStatus.ADMIN_APPROVED, leaveApplication.getStatus());
	 }
	 
	 @Test
	 public void disapproveLeaveApplicationBySupervisor() {
		 leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.PENDING, filer, supervisor);
		 supervisor.disapprove(leaveApplication);
		 
		 assertEquals(LeaveStatus.SUPERVISOR_DISAPPROVED, leaveApplication.getStatus());
	 }
	 
	 @Test
	 public void disapproveLeaveApplicationByAdmin() {
		 leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.SUPERVISOR_APPROVED, filer, supervisor);
		 admin.disapprove(leaveApplication);
		 
		 assertEquals(LeaveStatus.ADMIN_DISAPPROVED, leaveApplication.getStatus());
	 }
	 
	 @Test
	 public void changeLeaveApplicationToNotTakenByAdmin() {
		 leaveApplication = new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, LeaveStatus.ADMIN_APPROVED, filer, supervisor);
		 admin.changeToNotTaken(leaveApplication);
		 
		 assertEquals(LeaveStatus.NOT_TAKEN, leaveApplication.getStatus());
	 }
	 
	 @Test
	 public void resetLeavePointsToZero() {
		 filer.resetLeaveCredits();
		 
		 assertTrue(3.75 == filer.getSickLeaveCredits());
		 assertTrue(3.75 == filer.getVacationLeaveCredits());
		 assertTrue(3.00 == filer.getEmergencyLeaveCredits());
	 }
	 
	 @Test
	 public void incrementLeavePointOfEmployee() {
		 filer.gainLeavePoints();

		 assertTrue(1.25 == filer.getSickLeaveCredits());
		 assertTrue(1.25 == filer.getVacationLeaveCredits());
	 }
	 
	 @Test
	 public void incrementLeavePointOfEmployeeButHasReachedMaximum() {
		 filer.setSickLeaveCredits(LeaveType.SICK_LEAVE.getMaxValue());
		 filer.setEmergencyLeaveCredits(LeaveType.EMERGENCY_LEAVE.getMaxValue());
		 filer.setVacationLeaveCredits(LeaveType.VACATION_LEAVE.getMaxValue());
		 filer.gainLeavePoints();
		 
		 assertTrue(15.0 == filer.getSickLeaveCredits());
		 assertTrue(15.0 == filer.getVacationLeaveCredits());
		 assertTrue(3.0 == filer.getEmergencyLeaveCredits());
	 }
	 
	 @Test
	 public void changeOffsetCreditsOfEmployeeByAdmin() {
		 admin.resetOffsetLeaveCredits(filer, (float) 1.5);
		 
		 assertTrue(0 == admin.getOffsetLeaveCredits());
		 assertTrue(1.5 == filer.getOffsetLeaveCredits());
	 }

}
