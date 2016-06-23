package com.orangeandbronze.leaveapp.domain;

import java.util.Calendar;

public class LeaveApplication {

	private Calendar startDate;
	private Calendar endDate;
	private LeaveType leavetype;
	private LeaveStatus leaveStatus;
	private Employee approver;
	
	public LeaveApplication(Calendar startDate, Calendar endDate, LeaveType leaveType) {
		this(startDate, endDate, leaveType, LeaveStatus.PENDING);
	}
	
	public LeaveApplication(Calendar startDate, Calendar endDate, LeaveType leaveType, LeaveStatus leaveStatus) {
		checkIfEndDateIsBeforeStartDate(startDate, endDate);
		this.startDate = startDate;
		this.endDate = endDate;
		this.leavetype = leaveType;
		this.leaveStatus = leaveStatus;
	}
	
	private void checkIfEndDateIsBeforeStartDate(Calendar startDate, Calendar endDate) {
		if(endDate.before(startDate))
			throw new IllegalArgumentException(endDate + " is before " + startDate);
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

	public void disapprove() {
		if(this.leaveStatus == LeaveStatus.PENDING)
			this.leaveStatus = LeaveStatus.SUPERVISOR_DISAPPROVED;
		else
			this.leaveStatus = LeaveStatus.ADMIN_DISAPPROVED;
	}
	
	public LeaveStatus getStatus() {
		return leaveStatus;
	}

	public void changeToNotTaken() {
		leaveStatus = LeaveStatus.NOT_TAKEN;
	}
}
