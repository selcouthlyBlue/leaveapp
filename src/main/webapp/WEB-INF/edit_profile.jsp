<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:header/>
<div class="container-fluid" id="content">
	<div class="row">
		<t:menu/>
		<div class="col-md-10" id="mainContent">
			<div class="col-md-12">
				<h1>Edit Account Information</h1>
				<div class="panel panel-default">
					<div class="panel-body">
						<t:account_details/>
					</div>
				</div>
			</div>						
			<div class="col-md-12">
				<t:admin_tabs/>
				<div class="panel panel-default" id="mainContentBottom">
					<div class="panel-body">
						<form class="col-md-8 col-md-offset-2">
							<div class="form-group col-md-12">
								<label class="col-md-4"> First Name </label>
								<div class="col-md-8">
									<input type="text" class="form-control" value="Jason">
								</div>
							</div>
							
							<div class="form-group col-md-12">
								<label class="col-md-4"> Last Name </label>
								<div class="col-md-8">
									<input type="text" class="form-control" value="Bajade">
								</div>
							</div>
							
							<div class="form-group col-md-12">
								<label class="col-md-4"> Status </label>
								<div class="col-md-8">
									<label class="radio-inline"><input type="radio" name="status">Probationary</label>
									<label class="radio-inline"><input type="radio" name="status">Regular</label>
								</div>
							</div>
							
							<div class="form-group col-md-12">
								<label class="col-md-4"> Email </label>
								<div class="col-md-8">
									<span>jasonbajade@orangeandbronze.com</span>
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
								<label class="col-md-4"> Department </label>
								<div class="col-md-8">
									<select class="form-control">
										<option> Department 1 </option>
										<option> Department 2 </option>
										<option> Department 3 </option>
										<option> Department 4 </option>
									</select>
								</div>
							</div>

							<div class="form-group col-md-12">
								<label class="col-md-4"> Role </label>
								<div class="col-md-8">
									<div class="checkbox">
										<label><input type="checkbox"> HR </label>
									</div>
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
					</div>
				</div>
			</div>	
		</div>
	</div>
</div>
<t:footer/>