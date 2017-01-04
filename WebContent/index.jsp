<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String base = request.getScheme() + "://" + request.getServerName() + ":" +
		request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%= base %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
 
<%
	if(session.getAttribute("username") == null) {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
%>		

</head>
<body style="margin:0px;padding:0px;">

	<s:include value="/user/header.jsp" />

	<s:include value="/user/sidenav.html" />
	
	<div id="content" class="w3-container" style="height:300px;width:75%;margin-left:25%;">

		<h3>show user information here...</h3>
		<table class="w3-table w3-border">
			<tr class="w3-pale-red"><th>帳號</th><th>帳戶餘額</th><th>狀態</th></tr>
			<tr class="w3-pale-blue">
				<td>${aid}</td><td>${balance}</td><td>${status}</td>
			</tr>
		</table>	

	</div>

	<s:include value="/footer.html" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="js/user.js"></script>

</body>
</html>