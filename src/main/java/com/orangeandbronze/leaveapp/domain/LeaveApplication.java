package com.orangeandbronze.leaveapp.domain;

import java.util.Calendar;

public class LeaveApplication {

	private Calendar startDate;
	private Calendar endDate;
	private LeaveType leavetype;
	private LeaveStatus leaveStatus;
	private Employee filer;
	private Employee approver;
	private String reason;
	private float numberOfLeaveDays;
	
	public LeaveApplication(Calendar startDate, Calendar endDate, LeaveType leaveType, Employee filer, Employee approver) {
		this(startDate, endDate, leaveType, LeaveStatus.PENDING, filer, approver);
	}
	
	public LeaveApplication(Calendar startDate, Calendar endDate, LeaveType leaveType, LeaveStatus leaveStatus, Employee filer, Employee approver) {
		checkIfEndDateIsBeforeStartDate(startDate, endDate);
		this.startDate = startDate;
		this.endDate = endDate;
		this.leavetype = leaveType;
		this.leaveStatus = leaveStatus;
		this.filer = filer;
		this.approver = approver;
		numberOfLeaveDays = computeNumberOfLeaveDays(startDate, endDate);
	}
	
	private float computeNumberOfLeaveDays(Calendar startDate, Calendar endDate) {
		int numberOfLeaveDays = 0;
		for(Calendar date = startDate; date.before(endDate); date.add(Calendar.DATE,1)) {
			numberOfLeaveDays++;
		} 
		System.out.println(numberOfLeaveDays);
		return (float) numberOfLeaveDays;
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
		else if(this.leaveStatus == LeaveStatus.SUPERVISOR_APPROVED) 
			this.leaveStatus = LeaveStatus.ADMIN_APPROVED;
	}

	public void disapprove() {
		if(this.leaveStatus == LeaveStatus.PENDING)
			this.leaveStatus = LeaveStatus.SUPERVISOR_DISAPPROVED;
		else if(this.leaveStatus == LeaveStatus.SUPERVISOR_APPROVED)
			this.leaveStatus = LeaveStatus.ADMIN_DISAPPROVED;
	}
	
	public LeaveStatus getStatus() {
		return leaveStatus;
	}
	
	public float getNumberOfLeaveDays() {
		return numberOfLeaveDays;
	}

	public void changeToNotTaken() {
		leaveStatus = LeaveStatus.NOT_TAKEN;
	}
}
