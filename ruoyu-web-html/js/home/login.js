/**
 * 登录方法
 */
function login(){
	$("#message-propmt").html("");
	var userName = $("#userName").val();
	var password = $("#password").val();
	if(userName == null || userName == ''){
		$("#message-propmt").html("请输入登录用户名/邮箱/手机号");
		$("#userName").focus();
		return;
	}
	
	if(password == null || password == ''){
		$("#message-propmt").html("请输入登录用户密码");
		$("#password").focus();
		return;
	}
	var param = {"userName" : userName, "password" : password};
	
	$.ajax({
		url : login_url,
		type : "post",
		dataType : "json",
		data : JSON.stringify(param),
		contentType : "application/json;charset=utf-8",
		success : function(result) {
			if(result.code == base_success_code){
				document.cookie = result.token;
				window.location.href = 'home.html';
			}else{
				$("#message-propmt").html(result.msg);
				$("#message-propmt").css("visibility", "visible");
			}
		}
	})
}