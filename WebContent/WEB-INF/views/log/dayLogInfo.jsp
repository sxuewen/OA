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
     <form action="###" method="post">
     
     	<table style="padding-top: 100px;padding-left: 190px;">
     		<tr>
     			<td style="text-align: right;"><b>日志详情</b></td>
     		</tr>
     		
     		<tr>
     			<td style="text-align: right;">日志类型:</td>
     			<c:if test="${logVo.logType==1}">
			  	   <td><input type="text" style="width: 220px;" value="日报" disabled></td>
			  	</c:if>
			  	<c:if test="${logVo.logType==2}">
			  	   <td><input type="text" style="width: 220px;" value="周报" disabled></td>
			  	</c:if>
			  	<c:if test="${logVo.logType==3}">
			  	   <td><input type="text" style="width: 220px;" value="月报" disabled></td>
			  	</c:if>
			  	<c:if test="${logVo.logType==4}">
			  	   <td><input type="text" style="width: 220px;" value="会议纪要" disabled></td>		  	    
			  	</c:if>
     		</tr>
     		
     		<tr>
     		  <td>具体内容:</td>
     		  <td>
     			<table style="background-color: brown;">     				
     				<tr>
     					<td style="text-align: right;">工作总结:</td>
     					<td><textarea rows="5" cols="32" disabled>${dayLog.conclusion}</textarea></td>     				
     				</tr>
     				<tr>
     					<td style="text-align: right;">遇到的问题:</td>
     					<td><textarea rows="5" cols="32" disabled>${dayLog.problem}</textarea></td>    					
     				</tr>
     				<tr>
     					<td style="text-align: right;">解决方法:</td>
     					<td><textarea rows="5" cols="32" disabled>${dayLog.solution}</textarea></td>    					
     				</tr>
     				<tr>
     					<td style="text-align: right;">下一步计划:</td>
     					<td><textarea rows="5" cols="32" disabled>${dayLog.plan}</textarea></td>     					
     				</tr> 
     			</table>
     		  </td>     				     		
     		</tr>
     		
     		<tr>
     			<td style="text-align: right;">创建者:</td>
     			<td><input type="text" style="width: 220px;" value="${logVo.sfUserName}" disabled></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">所属部门:</td>
     			<td><input type="text" style="width: 220px;" value="${logVo.dpmName}" disabled></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">创建时间:</td>
     			<td><input type="text" style="width: 220px;" value="${logVo.logDate}" disabled></td>
     		</tr>
     		<tr>
     			<td><input type="button" value="返回" onclick="location.href='javascript:history.go(-1);'"></td>
     		</tr>
     	</table>
     </form>
  </body>
</html>
