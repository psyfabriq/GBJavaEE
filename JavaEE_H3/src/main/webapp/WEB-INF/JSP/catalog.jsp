<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=request.getAttribute("title")%></title>
</head>
<body>
	<h1><%=request.getAttribute("title")%></h1>
	<%@include file="/WEB-INF/includes/navmenu.jsp"%>ude file="includes/navmenu.jsp"%>

</body>
</html>