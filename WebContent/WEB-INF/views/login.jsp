<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	function checkUserName() {
		var userName=$("#userName");
		if (userName.val().trim()==null||userName.val().trim().length==0) {
			$("#tip1")[0].style.display=="block";
			userName.focus();
			return false;
		}else{
			$("#tip1")[0].style.display=="none";
			return true;
		}
		
	}
	function checkPassword() {
		var password=$("#password");
		if (password.val().trim()==null||password.val().trim().length==0) {
			$("#tip2")[0].style.display=="block";
			password.focus();
			return false;
		} else {
			$("#tip2")[0].style.display=="none";
			return true;
		}
	}
	function checkAll(){
		if (checkUserName()==true&&checkPassword()==true) {
			document.forms[0].submit();
		} else {
			alert("请确保信息无误后再提交!");
			return false;
		}
	}
</script>
</head>
<body>
	<div>		
		<form action="staff/userLogin" method="post" id="form">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="userName" id="userName" onblur="checkUserName()"></td>
					<td id="tip1" style="display: none;"><span>用户名不正确!</span></td>
					<td>${error}</td>
				</tr>
				<tr>
					<td>密 码：</td>
					<td><input type="password" name="password" id="password" onblur="checkPassword()"></td>
					<td id="tip2" style="display: none;"><span>密码有误!</span></td>
				</tr>
				<tr>
					<td><input type="button" onclick="checkAll()" value="提交"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>		
	</div>
</body>
</html>