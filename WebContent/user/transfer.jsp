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

		<h3>轉帳交易設定畫面</h3>
		<div class="w3-container" style="width:35%;min-width:200px;">
			<form action="user/transfer" method="post">
				<label class="w3-label w3-black">請輸入轉入帳戶</label>
				<input class="w3-input w3-pale-yellow" type="text" name="toAccountId" required/>
				<span class="w3-small w3-text-red"></span><br/>
				<label class="w3-label w3-black">請輸入轉帳金額</label>
				<input class="w3-input w3-pale-yellow" type="text" name="transferAmount" required/>
				<span class="w3-small w3-text-red"></span><br/>
				<input class="w3-btn w3-pink w3-right" type="submit" value="轉帳" /><br/> 
			</form> 
		</div>

	</div>

	<s:include value="/footer.html" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="/ss2h-mybank/js/user.js"></script>
<script>
	$(document).ready(function() {
		
		$('input:first').focus();
		// 檢查是否輸入非數字，或零
		$('form').submit(function(e) {
			$('span').empty();
			var aid = $('input:first').val().trim();

			if(!verifyNumber(aid) || !parseFloat(aid)) {
				$('span:eq(0)').text('invalid account format');
				e.preventDefault();
				return;
			}
			var amount = $('input:eq(1)').val().trim();

			if(!verifyNumber(amount) || !parseFloat(amount)) {
				$('span:eq(1)').text('invalid money format');
				e.preventDefault();
				return;
			}
			//$('span').text('correct input format');	
		});
	});
	
	function verifyNumber(input) {	
		var pattern = /\D+/i;
		if(pattern.test(input)) {
			return false;
		} else {
			return true;
		}
	}
</script>
</body>
</html>