<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vaccine-App OTP Verification</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
			<style>
		.footer {
			bottom: 0; 
			margin-bottom: 0px; 
			margin-top: 34.5%; 
			text-align: center; 
			background-color: #374b62; 
			padding-top: 10px; 
			padding-bottom: 10px; 
			width: 100%; 
			color: white;
		}
		.header{
			margin-top: 0px; 
			text-align: center; 
			background-color: #496483; 
			padding-top: 10px; 
			padding-bottom: 10px; 
			width: 100%; 
			color: white;
		}
		.login_btn{
			background-color: #17f9f2;
			background-image: linear-gradient(315deg, #17f9f2 0%, #b0f9a9 74%);	
			padding: 8px;
			width: 100px;
			color:black;
			border:none;
			margin-bottom:30px;
			margin-top:12px;
		}
		.loginBox{
			box-shadow: rgba(67, 71, 85, 0.27) 0px 0px 0.25em, rgba(90, 125, 188, 0.05) 0px 0.25em 1em;
			margin-top:30px;
		}
	</style>
	</head>
	<body>
		<h2 class="header" style="margin-right:400px">Welcome to Vaccination Website
			<span class="pull-right">
				<h4 style="color:white;margin-right:100px;" >${userName}</h4>
				<a href="logout.vaccine"><button type="submit" class="btn btn-danger" style="margin-top: -79px;margin-left:80px;margin-right: 25px;">Logout</button></a>			
			</span>	
		</h2>
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<a href="getAllAddedMember.vaccine" style="color:black"><button class="btn btn-block btn-secondary" style="margin-top:30px">See Member</button></a>								
				</div>
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<a href="redirectaddmember.vaccine" style="color:black"><button class="btn btn-block btn-secondary" style="margin-top:30px">Add Member</button></a>				
				</div>
			</div>
		</div>
		
		<div class="container" style="margin-top:40px">
			<div class="row">
			<div class="col-lg-12">
				<div class="container" style="margin-top: 8px">
					<table class="table table-bordered table-responsive">
						<thead>
							<tr>
								<th>Name</th>
								<th>Gender</th>
								<th>Year of Birth</th>
								<th>Photo Id</th>
								<th>Photo Id no</th>
								<th>Dose</th>
								<th>vaccine type</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ListOfMembers}" var="addedmember">
								<tr>
									<td>${addedmember.userName}</td>
									<td>${addedmember.gender}</td>
									<td>${addedmember.yob}</td>
									<td>${addedmember.photo_id_proof}</td>
									<td>${addedmember.photo_id_no}</td>
									<td>${addedmember.dose}</td>
									<td>${addedmember.vaccine_type}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>			
		</div>
		</div>
			
		<div class="footer">
			<b>@2021 CopyRight Vaccine-App</b>
			<br><b>By Akash-XWorkz</b>
		</div>		
	</body>
</html>