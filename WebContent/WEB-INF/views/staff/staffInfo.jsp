<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
</head>
<body>
	<div>
	  <c:if test="${not empty staffInfo}">
		<table>
			<tr>
				<td>&nbsp;用户名：</td>
				<td><input type="text" style="color: brown;" value="${staffInfo.sfUserName}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>真实姓名：</td>
				<td><input type="text" style="color: brown;" value="${staffInfo.sfRealName}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>&nbsp;性&nbsp;别：</td>
				<td><input type="text" style="color: brown;" value="${staffInfo.sfSex}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td><input type="text" style="color: brown;" value="${staffInfo.sfCard}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>手机号码：</td>
				<td><input type="text" style="color: brown;" value="${staffInfo.sfPhone}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>联系地址：</td>
				<td><textarea rows="5" style="color: brown;" cols="21" readonly="readonly">${staffInfo.sfAddress}</textarea></td>
			</tr>
			<tr>
				<td>电子邮箱：</td>
				<td><input type="text" style="color: brown;" value="${staffInfo.sfEmail}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>所属部门：</td>
				<td><input type="text" style="color: brown;" value="${staffInfo.dpmName}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>所属职位：</td>
				<td><input type="text" style="color: brown;" value="${staffInfo.roleName}" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="返回" onclick="location.href='javascript:history.go(-1);'"></td>
			</tr>
		</table>
	  </c:if>
	  
	  <c:if test="${empty staffInfo}">
	  	<h1>信息为空!</h1>
	  </c:if>
	</div>
</body>
</html>