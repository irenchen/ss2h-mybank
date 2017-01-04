$(document).ready(function() {

	
	
});



var users = [];
var ready = false;

function listAllUsers() {
	$('#searchDiv').show();
	ready = false;
	AdminDWR.listAllUsers(callback);
}

function callback(data) {
	ready = true;
	users = data;
	var keyStr = "輸入使用者真實姓名 : <input type='text' id='key' size='10'>";
	keyStr += "</div>";

	$('#searchDiv').html(keyStr);
	$('#key').change(searchKey);
	build_table(users);
}

function build_table(users) {
	var tableStr = "";
	tableStr += "<table id='tb1' class='w3-table-all w3-tiny'>";
	tableStr += "<tr class='w3-green'><th>UserID</th><th>Username</th><th>Password</th>";
	tableStr += "<th>Realname</th><th>PID</th><th>Phone</th>";
	tableStr += "<th>AccountNo.</th><th>Status</th></tr>";

	for (var i = 0; i < users.length; i++) {
		var uid = users[i].id;
		tableStr += "<tr id='tr" + uid + "'><td>" + uid + "</td>";
		tableStr += "<td>" + users[i].username + "</td>";
		tableStr += "<td>" + users[i].password + "</td>";
		tableStr += "<td>" + users[i].realname + "</td>";
		tableStr += "<td>" + users[i].pid + "</td>";
		tableStr += "<td>" + users[i].phone + "</td>";
		tableStr += "<td>" + users[i].accounts[0].id + "</td>";
		tableStr += "<td>" + users[i].accounts[0].status.statusName
				+ "</td></tr>";
		tableStr += "<tr id='etr" + uid + "' style='display:none;'>";
		tableStr += "<td><button id='btn" + uid + "'>修改</button></td>";
		tableStr += "<td><input type='text' size='10' value='"
				+ users[i].username + "'></td>";
		tableStr += "<td><input type='text' size='10' value='"
				+ users[i].password + "'></td>";
		tableStr += "<td><input type='text' size='10' value='"
				+ users[i].realname + "'></td>";
		tableStr += "<td><input type='text' size='10' value='" + users[i].pid
				+ "'></td>";
		tableStr += "<td><input type='text' size='10' value='" + users[i].phone
				+ "'></td>";
		tableStr += "<td>" + users[i].accounts[0].id + "</td>";
		var status1 = (users[i].accounts[0].status.id == 1) ? 1 : 2;
		var status1_name = (users[i].accounts[0].status.id == 1) ? 'active'
				: 'disabled';
		var status2 = (users[i].accounts[0].status.id == 1) ? 2 : 1;
		var status2_name = (users[i].accounts[0].status.id == 1) ? 'disabled'
				: 'active';
		tableStr += "<td><select name='status'><option value='"
				+ users[i].accounts[0].status.id + "' checked>" + status1_name
				+ "<option value='" + status2 + "'>" + status2_name
				+ "</select></td></tr>";
	}
	tableStr += "</table>";

	$("#tableDiv").html(tableStr);
	$('tr[id^="tr"]').click(function() {
		if ($(this).next().css('display') == 'none') {
			$(this).next().show();
		} else {
			$(this).next().hide();
		}
	});
	$('tr input, select').change(function() {
		$(this).css('color', 'red');
	});
	// 按下修改後，收集資料，利用DWR->updateUser更新使用者帳號，並重新顯示結果
	$('#tableDiv button').click(function() {
		var user = {};
		user.id = $(this).attr('id').substring(3);
		// console.log("user ID : " + user.id);
		var inputs = $(this).parent().parent().find('input');

		user.username = inputs.eq(0).val();
		user.password = inputs.eq(1).val();
		user.realname = inputs.eq(2).val();
		user.pid = inputs.eq(3).val();
		user.phone = inputs.eq(4).val();
		user.accountStatus = $(this).parent().parent().find('select').val();
		// /console.log(user.username + ", " + user.phone + ", " +
		// user.accountStatus);

		// 呼叫Ajax method
		AdminDWR.updateUser(user, afterUpdate);

	});
}

function searchKey() {
	var search_results = [];
	var key = $('#key').val().trim();
	if (key.length == 0 || key === "") {
		build_table(users);
		return;
	}
	for (var i = 0; i < users.length; i++) {
		var realname = users[i].realname;
		// console.log("key : " + key);
		// console.log("realname : " + realname);
		// console.log("result : " + realname.indexOf(key));
		if (realname.indexOf(key) != -1) {
			// console.log("found...");
			search_results.push(users[i]);
		}
	}
	build_table(search_results);
}

function afterUpdate(user) {
	if (user == null) {
		console.log("error while updating user...");
	} else {
		// update User details...
		console.log("success updating user..." + user.username);
		var uid = user.id;
		var trNo = 'tr' + uid;
		var trStr = "";
		trStr += "<td>" + uid + "</td>";
		trStr += "<td>" + user.username + "</td>";
		trStr += "<td>" + user.password + "</td>";
		trStr += "<td>" + user.realname + "</td>";
		trStr += "<td>" + user.pid + "</td>";
		trStr += "<td>" + user.phone + "</td>";
		trStr += "<td>" + user.accounts[0].id + "</td>";
		trStr += "<td>" + user.accounts[0].status.statusName + "</td>";

		$('tr').each(function() {
			if ($(this).attr('id') == trNo) {
				$(this).html(trStr);
			}
		});
		// update users
		AdminDWR.listAllUsers(updateAllUsers);
	}
}

function updateAllUsers(data) {
	users = data;
}

function listActiveUsers() {
	$('#searchDiv').hide();
	var results = [];
	if(users.length != 0) {
		for(var i=0; i<users.length; i++) {
			if(users[i].accounts[0].status.id == 1) {
				results.push(users[i]);
			}
		}
		build_table(results);
		return;
	} else {
		AdminDWR.listAllUsers(function(data) {
			users = data;
			for(var i=0; i<users.length; i++) {
				if(users[i].accounts[0].status.id == 1) {
					results.push(users[i]);
				}
			}
			build_table(results);
		});
	}	
}

function listDisabledUsers() {
	$('#searchDiv').hide();
	var results = [];
	if(users.length != 0) {
		for(var i=0; i<users.length; i++) {
			if(users[i].accounts[0].status.id == 2) {
				results.push(users[i]);
			}
		}
		build_table(results);
		return;
	} else {
		AdminDWR.listAllUsers(function(data) {
			users = data;
			for(var i=0; i<users.length; i++) {
				if(users[i].accounts[0].status.id == 2) {
					results.push(users[i]);
				}
			}
			build_table(results);
		});
	}	
}

function confirmLogout() {
	// /console.log("confirm logout...");
	var ans = confirm("Do you want to logout?");
	if (ans) {
		location.href = '/ss2h-mybank/admin/logout';
	} else {
		return;
	}
}