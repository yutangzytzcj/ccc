<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
if( request.getSession().getAttribute("UserId") == null ) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>银行信用卡管理系统</title>
<META http-equiv=Pragma content=no-cache>
<META http-equiv=Cache-Control content=no-cache>
<META http-equiv=Expires content=-1000>
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
</head>
<frameset border=0 frameSpacing=0 rows="60, *" frameBorder=0>
<frame name=header src="header.jsp" frameBorder=0 noResize scrolling=no>
<frameset cols="170, *">
<frame name=menu src="menu.jsp" frameBorder=0 noResize>
<frame name=main src="main.jsp" frameBorder=0 noResize scrolling=yes>
</frameset>
</frameset>
<noframes>
</noframes>
</html>