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
	
	<div class="w3-container w3-small" style="width:50%;">
		<form action="admin/addUser" method="post">
			<fieldset>
				<legend>User info</legend>
				<label class="w3-label w3-validate w3-text-blue">使用者名稱</label>
				<input type="text" name="user.username" class="w3-input">
				<span style="color:red;"><s:fielderror fieldName="username" /></span>
				<label class="w3-label w3-validate w3-text-blue">密碼</label>
				<input type="password" name="user.password" class="w3-input">
				<label class="w3-label w3-validate w3-text-blue">真實姓名</label>
				<input type="text" name="user.realname" class="w3-input">
				<label class="w3-label w3-validate w3-text-blue">身分證字號</label>
				<input type="text" name="user.pid" class="w3-input">
				<label class="w3-label w3-validate w3-text-blue">電話</label>
				<input type="text" name="user.phone" class="w3-input">				
			</fieldset>
			<fieldset>
				<legend>Account info</legend>
				<label class="w3-label w3-validate w3-text-blue">帳戶初始金額</label>
				<input type="text" name="account.balance" class="w3-input">
				<label class="w3-label w3-validate w3-text-blue">帳戶初始狀態</label>
				<input type="radio" value="1" name="accountStatus" class="w3-radio" checked>啟用
				<input type="radio" value="2" name="accountStatus" class="w3-radio" checked>停用
			</fieldset>
			<input type="submit" value="add new User" class="w3-btn w3-blue">
		</form>
	</div>

	<s:include value="/footer.html" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>

</script>

</body>
</html>