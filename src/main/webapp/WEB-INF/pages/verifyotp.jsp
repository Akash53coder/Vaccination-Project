<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vaccine-App OTP Verification</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
			<style>
		.footer {
			bottom: 0; 
			margin-bottom: 0px; 
			margin-top: 31%; 
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
			color: white;
		}
	</style>
	</head>
	<body>
		<h2 class="header">Welcome
		to Vaccination Website</h2>
		<div class="container" style="margin-top:40px">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form action="verifyotp.vaccine" method="POST">
					<h3 style="text-align:center">OTP Verification</h3>
					<h4 style="color: green; margin-left: 30px; text-align: center;">${OTP_Sent}</h4>
					<div class="form-group">
						<label>Enter OTP</label>
						<input type="text" name="otp" class="form-control">
					</div>
					<button type="submit" class="btn btn-warning">Verify OTP</button>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
		<div class="footer">
			<b>@2021 CopyRight Vaccine-App</b>
			<br><b>By Akash-XWorkz</b>
		</div>		
	</body>
</html>