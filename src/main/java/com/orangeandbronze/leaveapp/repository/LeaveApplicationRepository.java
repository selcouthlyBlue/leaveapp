package com.orangeandbronze.leaveapp.repository;

import java.util.Collection;

import com.orangeandbronze.leaveapp.domain.LeaveApplication;;

public interface LeaveApplicationRepository {

	public LeaveApplication findBy(int leaveId);
	
	public Collection<LeaveApplication> findAll();
	
	public void updateLeaveStatus(LeaveApplication leaveApplication);
	
	public Collection<LeaveApplication> findLeaveApplicationsForSupervisor(int supervisorId);
	
	public void create(LeaveApplication leaveApplication);
}
