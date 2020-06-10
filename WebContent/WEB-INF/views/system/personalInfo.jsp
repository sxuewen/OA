<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<table align="center" cellspacing="0" border="0">
		<tr>
			<td colspan="2" style="text-align:center;"><h2><b>个人信息</b></h2></td>
		</tr>
		<tr>
			<td style="text-align: right;">用户名：</td>
			<td><input type="text" value="${sfInfo.sfUserName}" style="color: brown;" disabled="disabled"></td>
		</tr>
		<tr>
			<td style="text-align: right;">真实姓名：</td>
			<td><input type="text" value="${sfInfo.sfRealName}" style="color: brown;" disabled="disabled"></td>
		</tr>
		<tr>
			<td style="text-align: right;">性别：</td>
			<td><input type="text" value="${sfInfo.sfSex}" style="color: brown;" disabled="disabled"></td>
		</tr>
		<tr>
			<td style="text-align: right;">身份证号：</td>
			<td><input type="text" value="${sfInfo.sfCard}" style="color: brown;" disabled="disabled"></td>
		</tr>
		<tr>
			<td style="text-align: right;">手机号：</td>
			<td><input type="text" value="${sfInfo.sfPhone}" style="color: brown;" disabled="disabled"></td>
		</tr>
		<tr>
			<td style="text-align: right;">联系地址：</td>
			<td><textarea rows="5" cols="22" disabled="disabled" style="color: brown;">${sfInfo.sfAddress}</textarea></td>
		</tr>
		<tr>
			<td style="text-align: right;">电子邮箱：</td>
			<td><input type="text" value="${sfInfo.sfEmail}" style="color: brown;" disabled="disabled"></td>
		</tr>
		<tr>
			<td style="text-align: right;">部门名称：</td>
			<td><input type="text" value="${sfInfo.dpmName}" style="color: brown;" disabled="disabled"></td>
		</tr>
		<tr>
			<td style="text-align: right;">职位名称：</td>
			<td><input type="text" value="${sfInfo.roleName}" style="color: brown;" disabled="disabled"></td>
		</tr>
	</table>


	<div align="center" style="padding-top: 5%">
		<a href="updatePersonalInfo?sfId=${sfInfo.sfId}">修改个人信息</a>
	</div>
</body>
</html>