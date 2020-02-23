<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,prj.model.*,prj.dao.*,java.util.*" errorPage="" %>
<%
String msg = null;
request.setCharacterEncoding("utf-8");
AdminDao dao = new AdminDao();

Integer userId = (Integer)request.getSession().getAttribute("UserId");
Admin e = dao.findById(userId);
if( request.getParameter("Action") != null ) {
    e.setName(String.valueOf(request.getParameter("Name")));
    e.setPassword(String.valueOf(request.getParameter("Password")));
    dao.update(e);
	//response.sendRedirect("AdminList.jsp");
    //return;
    msg="操作成功！";
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<style>td { font-size: 12px; }</style>
</head>
<body>

    <table border="1" cellSpacing="0" borderColorLight="#145aa0" borderColorDark="#9cc7ef" cellPadding="4" width="100%" align="center">
		<tr bgColor="#4296e7">
			<td colSpan="2"><div align="center"><font color="#ffffff">修改密码</font></div></td>
		</tr>
		<tr>
			<td><br />
				<div><form action="" method="post">
					<input type="hidden" name="Action" value="insert" />
					<input type="hidden" name="id" value="<%=e.getId()%>" />
                                        <input type="hidden" name="Name" value="<%=e.getName()%>" />
                    
                    <table style="border-width: 1px; border-style: solid; width: 100%; height: 50px; border-collapse: collapse;"
						border="1" rules="all" cellSpacing="0" cellPadding="4">
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">密码</td>
							<td><input id="Password" name="Password" type="text" value="<%=e.getPassword()%>"></td>
						</tr>
						<tr style="width: 79%;" align="center">
							<td colSpan="2">
								<input type="submit" value="保存" />
								<input type="reset" value="重置" />
							</td>
						</tr>
					</table>
				</form></div>
			</td>
		</tr>
		<tr bgColor="#4296e7">
			<td colSpan="2"></td>
		</tr>
	</table>
<%
if(msg != null && msg.length()>0){
%>
<script type="text/javascript">
    window.alert("<%=msg%>");
</script>    
<%    
}
%>
</body>
</html>
