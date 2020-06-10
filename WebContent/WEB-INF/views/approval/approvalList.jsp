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
  </head>
  
  <body>
  	<div class="mtitle">
		<span class="menu_selected">待我审批</span>
	</div>

   <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm">
  		<tr>
    		<th class="th_head">
			<div id="menuArrow1" style="background:url(images/down.gif) no-repeat center;float:left;">&nbsp;</div>
			<div id="menuTitle1" style="font-weight:bold">搜索</div>
			</th>
    		<th class="th_head"></th>
  		</tr>
  		
  	   <tr>	  	
  	   </tr>
	 </table>
	<br>
	
	<h3><img src="images/khlb.png" border="0">&nbsp;审批列表</h3>
	
	<div class="border">
	  <form name="form" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
			
		  <c:if test="${not empty approvalVoList}">
		   	  <tr>
		  	    <td width="10%" class="listViewThS1">申请标题</td>
		  	    <td width="10%" class="listViewThS1">申请类型</td>
		  	    <td width="10%" class="listViewThS1">申请人</td>
		  	    <td width="10%" class="listViewThS1">所属部门</td>
		  	    <td width="10%" class="listViewThS1">所属职位</td>		  	   
		  	    <td width="10%" class="listViewThS1">申请日期</td>
		  	    <td width="10%" class="listViewThS1">操作</td>
			  </tr>
		   	  <c:forEach items="${approvalVoList}" var="approvalVo">
				<tr>
			  	    <td><a href="approval/findAppInfoByappId?appId=${approvalVo.appId}">${approvalVo.appTitle}</a></td>
			  	    <td>${approvalVo.appTypeName}</td>
			  	    <td>${approvalVo.sfRealName}</td>
					<td>${approvalVo.dpmName}</td>
					<td>${approvalVo.roleName}</td>			
					<td>${approvalVo.createDate}</td>
					<td><a href="approval/startApproval?appId=${approvalVo.appId}&appTypeId=${approvalVo.appTypeId}">开始审批</a></td>
				</tr>
			  </c:forEach>
			</c:if>
			
			<c:if test="${empty approvalVoList}">
				<div><h1>暂无数据!</h1></div>
			</c:if>
			
	   	   </table>  
	  	</form>
	   </div>
	
   <!-- 分页显示所有数据 -->
	<div style="padding-top:30px;color:#FF0000;">
	   <c:if test="${not empty page}">
	    <tr>  
	     <td colspan="9">
	        <c:if test="${page.totalPage!=0}">  
	                      当前是第${page.pageNow}页，共${page.totalPage}页 
	             
	            <a href="approval/findWaitApproval?pageNow=1"><u>首页</u></a>  
	        	 	        	 
	       		<c:if test="${page.isHasPre()!=false}">	        		
	            	<a href="approval/findWaitApproval?pageNow=${page.pageNow-1}"><u>上一页</u></a>
	        	</c:if>
	        	  
	        	<c:if test="${page.isHasNext()!=false}">	        		
	        		<a href="approval/findWaitApproval?pageNow=${page.pageNow+1}"><u>下一页</u></a>            
	        	</c:if>
	        	  		         
		        <a href="approval/findWaitApproval?pageNow=${page.totalPage}"><u>尾页</u></a>  
		        
		     </c:if>         
	      </td>  
	  	 </tr>
	  	</c:if>
	 </div>
    
  </body>
</html>
