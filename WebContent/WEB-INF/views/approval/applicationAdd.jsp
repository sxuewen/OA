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
	<script type="text/javascript" src="js/laydate/laydate.js"></script>
	
	<script type="text/javascript">
		$(function(){
			/* laydate.render({
			    elem: '#CCStartDate',
			    format:'yyyy-MM-dd',
			    done:function(value,date,endDate){
			    	var startDate=new Date(value).getTime();
			    	var endDate=new Date($("#CCEndDate").val()).getTime();			    	
			    	if(endDate>startDate){
			    		layer.msg("结束时间不能小于开始时间");
			    		$("#CCStartDate").val($("#CCEndDate").val());
			    	}
			    } 
			});
			
			laydate.render({
			    elem: '#CCEndDate',
			    format:'yyyy-MM-dd',
			    done:function(value,date,endDate){
			    	var startDate=new Date($("#CCStartDate").val()).getTime();
			    	var endDate=new Date(value).getTime();			    
			    	if(endDate<startDate){
			    		layer.msg("结束时间不能小于开始时间");
			    		$("#CCEndDate").val($("#CCStartDate").val());
			    	}
			    } 
			}); */
			
			// 出差
			$("#CCStartDate").bind("input propertychange",function(){
				var dateOne=$("#CCStartDate").val();
				var dateTwo=$("#CCEndDate").val();
				$("#CCDays").val(countDay(dateOne, dateTwo));				
			});	
			
			$("#CCEndDate").bind("input propertychange",function(){
				var dateOne=$("#CCStartDate").val();
				var dateTwo=$("#CCEndDate").val();
				$("#CCDays").val(countDay(dateOne, dateTwo));				
			});
			
			// 倒休  js函数，填写完日期自动计算天数
			$("#DXStartDate").bind("input propertychange",function(){
				var dateOne=$("#DXStartDate").val();
				var dateTwo=$("#DXEndDate").val();
				$("#DXDays").val(countDay(dateOne, dateTwo));				
			});	
			
			$("#DXEndDate").bind("input propertychange",function(){
				var dateOne=$("#DXStartDate").val();
				var dateTwo=$("#DXEndDate").val();
				$("#DXDays").val(countDay(dateOne, dateTwo));				
			});
			// 补班
			$("#DXWorkStartDate").bind("input propertychange",function(){
				var dateOne=$("#DXWorkStartDate").val();
				var dateTwo=$("#DXWorkEndDate").val();
				$("#DXWorkDays").val(countDay(dateOne, dateTwo));				
			});	
			
			$("#DXWorkEndDate").bind("input propertychange",function(){
				var dateOne=$("#DXWorkStartDate").val();
				var dateTwo=$("#DXWorkEndDate").val();
				$("#DXWorkDays").val(countDay(dateOne, dateTwo));				
			});
			// 加班（小时）
			$("#JBStartTime").bind("input propertychange",function(){
				var dateOne=$("#JBStartTime").val();
				var dateTwo=$("#JBEndTime").val();
				$("#JBTime").val(parseInt(countHours(dateOne, dateTwo)/60)+"小时"+countHours(dateOne, dateTwo)%60+"分钟");				
			});	
			
			$("#JBEndTime").bind("input propertychange",function(){
				var dateOne=$("#JBStartTime").val();
				var dateTwo=$("#JBEndTime").val();
				$("#JBTime").val(parseInt(countHours(dateOne, dateTwo)/60)+"小时"+countHours(dateOne, dateTwo)%60+"分钟");			
			});
			// 请假
			$("#QJStartDay").bind("input propertychange",function(){
				var dateOne=$("#QJStartDay").val();
				var dateTwo=$("#QJEndDay").val();
				$("#QJDays").val(countDay(dateOne, dateTwo));				
			});	
			
			$("#QJEndDay").bind("input propertychange",function(){
				var dateOne=$("#QJStartDay").val();
				var dateTwo=$("#QJEndDay").val();
				$("#QJDays").val(countDay(dateOne, dateTwo));				
			});
			// 外出
			$("#WCDate").bind("input propertychange",function(){
				var dateOne=$("#WCDate").val();
				var dateTwo=$("#WCBackDate").val();
				$("#WCDays").val(countDay(dateOne, dateTwo));				
			});	
			
			$("#WCBackDate").bind("input propertychange",function(){
				var dateOne=$("#WCDate").val();
				var dateTwo=$("#WCBackDate").val();
				$("#WCDays").val(countDay(dateOne, dateTwo));				
			});
			
		});
		
		
		/* 计算日期差（天数） */
		function countDay(strDateStart,strDateEnd){
			var strSeparator="-";  // 日期分隔符
			var date1,date2,days;
			date1=strDateStart.split(strSeparator);
			date2=strDateEnd.split(strSeparator);
			var strDateS=new Date(date1[0],date1[1]-1,date1[2]);
			var strDateE=new Date(date2[0],date2[1]-1,date2[2]);
			days=parseInt(Math.abs(strDateS-strDateE)/1000/60/60/24); //把相差的毫秒数转换为天数
			return days;
		}
		
		/* 计算日期差（xx小时xx分钟） */
		function countHours(strDateStart,strDateEnd){
			var d1 = strDateStart.replace(/\-/g, "/");
			var date1 = new Date(d1);      // 先将字符串转换为日期类型
			
			var d2 = strDateEnd.replace(/\-/g, "/");
			var date2 = new Date(d2);      // 先将字符串转换为日期类型
			var date3=date2.getTime()-date1.getTime();  //时间差的毫秒数
			var leave1=date3%(24*3600*1000);    //计算天数后剩余的毫秒数
			var hours=Math.floor(leave1/(3600*1000));   //计算出小时数 */
			var leave2=leave1%(3600*1000);        //计算小时数后剩余的毫秒数
			var minutes=Math.floor(leave2/(60*1000));
			return hours*60+minutes;
		}
		
		/* 获取申请类型 */
		function selectAppContent(){
		    var appTypeId=$("#appTypeId").val();
		    
		    if (appTypeId==4||appTypeId==6||appTypeId==7||appTypeId==9) {  // 没有时间
		    	$("#haveTime").val("0");
			} else if(appTypeId==3){       //  申请时间（小时）
				$("#haveTime").val("1");
			}else {
				$("#haveTime").val("2");   //  申请时间（天数）
			}
		    
		   		    		   		    
		    var list=new Array();
		    list[0]=document.getElementById("tb1");
		    list[1]=document.getElementById("tb2");
		    list[2]=document.getElementById("tb3");
		    list[3]=document.getElementById("tb4");
		    list[4]=document.getElementById("tb5");
		    list[5]=document.getElementById("tb6");
		    list[6]=document.getElementById("tb7");
		    list[7]=document.getElementById("tb8");
		    list[8]=document.getElementById("tb9");
		    		    
		    if (appTypeId=="0") {
		    	for(var j=0;j<list.length;j++){
	    			var list3=list[j].getElementsByTagName('input');
	    			var list4=list[j].getElementsByTagName('textarea');
	    			for (var k = 0; k < list3.length; k++) {
						list3[k].value=null;
					}
	    			for (var l = 0; l < list4.length; l++) {
						list4[l].value=null;
					}
					list[j].style.display="none";					
	    		}
			} else {
				for(var i=0;i<list.length;i++){
			    	if(appTypeId==i+1){
			    		list[i].style.display="block";
			    		for(var j=0;j<list.length;j++){
			    			if (j!=i){
			    				var list3=list[j].getElementsByTagName('input');
			    				var list4=list[j].getElementsByTagName('textarea');
			    				for (var k = 0; k < list3.length; k++) {
									list3[k].value=null;
								}
			    				for (var l = 0; l < list4.length; l++) {
									list4[l].value=null;
								}
								list[j].style.display="none";
							}
			    		}
			    		break;
			    	}		    	
			    }		
			}
		        		    		    		   
	    }
		
	   /* 出差表校验 */
	   function checkCCPlace(){
			var CCPlace=$("#CCPlace").val();
			var tip=$("#CCPlace_id")[0];
			if(CCPlace==null || CCPlace.trim().length==0){
				tip.innerHTML="出差地点不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		function checkCCReason(){
			var CCReason=$("#CCReason").val();
			var tip=$("#CCReason_id")[0];
			if(CCReason==null || CCReason.trim().length==0){
				tip.innerHTML="出差原因不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		 }
		
		/* 倒休表校验 */
		function checkDXReason() {
			var DXReason=$("#DXReason").val();
			var tip=$("#DXReason_id")[0];
			if(DXReason==null || DXReason.trim().length==0){
				tip.innerHTML="倒休原因不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		/* 加班表校验 */
		function checkJBReason() {
			var JBReason=$("#JBReason").val();
			var tip=$("#JBReason_id")[0];
			if(JBReason==null || JBReason.trim().length==0){
				tip.innerHTML="加班原因不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		function checkJBContent() {
			var JBContent=$("#JBContent").val();
			var tip=$("#JBContent_id")[0];
			if(JBContent==null || JBContent.trim().length==0){
				tip.innerHTML="加班内容不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		/* 离职表校验 */
		function checkLZReason() {
			var LZReason=$("#LZReason").val();
			var tip=$("#LZReason_id")[0];
			if(LZReason==null || LZReason.trim().length==0){
				tip.innerHTML="离职原因不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		/* 请假表校验 */
		function checkQJReason() {
			var QJReason=$("#QJReason").val();
			var tip=$("#QJReason_id")[0];
			if(QJReason==null || QJReason.trim().length==0){
				tip.innerHTML="请假原因不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		/* 入职表校验 */
		
		
		/* 调岗表校验 */
		function checkTGReason() {
			var TGReason=$("#TGReason").val();
			var tip=$("#TGReason_id")[0];
			if(TGReason==null || TGReason.trim().length==0){
				tip.innerHTML="调岗原因不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		/* 外出表校验 */
		function checkWCReason() {
			var WCReason=$("#WCReason").val();
			var tip=$("#WCReason_id")[0];
			if(WCReason==null || WCReason.trim().length==0){
				tip.innerHTML="外出原因不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		/* 转正表校验 */
		function checkZZReason() {
			var ZZReason=$("#ZZReason").val();
			var tip=$("#ZZReason_id")[0];
			if(ZZReason==null || ZZReason.trim().length==0){
				tip.innerHTML="转正理由不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
		function checkZZselfComment() {
			var ZZselfComment=$("#ZZselfComment").val();
			var tip=$("#ZZselfComment_id")[0];
			if(ZZselfComment==null || ZZselfComment.trim().length==0){
				tip.innerHTML="自我评价不能为空";
				tip.style.color="red";
				return false;
			}else{
				tip.innerHTML="";
				tip.style.color="blue";
				return true;
			}
		}
		
												
		/* 提交申请 */
		function checkApplication(){
			var appTypeId=$("#appTypeId").val();  		
			if (appTypeId==1) {               // 出差表
				if(checkCCPlace()==true&&checkCCReason()==true){
					$("#count").val($("#CCDays").val());
					document.forms[0].submit();
				}else {
					alert("请填完后再提交!");
					return false;
				}
			}else if (appTypeId==2) {         // 倒休表
				if (checkDXReason()==true) {
					$("#count").val($("#DXDays").val());
					document.forms[0].submit();
				} else {
					alert("请填完后再提交!");
					return false;
				}
			}else if (appTypeId==3){         // 加班表
				if (checkJBReason()==true&&checkJBContent()==true) {
					document.forms[0].submit();
				} else {
					alert("请填完后再提交!");
					return false;
				}
			}else if (appTypeId==4){    // 离职
				if (checkLZReason()==true) {
					document.forms[0].submit();
				} else {
					alert("请填完后再提交!");
					return false;
				}
			}else if (appTypeId==5){   // 请假
				if (checkQJReason()==true) {
					$("#count").val($("#QJDays").val());
					document.forms[0].submit();
				} else {
					alert("请填完后再提交!");
					return false;
				}
			}else if (appTypeId==6){    // 入职
				if (condition) {
					
				} else {
					alert("请填完后再提交!");
					return false;
				}
			}else if (appTypeId==7){    // 调岗
				if (checkTGReason()==true) {
					document.forms[0].submit();
				} else {
					alert("请填完后再提交!");
					return false;
				}
			}else if (appTypeId==8){   // 外出
				if (checkWCReason()==true) {
					$("#count").val($("#WCDays").val());
					document.forms[0].submit();
				} else {
					alert("请填完后再提交!");
					return false;
				}
			}else if (appTypeId==9){   // 转正
				if (checkZZReason()==true&&checkZZselfComment()==true) {
					document.forms[0].submit();
				} else {
					alert("请填完后再提交!");
					return false;
				}
			}						
		}
		
	</script>
	
  </head>
  
  <body>
	 <div>
	  	<form action="approval/saveApplication" method="post">
	  		<input type="hidden" name="sfId" value="${staff.sfId}">
	  		<input type="hidden" name="departmentId" value="${staff.dpmId.dpmId}">
	  		<input type="hidden" name="roleLevel" value="${staff.roleId.roleLevel}">
	  		<input type="hidden" name="departmentLevel" value="${staff.dpmId.dpmLevel}">
	  		<input type="hidden" name="haveTime" id="haveTime">
	  		<input type="hidden" name="count" id="count">	  		
		  	<table align="center">
			  	<tr>
			  		<td style="text-align: right;">申请标题:</td>
			  		<td><input type="text" style="width: 220px;" name="appTitle" value="${staff.sfUserName}提交的申请" readonly></td>
			  	</tr>
			  	
			  	<tr>
			  		<td style="text-align: right;">申请人:</td>
			  		<td><input type="text" style="width: 220px;" value="${staff.sfRealName}" disabled></td>
			  	</tr>			  	
     			<tr>
     				<td style="text-align: right;">所属部门:</td>
     				<td><input type="text" style="width: 220px;" value="${staff.dpmId.dpmName}" disabled></td>
     			</tr>
     			
     			<tr>
     				<td style="text-align: right;">所在职位:</td>
     				<td><input type="text" style="width: 220px;" value="${staff.roleId.roleName}" disabled></td>
     			</tr>
     			
		  		<tr>
		  			<td>申请表类型:</td>
		  			<td style="text-align: left;">
		  				<select name="appTypeId" id="appTypeId" onchange="selectAppContent()">
		  					<option value="0"> ---请选择--- </option>
     						<c:if test="${not empty appTypeList}">
     					   		<c:forEach items="${appTypeList}" var="appType">     					   	  
     					   	   		<option value="${appType.appTypeId}">${appType.appTypeName}</option>     					   	   
     					   		</c:forEach>
     						</c:if>
     						<c:if test="${empty appTypeList}">
     							<option value="0">暂无类别</option>
     						</c:if>
		  				</select>
		  			</td>
		  		</tr>
		  		
		  		
		  		<!-- 出差表内容 -->
			  		<table id="tb1" style="display: none;margin-left: 170px;">     				
	     				<tr>
	     					<td style="text-align: right;">出差起始日期:</td>
	     					<td><input type="text" name="CCStartDate" id="CCStartDate"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">出差结束日期:</td>
	     					<td><input type="text" name="CCEndDate" id="CCEndDate"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">出差天数:</td>
	     					<td><input type="text" name="CCDays" id="CCDays" readonly="readonly"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">出差地点:</td>
	     					<td><input type="text" name="CCPlace" id="CCPlace" onblur="checkCCPlace()"></td>
	     					<td><div id="CCPlace_id"></div></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">出差原因:</td>
	     					<td><textarea rows="5" cols="32" name="CCReason" id="CCReason" onblur="checkCCReason()"></textarea></td>
	     					<td><div id="CCReason_id"></div></td>
	     				</tr>    				
	     			</table>
     		
		  		
		  		
		  		<!-- 倒休表内容 -->
			  		<table id="tb2" style="display: none;margin-left: 170px;">
	     				<tr>
	     					<td style="text-align: right;">倒休起始日期:</td>
	     					<td><input type="text" name="DXStartDate" id="DXStartDate"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">倒休结束日期:</td>
	     					<td><input type="text" name="DXEndDate" id="DXEndDate"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">倒休天数:</td>
	     					<td><input type="text" name="DXDays" id="DXDays" readonly></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">补班起始日期:</td>
	     					<td><input type="text" name="DXWorkStartDate" id="DXWorkStartDate"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">补班结束日期:</td>
	     					<td><input type="text" name="DXWorkEndDate" id="DXWorkEndDate"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">补班天数:</td>
	     					<td><input type="text" name="DXWorkDays" id="DXWorkDays" readonly></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">倒休原因:</td>
	     					<td><textarea rows="5" cols="32" name="DXReason" id="DXReason" onblur="checkDXReason()"></textarea></td>
	     					<td><div id="DXReason_id"></div></td>
	     				</tr>    				
	     			</table>
		  		
		  		
		  		<!-- 加班表内容 -->	
			  		<table id="tb3" style="display: none;margin-left: 170px;">
	     				<tr>
	     					<td style="text-align: right;">加班时段:</td>
	     					<td>
	     						<select name="JBTip" id="JBTip">
	     							<option value="工作日">工作日</option>
	     							<option value="双休日">双休日</option>
	     							<option value="节假日">节假日</option>
	     						</select>
	     					</td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">加班起始日期:</td>
	     					<td><input type="text" name="JBStartTime" id="JBStartTime"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">加班结束日期:</td>
	     					<td><input type="text" name="JBEndTime" id="JBEndTime"></td>
	     				</tr> 
	     				<tr>
	     					<td style="text-align: right;">加班时长:</td>
	     					<td><input type="text" name="JBTime" id="JBTime" readonly></td>
	     				</tr> 				
	     				<tr>
	     					<td style="text-align: right;">加班原因:</td>
	     					<td><textarea rows="5" cols="32" name="JBReason" id="JBReason" onblur=""></textarea></td>
	     					<td><div id="JBReason_id"></div></td>
	     				</tr>  
	     				<tr>
	     					<td style="text-align: right;">加班内容:</td>
	     					<td><textarea rows="5" cols="32" name="JBContent" id="JBContent" onblur=""></textarea></td>
	     					<td><div id="JBContent_id"></div></td>
	     				</tr>   				
	     			</table>
		  		
		  		
		  		<!-- 离职表内容 -->	
			  		<table id="tb4" style="display: none;margin-left: 170px;">
	     				<tr>
	     					<td style="text-align: right;">离职类型:</td>
	     					<td>
	     						<select name="LZType" id="LZType">
	     							<option value="辞职">辞职</option>
	     							<option value="辞退">辞退</option>
	     							<option value="除名">除名</option>
	     							<option value="合同到期">合同到期</option>
	     							<option value="其它">其它</option>
	     						</select>
	     					</td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">离职日期:</td>
	     					<td><input type="text" name="LZDate" id="LZDate"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">离职原因:</td>
	     					<td><textarea rows="5" cols="32" name="LZReason" id="LZReason" onblur=""></textarea></td>
	     					<td><div id="LZReason_id"></div></td>
	     				</tr>   				
	     			</table>
		  		
		  		
		  		<!-- 请假表内容 -->
			  		<table id="tb5" style="display: none;margin-left: 170px;">
	     				<tr>
	     					<td style="text-align: right;">请假类型:</td>
	     					<td>
	     						<select name="QJType" id="QJType">
	     							<option value="病假">病假</option>
	     							<option value="伤假">伤假</option>
	     							<option value="产假">产假</option>
	     							<option value="婚假">婚假</option>
	     							<option value="事假">事假</option>
	     							<option value="丧假">丧假</option>
	     							<option value="其它">其它</option>
	     						</select>
	     					</td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">请假起始日期:</td>
	     					<td><input type="text" name="QJStartDay" id="QJStartDay"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">请假结束日期:</td>
	     					<td><input type="text" name="QJEndDay" id="QJEndDay"></td>
	     				</tr> 
	     				<tr>
	     					<td style="text-align: right;">请假天数:</td>
	     					<td><input type="text" name="QJDays" id="QJDays" readonly></td>
	     				</tr> 				
	     				<tr>
	     					<td style="text-align: right;">请假原因:</td>
	     					<td><textarea rows="5" cols="32" name="QJReason" id="QJReason" onblur=""></textarea></td>
	     					<td><div id="QJReason_id"></div></td>
	     				</tr>      								
	     			</table>
		  		
		  		
		  		<!-- 入职表内容 -->
			  		<table id="tb6" style="display: none;margin-left: 170px;">     				
	     				<tr>
	     					<td style="text-align: right;">姓名:</td>
	     					<td><input type="text" name="RZrealName" id="RZrealName"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">性别:</td>
	     					<td><input type="text" name="RZsex" id="RZsex"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">家庭住址:</td>
	     					<td><textarea rows="5" cols="32" name="RZaddress" id="RZaddress" onblur=""></textarea></td>
	     					<td><div id="RZaddress_id"></div></td>
	     				</tr> 
	     				<tr>
	     					<td style="text-align: right;">出生日期:</td>
	     					<td><input type="text" name="RZbirthday" id="RZbirthday"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">身份证号:</td>
	     					<td><input type="text" name="RZIDcard" id="RZIDcard"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">电话号码:</td>
	     					<td><input type="text" name="RZphone" id="RZphone"></td>
	     				</tr>  
	     				<tr>
	     					<td style="text-align: right;">家庭背景:</td>
	     					<td><textarea rows="5" cols="32" name="RZfamily" id="RZfamily" onblur=""></textarea></td>
	     					<td><div id="RZfamily_id"></div></td>
	     				</tr>   								
	     				<tr>
	     					<td style="text-align: right;">教育背景:</td>
	     					<td><textarea rows="5" cols="32" name="RZeduExperience" id="RZeduExperience" onblur=""></textarea></td>
	     					<td><div id="RZeduExperience_id"></div></td>
	     				</tr>   
	     				<tr>
	     					<td style="text-align: right;">工作经历:</td>
	     					<td><textarea rows="5" cols="32" name="RZworkExperience" id="RZworkExperience" onblur=""></textarea></td>
	     					<td><div id="RZworkExperience_id"></div></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">目标部门:</td>
	     					<td><input type="text" name="RZdepartmentName" id="RZdepartmentName"></td>
	     				</tr>  
	     				<tr>
	     					<td style="text-align: right;">目标职位:</td>
	     					<td><input type="text" name="RZroleName" id="RZroleName"></td>
	     				</tr>   
	     			</table>
		  		
		  		
		  		<!-- 调岗表内容 -->	
			  		<table id="tb7" style="display: none;margin-left: 170px;">     				
	     				<tr>
	     					<td style="text-align: right;">目标部门:</td>
	     					<td><input type="text" name="TGNewDepartment" id="TGNewDepartment"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">目标职位:</td>
	     					<td><input type="text" name="TGNewRole" id="TGNewRole"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">调岗原因:</td>
	     					<td><textarea rows="5" cols="32" name="TGReason" id="TGReason" onblur=""></textarea></td>
	     					<td><div id="TGReason_id"></div></td>
	     				</tr>
	     			</table>
		  		
		  		
		  		<!-- 外出表内容 -->	
			  		<table id="tb8" style="display: none;margin-left: 170px;">
			  			<tr>
	     					<td style="text-align: right;">外出起始日期:</td>
	     					<td><input type="text" name="WCDate" id="WCDate"></td>
	     				</tr>
	     				<tr>
	     					<td style="text-align: right;">外出结束日期:</td>
	     					<td><input type="text" name="WCBackDate" id="WCBackDate"></td>
	     				</tr> 
	     				<tr>
	     					<td style="text-align: right;">外出天数:</td>
	     					<td><input type="text" name="WCDays" id="WCDays" readonly></td>
	     				</tr> 				
	     				<tr>
	     					<td style="text-align: right;">外出原因:</td>
	     					<td><textarea rows="5" cols="32" name="WCReason" id="WCReason" onblur=""></textarea></td>
	     					<td><div id="WCReason_id"></div></td>
	     				</tr>      								
	     			</table>
     			
     			
     			<!-- 转正表内容 -->
	     			<table id="tb9" style="display: none;margin-left: 170px;">
	     				<tr>
	     					<td style="text-align: right;">转正理由:</td>
	     					<td><textarea rows="5" cols="32" name="ZZReason" id="ZZReason" onblur=""></textarea></td>
	     					<td><div id="ZZReason_id"></div></td>
	     				</tr> 
	     				<tr>
	     					<td style="text-align: right;">自我评价:</td>
	     					<td><textarea rows="5" cols="32" name="ZZselfComment" id="ZZselfComment" onblur=""></textarea></td>
	     					<td><div id="ZZselfComment_id"></div></td>
	     				</tr> 
	     			</table>
		  		
		  		
		  		<div style="margin-left: 300px;margin-top: 20px;">
	     			<input type="button" value="提交" onclick="checkApplication()">
	     			<input type="button" style="margin-left:20px;" value="返回" onclick="location.href='javascript:history.go(-1);'">
	     		</div>
		  	</table>
	  	</form>	  	
	  </div>
  </body>
</html>
