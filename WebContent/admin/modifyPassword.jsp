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
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
 
<%
	if(session.getAttribute("admin") == null) {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
%>		


</head>
<body>
	<s:include value="/header.html" />
	
	<div class="w3-container w3-small w3-margin" style="width:50%;">
		<form action="admin/modifyPassword" method="post">
		
			<label class="w3-label w3-validate w3-text-blue">舊密碼</label>
			<input type="password" name="old_password" class="w3-input">
			<s:fielderror fieldName="password" cssStyle="color:red;" />
				
			<label class="w3-label w3-validate w3-text-blue">新密碼</label>
			<input type="text" name="new_password" class="w3-input"><br/>
			
			<button id="back" class="w3-btn w3-round w3-blue w3-hover-green w3-right w3-margin-left">取消</button>	
			<input type="submit" value="修改密碼" class="w3-btn w3-round w3-blue w3-hover-green w3-right">
			
		</form>
	</div>

	<s:include value="/footer.html" />
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#back').click(function() {
			location.href = "/ss2h-mybank/admin/manage.jsp";
			return false;
		});
	});
</script>

</body>
</html>