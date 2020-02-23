<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/admin.css" type="text/css" rel="stylesheet">
</head>

<body>
		<TABLE cellSpacing=0 cellPadding=0 width="100%"
			background="images/header_bg.jpg" border=0>
			<TR height=56>
				<TD width=260>
					<IMG height=56 src="images/header_left.jpg" width=260>
				</TD>
				<TD style="FONT-WEIGHT: bold; COLOR: #fff; PADDING-TOP: 20px"
					align=middle>
					当前用户：<%=request.getSession().getAttribute("UserName")%> &nbsp;&nbsp;
					<A style="COLOR: #fff"
						onclick="if (confirm('确定要退出吗？')) return true; else return false;"
						href="login.jsp" target=_top>退出系统</A>
				</TD>
				<TD align=right width=268>
					<IMG height=56 src="images/header_right.jpg" width=268>
				</TD>
			</TR>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TR bgColor=#1c5db6 height=4>
				<TD></TD>
			</TR>
		</TABLE>

</body>
</html>