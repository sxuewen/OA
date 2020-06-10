<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="js/jquery-3.2.1.js"></script>

<script type="text/javascript">
	function checkOldpsd() {
		var oldpsd=$("#oldpsd").val();
		var tip=$("#oldpsd_id")[0];
		if(oldpsd==null || oldpsd.trim().length==0){
			tip.innerHTML="旧密码不能为空";
			tip.style.color="red";
			return false;
		}else{
			$.ajax({
				type:"post",
				url:"staff/checkPassword",
				data:{oldpsd:oldpsd},
				success:function(result){
					if(result.length==4){
						$("#oldpsd_id").html(result);
						$("#oldpsd_id")[0].style.color="blue";
					}else{
						$("#oldpsd_id").html(result);
						$("#oldpsd_id")[0].style.color="red";
					}
				}
			});
			return true;
		}
	}
	
	function checkNewpsd() {
		var newpsd=$("#newpsd").val();
		var tip=$("#newpsd_id")[0];
		// 密码，6到16位（至少一次大小写字母，数字，特殊符号）
		var reg = /^.*(?=.{6,16})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*?]).*$/;
		if (reg.test(newpsd)) {
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}else {
			tip.innerHTML="请输入正确的密码";
			tip.style.color="red";
			return false;
		}
	}
	
	function checkrepsd() {
		var newpsd=$("#newpsd");
		var renewpsd=$("#renewpsd");
		var tip=$("#renewpsd_id")[0];
		if(renewpsd.val()==null || renewpsd.val().trim().length==0 || renewpsd.val()!=newpsd.val()){
			tip.innerHTML="两次密码不一致";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			return true;
		}
	}
	
	function checkpsd() {
		var tip=$("#oldpsd_id")[0];					
		var list =new Array();
		list[0]=checkOldpsd();
		list[1]=checkNewpsd();
		list[2]=checkrepsd();
		
		for (var i = 0; i < list.length; i++) {
			var result = list[i];
			if (result == false) {
				alert("1:请确保信息无误后再提交!");
				return false;
			}
		}
		// 密码正确
		if(tip.innerHTML.length==4){
			document.forms[0].submit();
		}else{	
			alert("2:请确保信息无误后再提交!");
			return false;
		}	
	}
</script>

</head>
<body>
	<form action="staff/updatePassword" method="post">
		<table cellspacing="0" border="0" align="center" style="padding-top: 10%">
			<tr>
				<td>输入旧密码：</td>
				<td><input type="password" name="oldpsd" id="oldpsd" onblur="checkOldpsd()"></td>
				<td><div id="oldpsd_id"></div></td>
			</tr>
			<tr>
				<td>输入新密码：</td>
				<td><input type="password" name="newpsd" id="newpsd" onblur="checkNewpsd()"></td>
				<td><div id="newpsd_id"></div></td>
			</tr>
			<tr>
				<td>确认新密码：</td>
				<td><input type="password" name="renewpsd" id="renewpsd" onblur="checkrepsd()"></td>
				<td><div id="renewpsd_id"></div></td>
			</tr>
			
			<tr>
				<td><input type="button" value="保存" onclick="checkpsd()"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>