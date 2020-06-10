<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		
		function checkroleName(){
			var roleName=$("#roleName").val();
			var dpm=$("#dpm").val();
			var tip=$("#roleName_id")[0];
			if(roleName==null || roleName.trim().length==0){
				tip.innerHTML="职位名称不能为空";
				tip.style.color="red";
				return false;
			}else{
				$.ajax({
					type:"post",
					url:"role/checkroleName",
					data:{roleName:roleName,dpmId:dpm},
					success:function(result){
						if(result.length==4){
							$("#roleName_id").html(result);
							$("#roleName_id")[0].style.color="blue";
						}else{
							$("#roleName_id").html(result);
							$("#roleName_id")[0].style.color="red";
						}
					}
				});
				return true;
			}
		}
		
		
		function checkroleDescription(){
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
		
		
		function checkrole(){
			var tip=$("#roleName_id")[0];					
			var list =new Array();
			list[0]=checkroleName();
			list[1]=checkroleDescription();
			
			for (var i = 0; i < list.length; i++) {
				var result = list[i];
				if (result == false) {
					alert("1:请确保信息无误后再提交!");
					return false;
				}
			}
			// 可以使用
			if(tip.innerHTML.length==4){
				document.forms[0].submit();
			}else{	
				alert("2:请确保信息无误后再提交!");
				return false;
			}				
		}
	</script>
	<!-- <style type="text/css">
	
	body {
		background-image: url('images/bai.gif');
		background-size: 100% 100%;
		padding: 0;
		margin: 0;
	}
	</style> -->
  </head>
  
  <body>
     <form action="role/saveRole" method="post">
     	<table style="padding-top: 100px;padding-left: 190px;">
     		<tr>
     			<td style="text-align: right;"><b>职位添加</b></td>
     		</tr>
     		
     		<tr>
     			<td style="text-align: right;">职位名称:</td>
     			<td><input type="text" style="width: 220px;" name="roleName" id="roleName" onblur="checkroleName()"></td>
     			<td><div id="roleName_id"></div></td>
     		</tr>
     		
     		<tr>
     			<td style="text-align: right;">所属部门:</td>
     			<td>
     			   <select name="dpm" id="dpm" onchange="checkroleName()">
     					<c:if test="${not empty dpmList}">
     					   <c:forEach items="${dpmList}" var="dpm">
     					   	   <c:if test="${dpm==dpmList[0]}">
     					   	   	  <option value="${dpm.dpmId}" selected>${dpm.dpmName}</option>
     					   	   </c:if>
     					   	   <c:if test="${dpm!=dpmList[0]}">
     					   	      <option value="${dpm.dpmId}">${dpm.dpmName}</option>
     					   	   </c:if>
     					   </c:forEach>
     					</c:if>
     					<c:if test="${empty dpmList}">
     						<option>暂无类别</option>
     					</c:if>
     				</select>
     			</td>
     		</tr>
     		
     		<tr>
     			<td style="text-align: right;">职位描述:</td>
     			<td><textarea rows="5" cols="31" name="roleDescription" id="roleDescription" onblur="checkroleDescription()"></textarea></td>
     			<td><div id="roleDescription_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">职位等级:</td>
     			<td><input type="text" style="width: 220px;" name="roleLevel" id="roleLevel"></td>
     			<td><div id="roleLevel_id"></div></td>
     		</tr>
     		
     		<%-- <tr>
     			<td style="text-align: right;">分类:</td>
     			<td>
     			   <select name="typeName" id="typeName">
     					<c:if test="${not empty typeList}">
     					   <c:forEach items="${typeList}" var="type">
     					   	   <option value="${type.typeId}">${type.typeName}</option>
     					   </c:forEach>
     					</c:if>
     					<c:if test="${empty typeList}">
     						<option>暂无类别</option>
     					</c:if>
     				</select>
     			</td>
     		</tr> --%>
     		
     	</table>
     	<br>
     	<div style="padding-left: 300px;">
     		<input type="button" value="保存" onclick="checkrole()">
     		<input type="button" style="margin-left: 30px;" value="返回" onclick="location.href='javascript:history.go(-1);'">
     	</div>
     	
     </form>
  </body>
</html>
