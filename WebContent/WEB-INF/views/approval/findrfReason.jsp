<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div align="center">
		<div>
			<h2>未通过原因:</h2>
		</div>
		<textarea rows="5" cols="50">${approval.refuseReason}</textarea>
	</div>
	
	<div>
		<input type="button" style="margin-left:20px;" value="返回" onclick="location.href='javascript:history.go(-1);'">
	</div>
</body>
</html>