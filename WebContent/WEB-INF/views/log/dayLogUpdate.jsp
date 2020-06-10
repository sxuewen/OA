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
		function checkConclusion(){
			var conclusion=$("#conclusion").val();
			var tip=$("#conclusion_id")[0];
			if(conclusion==null || conclusion.trim().length==0){
				tip.innerHTML="工作总结不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}	
		
		function checkProblem(){
			var problem=$("#problem").val();
			var tip=$("#problem_id")[0];
			if(problem==null || problem.trim().length==0){
				tip.innerHTML="遇到的问题不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}	
		
		function checkSolution(){
			var solution=$("#solution").val();
			var tip=$("#solution_id")[0];
			if(solution==null || solution.trim().length==0){
				tip.innerHTML="解决方法不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}	
		
		function checkPlan(){
			var plan=$("#plan").val();
			var tip=$("#plan_id")[0];
			if(plan==null || plan.trim().length==0){
				tip.innerHTML="下一步计划不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}	
		
		function checkDayLog() {
			if(checkConclusion()==true&&checkProblem()==true&&checkSolution()==true&&checkPlan()==true){			
				document.forms[0].submit();
			} else {
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
     <form action="log/updateDayLog" method="post">
     	<input type="hidden" name="logId" value="${logVo.logId}">
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
     					<td><textarea rows="5" cols="32" name="conclusion" id="conclusion" onblur="checkConclusion()">${dayLog.conclusion}</textarea></td>     				
     					<td><div id="conclusion_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">遇到的问题:</td>
     					<td><textarea rows="5" cols="32" name="problem" id="problem" onblur="checkProblem()">${dayLog.problem}</textarea></td>    					
     					<td><div id="problem_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">解决方法:</td>
     					<td><textarea rows="5" cols="32" name="solution" id="solution" onblur="checkSolution()">${dayLog.solution}</textarea></td>    					
     					<td><div id="solution_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">下一步计划:</td>
     					<td><textarea rows="5" cols="32" name="plan" id="plan" onblur="checkPlan()">${dayLog.plan}</textarea></td>     					
     					<td><div id="plan_id"></div></td>
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
     			<td><input type="button" value="保存" onclick="checkDayLog()"></td>
     			<td><input type="button" value="返回" onclick="location.href='javascript:history.go(-1);'"></td>
     		</tr>
     	</table>
     </form>
  </body>
</html>
