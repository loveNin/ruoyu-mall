/**
 * 给输入框绑定失去焦点事件
 */
//window.onload = function(){
//	$("#userName").on("blur", checkUserName);
//	$("#password").on("blur", checkPassword);
//	$("#phone").on("blur", checkPhone);
//	$("#authNum").on("blur", checkSecurityCode);
//	
//	
//}

/**
 * 去登录 
 */
function goLogin(){
	window.location.href = "login.html";
}


/********************************************** 邮箱注册部分 *****************************************************************************/
/**
 * 用户注册方法
 */
function registerByMail(){
	var userName = $("#userName-mail").val();
	var password = $("#password-mail").val();
	var email = $("#email").val();
	var securityCode = $("#code-mail").val();
	
	if(checkUserNameByMail() && checkEmail() && checkMailCode() && checkPasswordByMail()){
		var param = {
			userName : userName, 
			password : password, 
			email : email, 
			securityCode : securityCode,
			phoneNumber:""
		}
		
		$.ajax({
			url : regist_url,
			type : "post",
			dataType : "json",
			data : JSON.stringify(param),
			contentType : "application/json;charset=utf-8",
			success : function(result) {
				if(result.code == base_success_code){
					//window.location.href = 'login.html';
				}else{
					$("#message-mail").html(result.msg);
				}
			}
		})
	}
}

/*获取验证码*/
function sendEmailCode(){
	var email = $('#email').val();
	var isEmail = checkEmail(); //验证邮箱
	if(isEmail){
		sendCode(email);//给邮箱发验证码
		resetCodeByMail(); //倒计时
	}else{
		$('#email').focus();
	}
}

//给邮箱发验证码
function sendCode(email){
	$.post(sendMailCode_url, {email : email});
}

//验证验证码
function checkMailCode(){
	$("#message-mail").html("");
	var authNum = $('#code-mail').val();
	if(authNum == null || authNum == '') {
		$("#message-mail").html('请输入验证码');
		$("#code-mail").focus();
		return false;
	}
	return true;
}

//验证用户名
function checkUserNameByMail(){
	$("#message-mail").html("");
	var userName = $('#userName-mail').val();
	var pattern = /^[A-Za-z0-9]{3,10}$/;
	if(userName == null || userName == '') {
		$("#message-mail").html('请输入用户名');
		$("#userName-mail").focus();
		return false;
	}
	if(!pattern.test(userName)){
		$("#message-mail").html('请输入3~10位数字和英文字符组成的用户名');
		$("#userName-mail").focus();
		return false;
	}
	return true;
}

//验证用户密码
function checkPasswordByMail(){
	$("#message-mail").html("");
	var password = $('#password-mail').val();
	var pattern = /^[A-Za-z0-9]{8,15}$/;
	if(password == null || password == '') {
		$("#message-mail").html('请输入密码');
		$("#password-mail").focus();
		return false;
	}
	if(!pattern.test(password)){
		$("#message-mail").html('请输入8~15位数字和英文字符组成的密码');
		$("#password-mail").focus();
		return false;
	}
	return true;
}

//验证邮箱地址
function checkEmail(){
	$("#message-mail").html("");
	var email = $('#email').val();
	var pattern = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
	if(email == null || email == '') {
		$("#message-mail").html('请输入邮箱地址');
		$("#email").focus();
		return false;
	}
	if(!pattern.test(email)){
		$("#message-mail").html('请输入正确的邮箱地址');
		$("#email").focus();
		return false;
	}
	return true;
}

//倒计时
function resetCodeByMail(){
	var second = 60;
	var timer = null;
	$('#sendMailCode').hide();
	$('#J_second_mail').html(second);
	$('#resetCode-mail').show();
	timer = setInterval(function(){
		second--;
		if(second >0 ){
			$('#J_second_mail').html(second);
		}else{
			clearInterval(timer);
			$('#sendMailCode').show();
			$('#resetCode-mail').hide();
		}
	},1000);
}


/************************************************** 手机号注册部分 *******************************************************************/
/**
 * 用户注册方法
 */
function registerByMobile(){
	var userName = $("#userName-mobile").val();
	var password = $("#password-mobile").val();
	var phoneNumber = $("#phone").val();
	var securityCode = $("#code-mobile").val();
	
	if(checkUserNameByMobile() && checkPhone() && checkMobileCode() && checkPasswordByMobile()){
		var param = {
			userName : userName, 
			password : password, 
			phoneNumber : phoneNumber, 
			securityCode : securityCode
		}
		
		$.ajax({
			url : regist_url,
			type : "post",
			dataType : "json",
			data : JSON.stringify(param),
			contentType : "application/json;charset=utf-8",
			success : function(result) {
				if(result.code == base_success_code){
					//window.location.href = 'login.html';
				}else{
					$("#message-mobile").html(result.msg);
				}
			}
		})
	}
}


/*获取验证码*/
function sendMobileCode(){
	var phone = $('#phone').val();
	var isPhone = checkPhone(); //验证邮箱
	if(isPhone){
		sendPhoneCode(phone);//给邮箱发验证码
		resetCodeByMobile() //倒计时
	}else{
		$('#phone').focus();
	}
}

//给手机号发验证码
function sendPhoneCode(phone){
	$.post(sendSecurityCode_url, {phoneNumber : phone});
}

//验证验证码
function checkMobileCode(){
	$("#message-mobile").html("");
	var authNum = $('#code-mobile').val();
	if(authNum == null || authNum == '') {
		$("#message-mobile").html('请输入验证码');
		$("#code-mobile").focus();
		return false;
	}
	return true;
}

//验证用户名
function checkUserNameByMobile(){
	$("#message-mobile").html("");
	var userName = $('#userName-mobile').val();
	var pattern = /^[A-Za-z0-9]{3,10}$/;
	if(userName == null || userName == '') {
		$("#message-mobile").html('请输入用户名');
		$("#userName-mobile").focus();
		return false;
	}
	if(!pattern.test(userName)){
		$("#message-mobile").html('请输入3~10位数字和英文字符组成的用户名');
		$("#userName-mobile").focus();
		return false;
	}
	return true;
}

//验证用户密码
function checkPasswordByMobile(){
	$("#message-mobile").html("");
	var password = $('#password-mobile').val();
	var pattern = /^[A-Za-z0-9]{8,15}$/;
	if(password == null || password == '') {
		$("#message-mobile").html('请输入密码');
		$("#password-mobile").focus();
		return false;
	}
	if(!pattern.test(password)){
		$("#message-mobile").html('请输入8~15位数字和英文字符组成的密码');
		$("#password-mobile").focus();
		return false;
	}
	return true;
}

//验证邮箱地址
function checkPhone(){
	$("#message-mobile").html("");
	var phone = $('#phone').val();
	var pattern = /^1[0-9]{10}$/;
	if(phone == null || phone == '') {
		$("#message-mobile").html('请输入手机号码');
		$("#phone").focus();
		return false;
	}
	if(!pattern.test(phone)){
		$("#message-mobile").html('请输入正确的手机号码');
		$("#phone").focus();
		return false;
	}
	return true;
}

//倒计时
function resetCodeByMobile(){
	var second = 60;
	var timer = null;
	$('#sendPhoneCode').hide();
	$('#J_second_mobile').html(second);
	$('#resetCode-mobile').show();
	timer = setInterval(function(){
		second--;
		if(second >0 ){
			$('#J_second_mobile').html(second);
		}else{
			clearInterval(timer);
			$('#sendPhoneCode').show();
			$('#resetCode-mobile').hide();
		}
	},1000);
}