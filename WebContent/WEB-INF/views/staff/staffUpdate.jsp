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
	
		/* function checksfUserName(){
			var sfUserName=$("#sfUserName").val();
			var tip=$("#sfUserName_id")[0];
			if(sfUserName==null || sfUserName.trim().length==0){
				tip.innerHTML="用户名不能为空";
				tip.style.color="red";
				return false;
			}else{
				$.ajax({
					type:"post",
					url:"staff/checksfUserName",
					data:{sfUserName:sfUserName},
					success:function(result){
						if(result.length==4){
							$("#sfUserName_id").html(result);
							$("#sfUserName_id")[0].style.color="blue";
						}else{
							$("#sfUserName_id").html(result);
							$("#sfUserName_id")[0].style.color="red";
						}
					}
				});
				return true;
			}
		} */
		
		/* function checksfRealName(){
			var sfRealName=$("#sfRealName").val();
			var tip=$("#sfRealName_id")[0];
			var reg = /^[\u4E00-\u9FA5A-Za-z]+$/;
			if (reg.test(sfRealName)) {
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}else {
				tip.innerHTML="只能输入中文和英文";
				tip.style.color="red";
				return false;
			}
		} */
		
		/* function checksfCard(){
			var sfCard=$("#sfCard").val();
			var tip=$("#sfCard_id")[0];
			// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
			var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
			if (reg.test(sfCard)) {
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}else {
				tip.innerHTML="请输入正确的身份证号";
				tip.style.color="red";
				return false;
			}
		} */
		
		function selectRoleBydpmId(){
			var dpmId=$("#dpm").val();
			$.ajax({
				type:"post",
				url:"role/selectRoleBydpmId",
				data:{dpmId:dpmId},
				dataType:"json",
				success:function(data){					
					$("#role").empty();
					$("#role").append("<option value='0' selected>"+"---请选择---"+"</option>");
					for(var i=0;i<data.length;i++){
					   $("#role").append("<option value="+data[i].roleId+">"+data[i].roleName+"</option>");
					}
				}
			});
		}
		
		function checksfPhone(){
			var sfPhone=$("#sfPhone").val();
			var tip=$("#sfPhone_id")[0];
			var reg = /^1(3|4|5|7|8)\d{9}$/;
			if (reg.test(sfPhone)) {
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}else {
				tip.innerHTML="请输入正确的手机号码";
				tip.style.color="red";
				return false;
			}
		}
		
		function checksfAddress(){
			var sfAddress=$("#sfAddress").val();
			var tip=$("#sfAddress_id")[0];
			if(sfAddress==null || sfAddress.trim().length==0){
				tip.innerHTML="联系地址不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		function checksfEmail(){
			var sfEmail=$("#sfEmail").val();
			var tip=$("#sfEmail_id")[0];
			// 只允许英文字母、数字、下划线、@、英文句号、以及中划线组成
			var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
			if (reg.test(sfEmail)) {
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}else {
				tip.innerHTML="请输入正确的电子邮箱";
				tip.style.color="red";
				return false;
			}
		}
		
			
		function checkStaff() {
			var dpm=$("#dpm").val();
			var role=$("#role").val();
			if (checksfPhone()==true&&checksfAddress()==true&&checksfEmail()==true&&dpm!=0&&role!=0) {
				document.forms[0].submit();
			} else {
				alert("请确保信息无误后再提交!");
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
     <form action="staff/updateStaff" method="post">
     	<input type="hidden" name="sfId" id="sfId" value="${staffInfo.sfId}"> 
     	<table style="padding-top: 100px;padding-left: 190px;">
     		<tr>
     			<td style="text-align: right;"><b>员工信息修改</b></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">用户名:</td>
     			<td><input type="text" style="width: 220px;" name="sfUserName" id="sfUserName" value="${staffInfo.sfUserName}" readonly="readonly"></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">真实姓名:</td>
     			<td><input type="text" style="width: 220px;" name="sfRealName" id="sfRealName" value="${staffInfo.sfRealName}" readonly="readonly"></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">性别:</td>
     			<td>
     				<select name="sfSex">
     					<c:if test="${staffInfo.sfSex=='男'}">
     						<option value="男" selected="selected">男</option>
     						<option value="女">女</option>
     					</c:if>
     					<c:if test="${staffInfo.sfSex=='女'}">
     						<option value="男">男</option>
     						<option value="女" selected="selected">女</option>
     					</c:if>		
     				</select>
     			</td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">身份证号:</td>
     			<td><input type="text" style="width: 220px;" name="sfCard" id="sfCard" value="${staffInfo.sfCard}" readonly="readonly"></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">手机号码:</td>
     			<td><input type="text" style="width: 220px;" name="sfPhone" id="sfPhone" value="${staffInfo.sfPhone}" onblur="checksfPhone()"></td>
     			<td><div id="sfPhone_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">联系地址:</td>
     			<td><textarea rows="5" cols="31" name="sfAddress" id="sfAddress" onblur="checksfAddress()">${staffInfo.sfAddress}</textarea></td>
     			<td><div id="sfAddress_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">电子邮箱:</td>
     			<td><input type="text" style="width: 220px;" name="sfEmail" id="sfEmail" value="${staffInfo.sfEmail}" onblur="checksfEmail()"></td>
     			<td><div id="sfEmail_id"></div></td>
     		</tr>
     		
     		<tr>
     			<td style="text-align: right;">所属部门:</td>
     			<td>
     			   <select name="dpm" id="dpm" style="width: 100px;" onchange="selectRoleBydpmId()">
     					<c:if test="${not empty dpmList}">
     					   <c:forEach items="${dpmList}" var="dpm">
     					   	   <c:if test="${staffInfo.dpmName==dpm.dpmName}">
     					   	   	  <option value="${dpm.dpmId}" selected>${dpm.dpmName}</option>
     					   	   </c:if>
     					   	   <c:if test="${staffInfo.dpmName!=dpm.dpmName}">
     					   	      <option value="${dpm.dpmId}">${dpm.dpmName}</option>
     					   	   </c:if>
     					   </c:forEach>
     					</c:if>
     					<c:if test="${empty dpmList}">
     						<option value="0">暂无类别</option>
     					</c:if>
     				</select>
     			</td>
     		</tr>
     		
     		<tr>
     			<td style="text-align: right;">所属职位:</td>
     			<td>
     			   <select name="role" id="role" style="width: 100px;">
     					<c:if test="${not empty roleList}">
     					   <c:forEach items="${roleList}" var="role">
     					      <c:if test="${staffInfo.roleName==role.roleName}">
     					      	 <option value="${role.roleId}" selected>${role.roleName}</option>
     					      </c:if>
     					   	  <c:if test="${staffInfo.roleName!=role.roleName}">
     					   	  	 <option value="${role.roleId}">${role.roleName}</option>
     					   	  </c:if>
     					   </c:forEach>
     					</c:if>
     					<c:if test="${empty roleList}">
     						<option value="0">暂无类别</option>
     					</c:if>
     				</select>
     			</td>
     		</tr>
     		
     	</table>
     	<br>
     	<div style="padding-left: 300px;">
     		<input type="button" value="保存" onclick="checkStaff()">
     		<input type="button" style="margin-left: 30px;" value="返回" onclick="location.href='javascript:history.go(-1);'">
     	</div>
     	
     </form>
  </body>
</html>
