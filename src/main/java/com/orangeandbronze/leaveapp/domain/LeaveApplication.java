package com.orangeandbronze.leaveapp.domain;

import java.util.Calendar;

public class LeaveApplication {

	private LeaveStatus leaveStatus;

	public LeaveApplication(Calendar startDate, Calendar endDate, LeaveType leaveType) {
		checkIfEndDateIsBeforeStartDate(startDate, endDate);
		this.leaveStatus = LeaveStatus.PENDING;
	}
	
	private void checkIfEndDateIsBeforeStartDate(Calendar startDate, Calendar endDate) {
		if(endDate.before(startDate))
			throw new IllegalArgumentException(endDate + " is before " + startDate);
	}

	public LeaveStatus getStatus() {
		return leaveStatus;
	}

	public void cancel() {
		this.leaveStatus = LeaveStatus.CANCELLED;
	}

	public void approve() {
		if(this.leaveStatus == LeaveStatus.PENDING)
			this.leaveStatus = LeaveStatus.SUPERVISOR_APPROVED;
		else
			this.leaveStatus = LeaveStatus.ADMIN_APPROVED;
	}

}
