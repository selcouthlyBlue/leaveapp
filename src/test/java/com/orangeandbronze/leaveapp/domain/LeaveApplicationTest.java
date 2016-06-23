package com.orangeandbronze.leaveapp.domain;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class LeaveApplicationTest {

	@Test
	public void leaveApplicationWithEndDateBeforeStartDateRaisesAnException() {
		Calendar startDate = new GregorianCalendar(2016,11,12);
		Calendar endDate = new GregorianCalendar(2016,11,5);
		LeaveType leaveType = LeaveType.SICK_LEAVE;
		try {
			new LeaveApplication(startDate, endDate, leaveType, new Employee(), new Employee());
			fail("Instantiating a LeaveApplication object should "
					+ "throw an exception if the end date "
					+ "is before start date.");
		} catch (IllegalArgumentException expected) {
			
		}
	}

}
