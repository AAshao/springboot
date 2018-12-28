<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String path=request.getContextPath(); 
String bathPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=bathPath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="common/css/css.css">
<link type="text/css" href="common/css/common.css">
<script type="text/javascript" src="common/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="common/js/jquery.validate.js"></script>
<script type="text/javascript" src="common/js/jquery.blockUI.js"></script>
<script type="text/javascript" src="common/js/jQuery.md5.js"></script>
<script type="text/javascript" src="common/js/encoder.js"></script>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>
<script type="text/javascript">
/* 作用是在表单验证成功提交时alert成功，随后清空form表单 */
$.validator.setDefaults({
		
});
$(document).ready(function(){
	  /* 验证myform表单 */
	  $("#myform").validate({ 
		  /* validate 校验规则 */
		  rules:{
			  sex:{ /* 通过每个元素的name属性来添加相应的验证规则 */
				  required:true /* required是validate默认的一个验证规则，作用是限制该元素的值不能为空 */
			  },
			  like:{
				  required:true
			  },
			  location:{
				  required:true
			  },
			  self:{
				  required:true,
				  email:true
			  },
			  //使用ajax校验表单的值
			  username:{
				  required:true,
				  remote:{
					  url:"user/ajaxRequest",
					  type:"post",
					  data:{
						  username:function(){
			                   return $("#username").val();
			                }
					  },
					  dataType:"json"
				  }
			  }
		  },
		  /* 错误提示信息。如果不定义，默认会根据每个元素使用的验证规则显示默认提示信息，是英文的 
		             错误信息和rules是相对应的，根据name属性和验证规则来定义错误提示信息。  */
		  messages:{
			  sex:{ 
				  required:"请选择性别！" ,
		  
			  },
			  like:{
				  required:"至少选择一个爱好！"
			  },
			  location:{
				  required:"请选择户籍所在地！"
			  },
			  self:{
				  required:"请填写自我介绍！",
				  email:"email格式不正确"
			  },
			  username:{
				  required:"用户名不能为空！",
				  remote:"用户名错误"
			  }
		  },
		  //errorLabelContainer:$("#divId"),
		  /* radio CheckBox会有多个input框,会导致错误信息位置错乱,所以指定错误信息位置 */
		  errorPlacement: function (error, element) { /* 指定错误信息位置 */
			  /* 如果是radio或checkbox */
		      	 error.appendTo("#divId"); /* 将错误信息添加当前元素的父结点后面 */
		  },
		  //验证成功后，提交表单
		  submitHandler: function() {
				$("#myform").submit();
		}
	  });
	  //
	  $("#myform").focus(function(){
		 console.info("123"); 
	  });
});
/**
 * 弹出层
 */
function addDept(){
   	/* 弹出blockUI弹出层 */
	$.blockUI({
		message: $("#box_open"),/* 弹出层上显示的信息 */
		css: {/* 弹出层的样式 */
			width: '40%',
			top: '30%',/*top属性可以调整弹出层的上下位置，左右位置使用left属性，属性值可以是针对容器的百分比，也可以是30px*/
			border: 'none'
	    }
    }); 
}
/**
 * 关闭
 */
 function removeTip(){
	 $.unblockUI();
} 
/**
 * ajax传递数组测试
 */
 function ajaxArrReq(){
	var md5Str=$.encoder({"data":"zhangsan",encType:1});
	$.deleteId(121);
	console.info(start);
	//var arr=["12","34","56"];
	var obj={};
	obj.name="张三";
	obj.age=23;
	obj.sex="男";
	console.info(JSON.stringify(obj));
	$.ajax({
		url:"user/ajaxArr",
		dataType:"text/html",
		type:"post",
		data:{
			"arr":JSON.stringify(arr)
		},
		success:function(res){
			console.info(res);
		}
	}); 
}
/**
 * jquery测试
 */
$.extend(
	{
		add:function(a,b){
			return a+b;
		}
	}	
);
(function($){
	window.start="123456789";
	$.deleteId=function(opt){
		console.info(opt);
	}
	console.info(1212121);
})(jQuery)

$(document).ready(function(){
	console.info(121212);
})
window.onload=function(){
	console.info("load");
}
$(function(){
	
})
</script>
	<h3> <c:if test="${not empty user }">欢迎你:${user.username}</c:if> </h3>
	<p>Hello <c:if test="${not empty name}">${name}!</c:if></p>
	
	
	<!-- form表单提供ID属性。-->
<form action="user/hello" method="post" id="myform">
  <table>
  	<tr>
  		<th>姓名</th>
  		<td>
  			<input type="text" name="username"  id="username"/>
  		</td>
  	</tr>
    <tr>
      <th>性别:</th>
      <td>
        <!-- 导入两个js文件后  控件添加  required 属性  表单提交会有默认提示 -->
        <!-- input提供name属性，validate根据input的name属性来进行校验的 -->
        <input type="radio" name="sex" value="男" id="sex" required/>男
        <input type="radio" name="sex" value="女" id="sex" required/>女
      </td>
    </tr>
    <tr>
      <th>爱好:</th>
      <td>
        <input type="checkbox" name="like" value="打游戏" id="like" required/>打游戏
        <input type="checkbox" name="like" value="旅游" id="like" required/>旅游
        <input type="checkbox" name="like" value="运动" id="like" required/>运动
      </td>
    </tr>
    <tr>
      <th>户籍所在地:</th>
      <td>
        <select name="location" required>
          <option value="">-请选择-</option>
          <option value="河北省">河北省</option>
          <option value="山东省">山东省</option>
          <option value="四川省">四川省</option>
        </select>
      </td>
    </tr>
    <tr>
      <th>自我介绍:</th>
      <td><textarea rows="" cols="" name="self"></textarea></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="提交"/></td>
    </tr>
  </table>
  <div id="divId"></div>
</form>
<input type="button" onclick="addDept()" value="弹出层">
<input type="button" onclick="ajaxArrReq();" value="ajaxArr">  
<div id="" style="display:none">
	<p>弹出的信息</p>
	<a href="javascript:removeTip();">取消</a>
</div>
<div class="pop_windowsTip" style="width: 380px; display:none" id="box_open">
			<h4><span>提示信息</span><a class="close" href="#"></a></h4>
			<div class="popcon">
				<p class="tipstit red">抱歉，不能提交！</p>
				<span class="tipsdescrip">有未填写的表单不能提交！</span>
			</div>
			<div class="pop_btnarea popbtnarea">
					<input class="btnsure" type="button" value="确 定" onclick="removeTip();" />
			</div>
</div>


</body>
</html>