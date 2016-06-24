package com.orangeandbronze.leaveapp.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LeaveCreditsTest {

	private Employee employee;
	private Employee admin;

	@Before
	public void setUp() {
		employee = generateEmployee();
		admin = generateEmployee();
	}

	private Employee generateEmployee() {
		return new Employee();
	}

	@Test
	public void resetLeavePointsToZero() {
		employee.resetLeaveCredits();

		assertTrue(3.75 == employee.getSickLeaveCredits());
		assertTrue(3.75 == employee.getVacationLeaveCredits());
		assertTrue(3.00 == employee.getEmergencyLeaveCredits());
	}

	@Test
	public void incrementLeavePointOfEmployee() {
		employee.gainSickLeaveCreditsAndVactionLeaveCredits();
		assertTrue(1.25 == employee.getSickLeaveCredits());
		assertTrue(1.25 == employee.getVacationLeaveCredits());
	}

	@Test
	public void changeOffsetCreditsOfEmployeeByAdmin() {
		admin.awardOffsetLeaveCreditsTo(employee, (float) 1.5);
		assertTrue(1.5 == employee.getOffsetLeaveCredits());
	}
}
