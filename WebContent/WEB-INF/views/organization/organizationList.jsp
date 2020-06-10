<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<!-- <link rel="stylesheet" href="css/css.css" /> -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	
  </head>
  
  <body> 

	<!-- <div class="f-tree">
		
	</div> -->
	
	
	<div id="div"></div>

		
	<!-- <script type="text/javascript" src="js/jquery.min.js"></script>		
	<script type="text/javascript" src="js/config.js" ></script> -->
		
	<!--数据封装在这里-->
	<!-- <script type="text/javascript" src="js/data.js" ></script> -->
	<!-- <script>
		var treeData=$("#treeData")[0].childNodes[0].nodeValue;  // json字符串
		var tree=JSON.parse(treeData);      //  json对象
		
		config.tree({
			type:0,     //1有选择框，没有则不传type或传0
			wrapper:'.f-tree',   //容器
			data:tree,           //数据
			check:[1,2]          //选中的数据，可以不传
		});
     </script> -->
     
     
     <script type="text/javascript">
		function renderMenu(menu, parent) {
			if (menu.url!=null&&menu.url!="") {
				var el = $('<a href='+menu.url+'>' + menu.name + '</a>');
			} else {
				var el = $('<a href="javascript:void(0)">' + menu.name + '</a>');				
			}		
		    parent.append(el);
		    
		    if (menu.contents==null) {   //判断是否是叶子节点，根据自己的数据去判断
		        return parent;
		    } 
	
		    var ul = $('<ul/>');
		    for (var i = 0; i < menu.contents.length; ++i) {
		        var li = $('<li/>');
		        renderMenu(menu.contents[i], li);
		        ul.append(li);
		    }
	
		    parent.append(ul);
		    return parent;
		}
	
		function render(data) {
		    var div = $('<div/>');
		    return renderMenu(data, div);
		}
	
		$(function () {			
			$.get("organization/organizationList",function(data){
				//后台传来的json数据
			    var menu = render(data);		
			    $("#div").append(menu);
			    $("#div ul").css("display", "none");
			    $("#div a").on("click", function () {
			        $(this).next().toggle();
			    });				
			});					   		    
		});
	</script>
  </body>
</html>
