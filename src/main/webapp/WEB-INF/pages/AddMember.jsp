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
			background-color: #e3efe8;
background-image: linear-gradient(315deg, #e3efe8 0%, #96a7cf 74%);
			padding: 8px;
			color:white;
			border:none;
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
		<h2 class="header">Welcome to Vaccination Website
			<form action="redirectlogin.vaccine" method="GET">
			<span>
				<h4 style="color:white">${userName}</h4>
				<button type="submit" class="btn btn-success pull-right" style="margin-top: -39px !important;margin-right: 20px;">Login</button>				
			</span>
			</form>	
		</h2>		
		<div class="container" style="margin-top:29px">
			<div class="col-sm-4"></div>
			<div class="col-sm-4 signupBox">
				<form action="addmember.vaccine" method="POST">
					<h4 style="text-align:center;font-weight:bold">Add Member</h4>
					<h4 style="color: green; margin-left: 30px; text-align: center;">${Member_Added}</h4>
					<h4 style="color: red; margin-left: 30px; text-align: center;">${Member_Not_Added}</h4>		
					<h4 style="color: red; margin-left: 30px; text-align: center;">${Reached_Add_Member_Count}</h4>				
					<div class="form-group">
						<label>Enter Username</label>
						<input type="text" name="userName" class="form-control">
						<span style="color:red;">${Name_Invalid}</span>
					</div>
					<div class="form-check">
					  <label>Gender &nbsp;&nbsp;</label>
					  <input class="form-check-input" type="radio" name="gender" value="male">
					  <label>Male</label>
					  
					  <input class="form-check-input" type="radio" name="gender" value="female">
					  <label>Female</label>
					  
					  <input class="form-check-input" type="radio" name="gender" value="others">
					  <label>Others</label>		
					  <span style="color:red;">${Gender_Invalid}</span>			  					  
					</div>					
					<div class="form-group">
						<label>YOB</label>
						<input type="text" name="yob" class="form-control">
						<span style="color:red;">${YOB_Invalid}</span>
					</div>
					<div class="form-group">
						<label>Photo Id Proof</label>
						<select name="photo_id_proof" class="form-control">
							<option>--select--</option>
							<option value="aadhar">Aadhar Card</option>
							<option value="driving License">Driving License</option>
							<option value="pan">Pan Card</option>
						</select>
						<span style="color:red;">${Photo_Id_Invalid}</span>
					</div>
					<div class="form-group">
						<label>Id Proof No.</label>
						<input type="text" name="photo_id_no" class="form-control">
						<span style="color:red;">${Photo_Id_No_Invalid}</span>
					</div>					
					<div class="form-group">
						<label>Dose</label>
						<select name="dose" class="form-control">
							<option>--select--</option>
							<option value="dose1">Dose 1</option>
							<option value="dose2">Dose 2</option>
						</select>
						<span style="color:red;">${Dose_Invalid}</span>
					</div>	
					<div class="form-group">
						<label>Vaccine Type</label>
						<select name="vaccine_type" class="form-control">
							<option>--select--</option>
							<option value="aadhar">Covishield</option>
							<option value="covaxin">Covaxin</option>
							<option value="sputnik">Sputnik</option>
						</select>
						<span style="color:red;">${Photo_Id_Invalid}</span>
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