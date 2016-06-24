package com.orangeandbronze.leaveapp.domain;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class LeaveApplicationTest {
	
	private LeaveApplication leaveApplication;
	
	private LeaveApplication generateLeaveApplication(Calendar startDate, Calendar endDate) {
		return new LeaveApplication(startDate, endDate, LeaveType.SICK_LEAVE, new Employee(), new Employee());
	}

	private void assertGetNumberOfLeaveDaysEvaluatesTo(int expected) {
		assertTrue("Number of leave days computed was " + leaveApplication.getNumberOfLeaveDays(), 
				expected == leaveApplication.getNumberOfLeaveDays());
	}

	@Test
	public void leaveApplicationWithIntervalContainingOnlyWeekdaysShouldHaveCorrectNumberOfLeaveDays() 
			throws Exception {
		Calendar startDate = new GregorianCalendar(2016,5,20);
		Calendar endDate = new GregorianCalendar(2016,5,24);
		leaveApplication = generateLeaveApplication(startDate, endDate);
		assertGetNumberOfLeaveDaysEvaluatesTo(5);
	}

	@Test
	public void leaveApplicationWithIntervalContainingWeekendsShouldHaveCorrectNumberOfLeaveDays() 
			throws Exception {
		Calendar startDate = new GregorianCalendar(2016,5,23);
		Calendar endDate = new GregorianCalendar(2016,5,27);
		leaveApplication = generateLeaveApplication(startDate, endDate);
		assertGetNumberOfLeaveDaysEvaluatesTo(3);
	}

	@Test
	public void leaveApplicationWithEndDateBeforeStartDateRaisesAnException() {
		Calendar startDate = new GregorianCalendar(2016,11,12);
		Calendar endDate = new GregorianCalendar(2016,11,5);
		try {
			generateLeaveApplication(startDate, endDate);
			fail("Instantiating a LeaveApplication object should "
					+ "throw an exception if the end date "
					+ "is before start date.");
		} catch (IllegalArgumentException expected) {
			
		}
	}


}
