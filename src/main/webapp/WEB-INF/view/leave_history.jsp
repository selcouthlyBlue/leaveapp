<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:wrapper>
<div class="container-fluid" id="content">
	<div class="row">
		<t:menu/>
		<div class="col-md-10" id="mainContent">
			<div class="col-md-12">
				<h1>My Leave History</h1>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th> Status (Supervisor) </th>
							<th> Status (HR) </th>
							<th> Name </th>
							<th> Leave Type </th>
							<th> Date Filed </th>
							<th> Start Date </th>
							<th> End Date </th>
							<th> Duration </th>
							<th> Action </th>
						</tr>
					</thead>
					<tbody>
						<!-- loop leaves here -->
						<tr>
							<td> Approved </td>
							<td> Approved </td>
							<td> Jason Bajade </td>
							<td> ${leaveApplication.leaveType} </td>
							<td> </td>
							<td> ${leaveApplication.startDate} </td>
							<td> ${leaveApplication.endDate} </td>
							<td>  </td>
							<td>	<i class="fa fa-eye text-primary" aria-hidden="true"></i>
										<i class="fa fa-times text-danger" aria-hidden="true"></i> 
							</td>
						</tr>
						<tr>
							<td> Approved </td>
							<td> Approved </td>
							<td> Jason Bajade </td>
							<td> SL </td>
							<td>  </td>
							<td>  </td>
							<td>  </td>
							<td>  </td>
							<td>	<i class="fa fa-eye text-primary" aria-hidden="true"></i>
										<i class="fa fa-times text-danger" aria-hidden="true"></i> 
							</td>
						</tr>
						<tr>
							<td> Approved </td>
							<td> Approved </td>
							<td> Jason Bajade </td>
							<td> SL </td>
							<td>  </td>
							<td>  </td>
							<td>  </td>
							<td>  </td>
							<td>	<i class="fa fa-eye text-primary" aria-hidden="true"></i>
										<i class="fa fa-times text-danger" aria-hidden="true"></i> 
							</td>
						</tr>
					</tbody>
				</table>
				<div class="col-md-12" id="pagination">
					<ul class="pagination">
						<li class="active"><a href="">1</a></li>
						<li><a href="">2</a></li>
						<li><a href="">3</a></li>
						<li><a href="">4</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
</t:wrapper>