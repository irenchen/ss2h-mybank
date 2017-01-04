<header class="w3-container w3-yellow" style="position:relative;">
	<h1><a href="/ss2h-mybank/index.jsp" style="text-decoration:none;">Welcome to My Web Bank 3.0</a></h1>
	<h4 style="position:absolute;right:30px;top:40px;color:blue;">user : <%= session.getAttribute("username") %></h4>
	<!--  
	<h4>name : ${sessionScope.username}</h4>
	<h4>name : <s:property value="#session.username" /></h4>
	-->
</header>
