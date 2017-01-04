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

</head>

<body>
	
	<!--  底下是系統一開始需要建立的admin帳號
		<s:action name="init" namespace="/" />
	-->
	<s:include value="/header.html" />
	
	<div class="w3-container w3-margin-top w3-small" style="width:50%;">
		<form action="user/login" method="post" class="w3-container w3-card-4">
			<p>
				<label class="w3-label w3-validate w3-text-blue">Username</label> 
				<input
					class="w3-input w3-border w3-text-blue w3-hover-yellow" type="text" style="width: 90%;"
					name="user.username" value="${inputUsername}" required />
				<s:fielderror fieldName="username" cssStyle="color:red;" />
			</p>
			<p>
				<label class="w3-label w3-validate w3-text-blue">Password</label> 
				<input
					class="w3-input w3-border w3-text-blue w3-hover-yellow" type="password" style="width: 90%;"
					name="user.password" required />
				<s:fielderror fieldName="password" cssStyle="color:red;" />
			</p>
			<p>
				<select name="type" class="w3-select w3-border w3-text-blue" style="width:50%;">
					<option value="0">一般用戶</option>
					<option value="1">管理者</option>
				</select>
			</p>
			<p>
				<span id="time" class="w3-right"></span>
				<input class="w3-btn w3-blue w3-hover-green" type="submit" value="Log in" />
			</p>
		</form>
	</div>

	<s:include value="/footer.html" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="js/user.js"></script>
<script>
	$.holdReady(true);
	$.getScript('js/user.js', function() {
		$.holdReady(false);
	});
	$(document).ready(function() {
		displayTime();
		$('input:first').focus();
		$('select').change(function() {
			var type = this.value;			
			if(type == 1) {
				console.log("user type is " + type);
				$('form').attr('action', 'admin/login');
			} else {
				$('form').attr('action', 'user/login');
			}
		});
	});
</script>
</body>
</html>