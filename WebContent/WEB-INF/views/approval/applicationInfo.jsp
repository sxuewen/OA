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
			var typeId=$("#typeId").val();
			for (var i = 1; i <=9 ; i++) {
				if (typeId==i) {
					$(("#tb"+i))[0].style.display="block";
				}
			}
		});		
	</script>
	
  </head>
  
  <body>
	 <div>
	  	<form action="" method="post">
	  		<input type="hidden" name="typeId" id="typeId" value="${approvalVo.appTypeId}">
		  	<table align="center">
			  	<tr>
			  		<td style="text-align: right;">申请标题:</td>
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
		  			<td>申请表类型:</td>
		  			<td><input type="text" value="${approvalVo.appTypeName}" disabled></td>
		  		</tr>
		  		
		  		
		  		<!-- 出差表内容 -->		  		
		  		<table id="tb1" style="display: none;margin-left: 492px;">    			
     				<tr>
     					<td style="text-align: right;">出差起始日期:</td>
     					<td><input type="text" style="width: 220px;" value="${appData1.CCStartDate}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">出差结束日期:</td>
     					<td><input type="text" style="width: 220px;" value="${appData1.CCEndDate}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">出差天数:</td>
     					<td><input type="text" style="width: 220px;" value="${appData1.CCDays}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">出差地点:</td>
     					<td><input type="text" style="width: 220px;" value="${appData1.CCPlace}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">出差原因:</td>
     					<td><textarea rows="5" cols="32" disabled>${appData1.CCReason}</textarea></td>
     				</tr>    				
     			</table>
		  		
		  		
		  		<!-- 倒休表内容 -->		  		
		  		<table id="tb2" style="display: none;margin-left: 170px;">     				
     				<tr>
     					<td style="text-align: right;">倒休起始日期:</td>
     					<td><input type="text" style="width: 220px;" value="${appData2.DXStartDate}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">倒休结束日期:</td>
     					<td><input type="text" style="width: 220px;" value="${appData2.DXEndDate}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">倒休天数:</td>
     					<td><input type="text" style="width: 220px;" value="${appData2.DXDays}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">补班起始日期:</td>
     					<td><input type="text" style="width: 220px;" value="${appData2.DXWorkStartDate}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">补班结束日期:</td>
     					<td><input type="text" style="width: 220px;" value="${appData2.DXWorkEndDate}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">补班天数:</td>
     					<td><input type="text" style="width: 220px;" value="${appData2.DXWorkDays}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">倒休原因:</td>
     					<td><textarea rows="5" cols="32" disabled>${appData2.DXReason}</textarea></td>
     				</tr>    				
     			</table>
		  		
		  		
		  		<!-- 加班表内容 -->		  		
		  		<table id="tb3" style="display: none;margin-left: 170px;">
     				<tr>
     					<td style="text-align: right;">加班时段:</td>
     					<td><input type="text" style="width: 220px;" value="${appData3.JBTip}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">加班起始日期:</td>
     					<td><input type="text" style="width: 220px;" value="${appData3.JBStartTime}" disabled></td>
     				</tr>
     				<tr>
     					<td style="text-align: right;">加班结束日期:</td>
     					<td><input type="text" style="width: 220px;" value="${appData3.JBEndTime}" disabled></td>
     				</tr> 	
     				<tr>
     					<td style="text-align: right;">加班时长:</td>
     					<td><input type="text" style="width: 220px;" value="${appData3.JBTime}" disabled></td>
     				</tr> 			
     				<tr>
     					<td style="text-align: right;">加班原因:</td>
     					<td><textarea rows="5" cols="32" disabled>${appData3.JBReason}</textarea></td>
     				</tr>  
     				<tr>
     					<td style="text-align: right;">加班内容:</td>
     					<td><textarea rows="5" cols="32" disabled>${appData3.JBContent}</textarea></td>
     				</tr>   				
     			</table>
		  		
		  		<!-- 离职表内容 -->
		  		<table id="tb4" style="display: none;margin-left: 170px;">
	     			<tr>
	     				<td style="text-align: right;">离职类型:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData4.LZType}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">离职日期:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData4.LZDate}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">离职原因:</td>
	     				<td><textarea rows="5" cols="32" disabled>${appData4.LZReason}</textarea></td>
	     			</tr>   				
	     		</table>
		  		
		  		<!-- 请假表内容 -->
		  		<table id="tb5" style="display: none;margin-left: 170px;">
	     			<tr>
	     				<td style="text-align: right;">请假类型:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData5.QJType}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">请假起始日期:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData5.QJStartDay}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">请假结束日期:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData5.QJEndDay}" disabled></td>
	     			</tr> 
	     			<tr>
	     				<td style="text-align: right;">请假天数:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData5.QJDays}" disabled></td>
	     			</tr> 				
	     			<tr>
	     				<td style="text-align: right;">请假原因:</td>
	     				<td><textarea rows="5" cols="32" disabled>${appData5.QJReason}</textarea></td>
	     			</tr>      								
	     		</table>
	     		
	     		
	     		<!-- 入职表内容 -->
	     		<table id="tb6" style="display: none;margin-left: 170px;">     				
	     			<tr>
	     				<td style="text-align: right;">姓名:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData6.RZrealName}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">性别:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData6.RZsex}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">家庭住址:</td>
	     				<td><textarea rows="5" cols="32" disabled>${appData6.RZaddress}</textarea></td>
	     			</tr> 
	     			<tr>
	     				<td style="text-align: right;">出生日期:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData6.RZbirthday}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">身份证号:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData6.RZIDcard}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">电话号码:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData6.RZphone}" disabled></td>
	     			</tr>  
	     			<tr>
	     				<td style="text-align: right;">家庭背景:</td>
	     				<td><textarea rows="5" cols="32" disabled>${appData6.RZfamily}</textarea></td>
	     			</tr>   								
	     			<tr>
	     				<td style="text-align: right;">教育背景:</td>
	     				<td><textarea rows="5" cols="32" disabled>${appData6.RZeduExperience}</textarea></td>
	     			</tr>   
	     			<tr>
	     				<td style="text-align: right;">工作经历:</td>
	     				<td><textarea rows="5" cols="32" disabled>${appData6.RZworkExperience}</textarea></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">目标部门:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData6.RZdepartmentName}" disabled></td>
	     			</tr>  
	     			<tr>
	     				<td style="text-align: right;">目标职位:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData6.RZroleName}" disabled></td>
	     			</tr>   
	     		</table>
	     		
	     		
	     		<!-- 调岗表内容 -->	
			  	<table id="tb7" style="display: none;margin-left: 170px;">     				
	     			<tr>
	     				<td style="text-align: right;">目标部门:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData7.TGNewDepartment}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">目标职位:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData7.TGNewRole}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">调岗原因:</td>
	     				<td><textarea rows="5" cols="32" disabled>${appData7.TGReason}</textarea></td>
	     			</tr>
	     		</table>
     			
		  		
	     		<!-- 外出表内容 -->	
			  	<table id="tb8" style="display: none;margin-left: 170px;">
			  		<tr>
	     				<td style="text-align: right;">外出起始日期:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData8.WCDate}" disabled></td>
	     			</tr>
	     			<tr>
	     				<td style="text-align: right;">外出结束日期:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData8.WCBackDate}" disabled></td>
	     			</tr> 
	     			<tr>
	     				<td style="text-align: right;">外出天数:</td>
	     				<td><input type="text" style="width: 220px;" value="${appData8.WCDays}" disabled></td>
	     			</tr> 				
	     			<tr>
	     				<td style="text-align: right;">外出原因:</td>
	     				<td><textarea rows="5" cols="32" disabled>${appData8.WCReason}</textarea></td>
	     			</tr>      								
	     		</table>
     			
	     		
	     		<!-- 转正表内容 -->
	     		<table id="tb9" style="display: none;margin-left: 170px;">
	     			<tr>
	     				<td style="text-align: right;">转正理由:</td>
	     				<td><textarea rows="5" cols="32" disabled>${appData9.ZZReason}</textarea></td>
	     			</tr> 
	     			<tr>
	     				<td style="text-align: right;">自我评价:</td>
	     				<td><textarea rows="5" cols="32" disabled>${appData9.ZZselfComment}</textarea></td>
	     			</tr> 
	     		</table>
     					  		
		  		
		  		<div style="margin-left: 300px;margin-top: 20px;">	     		
	     			<input type="button" style="margin-left:20px;" value="返回" onclick="location.href='javascript:history.go(-1);'">
	     		</div>
		  	</table>
	  	</form>	  	
	  </div>
  </body>
</html>
