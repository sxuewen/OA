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
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/left.js"></script>
  </head>

  <body>
	<ul class="cd-accordion-menu animated">
	
	   <c:if test="${not empty map}">
			<c:forEach items="${map}" var="map">
			  <li class="has-children">
					    
					<input type="checkbox" id="${map.key}">					
					<label for="${map.key}">${map.key}</label>
					
					<c:forEach items="${map.value}" var="models">													
					<ul>
					  	<li><a href="${models.modelUrl}" target="rightFrame">${models.modelName}</a></li>	
					</ul>
					</c:forEach>							   					    	
				 </li>
			  </c:forEach>
		 </c:if>
		
		
		
		<c:if test="${empty map}">
			<li>模块为空!</li>
		</c:if>
	
	
	
	
		<!-- <li class="has-children"><input type="checkbox" name="group-1" id="group-1"> 
			<label for="group-1">个人中心</label>
			<ul>
				<li><a href="page/admin/alterPassword.jsp" target="rightFrame">修改密码</a></li>			
			</ul>
		</li>

		<li class="has-children"><input type="checkbox" name="group-2" id="group-2">
			<label for="group-2">资讯管理</label>
			<ul>
				<li><a href="newsListByPage" target="rightFrame">咨询列表</a></li>			
			</ul>
		</li>

		<li class="has-children"><input type="checkbox" name="group-3" id="group-3">
		 	<label for="group-3">客户信息查询</label>
			<ul>
				<li><a href="userListByPage" target="rightFrame">客户列表</a></li>				
			</ul>
		</li>

		<li class="has-children"><input type="checkbox" name="group-4" id="group-4">
		 	<label for="group-4">汽车分类管理</label>
			<ul>
				<li><a href="typeListByPage" target="rightFrame">汽车分类列表</a></li>
			</ul>
		</li>
		
		<li class="has-children"><input type="checkbox" name="group-5" id="group-5">
			<label for="group-5">租赁车辆管理</label>
			<ul>
				<li><a href="carListByPage" target="rightFrame">车辆列表</a></li>	
			</ul>
		</li>
		
		<li class="has-children"><input type="checkbox" name="group-6" id="group-6">
			<label for="group-6">客户评价管理</label>
			<ul>
				<li><a href="commentListByPage" target="rightFrame">客户评价列表</a></li>			
			</ul>
		</li>
		
		<li class="has-children"><input type="checkbox" name="group-7" id="group-7">
			<label for="group-7">租赁反馈管理</label>
			<ul>
				<li><a href="rebackListByPage" target="rightFrame">租赁维权信息列表</a></li>				
			</ul>
		</li>
		
		<li class="has-children"><input type="checkbox" name="group-8" id="group-8">
			<label for="group-8">订单管理</label>
			<ul>
				<li><a href="orderListByPage" target="rightFrame">订单列表</a></li>				
			</ul>
		</li> -->
		
	</ul>
  </body>
</html>
