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
			laydate.render({
			    elem: '#notDate'  //指定元素
			});
		});		
		
		function forward(strURL) {
			window.location = strURL;
		}

	</script>
  </head>
  
  <body>
  	<div class="mtitle">
		<span class="menu_selected">查看公告</span>
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
	  	<td colspan="2">
		  <form name="form1" method="post" action="notice/seeNoticeByDate">
  			<table width="100%" border="0" cellspacing="0" cellpadding="0" name="base" id="base">
			  <tr> 	
				<td width="30%" nowrap>按日期查询：
					<c:if test="${empty notDate}">
						<input type="text" name="notDate" id="notDate" readonly="readonly">
					</c:if>
					
					<c:if test="${not empty notDate}">
						<input type="text" name="notDate" id="notDate" value="${notDate}" readonly="readonly">
					</c:if>
		    	</td>
		    	
		    	
		    	<td width="15%" nowrap>&nbsp;</td>
		  	    <td width="25%" align="center">
					<div class="control">
						<button type="button" class="button" onMouseOver="this.className='button_over';" 
						        onMouseOut="this.className='button';"  onClick="document.forms[0].submit()">
						        <img src="images/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索
						</button>&nbsp;
						
		      		    <button type="button" class="button" onMouseOver="this.className='button_over';" 
		      		    		onMouseOut="this.className='button';" onClick="forward('notice/seeAllNotice')">
		          			    <img src="images/qingkong.png" border='0' 
		          			    align='absmiddle'>&nbsp;清空
		          		</button>
					 </div>
				  </td>
			    </tr>
		   	  </table>
			</form>
	  	  </td>
  	   </tr>
	 </table>
	<br>
	
	<h3><img src="images/khlb.png" border="0">&nbsp;公告列表</h3>
	
	<div class="border">
	  <form name="form2" method="post" action="###">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
			
		   <c:if test="${not empty noticeVoList}">
		   	  <tr>		
		  	    <td width="15%" class="listViewThS1">公告标题</td>
		  	    <td width="15%" class="listViewThS1">发布时间</td>
		  	    <td width="10%" class="listViewThS1">发布人</td>
		  	    <td width="7%" class="listViewThS1">阅读状态</td>		  	    
			  </tr>
		   	  <c:forEach items="${noticeVoList}" var="noticeVo">
				<tr>		  
			  	    <td><a href="notice/seeNoticeInfo?notId=${noticeVo.notId}&sfId=${staff.sfId}">${noticeVo.notTitle}</a></td>
					<td>${noticeVo.notDate}</td>
					<td>${noticeVo.adminName}</td>
					<c:if test="${noticeVo.flag==1}">
						<td>已读</td>
					</c:if>
					<c:if test="${noticeVo.flag!=1}">
						<td>未读</td>
					</c:if>
				</tr>
			  </c:forEach>
			</c:if>
			
			<c:if test="${empty noticeVoList}">
				<div><h1>暂无数据!</h1></div>
			</c:if>
			
	   	   </table>  
	  	</form>
	   </div>
	
   <!-- 分页显示所有数据 -->
   <c:if test="${empty notDate}">
	<div style="padding-top:30px;color:#FF0000;">
	   <c:if test="${not empty page}">
	    <tr>  
	     <td colspan="9">
	        <c:if test="${page.totalPage!=0}">  
	                      当前是第${page.pageNow}页，共${page.totalPage}页 
	             
	            <a href="notice/seeAllNotice?pageNow=1"><u>首页</u></a>  
	        	 	        	 
	       		<c:if test="${page.isHasPre()!=false}">	        		
	            	<a href="notice/seeAllNotice?pageNow=${page.pageNow-1}"><u>上一页</u></a>
	        	</c:if>
	        	  
	        	<c:if test="${page.isHasNext()!=false}">	        		
	        		<a href="notice/seeAllNotice?pageNow=${page.pageNow+1}"><u>下一页</u></a>            
	        	</c:if>
	        	  		         
		        <a href="notice/seeAllNotice?pageNow=${page.totalPage}"><u>尾页</u></a>  
		        
		     </c:if>         
	      </td>  
	  	 </tr>
	  	</c:if>
	 </div>
    </c:if>
    
   <!-- 分页显示部分数据 -->
   <c:if test="${not empty notDate}">
	<div style="padding-top:30px;color:#FF0000;">
	   <c:if test="${not empty page}">
	    <tr>  
	     <td colspan="9">
	        <c:if test="${page.totalPage!=0}">  
	                      当前是第${page.pageNow}页，共${page.totalPage}页 
	             
	            <a href="notice/seeNoticeByDate?notDate=${notDate}&pageNow=1" ><u>首页</u></a>  
	        	 	        	 
	       		<c:if test="${page.isHasPre()!=false}">	        		
	            	<a href="notice/seeNoticeByDate?notDate=${notDate}&pageNow=${page.pageNow-1}"><u>上一页</u></a>
	        	</c:if>
	        	  
	        	<c:if test="${page.isHasNext()!=false}">	        		
	        		<a href="notice/seeNoticeByDate?notDate=${notDate}&pageNow=${page.pageNow+1}"><u>下一页</u></a>            
	        	</c:if>
	        	  		         
		        <a href="notice/seeNoticeByDate?notDate=${notDate}&pageNow=${page.totalPage}"><u>尾页</u></a>  
		        
		     </c:if>         
	      </td>  
	  	 </tr>
	  	</c:if>
	 </div>
    </c:if>
 	
  </body>
</html>
