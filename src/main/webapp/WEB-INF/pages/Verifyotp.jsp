<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			margin-top: 31%; 
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
		.verify_btn{
			background: linear-gradient(to right, #642b73, #c6426e);
			padding: 8px;
			width: 100px;
			color:white;
			border:none;
			outline: none;
			box-shadow:0px 2px 8px 0px rgba(255,97,98,0.46) !important;
		}
	</style>
	</head>
	<body>
		<h2 class="header">Welcome to Vaccination Website
			<form action="redirectlogin.vaccine" method="GET">
				<button type="submit" class="btn btn-success pull-right" style="margin-top: -31px !important;margin-right: 20px;">Login</button>
			</form>	
		</h2>
		<div class="container" style="margin-top:39px">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form action="verifyotp.vaccine" method="POST">
					<h3 style="text-align:center">OTP Verification</h3>
					<h4 style="color: green; margin-left: 30px; text-align: center;">${OTP_Msg}</h4>
					<h4 style="color: green; margin-left: 30px; text-align: center;">${OTP_Verified}</h4>
					<h4 style="color: red; margin-left: 30px; text-align: center;">${OTP_Invalid}</h4>
					<div class="form-group">
						<label>Enter OTP</label>
						<input type="text" name="otp" class="form-control">
					</div>
					<button type="submit" class="btn verify_btn">Verify OTP</button>
					<span><a href="resendotpmail.vaccine" style="text-decoration:underline;margin-left:10px;cursor:pointer;font-weight:bold">Resend OTP</a></span>				
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