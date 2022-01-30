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
			margin-top: 23%; 
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
		<h2 class="header" >Welcome
		to Vaccination Website</h2>
		<div class="container" style="margin-top:39px">
			<div class="col-sm-4"></div>
			<div class="col-sm-4 loginBox">
				<form action="verifyotp.vaccine" method="POST">
					<h3 style="text-align:center">Vaccine Login</h3>
					<div class="form-group">
						<label>Enter EmailId</label>
						<input type="text" name="emailId" class="form-control">
					</div>
					<div class="form-group">
						<label>Enter Password</label>
						<input type="text" name="password" class="form-control">
					</div>					
					<button type="submit" class="btn login_btn">Sign in</button>
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