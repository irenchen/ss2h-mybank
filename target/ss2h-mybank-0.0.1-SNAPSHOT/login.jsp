<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
</head>
<body>

	<header class="w3-container">
		<h1>Welcome to My Web Bank 3.0</h1>
	</header>
	
	<div class="w3-container w3-margin-top" style="width:50%;">
		<form action="doLogin" method="post" class="w3-container w3-card-4">
			<p>
				<label class="w3-label w3-validate">Username</label> 
				<input
					class="w3-input" type="text" style="width: 90%;"
					name="user.username" required />
				<s:fielderror fieldName="username" />
			</p>
			<p>
				<label class="w3-label w3-validate">Password</label> 
				<input
					class="w3-input" type="password" style="width: 90%;"
					name="user.password" required />
				<s:fielderror fieldName="password" />
			</p>
			<p>
				<input class="w3-btn" type="submit" value="Log in" />
			</p>
		</form>
	</div>

	<footer class="w3-container w3-margin-top"> &copy;Web Bank since 2016 </footer>
	
</body>
</html>