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
	<script type="text/javascript" src="js/laydate/laydate.js"></script>
	
	<script type="text/javascript">
		
		
	function checkNotTitle(){
		var notTitle=$("#notTitle").val();
		var tip=$("#notTitle_id")[0];
		if(notTitle==null || notTitle.trim().length==0){
			tip.innerHTML="公告标题不能为空";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}
	}	
	
	function checkNotContent(){
		var notContent=$("#notContent").val();
		var tip=$("#notContent_id")[0];
		if(notContent==null || notContent.trim().length==0){
			tip.innerHTML="公告内容不能为空";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}
	}		
	
	
	function checkNotice(){					
		if (checkNotTitle()==true && checkNotContent()==true) {
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
     <form action="notice/updateNotice" method="post">
     	<input type="hidden" name="notId" id="notId" value="${noticeVo.notId}"> 
     	<table style="padding-top: 100px;padding-left: 190px;">
     		<tr>
     			<td style="text-align: right;"><b>公告修改</b></td>
     		</tr>
     		
     		<tr>
     			<td style="text-align: right;">公告标题:</td>
     			<td><input type="text" style="width: 220px;" name="notTitle" id="notTitle" value="${noticeVo.notTitle}" onblur="checkNotTitle()"></td>
     			<td><div id="notTitle_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">公告内容:</td>
     			<td><textarea rows="5" cols="31" name="notContent" id="notContent" onblur="checkNotContent()">${noticeVo.notContent}</textarea></td>
     			<td><div id="notContent_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">发布时间:</td>
     			<td><input type="text" style="width: 220px;" name="notDate" id="notDate" value="${noticeVo.notDate}" readonly></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">发布人:</td>
     			<td><input type="text" style="width: 220px;" name="adminName" id="adminName" value="${noticeVo.adminName}" readonly></td>
     		</tr>
     		<tr>
     			<td><input type="button" value="保存" onclick="checkNotice()"></td>
     			<td><input type="button" value="返回" onclick="location.href='javascript:history.go(-1);'"></td>
     		</tr>
     	</table>
     </form>
  </body>
</html>
