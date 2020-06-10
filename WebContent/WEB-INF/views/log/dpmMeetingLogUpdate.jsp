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
		
		function checkMeetingLog(){
			if (checkMdate()==true&&checkPlace()==true&&checkHost()==true&&checkAttendee()==true
					&&checkRecorder()==true&&checkTopic()==true&&checkMconclusion()==true) {			
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
     <form action="log/dpmUpdateMeetingLog" method="post">
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
     					<td style="text-align: right;">会议时间:</td>
     					<td><input type="text" style="width: 220px;" name="mdate" id="mdate" onblur="checkMdate()" value="${meetingLog.mdate}"></td>
     					<td><div id="mdate_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">会议地点:</td>
     					<td><input type="text" style="width: 220px;" name="place" id="place" onblur="checkPlace()" value="${meetingLog.place}"></td>
     					<td><div id="place_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">主持人:</td>
     					<td><textarea rows="5" cols="32" name="host" id="host" onblur="checkHost()">${meetingLog.host}</textarea></td>
     					<td><div id="host_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">出席者:</td>
     					<td><textarea rows="5" cols="32" name="attendee" id="attendee" onblur="checkAttendee()">${meetingLog.attendee}</textarea></td>
     					<td><div id="attendee_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">缺席者:</td>
     					<td><textarea rows="5" cols="32" name="absentee" id="absentee">${meetingLog.absentee}</textarea></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">记录人:</td>
     					<td><textarea rows="5" cols="32" name="recorder" id="recorder" onblur="checkRecorder()">${meetingLog.recorder}</textarea></td>
     					<td><div id="recorder_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">会议主题:</td>
     					<td><textarea rows="5" cols="32" name="topic" id="topic" onblur="checkTopic()">${meetingLog.topic}</textarea></td>
     					<td><div id="topic_id"></div></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">会议总结:</td>
     					<td><textarea rows="5" cols="32" name="mconclusion" id="mconclusion" onblur="checkMconclusion()">${meetingLog.mconclusion}</textarea></td>
     					<td><div id="mconclusion_id"></div></td>
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
     			<td><input type="button" value="保存" onclick="checkMeetingLog()"></td>
     			<td><input type="button" value="返回" onclick="location.href='javascript:history.go(-1);'"></td>
     		</tr>
     	</table>
     </form>
  </body>
</html>
