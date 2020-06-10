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
	
	 $(function(){
		$("#logType").bind("input propertychange",function(){			
			  var list1=tb1.getElementsByTagName('input');
			  var list2=tb1.getElementsByTagName('textarea');
			  for (var m = 0; m < list1.length; m++) {
				  list1[m].value=null;
			  }
			  for (var n = 0; n < list2.length; n++) {
				  list2[n].value=null;
			  }
			  
			  var list3=tb2.getElementsByTagName('input');
			  var list4=tb2.getElementsByTagName('textarea');
			  for (var k = 0; k < list3.length; k++) {
				  list3[k].value=null;
			  }
			  for (var l = 0; l < list4.length; l++) {
				  list4[l].value=null;
			  }			 
		 });
	 });
	 
	 
	  function selectLogType(){		
		  var logType=$("#logType").val();		  		  
		  var tb1=$("#tb1")[0];
		  var tb2=$("#tb2")[0];
		  
		  if (logType==1||logType==2||logType==3) {			 
			  tb2.style.display="none";
			  tb1.style.display="block";
		  } else if(logType==4){			  
			  tb1.style.display="none";
			  tb2.style.display="block";
		  }else{			  
			  tb1.style.display="none";
			  tb2.style.display="none";
		  }
		  
	  }
		
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
	
	
	
	
	function checkMdate(){
		var mdate=$("#mdate").val();
		var tip=$("#mdate_id")[0];
		if(mdate==null || mdate.trim().length==0){
			tip.innerHTML="会议时间不能为空";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}
	}	
	
	function checkPlace(){
		var place=$("#place").val();
		var tip=$("#place_id")[0];
		if(place==null || place.trim().length==0){
			tip.innerHTML="会议地点不能为空";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}
	}	
	
	function checkHost(){
		var host=$("#host").val();
		var tip=$("#host_id")[0];
		if(host==null || host.trim().length==0){
			tip.innerHTML="主持人不能为空";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}
	}	
	
	function checkAttendee(){
		var attendee=$("#attendee").val();
		var tip=$("#attendee_id")[0];
		if(attendee==null || attendee.trim().length==0){
			tip.innerHTML="出席者不能为空";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}
	}	
	
	function checkRecorder(){
		var recorder=$("#recorder").val();
		var tip=$("#recorder_id")[0];
		if(recorder==null || recorder.trim().length==0){
			tip.innerHTML="记录人不能为空";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}
	}	
	
	function checkTopic(){
		var topic=$("#topic").val();
		var tip=$("#topic_id")[0];
		if(topic==null || topic.trim().length==0){
			tip.innerHTML="会议主题不能为空";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}
	}	
	
	function checkMconclusion(){
		var mconclusion=$("#mconclusion").val();
		var tip=$("#mconclusion_id")[0];
		if(mconclusion==null || mconclusion.trim().length==0){
			tip.innerHTML="会议总结不能为空";
			tip.style.color="red";
			return false;
		}else{
			tip.innerHTML="";
			tip.style.color="blue";
			return true;
		}
	}	
	
	
	function checkLog(){
		var logType=$("#logType").val();
		var form1=document.getElementById("form1");
		if (logType==1||logType==2||logType==3) {
			if(checkConclusion()==true&&checkProblem()==true&&checkSolution()==true&&checkPlan()==true){
				form1.action="log/saveDayLog";
				document.forms[0].submit();
			} else {
				alert("请确保信息无误后再提交!");
				return false;
			}		
		}else if(logType==4){
			if (checkMdate()==true&&checkPlace()==true&&checkHost()==true&&checkAttendee()==true
					&&checkRecorder()==true&&checkTopic()==true&&checkMconclusion()==true) {
				form1.action="log/saveMeetingLog";
				document.forms[0].submit();
			}else{
				alert("请确保信息无误后再提交!");
				return false;
			}			
		}else{
			alert("请选择日志类型!");
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
     <form id="form1" action="" method="post">
     	<input type="hidden" name="sfId" value="${staff.sfId}">
     	<input type="hidden" name="dpmId" value="${staff.dpmId.dpmId}">
     	<table style="padding-top: 100px;padding-left: 190px;">
     		<tr>
     			<td style="text-align: right;"><b>添加日志</b></td>
     		</tr>
     		
     		<tr>
     			<td style="text-align: right;">创建者:</td>
     			<td><input type="text" style="width: 220px;" value="${staff.sfUserName}" disabled></td>
     			<td><div id="notTitle_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">所属部门:</td>
     			<td><input type="text" style="width: 220px;" value="${staff.dpmId.dpmName}" disabled></td>
     			<td><div id="notContent_id"></div></td>
     		</tr>
     		<tr>
     			<td style="text-align: right;">日志类型:</td>
     			<td>
	     			<select name="logType" id="logType" onchange="selectLogType()">
	     				<option value="0"> ---请选择--- </option>
	     				<option value="1">日报</option>
	     				<option value="2">周报</option>
	     				<option value="3">月报</option>
	     				<option value="4">会议纪要</option>
	     			</select>
     			</td>
     		 </tr>
     		
     		
     			<table id="tb1" style="display: none;margin-left: 174px;">     				
     				<tr>
     					<td style="text-align: right;">工作总结:</td>
     					<td><textarea rows="5" cols="32" name="conclusion" id="conclusion" onblur="checkConclusion()"></textarea></td>
     					<td><div id="conclusion_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">遇到的问题:</td>
     					<td><textarea rows="5" cols="32" name="problem" id="problem" onblur="checkProblem()"></textarea></td>
     					<td><div id="problem_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">解决方法:</td>
     					<td><textarea rows="5" cols="32" name="solution" id="solution" onblur="checkSolution()"></textarea></td>
     					<td><div id="solution_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">下一步计划:</td>
     					<td><textarea rows="5" cols="32" name="plan" id="plan" onblur="checkPlan()"></textarea></td>
     					<td><div id="plan_id"></div></td>
     				</tr>    				
     			</table>
     		
     		
     			<table id="tb2" style="display: none;margin-left: 190px;">
     				<tr>
     					<td style="text-align: right;">会议时间:</td>
     					<td><input type="text" style="width: 220px;" name="mdate" id="mdate" onblur="checkMdate()"></td>
     					<td><div id="mdate_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">会议地点:</td>
     					<td><input type="text" style="width: 220px;" name="place" id="place" onblur="checkPlace()"></td>
     					<td><div id="place_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">主持人:</td>
     					<td><textarea rows="5" cols="32" name="host" id="host" onblur="checkHost()"></textarea></td>
     					<td><div id="host_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">出席者:</td>
     					<td><textarea rows="5" cols="32" name="attendee" id="attendee" onblur="checkAttendee()"></textarea></td>
     					<td><div id="attendee_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">缺席者:</td>
     					<td><textarea rows="5" cols="32" name="absentee" id="absentee"></textarea></td>     					
     				</tr>
     				<tr>
     					<td style="text-align: right;">记录人:</td>
     					<td><textarea rows="5" cols="32" name="recorder" id="recorder" onblur="checkRecorder()"></textarea></td>
     					<td><div id="recorder_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">会议主题:</td>
     					<td><textarea rows="5" cols="32" name="topic" id="topic" onblur="checkTopic()"></textarea></td>
     					<td><div id="topic_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">会议总结:</td>
     					<td><textarea rows="5" cols="32" name="mconclusion" id="mconclusion" onblur="checkMconclusion()"></textarea></td>
     					<td><div id="mconclusion_id"></div></td>
     				</tr>    				
     			</table>
     		     		     		     		    		
	     		<div style="margin-left: 300px;margin-top: 20px;">
	     			<input type="button" value="保存" onclick="checkLog()">
	     			<input type="button" style="margin-left:20px;" value="返回" onclick="location.href='javascript:history.go(-1);'">
	     		</div>
     		
     	</table>
     </form>
  </body>
</html>
