
/**
 * 进入页面开始加载 1
 */
//自己制定校验规则
jQuery.validator.addMethod("check_username",function(value,element){
	var reg=/^[0-9a-zA-Z]+$/;
	return reg.test(value);
},"请输入正确格式的用户名");

$(function(){
	console.info("进入页面开始加载 1.");
	$("#loginForm").validate({
		debug:true,
		rules:{
			username:{
				required:true,
				check_username:true,
				remote:{
					type:"post",
					url:"user/checkUser",
					dataType:"json",
					data:{
						username:function(){
							return $("#username_id").val();
						}
					}
				}
			},
			password:{
				required:true
			}
		},
		messages:{
			username:{
				required:"请输入姓名",
				remote:"用户名不正确"
			},
			password:{
				required:"请输入密码"
			}
		},
		 errorPlacement: function (error, element) { /* 指定错误信息位置 */
			  /* 如果是radio或checkbox */
			// element.after(error);
			 error.appendTo(element.parent());
		     // 	 error.appendTo("#divId"); /* 将错误信息添加当前元素的父结点后面 */
		  },
		submitHandler:function(form){
			//alert("校验通过");
			//通过得到form表单对象提交
			var $form=$("#loginForm");
			console.info($form.get(0).username.value);
			console.info($form.get(0).password.value);
			//
//			var formData=new FormData(document.getElementById("loginForm"));
//			console.info("formData="+fromData);
			
			var seriabledForm=$form.serialize();
			console.info("seriabledForm="+seriabledForm);
			
			form.submit();
		}
	})
	
	
})
// 上面两种取决于顺序
$(document).ready(function(){
	console.info("进入页面开始加载3.");
})

//最快
window.onload=function(){
	console.info("进入页面开始加载2.");
}
