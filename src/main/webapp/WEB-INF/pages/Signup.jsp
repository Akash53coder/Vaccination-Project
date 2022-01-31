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
			margin-top: 5%; 
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
		.signup_btn{
			background-color: #70b2d9;
			background-image: linear-gradient(315deg, #70b2d9 0%, #39e5b6 74%);
			padding: 8px;
			color:white;
			border:none;
			box-shadow:0px 1px 6px 0px rgba(255,97,98,0.46) !important;
			margin-bottom:30px;
			margin-top:18px;
			outline: none;
		}
		.signupBox{
			box-shadow: rgba(67, 71, 85, 0.27) 0px 0px 0.25em, rgba(90, 125, 188, 0.05) 0px 0.25em 1em;
			margin-top:30px;
		}
	</style>
	</head>
	<body>
		<h2 class="header" >Welcome	to Vaccination Website</h2>
		<div class="container" style="margin-top:29px">
			<div class="col-sm-4"></div>
			<div class="col-sm-4 signupBox">
				<form action="signup.vaccine" method="POST">
					<h3 style="text-align:center">Sign Up Here</h3><hr>
					<h4 style="color: red; margin-left: 30px; text-align: center;">${Signup_Msg}</h4>
					<div class="form-group">
						<label>Enter Username</label>
						<input type="text" name="name" class="form-control">
						<span style="color:red;">${NameNotValid}</span>
					</div>
					<div class="form-group">
						<label>Enter Phone.no</label>
						<input type="tel" name="phone" class="form-control" >
						<span style="color:red;">${PhoneNotValid}</span>
					</div>
					<div class="form-check">
					  <label>Gender &nbsp;&nbsp;</label>
					  <input class="form-check-input" type="radio" name="gender" value="male">
					  <label>Male</label>
					  
					  <input class="form-check-input" type="radio" name="gender" value="female">
					  <label>Female</label>
					  
					  <input class="form-check-input" type="radio" name="gender" value="others">
					  <label>Others</label>		
					  <span style="color:red;">${GenderNotInvalid}</span>			  					  
					</div>					
					<div class="form-group">
						<label>Enter Password</label>
						<input type="text" name="password" class="form-control">
						<span style="color:red;">${PasswordNotValid}</span>
					</div>
					<div class="form-group">
						<label>Confirm Password</label>
						<input type="text" name="cPassword" class="form-control">
						<span style="color:red;">${CpasswordNotValid}</span>
						<span style="color:red;">${PasswordNotMatched}</span>
					</div>
					<div class="form-group">
						<label>Enter DOB</label>
						<input type="date" name="dob" class="form-control">
						<span style="color:red;">${DobNotInvalid}</span>
					</div>																		
					<button type="submit" class="btn btn-block signup_btn"><b>Sign Up</b></button>
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