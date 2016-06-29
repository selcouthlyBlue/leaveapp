<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag description="Leave Application Form Tag" pageEncoding="UTF-8"%>
<<<<<<< HEAD
<form action='<c:url value="submit_leave_application" />'method="post" class="col-md-8 col-md-offset-2">				
	<div class="form-group col-md-12">
		<label class="col-md-4"> Leave Type </label>
		<div class="col-md-8">
			<select class="form-control" name="leaveType">
				<option value="VACATION_LEAVE"> Vacation Leave </option>
				<option value="EMERGENCY_LEAVE"> Emergency Leave </option>
				<option value="SICK_LEAVE"> Sick Leave </option>
				<option> Offset </option>
			</select>
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Supervisor </label>
		<div class="col-md-8">
			<select class="form-control" name="supervisorId" >
				<option value="1"> Supervisor 1 </option>
				<option value="2"> Supervisor 2 </option>
				<option value="3"> Supervisor 3 </option>
				<option value="4"> Supervisor 4 </option>
			</select>
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Start Date </label>
		<div class="col-md-8">
			<input type="date" class="form-control" name="startDate">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> End Date </label>
		<div class="col-md-8">
			<input type="date" class="form-control" name="endDate">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Number of Days </label>
		<div class="col-md-8">
			<input type="text" class="form-control" value="3">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Reason </label>
		<div class="col-md-8">
			<textarea class="form-control" rows="4" name="reason"> </textarea>
=======
<form action="view_leave_history" class="col-md-8 col-md-offset-2">				
	<div class="form-group col-md-12">
		<label class="col-md-4"> Leave Type </label>
		<div class="col-md-8">
			<select class="form-control">
				<option> Vacation Leave </option>
				<option> Emergency Leave </option>
				<option> Sick Leave </option>
				<option> Offset </option>
			</select>
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Supervisor </label>
		<div class="col-md-8">
			<select class="form-control">
				<option> Supervisor 1 </option>
				<option> Supervisor 2 </option>
				<option> Supervisor 3 </option>
				<option> Supervisor 4 </option>
			</select>
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Start Date </label>
		<div class="col-md-8">
			<input type="datetime-local" class="form-control">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> End Date </label>
		<div class="col-md-8">
			<input type="datetime-local" class="form-control">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Number of Days </label>
		<div class="col-md-8">
			<input type="text" class="form-control">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Reason </label>
		<div class="col-md-8">
			<textarea class="form-control" rows="4"> </textarea>
>>>>>>> branch 'master' of https://github.com/selcouthlyBlue/leaveapp.git
		</div>
	</div>
	
	<input type="submit" class="btn btn-primary" value="Submit">
</form>