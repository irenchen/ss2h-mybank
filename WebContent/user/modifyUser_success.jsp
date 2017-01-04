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
<style>
span {
	color:red;
}
</style>
</head>
<body style="margin:0px;padding:0px;">

	<s:include value="/user/header.jsp" />

	<s:include value="/user/sidenav.html" />
	
	<div id="content" class="w3-container" style="height:300px;width:75%;margin-left:25%;">

		<h3>修改基本資料畫面</h3>
		<div>
			<p>${msg}</p>
		</div>

	</div>

	<s:include value="/footer.html" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="/ss2h-mybank/js/user.js"></script>
<script>
	$(document).ready(function() {
		$('#btn1').click(function() {
			location.href="/ss2h-mybank/index.jsp";
			return;
		});
		
		$('#btn2').click(function() {
			$('span').empty();
			var newPass1 = $('input:eq(1)').val();
			var newPass2 = $('input:eq(2)').val();
			if(newPass1 != newPass2) {
				$('#msg').text("新密碼與確認密碼不一致");
				$(':password').val("");
				return;
			}			
			$('form').submit();
		});
	});
</script>
</body>
</html>