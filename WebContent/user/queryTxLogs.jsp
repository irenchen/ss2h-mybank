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

		<h3>查詢交易明細畫面</h3>
		<div style="height:300px;overflow:auto;">
		<table class="w3-table w3-white w3-small">
			<tr class="w3-pale-yellow"><th>交易日期</th><th>交易類別</th><th>交易金額</th><th>轉出帳戶</th><th>轉入帳戶</th></tr>
			<s:iterator value="#request.logs" status="stat">
				<tr>
					<td><s:date name="txDate" format="yyyy/MM/dd hh:mm:ss a"/></td>
					<s:if test="txType.typeName == 'deposit'">
						<td>存款</td>
						<td><s:property value="txAmount" /></td>
						<td></td>
						<td><s:property value="toAccount.id" /></td>
					</s:if>
					<s:elseif test="txType.typeName == 'withdraw'">
						<td>提款</td>
						<td><s:property value="txAmount" /></td>
						<td><s:property value="fromAccount.id" /></td>
						<td></td>
					</s:elseif>
					<s:else>
						<td>轉帳</td>
						<td><s:property value="txAmount" /></td>
						<td><s:property value="fromAccount.id" /></td>
						<td><s:property value="toAccount.id" /></td>
					</s:else>				
				</tr>					
			</s:iterator>
			<tr>
				<td>帳戶餘額</td>
				<td><s:property value="#request.account.balance" /></td>
				<td></td><td></td><td></td>				
			</tr>
		</table>
		</div>
	</div>

	<s:include value="/footer.html" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="/ss2h-mybank/js/user.js"></script>

</body>
</html>