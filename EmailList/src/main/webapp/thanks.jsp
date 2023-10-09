<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Web site login email</title>
</head>
<body>
	<a href = "/"><img alt="" src="left-arrow.png"></a> 
	<div class="container1">
		<nav class="navbar1"> 
			<h1>Thanks for joining our email list!</h1>
		    <p>Here is the information that you entered:</p>	
		    											
		    <label>Email:</label>
		    <span>${user.email}</span><br>
		    <label>First Name:</label>
		    <span>${user.firstName}</span><br>
		    <label>Last Name:</label>
		    <span>${user.lastName}</span><br>	
		    <p>To enter another email address, click on the Back button in your browser or the Return button shown below.</p>
		    
			<form action="index.jsp" method="get">
			    <input type="submit" value="Return">
			</form>
			<p> © Copyright ${currentYear} Mike Murach & Associates </p>
		</nav>			
	</div>	
</body>
</html>