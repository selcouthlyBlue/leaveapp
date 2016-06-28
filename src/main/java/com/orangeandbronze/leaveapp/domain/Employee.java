package com.orangeandbronze.leaveapp.domain;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

public class Employee {
	
	private String firstName;
	private String lastName;
	private Calendar employmentDate;
	private EmploymentStatus employmentStatus;
	private float sickLeaveCredits;
	private float vacationLeaveCredits;
	private float emergencyLeaveCredits;
	private float offsetLeaveCredits;
	private float lwopPoints;
	private LeaveCredits leaveCredits;
	private Collection<LeaveApplication> leavehistory = new HashSet<LeaveApplication>();
	
	public LeaveApplication fileLeave(Calendar startDate, Calendar endDate, LeaveType leaveType, Employee approver) {
		LeaveApplication leaveApplication = new LeaveApplication(startDate, endDate, leaveType, this, approver);
		leavehistory.add(leaveApplication);
		return leaveApplication;
	}

	public void cancel(LeaveApplication leaveApplication) {
		leaveApplication.cancel();
	}
	
	public void awardLeaveCredits(LeaveType leaveType, float credits){
		leaveCredits.award(leaveType, credits);
	}
	
	public void resetLeaveCredits() {
		sickLeaveCredits = (float) 3.75;
		vacationLeaveCredits = (float) 3.75;
		resetEmergencyLeaveCredits();
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
	
	public void gainSickLeaveCreditsAndVactionLeaveCredits(){
		gainSickLeaveCredits();
		gainVacationLeaveCredits();
	}
	
	private void gainSickLeaveCredits() {
		sickLeaveCredits += 1.25;
		if(isGreaterThanMaxCredits(sickLeaveCredits, LeaveType.SICK_LEAVE)) {
			sickLeaveCredits = LeaveType.SICK_LEAVE.getMaxValue();
		}
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
	
	public void awardOffsetLeaveCreditsTo(Employee employee, float offsetLeaveCredits) {
		employee.setOffsetLeaveCredits(offsetLeaveCredits);
	}

	private void setOffsetLeaveCredits(float offsetLeaveCredits) {
		this.offsetLeaveCredits = offsetLeaveCredits;
	}

	public float getOffsetLeaveCredits() {
		return offsetLeaveCredits;
	}

	public void deductLeaveCredits(float numberOfLeaveDays, LeaveType leaveType) {
		if(leaveType == LeaveType.SICK_LEAVE)
			decuctSickLeaveCredits(numberOfLeaveDays);
		if(leaveType == LeaveType.VACATION_LEAVE)
			deductVacationLeaveCredits(numberOfLeaveDays);
		if(leaveType == LeaveType.EMERGENCY_LEAVE)
			deductEmergencyLeaveCredits(numberOfLeaveDays);
	}
	
	private void decuctSickLeaveCredits(float numberOfLeaveDays) {
		sickLeaveCredits -= numberOfLeaveDays;
		if(sickLeaveCredits < 0){
			awardLWOPPoints(sickLeaveCredits);
			sickLeaveCredits = 0;
		}
	}
	
	private void deductVacationLeaveCredits(float numberOfLeaveDays) {
		vacationLeaveCredits -= numberOfLeaveDays;
		if(vacationLeaveCredits < 0){
			awardLWOPPoints(vacationLeaveCredits);
			vacationLeaveCredits = 0;
		}
	}
	
	private void deductEmergencyLeaveCredits(float numberOfLeaveDays) {
		emergencyLeaveCredits -= numberOfLeaveDays;
		if(emergencyLeaveCredits < 0){
			awardLWOPPoints(emergencyLeaveCredits);
			emergencyLeaveCredits = 0;
		}
	}
	
	private void awardLWOPPoints(float negativeLeaveCredits) {	
		lwopPoints += Math.abs(negativeLeaveCredits);
	}

	public boolean hasInLeaveHistoryA(LeaveApplication newLeaveApplication) {
		return leavehistory.contains(newLeaveApplication);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public float getLwopPoints() {
		return lwopPoints;
	}

	public void regularize() {
		employmentStatus = EmploymentStatus.REGULAR;
	}

	public EmploymentStatus getStatus() {
		return employmentStatus;
	}
}
