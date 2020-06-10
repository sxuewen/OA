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
	
	<link rel="stylesheet" type="text/css" href="css/style_cn.css">

	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	
		function checkrfReason(){
			var rfReason=$("#rfReason").val();
			var tip=$("#rfReason_id")[0];
			if(rfReason==null || rfReason.trim().length==0){
				tip.innerHTML="拒绝理由不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		// 提交表单
		function checkApproval() {
			var flag=document.getElementsByName("flag");			
			if ((flag[0].checked==true)||(flag[1].checked==true&&checkrfReason()==true)) {				
				document.forms[0].submit();
			}else{
				alert("请选择'同意'或'拒绝，并给出拒绝理由'");
				return false;
			}
		}
		
		$(function(){
			$("input[name='flag']").change(function(){
				var flag=document.getElementsByName("flag");			
				if (flag[1].checked==true) {     // 拒绝		
					document.getElementById("div1").style.display="block";
				}else {
					$("#rfReason").val(null);
					document.getElementById("div1").style.display="none";
				}
			});
		});
		
	</script>
  </head>
  
  <body>
	 <div>
	  	<form action="approval/updateApproval" method="post">
	  		<input type="hidden" name="appId" value="${approvalVo.appId}">
		  	<table align="center" cellspacing="0" border="0">
		  		<tr>
		  			<td style="text-align: right;">申请标题：</td>
		  			<td><input type="text" style="width: 220px;" value="${approvalVo.appTitle}" disabled></td>
		  		</tr>
		  		
		  		<tr>
		     		<td style="text-align: right;">申请人:</td>
		     		<td><input type="text" style="width: 220px;" value="${approvalVo.sfRealName}" disabled></td>
		     	</tr>
		     	
		     	<tr>
		     		<td style="text-align: right;">所属部门:</td>
		     		<td><input type="text" style="width: 220px;" value="${approvalVo.dpmName}" disabled></td>
		     	</tr>
		     	
		     	<tr>
		     		<td style="text-align: right;">所在职位:</td>
		     		<td><input type="text" style="width: 220px;" value="${approvalVo.roleName}" disabled></td>
		     	</tr>
		     			  		
		  		<tr>
		  			<td style="text-align: right;">申请类型:</td>
		  			<td><input type="text" style="width: 220px;" value="${approvalVo.appTypeName}" disabled></td>
		  		</tr>
		  		
		  		<tr>
		  			<td>详细情况：</td>
		  			<td>
		  				<table>		     				
		     				<tr>
		     					<td style="text-align: right;">出差起始日期:</td>
		     					<td><input type="text" style="width: 220px;" value="${chuChaiApp.CCStartDate}" disabled></td>
		     				</tr>
		     				<tr>
		     					<td style="text-align: right;">出差结束日期:</td>
		     					<td><input type="text" style="width: 220px;" value="${chuChaiApp.CCEndDate}" disabled></td>
		     				</tr>
		     				<tr>
		     					<td style="text-align: right;">出差天数:</td>
		     					<td><input type="text" style="width: 220px;" value="${chuChaiApp.CCDays}" disabled></td>
		     				</tr>
		     				<tr>
		     					<td style="text-align: right;">出差地点:</td>
		     					<td><input type="text" style="width: 220px;" value="${chuChaiApp.CCPlace}" disabled></td>
		     				</tr>
		     				<tr>
		     					<td style="text-align: right;">出差原因:</td>
		     					<td><textarea rows="5" cols="32" disabled>${chuChaiApp.CCReason}</textarea></td>
		     				</tr>    				
		     			</table>
		  			</td>
		  			
		  		</tr>
		  		
		  		<tr>
		  			<td style="text-align: right;">申请日期：</td>
		  			<td><input type="text" style="width: 220px;" value="${approvalVo.createDate}" disabled></td>
		  		</tr>
		  		
		  				  		
		  		<tr>
		  			<td><input type="radio" name="flag" value="1">同意</td>
		  			<td><input type="radio" name="flag" value="0">拒绝</td>
		  		</tr>
		  		
		  		<tr></tr>
		  		
		  		<tr id="div1" style="display: none;">
		  			<td style="text-align: right;">拒绝理由:</td>
		  			<td><textarea rows="5" cols="32" name="rfReason" id="rfReason" onblur="checkrfReason()"></textarea></td>
		  			<td><div id="rfReason_id"></div></td>
		  		</tr>
		  		
		  		<tr>
		  			<td><input type="button" value="提交" onclick="checkApproval()"></td>
					<td colspan="2"><input type="button" value="返回" onclick="location.href='javascript:history.go(-1);'"></td>
				</tr>
		  	</table>
	  	</form>
	  	
	  </div>
  </body>
</html>
