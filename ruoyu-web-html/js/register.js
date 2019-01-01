/*获取验证码*/
var isPhone = 1;
function getCode(e){
	//checkPhone(); //验证手机号码
	if(isPhone){
		resetCode(); //倒计时
	}else{
		$('#phone').focus();
	}
	
}
//验证手机号码
function checkPhone(){
	var phone = $('#phone').val();
	var pattern = /^1[0-9]{10}$/;
	isPhone = 1;
	if(phone == '') {
		alert('请输入手机号码');
		isPhone = 0;
		return;
	}
	if(!pattern.test(phone)){
		alert('请输入正确的手机号码');
		isPhone = 0;
		return;
	}
}
//倒计时
function resetCode(){
	var second = 10;
	var timer = null;
	$('#getAuthNum').hide();
	$('#J_second').html(second);
	$('#resetCode').show();
	timer = setInterval(function(){
		second--;
		if(second >0 ){
			$('#J_second').html(second);
		}else{
			clearInterval(timer);
			$('#getAuthNum').show();
			$('#resetCode').hide();
		}
	},1000);
}