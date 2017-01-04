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

	<header class="w3-container w3-yellow w3-margin-bottom w3-clear">
		<h1 class="w3-left">Welcome to My Web Bank 3.0</h1>
		<h4 class="w3-right" style="margin-top:30px;">user : <%= session.getAttribute("admin") %></h4>
		<!--   
		<h4>name : ${sessionScope.admin}</h4>
		<h4>name : <s:property value="#session.admin" /></h4>
		-->  
	</header>
	
	<div class="w3-row-padding w3-small" style="height:500px;">
		<div id="menu" class="w3-container w3-margin-bottom">
			<ul class="w3-navbar w3-blue">
				<li><a href="/ss2h-mybank/admin/listAllUsers">listAllUsers</a></li>
				<li><a href="javascript:listAllUsers();" id="listAllUsers">listAllUsers2</a></li>
				<li><a href="javascript:listActiveUsers()">listActiveUsers</a></li>				
				<li><a href="javascript:listDisabledUsers()">listDisabledUsers</a>
				<li><a href="/ss2h-mybank/admin/addUser.jsp">addUser</a>
				<li><a href="/ss2h-mybank/admin/modifyPassword.jsp">modifyPassword</a>
				<li><a href="javascript:confirmLogout();">logout</a>
			</ul>
		</div>
		<div id="content" class="w3-container w3-margin-top">
			<s:if test="#request.message != null">
				<h3>${requestScope.message}</h3>
			</s:if>
			<div id="searchDiv" class="w3-container w3-center w3-small"></div>
			<div id="tableDiv" class="w3-responsive">
			
			<s:if test="#request.users != null">
				<table id="tb1" class="w3-table-all w3-tiny">
					<caption>Users List</caption>
					<tr><th>No.</th><th>Username</th><th>Password</th>
						<th>Realname</th><th>PID</th><th>Phone</th><th>Account</th><th>Status</th>
					</tr>
					<s:iterator value="#request.users" var="user" status="stat">
						<tr>
							<td><a href="/ss2h-mybank/admin/editUser"><s:property value="#stat.count"/></a></td>
							<td><s:property value="username"/></td>
							<td><s:property value="password"/></td>
							<td><s:property value="realname"/></td>
							<td><s:property value="pid"/></td>
							<td><s:property value="phone"/></td>
							<td><s:property value="accounts[0].id"/></td>
							<td><s:property value="accounts[0].status.statusName"/></td>
					</s:iterator>
				</table>
			</s:if>
			
			</div>
		</div>
	</div>

	<s:include value="/footer.html" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type='text/javascript' src='/ss2h-mybank/dwr/engine.js'></script>
<script type='text/javascript' src='/ss2h-mybank/dwr/interface/AdminDWR.js'></script>
<script src="/ss2h-mybank/js/admin.js"></script>


</body>
</html>