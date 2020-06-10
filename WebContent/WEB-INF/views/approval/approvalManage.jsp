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
		
		function forward(strURL) {
			window.location = strURL;
		}

		//删除
		function deleteIds() {
			var count = 0;
			//遍历所有的复选框
			$("input[type='checkbox'][name='ids']").each(function(index, data) {
				if (this.checked) { //如果复选框处于选中状态
					count++; //count加1      
				}
			});
			
			//如果没有被选中		 
			if (count == 0) {
				alert("必须有一个类型被选中!!!");
				return false;
			} else {
				document.forms[1].submit();
			}
		}
	</script>
  </head>
  
  <body>
  	<div class="mtitle">
		<span class="menu_selected">申请表管理</span>
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
		  <form name="form1" method="post" action="approval/selectAppByRealName">
  			<table width="100%" border="0" cellspacing="0" cellpadding="0" name="base" id="base">
			  <tr> 	
			  
			    <td width="20%" nowrap>按申请人姓名查询：
					<c:if test="${empty sfRealName}">
						<input type="text" name="sfRealName" id="sfRealName">
					</c:if>
					
					<c:if test="${not empty sfRealName}">
						<input type="text" name="sfRealName" id="sfRealName" value="${sfRealName}">
					</c:if>
		    	</td>		    					
		    	
		    	<td width="5%" nowrap>&nbsp;</td>
		  	    <td width="25%" align="center">
					<div class="control">
						<button type="button" class="button" onMouseOver="this.className='button_over';" 
						        onMouseOut="this.className='button';"  onClick="document.forms[0].submit()">
						        <img src="images/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索
						</button>&nbsp;
						
		      		    <button type="button" class="button" onMouseOver="this.className='button_over';" 
		      		    		onMouseOut="this.className='button';" onClick="forward('approval/findAllApplication')">
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
	
	<h3><img src="images/khlb.png" border="0">&nbsp;申请列表</h3>
	<div class="control">
		<button type="button" class="button" onMouseOver="this.className='button_over';" 
		        onMouseOut="this.className='button';" onclick="deleteIds()">
		        <img src="images/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
	 </div>
	
	<div class="border">
	  <form name="form2" method="post" action="approval/deleteApproval">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
			
		   <c:if test="${not empty approvalVoList}">
		   	  <tr>
		    	<td width="4%"  class="listViewThS1"><input type="checkbox" name="checkall"  id="checkall" onClick="checkAllBox();"/></td>
		  	    <td width="10%" class="listViewThS1">申请标题</td>
		  	    <td width="7%"  class="listViewThS1">申请类型</td>
		  	    <td width="7%"  class="listViewThS1">申请人</td>
		  	    <td width="7%"  class="listViewThS1">所属部门</td>
		  	    <td width="7%"  class="listViewThS1">所属职位</td>		  	    
		  	    <td width="10%" class="listViewThS1">申请日期</td>
		  	    <td width="7%"  class="listViewThS1">申请结果</td>
		  	    <td width="10%" class="listViewThS1">终审日期</td>
			  </tr>
		   	  <c:forEach items="${approvalVoList}" var="approvalVo">
				<tr>
			    	<td><input type="checkbox" name="ids" value="${approvalVo.appId}" onClick="changeCheckCount();"/></td>
			  	    <td><a href="approval/findAppInfoByappId?appId=${approvalVo.appId}">${approvalVo.appTitle}</a></td>
			  	    <td>${approvalVo.appTypeName}</td>
			  	    <td>${approvalVo.sfRealName}</td>
					<td>${approvalVo.dpmName}</td>
					<td>${approvalVo.roleName}</td>					
					<td>${approvalVo.createDate}</td>
					<c:if test="${approvalVo.result==0}">
						<td style="color: red;">未通过</td>
					</c:if>
					<c:if test="${approvalVo.result==1}">
						<td style="color: green;">已通过</td>
					</c:if>
					<td>${approvalVo.resultDate}</td>
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
   <c:if test="${empty sfRealName}">
	<div style="padding-top:30px;color:#FF0000;">
	   <c:if test="${not empty page}">
	    <tr>  
	     <td colspan="9">
	        <c:if test="${page.totalPage!=0}">  
	                      当前是第${page.pageNow}页，共${page.totalPage}页 
	             
	            <a href="approval/findAllApplication?pageNow=1"><u>首页</u></a>  
	        	 	        	 
	       		<c:if test="${page.isHasPre()!=false}">	        		
	            	<a href="approval/findAllApplication?pageNow=${page.pageNow-1}"><u>上一页</u></a>
	        	</c:if>
	        	  
	        	<c:if test="${page.isHasNext()!=false}">	        		
	        		<a href="approval/findAllApplication?pageNow=${page.pageNow+1}"><u>下一页</u></a>            
	        	</c:if>
	        	  		         
		        <a href="approval/findAllApplication?pageNow=${page.totalPage}"><u>尾页</u></a>  
		        
		     </c:if>         
	      </td>  
	  	 </tr>
	  	</c:if>
	 </div>
    </c:if>
    
   <!-- 分页显示部分数据 -->
   <c:if test="${not empty sfRealName}">
	<div style="padding-top:30px;color:#FF0000;">
	   <c:if test="${not empty page}">
	    <tr>  
	     <td colspan="9">
	        <c:if test="${page.totalPage!=0}">  
	                      当前是第${page.pageNow}页，共${page.totalPage}页 
	             
	            <a href="approval/selectAppByRealName?sfRealName=${sfRealName}&pageNow=1" ><u>首页</u></a>  
	        	 	        	 
	       		<c:if test="${page.isHasPre()!=false}">	        		
	            	<a href="approval/selectAppByRealName?sfRealName=${sfRealName}&pageNow=${page.pageNow-1}"><u>上一页</u></a>
	        	</c:if>
	        	  
	        	<c:if test="${page.isHasNext()!=false}">	        		
	        		<a href="approval/selectAppByRealName?sfRealName=${sfRealName}&pageNow=${page.pageNow+1}"><u>下一页</u></a>            
	        	</c:if>
	        	  		         
		        <a href="approval/selectAppByRealName?sfRealName=${sfRealName}&pageNow=${page.totalPage}"><u>尾页</u></a>  
		        
		     </c:if>         
	      </td>  
	  	 </tr>
	  	</c:if>
	 </div>
    </c:if>
 	
	<script type="text/javascript">
	   function changeCheckCount(){
	       var count=0;
		   $("input[type='checkbox'][name='ids']").each(function(index,data){
	            if(this.checked){
	            	count++;  
	            }
		   });
		   /* $("#slt_ids_count2").empty();
	 	   $("#slt_ids_count2").append(count); */
		   
	       if(count== $("input[type='checkbox'][name='ids']").length){
	    	   $("#checkall").attr("checked","checked");
	       }else{
	    	   $("#checkall").attr("checked",null);
	       }
	   }
	   
	   function  checkAllBox(){
	      if($("#checkall")[0].checked){
	    	  $("input[type='checkbox'][name='ids']").attr("checked","checked");
	    	  /* $("#slt_ids_count2").empty();
	    	  $("#slt_ids_count2").append($("input[type='checkbox'][name='ids']").length); */
	      }else{
	    	  $("input[type='checkbox'][name='ids']").attr("checked",null);
	    	  /* $("#slt_ids_count2").empty();
	    	  $("#slt_ids_count2").append(0); */
	      }
	   }
	 </script>
  </body>
</html>
