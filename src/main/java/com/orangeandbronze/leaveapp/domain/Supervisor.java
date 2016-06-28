package com.orangeandbronze.leaveapp.domain;

public class Supervisor extends Employee {
	public Supervisor() {
		super();
	}
	
	public void approve(LeaveApplication leaveApplication) {
		leaveApplication.approve();
	}
	
	public void disapprove(LeaveApplication leaveApplication) {
		leaveApplication.disapprove();
	}
}
