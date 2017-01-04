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
<%
	if(session.getAttribute("username") == null) {
%>		
		<jsp:forward page="login.jsp" />
<%
	}
%>
	<header class="w3-container">
		<h1>Welcome to My Web Bank 3.0</h1>
		<h4>name : <%= session.getAttribute("username") %></h4>
		<!--  
		<h4>name : ${sessionScope.username}</h4>
		<h4>name : <s:property value="#session.username" /></h4>
		-->
	</header>
	
	<div class="w3-row-padding">
		<div id="menu" class="w3-third">
			<ul>
				<li>option 1</li>
				<li>option 2</li>
			</ul>
		</div>
		<div id="content" class="w3-rest">
			<h3>show user information here...</h3>
		</div>
	</div>

	<footer class="w3-container w3-margin-top"> &copy;Web Bank since 2016 </footer>

</body>
</html>