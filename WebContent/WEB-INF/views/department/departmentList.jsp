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
		<span class="menu_selected">部门管理</span>
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
		  <form name="form1" method="post" action="department/selectDepartment">
  			<table width="100%" border="0" cellspacing="0" cellpadding="0" name="base" id="base">
			  <tr> 	
				<td width="40%" nowrap>部门名称模糊查询：
					<c:if test="${empty dpmName}">
						<input type="text" name="dpmName" id="dpmName">
					</c:if>
					
					<c:if test="${not empty dpmName}">
						<input type="text" name="dpmName" id="dpmName" value="${dpmName}">
					</c:if>
		    	</td>
		    	<td width="39%" nowrap>&nbsp;</td>
		  	    <td width="25%" align="center">
					<div class="control">
						<button type="button" class="button" onMouseOver="this.className='button_over';" 
						        onMouseOut="this.className='button';"  onClick="document.forms[0].submit()">
						        <img src="images/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索
						</button>&nbsp;
						
		      		    <button type="button" class="button" onMouseOver="this.className='button_over';" 
		      		    		onMouseOut="this.className='button';" onClick="forward('department/findAllDepartment')">
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
	
	<h3><img src="images/khlb.png" border="0">&nbsp;部门列表</h3>
	<div class="control">
		<button type="button" class="button" onMouseOver="this.className='button_over';" 
		        onMouseOut="this.className='button';" onClick="forward('department/addDepartment?parentId=${parentId}')">
		        <img src="images/xinjian.png" border='0' align='absmiddle'>&nbsp;添加</button>&nbsp;
		<button type="button" class="button" onMouseOver="this.className='button_over';" 
		        onMouseOut="this.className='button';" onclick="deleteIds()">
		        <img src="images/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
	 </div>
	
	<div class="border">
	  <form name="form2" method="post" action="department/deleteDepartment">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
			
		   <c:if test="${not empty dpmList}">
		   	  <tr>
		    	<td width="4%" class="listViewThS1"><input type="checkbox" name="checkall"  id="checkall" onClick="checkAllBox();"/></td>
		  	    <td width="10%" class="listViewThS1">部门名称</td>
		  	    <td width="15%" class="listViewThS1">部门描述</td>
		  	    <td width="10%" class="listViewThS1">创建日期</td>
		  	    <td width="10%" class="listViewThS1">上级部门</td>
		  	    <td width="10%" class="listViewThS1">部门等级</td>
		  	    <td width="10%" class="listViewThS1">操作</td>
			  </tr>
		   	  <c:forEach items="${dpmList}" var="dpm">
				<tr>
			    	<td><input type="checkbox" name="ids" value="${dpm.dpmId}" onClick="changeCheckCount();"/></td>
			  	    <td><a href="department/finddpmChildren?dpmId=${dpm.dpmId}">${dpm.dpmName}</a></td>
					<td>${dpm.dpmDescription}</td>
					<td>${dpm.dpmCreatDate}</td>					
					<td>${dpm.parentName}</td>														
					<td>${dpm.dpmLevel}</td>
					<td><a href="department/finddpmInfo?dpmId=${dpm.dpmId}&parentId=${dpm.parentId}"><span style="color: blue;">修改</span></a></td>
				</tr>
			  </c:forEach>
			</c:if>
			
			<c:if test="${empty dpmList}">
				<div><h1>暂无数据!</h1></div>
			</c:if>
			
	   	   </table>  
	  	</form>
	   </div>
	
   <!-- 分页显示所有数据 -->
   <c:if test="${empty dpmName}">
	<div style="padding-top:30px;color:#FF0000;">
	   <c:if test="${not empty page}">
	    <tr>  
	     <td colspan="9">
	        <c:if test="${page.totalPage!=0}">  
	                      当前是第${page.pageNow}页，共${page.totalPage}页 
	             
	            <a href="department/findAllDepartment?pageNow=1"><u>首页</u></a>  
	        	 	        	 
	       		<c:if test="${page.isHasPre()!=false}">	        		
	            	<a href="department/findAllDepartment?pageNow=${page.pageNow-1}"><u>上一页</u></a>
	        	</c:if>
	        	  
	        	<c:if test="${page.isHasNext()!=false}">	        		
	        		<a href="department/findAllDepartment?pageNow=${page.pageNow+1}"><u>下一页</u></a>            
	        	</c:if>
	        	  		         
		        <a href="department/findAllDepartment?pageNow=${page.totalPage}"><u>尾页</u></a>  
		        
		     </c:if>         
	      </td>  
	  	 </tr>
	  	</c:if>
	 </div>
    </c:if>
    
   <!-- 分页显示部分数据 -->
   <c:if test="${not empty dpmName}">
	<div style="padding-top:30px;color:#FF0000;">
	   <c:if test="${not empty page}">
	    <tr>  
	     <td colspan="9">
	        <c:if test="${page.totalPage!=0}">  
	                      当前是第${page.pageNow}页，共${page.totalPage}页 
	             
	            <a href="department/selectDepartment?dpmName=${dpmName}&pageNow=1" ><u>首页</u></a>  
	        	 	        	 
	       		<c:if test="${page.isHasPre()!=false}">	        		
	            	<a href="department/selectDepartment?dpmName=${dpmName}&pageNow=${page.pageNow-1}"><u>上一页</u></a>
	        	</c:if>
	        	  
	        	<c:if test="${page.isHasNext()!=false}">	        		
	        		<a href="department/selectDepartment?dpmName=${dpmName}&pageNow=${page.pageNow+1}"><u>下一页</u></a>            
	        	</c:if>
	        	  		         
		        <a href="department/selectDepartment?dpmName=${dpmName}&pageNow=${page.totalPage}"><u>尾页</u></a>  
		        
		     </c:if>         
	      </td>  
	  	 </tr>
	  	</c:if>
	 </div>
    </c:if>
 
 	<c:if test="${not empty sessionScope.errorInfo}">
	 	<script type="text/javascript">
	 		window.onload=function(){
	 			setTimeout(info, 50);
	 		}
	 		function info(){
	 			alert("该部门下存在子部门或职位，无法删除!");
	 		}
	 	</script>
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
