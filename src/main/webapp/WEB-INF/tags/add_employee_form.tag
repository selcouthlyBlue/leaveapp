<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag description="Add Employee Form Tag" pageEncoding="UTF-8"%>
<form action="account_info" class="col-md-8 col-md-offset-2">
	<div class="form-group col-md-12">
		<label class="col-md-4"> First Name </label>
		<div class="col-md-8">
			<input type="text" class="form-control">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Last Name </label>
		<div class="col-md-8">
			<input type="text" class="form-control">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Email </label>
		<div class="col-md-8">
			<input type="text" class="form-control" value="jasonbajade@orangeandbronze.com">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Contact Number </label>
		<div class="col-md-8">
			<input type="text" class="form-control" value="09xxxxxxxxxxx">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Employment Date </label>
		<div class="col-md-8">
			<input type="date" class="form-control">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Employee Position </label>
		<div class="col-md-8">
			<input type="text" class="form-control" value="Senior Enterprise Engineer">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Employee Status </label>
		<div class="col-md-8">
			<select class="form-control">
				<option style="display:none">Select Status</option>
				<option> Probationary </option>
				<option> Regular </option>
			</select>
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-md-4"> Department </label>
		<div class="col-md-8">
			<select class="form-control">
				<option style="display:none">Select Department</option>
				<!-- loop departments from db -->
			</select>
		</div>
	</div>

	<div class="form-group col-md-12">
		<label class="col-md-4"> Roles </label>
		<div class="col-md-8">
			<div class="checkbox">
				<label><input type="checkbox"> Admin </label>
			</div>
			<div class="checkbox">
				<label><input type="checkbox"> Supervisor </label>
			</div>
		</div>
	</div>
	<input type="submit" class="btn btn-primary" value="Submit">
</form>