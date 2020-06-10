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
						
		function checksignPlace(){
			var signPlace=$("#signPlace").val();
			var tip=$("#signPlace_id")[0];
			if(signPlace==null || signPlace.trim().length==0){
				tip.innerHTML="打卡地点不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		} 
		function checklongitude(){
			var longitude=$("#longitude").val();
			var tip=$("#longitude_id")[0];
			if(longitude==null || longitude.trim().length==0){
				tip.innerHTML="经度不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		function checklatitude(){
			var latitude=$("#latitude").val();
			var tip=$("#latitude_id")[0];
			if(latitude==null || latitude.trim().length==0){
				tip.innerHTML="纬度不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		function checkmeter(){
			var meter=$("#meter").val();
			var tip=$("#meter_id")[0];
			if(meter==null || meter.trim().length==0){
				tip.innerHTML="打卡范围不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		function checkamStartTime(){
			var amStartTime=$("#amStartTime").val();
			var tip=$("#amStartTime_id")[0];
			if(amStartTime==null || amStartTime.trim().length==0){
				tip.innerHTML="上午开始打卡时间不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		function checkamEndTime(){
			var amEndTime=$("#amEndTime").val();
			var tip=$("#amEndTime_id")[0];
			if(amEndTime==null || amEndTime.trim().length==0){
				tip.innerHTML="上午结束打卡时间不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		function checkpmStartTime(){
			var pmStartTime=$("#pmStartTime").val();
			var tip=$("#pmStartTime_id")[0];
			if(pmStartTime==null || pmStartTime.trim().length==0){
				tip.innerHTML="下午开始打卡时间不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		function checkpmEndTime(){
			var pmEndTime=$("#pmEndTime").val();
			var tip=$("#pmEndTime_id")[0];
			if(pmEndTime==null || pmEndTime.trim().length==0){
				tip.innerHTML="下午结束打卡时间不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		function checklateTime(){
			var lateTime=$("#lateTime").val();
			var tip=$("#lateTime_id")[0];
			if(lateTime==null || lateTime.trim().length==0){
				tip.innerHTML="迟到时间设置不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		function checktooLateTime(){
			var tooLateTime=$("#tooLateTime").val();
			var tip=$("#tooLateTime_id")[0];
			if(tooLateTime==null || tooLateTime.trim().length==0){
				tip.innerHTML="严重迟到时间设置不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		function checkabsenceTime(){
			var absenceTime=$("#absenceTime").val();
			var tip=$("#absenceTime_id")[0];
			if(absenceTime==null || absenceTime.trim().length==0){
				tip.innerHTML="旷工时间设置不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		function checkSign() {
			if (checksignPlace()==true&&checklongitude()==true&&checklatitude()==true&&checkmeter()==true
				&&checkamStartTime()==true&&checkamEndTime()==true&&checkpmStartTime()==true&&checkpmEndTime()==true
				&&checklateTime()==true&&checktooLateTime()==true&&checkabsenceTime()==true) {
				document.forms[0].submit();
			} else {
				alert("请确保信息无误后再提交!");
				return false;
			}
		}
	</script>
  </head>
  
  <body>
  	<div class="mtitle">
		<span class="menu_selected">考勤规则修改</span>
	</div>

   <form action="sign/saveSign" method="post">
   	  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm">
  		 <tr>
    		<td style="text-align: right;">打卡地点:</td>
    		<td><input type="text" style="width: 220px;" name="signPlace" id="signPlace" value="${sign.signPlace}" onblur="checksignPlace()"></td>
    		<td><div id="signPlace_id"></div></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">地理位置(经度):</td>
    		<td><input type="text" style="width: 220px;" name="longitude" id="longitude" value="${sign.longitude}" onblur="checklongitude()"></td>
    		<td><div id="longitude_id"></div></td>
  		 </tr>
  		 <tr>
    		<td style="text-align: right;">地理位置(纬度):</td>
    		<td><input type="text" style="width: 220px;" name="latitude" id="latitude" value="${sign.latitude}" onblur="checklatitude()"></td>
  		 	<td><div id="latitude_id"></div></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">打卡范围:</td>
    		<td><input type="text" style="width: 220px;" name="meter" id="meter" value="${sign.meter}" onblur="checkmeter()"></td>
    		<td><div id="meter_id"></div></td>
  		 </tr>  		  
  		  <tr>
    		<td style="text-align: right;">上午开始打卡时间:</td>
    		<td><input type="text" style="width: 220px;" name="amStartTime" id="amStartTime" value="${sign.amStartTime}" onblur="checkamStartTime()"></td>
    		<td><div id="amStartTime_id"></div></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">上午结束打卡时间:</td>
    		<td><input type="text" style="width: 220px;" name="amEndTime" id="amEndTime" value="${sign.amEndTime}" onblur="checkamEndTime()"></td>
    		<td><div id="amEndTime_id"></div></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">下午开始打卡时间:</td>
    		<td><input type="text" style="width: 220px;" name="pmStartTime" id="pmStartTime" value="${sign.pmStartTime}" onblur="checkpmStartTime()"></td>
    		<td><div id="pmStartTime_id"></div></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">下午结束打卡时间:</td>
    		<td><input type="text" style="width: 220px;" name="pmEndTime" id="pmEndTime" value="${sign.pmEndTime}" onblur="checkpmEndTime()"></td>
    		<td><div id="pmEndTime_id"></div></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">迟到规则设置:</td>
    		<td><input type="text" style="width: 220px;" name="lateTime" id="lateTime" value="${sign.lateTime}" onblur="checklateTime()">分钟</td>
    		<td><div id="lateTime_id"></div></td>
  		 </tr>
  		  <tr>
    		<td style="text-align: right;">严重迟到规则设置:</td>
    		<td><input type="text" style="width: 220px;" name="tooLateTime" id="tooLateTime" value="${sign.tooLateTime}" onblur="checktooLateTime()">小时</td>
    		<td><div id="tooLateTime_id"></div></td>
  		 </tr>
  		 <tr>
    		<td style="text-align: right;">旷工规则设置:</td>
    		<td><input type="text" style="width: 220px;" name="absenceTime" id="absenceTime" value="${sign.absenceTime}" onblur="checkabsenceTime()">小时</td>
    		<td><div id="absenceTime_id"></div></td>
  		 </tr>
	  </table>
	  
	  <hr>
	  
	  <div>
	  	 <input type="button" value="保存" onclick="checkSign()">
	  	 <input type="button" style="margin-left:20px;" value="返回" onclick="location.href='javascript:history.go(-1);'">
	  </div>
	  
   </form>
	
  </body>
</html>
