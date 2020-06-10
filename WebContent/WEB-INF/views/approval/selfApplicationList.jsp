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
			    elem: '#createDate'  
			});
		});
		
		function forward(strURL) {
			window.location = strURL;
		}		
	</script>
  </head>
  
  <body>
  	<div class="mtitle">
		<span class="menu_selected">我的申请</span>
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
		  <form name="form1" method="post" action="approval/selectMyAppByDate">
  			<table width="100%" border="0" cellspacing="0" cellpadding="0" name="base" id="base">
			  <tr> 	
			  
			    <td width="20%" nowrap>按申请日期查询：
					<c:if test="${empty createDate}">
						<input type="text" name="createDate" id="createDate">
					</c:if>
					
					<c:if test="${not empty createDate}">
						<input type="text" name="createDate" id="createDate" value="${createDate}">
					</c:if>
		    	</td>		    			   
		    	
		    	<td width="25%" nowrap>&nbsp;</td>
		  	    <td width="25%" align="center">
					<div class="control">
						<button type="button" class="button" onMouseOver="this.className='button_over';" 
						        onMouseOut="this.className='button';"  onClick="document.forms[0].submit()">
						        <img src="images/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索
						</button>&nbsp;
						
		      		    <button type="button" class="button" onMouseOver="this.className='button_over';" 
		      		    		onMouseOut="this.className='button';" onClick="forward('approval/findSelfApplication')">
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
	
	<h3><img src="images/khlb.png" border="0">&nbsp;我的申请列表</h3>
	<div class="control">
		<button type="button" class="button" onMouseOver="this.className='button_over';" 
		        onMouseOut="this.className='button';" onClick="forward('approval/addApplication')">
		        <img src="images/xinjian.png" border='0' align='absmiddle'>&nbsp;添加</button>&nbsp;
	 </div>
	
	<div class="border">
	  <form name="form2" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
			
		   <c:if test="${not empty approvalVoList}">
		   	  <tr>
		   	    <td width="10%" class="listViewThS1">申请标题</td>
		  	    <td width="10%" class="listViewThS1">申请类型</td>
		  	    <td width="10%" class="listViewThS1">申请日期</td>
		  	    <td width="10%" class="listViewThS1">审批状态</td>
		  	    <td width="10%" class="listViewThS1">审批进程</td>
		  	    <td width="10%" class="listViewThS1">审批结果</td>
		  	    <td width="10%" class="listViewThS1">终审日期</td>
		  	    <td width="10%" class="listViewThS1">未通过原因</td>
			  </tr>
			  
		   	  <c:forEach items="${approvalVoList}" var="approvalVo">
				<tr>
			  	    <td><a href="approval/findAppInfoByappId?appId=${approvalVo.appId}">${approvalVo.appTitle}</a></td>
					<td>${approvalVo.appTypeName}</td>
					<td>${approvalVo.createDate}</td>
					
					<c:if test="${approvalVo.state==0}">
						<td><span style="color: red;">待审批</span></td>
					</c:if>
					<c:if test="${approvalVo.state==1}">
						<td><span style="color: blue;">审批中</span></td>
					</c:if>
					<c:if test="${approvalVo.state==2}">
						<td><span style="color: green;">已审批</span></td>
					</c:if>
					
					<td><a href="approval/findProcess?appId=${approvalVo.appId}">查看</a></td>
					
					<c:if test="${approvalVo.result==0}">
						<td><span style="color: red;">未通过</span></td>
					</c:if>
					<c:if test="${approvalVo.result==1}">
						<td><span style="color: green;">已通过</span></td>
					</c:if>
					<td>${approvalVo.resultDate}</td>
					<c:if test="${approvalVo.result==0}">
						<td><a href="approval/findrfReason?appId=${approvalVo.appId}">查看原因</a></td>
					</c:if>		
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
   <c:if test="${empty createDate}">
	<div style="padding-top:30px;color:#FF0000;">
	   <c:if test="${not empty page}">
	    <tr>  
	     <td colspan="9">
	        <c:if test="${page.totalPage!=0}">  
	                      当前是第${page.pageNow}页，共${page.totalPage}页 
	             
	            <a href="approval/findSelfApplication?pageNow=1"><u>首页</u></a>  
	        	 	        	 
	       		<c:if test="${page.isHasPre()!=false}">	        		
	            	<a href="approval/findSelfApplication?pageNow=${page.pageNow-1}"><u>上一页</u></a>
	        	</c:if>
	        	  
	        	<c:if test="${page.isHasNext()!=false}">	        		
	        		<a href="approval/findSelfApplication?pageNow=${page.pageNow+1}"><u>下一页</u></a>            
	        	</c:if>
	        	  		         
		        <a href="approval/findSelfApplication?pageNow=${page.totalPage}"><u>尾页</u></a>  
		        
		     </c:if>         
	      </td>  
	  	 </tr>
	  	</c:if>
	 </div>
    </c:if>
    
   <!-- 分页显示部分数据 -->
   <c:if test="${not empty createDate}">
	<div style="padding-top:30px;color:#FF0000;">
	   <c:if test="${not empty page}">
	    <tr>  
	     <td colspan="9">
	        <c:if test="${page.totalPage!=0}">  
	                      当前是第${page.pageNow}页，共${page.totalPage}页 
	             
	            <a href="approval/selectMyAppByDate?createDate=${createDate}&pageNow=1" ><u>首页</u></a>  
	        	 	        	 
	       		<c:if test="${page.isHasPre()!=false}">	        		
	            	<a href="approval/selectMyAppByDate?createDate=${createDate}&pageNow=${page.pageNow-1}"><u>上一页</u></a>
	        	</c:if>
	        	  
	        	<c:if test="${page.isHasNext()!=false}">	        		
	        		<a href="approval/selectMyAppByDate?createDate=${createDate}&pageNow=${page.pageNow+1}"><u>下一页</u></a>            
	        	</c:if>
	        	  		         
		        <a href="approval/selectMyAppByDate?createDate=${createDate}&pageNow=${page.totalPage}"><u>尾页</u></a>  
		        
		     </c:if>         
	      </td>  
	  	 </tr>
	  	</c:if>
	 </div>
    </c:if>
 	
  </body>
</html>
