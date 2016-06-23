package com.orangeandbronze.leaveapp.domain;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

public class Employee {
	
	private Collection<LeaveApplication> leavehistory = new HashSet<LeaveApplication>();
	private float sickLeaveCredits;
	private float vacationLeaveCredits;
	private float emergencyLeaveCredits;
	private float offsetLeaveCredits;
	

	public LeaveApplication fileLeave(Calendar startDate, Calendar endDate, LeaveType leaveType, Employee approver) {
		LeaveApplication leaveApplication = new LeaveApplication(startDate, endDate, leaveType, this, approver);
		leavehistory.add(leaveApplication);
		return leaveApplication;
	}

	public Collection<LeaveApplication> getLeaveHistory() {
		return new HashSet<LeaveApplication>(leavehistory);
	}

	public void cancel(LeaveApplication leaveApplication) {
		leaveApplication.cancel();
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
	
	public void resetLeaveCredits() {
		resetSickLeaveCredits();
		resetVacationLeaveCredits();
		resetEmergencyLeaveCredits();
	}
	
	private void resetSickLeaveCredits() {
		sickLeaveCredits = (float) 3.75;
	}
	
	private void resetVacationLeaveCredits() {
		vacationLeaveCredits = (float) 3.75;
	}
	
	private void resetEmergencyLeaveCredits() {
		emergencyLeaveCredits = (float) 3;
	}
	
	public float getSickLeaveCredits() {
		return sickLeaveCredits;
	}
	
	public float getVacationLeaveCredits() {
		return vacationLeaveCredits;
	}
	
	public float getEmergencyLeaveCredits() {
		return emergencyLeaveCredits;
	}
	
	public void gainLeavePoints(){
		gainSickLeaveCredits();
		gainVacationLeaveCredits();
	}
	
	private void gainSickLeaveCredits() {
		if(isGreaterThanMaxCredits(sickLeaveCredits, LeaveType.SICK_LEAVE)) {
			sickLeaveCredits = LeaveType.SICK_LEAVE.getMaxValue();
			return;
		}
		sickLeaveCredits += 1.25;
	}
	
	private void gainVacationLeaveCredits() {
		vacationLeaveCredits += 1.25;
		if(isGreaterThanMaxCredits(vacationLeaveCredits, LeaveType.VACATION_LEAVE)) {
			vacationLeaveCredits = LeaveType.VACATION_LEAVE.getMaxValue();
		}
	}
	
	private boolean isGreaterThanMaxCredits(float leaveCredits, LeaveType leave) {
		return leaveCredits >= leave.getMaxValue();
	}
	
	public void setSickLeaveCredits(float sickLeaveCredits) {
		this.sickLeaveCredits = sickLeaveCredits;
	}
	
	public void setVacationLeaveCredits(float vacationLeaveCredits) {
		this.vacationLeaveCredits = vacationLeaveCredits;
	}
	
	public void setEmergencyLeaveCredits(float emergencyLeaveCredits) {
		this.emergencyLeaveCredits = emergencyLeaveCredits;
	}
	
	public void resetOffsetLeaveCredits(Employee employee, float offsetLeaveCredits) {
		employee.setOffsetLeaveCredits(offsetLeaveCredits);
	}

	private void setOffsetLeaveCredits(float offsetLeaveCredits) {
		this.offsetLeaveCredits = offsetLeaveCredits;
	}

	public float getOffsetLeaveCredits() {
		return offsetLeaveCredits;
	}
	
}
