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
	<script type="text/javascript" src="js/laydate/laydate.js"></script>
	
	<script type="text/javascript">	
		$(function(){
			laydate.render({
			    elem: '#dpmCreatDate'  //指定元素
			});		
		});
		
		function checkdpmName(){
			var dpmName=$("#dpmName").val();
			var tip=$("#dpmName_id")[0];
			if(dpmName==null || dpmName.trim().length==0){
				tip.innerHTML="部门名称不能为空";
				tip.style.color="red";
				return false;
			}else{
				$.ajax({
					type:"post",
					url:"department/checkdpmName",
					data:{dpmName:dpmName},
					success:function(result){
						if(result.length==4){
							$("#dpmName_id").html(result);
							$("#dpmName_id")[0].style.color="blue";
						}else{
							$("#dpmName_id").html(result);
							$("#dpmName_id")[0].style.color="red";
						}
					}
				});
				return true;
			}
		}
		
		
		function checkdpmDescription(){
			var dpmDescription=$("#dpmDescription").val();
			var tip=$("#dpmDescription_id")[0];
			if(dpmDescription==null || dpmDescription.trim().length==0){
				tip.innerHTML="部门描述不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}		
		
		
		function checkdpm(){
			var tip=$("#dpmName_id")[0];					
			var list =new Array();
			list[0]=checkdpmName();
			list[1]=checkdpmDescription();
			
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
     <form action="department/saveDepartment" method="post">
    	<input type="hidden" name="parentId" value="${parentId}">
     	<table style="padding-top: 100px;padding-left: 190px;">
     		<tr>
     			<td style="text-align: right;"><b>部门添加</b></td>
     		</tr>
     		
     		<c:if test="${not empty parentId}">
     			<tr>
     				<td style="text-align: right;">上级部门:</td>
     				<td><input type="text" style="width: 220px;" value="${dpmName}" readonly></td>
     			</tr>
     		</c:if>
     		
     		<c:if test="${empty parentId}">
     			<tr>
     				<td><input type="hidden" name="parentId" value="null"></td>
     			</tr>
     		</c:if>
     		
     		<tr>
     			<td style="text-align: right;">部门名称:</td>
     			<td><input type="text" style="width: 220px;" name="dpmName" id="dpmName" onblur="checkdpmName()"></td>
     			<td><div id="dpmName_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">部门描述:</td>
     			<td><textarea rows="5" cols="31" name="dpmDescription" id="dpmDescription" onblur="checkdpmDescription()"></textarea></td>
     			<td><div id="dpmDescription_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">创建日期:</td>
     			<td><input type="text" style="width: 220px;" name="dpmCreatDate" id="dpmCreatDate" readonly="readonly"></td>
     			<td><div id="dpmCreatDate_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">部门等级:</td>
     			<td><input type="text" style="width: 220px;" name="dpmLevel" id="dpmLevel"></td>
     			<td><div id="dpmLevel_id"></div></td>
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
     		<input type="button" value="保存" onclick="checkdpm()">
     		<input type="button" style="margin-left: 30px;" value="返回" onclick="location.href='javascript:history.go(-1);'">
     	</div>
     	
     </form>
  </body>
</html>
