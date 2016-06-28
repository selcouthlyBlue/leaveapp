package com.orangeandbronze.leaveapp.domain;

public class Admin extends Employee {
	public Admin() {
		super();
	}
	
	public void approve(LeaveApplication leaveApplication) {
		leaveApplication.approve();
	}
	
	public void disapprove(LeaveApplication leaveApplication) {
		leaveApplication.disapprove();
	}
	
	public void changeToNotTaken(LeaveApplication leaveApplication) {
		leaveApplication.changeToNotTaken();
	}
	
	public void regularize(Employee employee) {
		employee.regularize();
	}	
}
