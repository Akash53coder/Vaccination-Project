<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vaccine-App</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	<style>
		.footer {
			bottom: 0; 
			margin-bottom: 0; 
			margin-top: 32%; 
			text-align: center; 
			background-color: #008080; 
			padding-top: 10px; 
			padding-bottom: 10px; 
			width: 100%; 
			color: white;
		}
		.header{
			margin-top: 0px; 
			text-align: center; 
			background-color: #009999; 
			padding-top: 10px; 
			padding-bottom: 10px; 
			width: 100%; 
			color: white
		}
	</style>
	<body>
		<h2 class="header">Welcome
		to Vaccination Website</h2>
		<div class="container" style="margin-top:40px">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<form action="registervaccine.vaccine" method="POST">
					<h3 style="text-align:center">Vaccination Registration</h3>
					<h4 style="color: red; margin-left: 30px; text-align: center;">${Invalid_EmailId}</h4>
					<h4 style="color: red; margin-left: 30px; text-align: center;">${OTP_Not_Sent}</h4>
					<div class="form-group">
						<label>Enter Email-Id</label>
						<input type="text" name="emailId" class="form-control">
					</div>
					<button type="submit" class="btn btn-primary">Get OTP</button>
				</form>
			</div>
			<div class="col-sm-3"></div>
		</div>
		<div class="footer">
			<b>@2021 CopyRight Vaccine-App</b>
			<br><b>By Akash-XWorkz</b><br>
		</div>
	</body>
</html>