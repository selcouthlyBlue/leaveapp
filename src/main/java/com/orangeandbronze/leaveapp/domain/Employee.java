package com.orangeandbronze.leaveapp.domain;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

public class Employee {
	
	private Collection<LeaveApplication> leavehistory = new HashSet<LeaveApplication>();

	public LeaveApplication fileLeave(Calendar startDate, Calendar endDate, LeaveType leaveType) {
		LeaveApplication leaveApplication = new LeaveApplication(startDate, endDate, leaveType);
		leavehistory.add(leaveApplication);
		return leaveApplication;
	}

	public Collection<LeaveApplication> getLeaveHistory() {
		return new HashSet<LeaveApplication>(leavehistory);
	}

	public void cancelLeave(LeaveApplication leaveApplication) {
		leaveApplication.cancel();
	}

	public void approveLeave(LeaveApplication leaveApplication) {
		leaveApplication.approve();
	}

}
