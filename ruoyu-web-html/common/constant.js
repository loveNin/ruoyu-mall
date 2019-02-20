var basePath = "http://68.61.113.44:8888";

var base_success_code = "000000";//后台成功的状态码
var base_fail_code = "999999";//后台失败的状态码

var sessionout_code = 777;//session过期后台返回状态码

var token = document.cookie;//用户SSO令牌

var login_url = basePath + "/sys/user/login";//用户登录
var regist_url = basePath + "/sys/user/register";//用户注册
var sendSecurityCode_url = basePath + "/sys/user/sendMobileCode";//手机发送验证码
var sendMailCode_url = basePath + "/sys/user/sendMailCode";//邮件发送验证码
var updatePassword_url = basePath + "/sys/user/updatePassword";//用户修改密码



/**
 * 重写ajax方法，用于session过期跳转到登录页面
 * @param {Object} $
 */
(function($) {
	//备份jquery的ajax方法  
	var _ajax = $.ajax;
	//重写jquery的ajax方法  
	$.ajax = function(opt) {
		//备份opt中error和success方法  
		var fn = {
			error: function(XMLHttpRequest, textStatus, errorThrown) {
			},
			success: function(data, textStatus) {
			}
		}
		if(opt.error) {
			fn.error = opt.error;
		}
		if(opt.success) {
			fn.success = opt.success;
		}

		//扩展增强处理  
		var _opt = $.extend(opt, {
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				var resText = XMLHttpRequest.responseText;
				if(resText != null && resText != ''){
					var response = JSON.parse(resText);
					console.log(response);
					if(response.status == sessionout_code){//如果错误状态码为session过期状态码
						window.location.href = "login.html";
						return;
					}
				}
				//错误方法增强处理
				fn.error(XMLHttpRequest, textStatus, errorThrown);
			},
			success: function(data, textStatus) {
				console.log("sycces");
				//成功回调方法增强处理  
				fn.success(data, textStatus);
			}
		});
		_ajax(_opt);
	};
})(jQuery);