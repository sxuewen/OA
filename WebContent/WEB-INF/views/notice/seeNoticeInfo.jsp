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
		$(function(){
			var flag=$("#flag").val();
			if(flag==1){  // 已读
				$("#btn").attr("disabled","disabled");
				$("#btn").attr("value","已读");
			}
		});
		
		function judgeState(){	
			var sfId=$("#sfId").val();
			var notId=$("#notId").val();		
			$.post("notice/setHaveRead",{"notId":notId,"sfId":sfId});
			$("#btn").attr("disabled","disabled");
			$("#btn").attr("value","已读");
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
     <form action="###" method="post">
     	<input type="hidden" id="flag" value="${noticeVo.flag}">
     	<input type="hidden" id="notId" value="${noticeVo.notId}">
     	<input type="hidden" id="sfId" value="${staff.sfId}">
     	<table style="padding-top: 100px;padding-left: 190px;">
     		<tr>
     			<td style="text-align: right;"><b>公告详情</b></td>
     		</tr>
     		
     		<tr>
     			<td style="text-align: right;">公告标题:</td>
     			<td><input type="text" style="width: 220px;" name="notTitle" value="${noticeVo.notTitle}" disabled></td>     		
     		</tr>
     		<tr>
     			<td style="text-align: right;">公告内容:</td>
     			<td><textarea rows="5" cols="31" name="notContent" disabled>${noticeVo.notContent}</textarea></td>     	
     		</tr>
     		<tr>
     			<td style="text-align: right;">发布时间:</td>
     			<td><input type="text" style="width: 220px;" name="notDate" value="${noticeVo.notDate}" disabled></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">发布人:</td>
     			<td><input type="text" style="width: 220px;" name="adminName" value="${noticeVo.adminName}" disabled></td>
     		</tr>
     		
     		<tr>
     			<td><input type="button" id="btn" value="未读" onclick="judgeState()"></td>
     		</tr>
     		
     		<tr>
     			<td><input type="button" value="返回" onclick="window.location.href = document.referrer;"></td>
     		</tr>
     	</table>
     </form>
  </body>
</html>
