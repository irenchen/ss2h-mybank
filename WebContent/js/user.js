
function verifyNumber(input) {	
	var pattern = /\D+/i;
	if(pattern.test(input)) {
		console.log("verifyNumber : false");
		return false;
	} else {
		console.log("verifyNumber : true");
		return true;
	}
}

function displayTime() {
	setInterval(function() {
		var now = new Date();
		var hour = now.getHours();		
		var min = now.getMinutes();
		var sec = now.getSeconds();
		var hourStr = (hour<10) ? '0' + hour : '' + hour;
		var minStr = (min<10) ? '0' + min : '' + min;
		var secStr = (sec<10) ? '0' + sec : '' + sec;
		$('#time').css('color', 'rgb(50,200,50)').text(hourStr + ":" + minStr + ":" + secStr);
	}, 1000);
}

function confirmLogout() {
	// /console.log("confirm logout...");
	var ans = confirm("Do you want to logout?");
	if (ans) {
		location.href = '/ss2h-mybank/user/logout';
	} else {
		return;
	}
}