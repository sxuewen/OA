<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	
	function checkRoleDescription(){
		var roleDescription=$("#roleDescription").val();
		var tip=$("#roleDescription_id")[0];
		if(roleDescription==null || roleDescription.trim().length==0){
			tip.innerHTML="职位描述不能为空";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}
	}			
	
	function checkRoleInfo(){					
		if (checkRoleDescription()==true) {
			document.forms[0].submit();
		}else{
			alert("请确保信息无误后再提交!")
			return false;
		}	
	}
	
	</script>
	
	<!-- <style type="text/css">
	
	body {
		background-image: url('images/mei.gif');
		background-size: 100% 100%;
		padding: 0;
		margin: 0;
	}
	</style> -->
  </head>
  
  <body>
     <form action="role/updateRole" method="post">
     	<input type="hidden" name="roleId" id="roleId" value="${roleInfo.roleId}"> 
     	<table style="padding-top: 100px;padding-left: 190px;">
     		<tr>
     			<td style="text-align: right;"><b>职位修改</b></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">职位名称:</td>
     			<td><input type="text" style="width: 220px;" name="roleName" id="roleName" value="${roleInfo.roleName}" disabled></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">职位描述:</td>
     			<td><textarea rows="5" cols="31" name="roleDescription" id="roleDescription" onblur="checkRoleDescription()">${roleInfo.roleDescription}</textarea></td>
     			<td><div id="roleDescription_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">所属部门:</td>
     			<td><input type="text" name="dpmName" id="dpmName" value="${roleInfo.dpmName}" disabled></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">职位等级:</td>
     			<td><input type="text" style="width: 220px;" name="roleLevel" id="roleLevel" value="${roleInfo.roleLevel}"></td>
     			<td><div id="roleLevel_id"></div></td>
     		</tr>
     		<tr>
     			<td><input type="button" value="保存" onclick="checkRoleInfo()"></td>
     			<td><input type="button" value="返回" onclick="location.href='javascript:history.go(-1);'"></td>
     		</tr>
     	</table>
     </form>
  </body>
</html>
