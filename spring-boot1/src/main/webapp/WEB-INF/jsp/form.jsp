<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="common/js/jquery-3.1.1.js"></script>
<script src="common/js/jquery.form.js"></script>
<script src="common/js/validate/jquery.validate.min.js"></script>
<script src="common/js/validate/additional-methods.min.js"></script>
<script src="common/js/validate/localization/messages_zh.min.js"></script>

<title>table--页面测试</title>
</head>
<body>
	<h2>
		测试提交一个table表单		
	</h2>
	<form action="" method="post" id="table-form">
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>姓名</th>
					<th>年龄</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input id="userId" name="userList[0].userId"></td>
					<td><input id="userName" name="userList[0].username"></td>
					<td><input id="userAge" name="userList[0].userAge"></td>
				</tr>
				<tr>
					<td><input id="userId" name="userList[1].userId"></td>
					<td><input id="userName" name="userList[1].username"></td>
					<td><input id="userAge" name="userList[1].userAge"></td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="submit" value="保存">  <!-- onclick="saveForm()" -->
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<script type="text/javascript">
		$(function(){
			$("#table-form").attr("action","saveForm");
			$("#table-form").ajaxForm(
				{
					success:function(req){
						console.info(req);
					}
				}
			);
		});
		function saveForm(){
			$("#table-form").ajaxSubmit({
				
			});
			return false;
		}
	</script>
</body>
</html>