package com.orangeandbronze.leaveapp.dao;

import java.util.Collection;

import com.orangeandbronze.leaveapp.domain.LeaveApplication;;

public interface LeaveApplicationDAO {

	public LeaveApplication findBy(int leaveId);
	
	public Collection<LeaveApplication> findAll();
	
	public void updateLeaveStatus(LeaveApplication leaveApplication);
	
	public Collection<LeaveApplication> findLeaveApplicationsForSupervisor(int supervisorId);
	
	public void create(LeaveApplication leaveApplication);
}
