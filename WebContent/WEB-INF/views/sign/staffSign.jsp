<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/sign2.css">

<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<!-- <script type="text/javascript" src="js/calendar2.js"></script>
<script type="text/javascript">
	$(function(){
	  //ajax获取日历json数据
	  var signList=[{"signDate":"2019-02-07"},{"signDate":"2019-03-27"},{"signDate":"2019-04-28"}];
	   calUtil.init(signList);
	});
</script> -->
</head>

<body>
	<!-- <div style="" id="calendar"></div> -->
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
		<c:if test="${not empty signVo}">
			<tr>								
				<td width="10%" class="listViewThS1">时间段:</td>
				<td width="10%" class="listViewThS1">出勤天数:</td>
				<td width="10%" class="listViewThS1">休息天数:</td>
				<td width="10%" class="listViewThS1">迟到次数:</td>
				<td width="10%" class="listViewThS1">早退次数:</td>
				<td width="10%" class="listViewThS1">缺卡次数:</td>
				<td width="10%" class="listViewThS1">旷工次数:</td>
				<td width="10%" class="listViewThS1">外勤次数:</td>
				<td width="10%" class="listViewThS1">加班次数:</td>
			</tr>
						
			<tr>				
				<td>${signVo.during}</td>
				<td>${signVo.workCount}</td>
				<td>${signVo.restCount}</td>
				<td>${signVo.lateCount}</td>
				<td>${signVo.backCount}</td>
				<td>${signVo.loseCount}</td>
				<td>${signVo.absenceCount}</td>
				<td>${signVo.outsideCount}</td>
				<td>${signVo.addWorkCount}</td>
			</tr>			
		</c:if>

		<c:if test="${empty signVo}">
			<div>
				<h1>暂无数据!</h1>
			</div>
		</c:if>
	</table>
	 
	 <hr>
	 
	 <table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
		<c:if test="${not empty signVo2}">
			<tr>								
				<td width="10%" class="listViewThS1">当前时间:</td>
				<td width="10%" class="listViewThS1">出勤天数:</td>
				<td width="10%" class="listViewThS1">休息天数:</td>
				<td width="10%" class="listViewThS1">迟到次数:</td>
				<td width="10%" class="listViewThS1">早退次数:</td>
				<td width="10%" class="listViewThS1">缺卡次数:</td>
				<td width="10%" class="listViewThS1">旷工次数:</td>
				<td width="10%" class="listViewThS1">外勤次数:</td>
				<td width="10%" class="listViewThS1">加班次数:</td>
			</tr>
			<tr>				
				<td>${signVo2.during}</td>
				<td>${signVo2.workCount}</td>
				<td>${signVo2.restCount}</td>
				<td>${signVo2.lateCount}</td>
				<td>${signVo2.backCount}</td>
				<td>${signVo2.loseCount}</td>
				<td>${signVo2.absenceCount}</td>
				<td>${signVo2.outsideCount}</td>
				<td>${signVo2.addWorkCount}</td>
			</tr>
		</c:if>

		<c:if test="${empty signVo2}">
			<div>
				<h1>暂无数据!</h1>
			</div>
		</c:if>
	</table> 
	
</body>
</html>