<html>
<body>
	<h2>User Registration</h2>
	<form name="user_registration_form" action="dostuff" method="post">
		<input type="hidden" name="action" value="user_registration">

		<input type="text" name="firstName" placeholder="Enter FirstName"
			required /><br> <input type="text" name="lastName"
			placeholder="Enter LastName" required /><br> <input
			type="radio" name="gender" value="Male" />Male <input type="radio"
			name="gender" value="Female" />Female<br> <br> <input
			type="email" name="email" placeholder="Enter Email" required /><br>
		<br> <input type="password" name="password"
			placeholder="Enter Password" required /><br> <br> <input
			type="date" name="date" /> <input type="number" name="mobileNumber"
			placeholder="Enter MobileNumber" required /><br> <br> <input
			type="submit" value="register">
	</form>

	<h3>Restaurant Register</h3>
	<form name="restaurant_registration_form" action="dostuff"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="restaurant_registration">
		<input type="text" name="govt_reg_id"
			placeholder="Enter Registered Id" required /><br> <input
			type="text" name="Name" placeholder="Enter Restaurant Name" required /><br>
		<input type="password" name="rest_password"
			placeholder="Enter Password" required /><br> <input type="file"
			name="logo_name" /><br>
		<br> <input type="submit" value="Register">
	</form>
	</div>
</body>
</html>