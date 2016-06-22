<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:header/>
<div class="container-fluid" id="content">
	<div class="row">
		<t:menu/>
		<div class="col-md-10" id="mainContent">
			<div class="col-md-12">
				<h1>Company Leave History</h1>
				<table class="table table-striped table-bordered" id="leaveList">
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
							<td> Emergency </td>
							<td>  </td>
							<td>  </td>
							<td>  </td>
							<td>  </td>
							<td>	<i class="fa fa-eye text-primary" aria-hidden="true"></i> 
										<i class="fa fa-check text-success" aria-hidden="true"></i> 
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
							<td>	<a href="modal1" data-toggle="modal" data-target="#modal1"><i class="fa fa-eye text-primary" aria-hidden="true"></i> </a>
										<i class="fa fa-check text-success" aria-hidden="true"></i> 
										<i class="fa fa-times text-danger" aria-hidden="true"></i>
							</td>
						</tr>
					</tbody>
				</table>
				<t:leave_details/>
				<div class="col-md-12" id="pagination">
					<ul class="pagination">
						<li class="active"><a href="">1</a></li>
						<li><a href="">2</a></li>
						<li><a href="">3</a></li>
						<li><a href="">4</a></li>
						<li><a href="">5</a></li>
						<li><a href="">6</a></li>
						<li><a href="">7</a></li>
						<li><a href="">8</a></li>
						<li><a href="">9</a></li>
						<li><a href="">10</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<t:footer/>