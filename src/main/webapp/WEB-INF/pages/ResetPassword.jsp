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
			margin-top: 21%; 
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
		.reset_btn{
			background-color: #cfc7f8;
			background-image: linear-gradient(315deg, #cfc7f8 0%, #ebbba7 74%);
			padding: 8px;
			width: 100px;
			color:black;
			border:none;
			margin-bottom:30px;
			margin-top:12px;
			outline: none;
		}
		.loginBox{
			box-shadow: rgba(67, 71, 85, 0.27) 0px 0px 0.25em, rgba(90, 125, 188, 0.05) 0px 0.25em 1em;
			margin-top:30px;
		}
	</style>
	</head>
	<body>
		<h2 class="header" >Welcome to Vaccination Website</h2>
		<div class="container" style="margin-top:39px">
			<div class="col-sm-4"></div>
			<div class="col-sm-4 loginBox">
				<form action="resetpassword.vaccine" method="POST">
					<h5 style="color: red;">${Password_Invalid}</h5>
					<h5 style="color: green;">${Password_Reset_Success}</h5>
					<h3 style="text-align:center">Reset Password</h3><hr>
					<div class="form-group">
						<label>Enter Password</label>
						<input type="text" name="password" class="form-control">
					</div>
					<div class="form-group">
						<label>Confirm Password</label>
						<input type="text" name="confirmPassword" class="form-control">
					</div>					
					<button type="submit" class="btn reset_btn">Reset</button>
					<c:if test="${login_link}">
						<span><a href="loginpage.vaccine" style="text-decoration:underline;margin-left:10px;cursor:pointer;font-weight:bold">Click Here to Login</a></span>	
					</c:if>			
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