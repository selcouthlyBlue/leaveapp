package com.orangeandbronze.leaveapp.domain;

public enum LeaveType {
	SICK_LEAVE(15.0), VACATION_LEAVE(15.0), EMERGENCY_LEAVE(3.0);
	
	private final float maxValue;
	
	private LeaveType(double maxValue) {
		this.maxValue = (float) maxValue;
	}
	
	public float getMaxValue() {
		return maxValue;
	}
}
