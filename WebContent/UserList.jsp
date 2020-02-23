<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,prj.model.*,prj.dao.*,java.util.*" errorPage="" %>
<%
request.setCharacterEncoding("utf-8");
UserDao dao = new UserDao();
User e = null;
List<User> list = null;
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
<%
Integer userId = (Integer)request.getSession().getAttribute("UserId");
if( request.getParameter("Action") != null && request.getParameter("Action").toString().equals("delete") ) {
	dao.delete(Integer.parseInt(request.getParameter("id")));
	response.getWriter().print("<script type='text/script'>window.alert('操作成功！');</script>");
}
if( request.getParameter("Action") != null && request.getParameter("Action").toString().equals("disable") ) {
	e = dao.findById(Integer.valueOf(request.getParameter("id")));
        e.setStatus("已冻结");
        dao.update(e);
	response.getWriter().print("<script type='text/script'>window.alert('操作成功！');</script>");
}
if( request.getParameter("Action") != null && request.getParameter("Action").toString().equals("enable") ) {
	e = dao.findById(Integer.valueOf(request.getParameter("id")));
        e.setStatus("正常");
        dao.update(e);
	response.getWriter().print("<script type='text/script'>window.alert('操作成功！');</script>");
}


%>
<table border="1" cellSpacing="0" borderColorLight="#145aa0" borderColorDark="#9cc7ef" cellPadding="4" width="100%" align="center">
	<tr bgColor="#4296e7"><td colSpan="2"><div align="center"><font color="#ffffff">用户管理</font></div></td></tr>
	<tr>
		<td><br><div>
			<table style="border-color: black; width: 100%; font-family: verdana; font-size: 8pt; border-collapse: collapse;" 
				border="1" rules="all" cellSpacing="0" cellPadding="2">
				<tr style="font-weight: bold; background-color: rgb(248, 250, 252); font-size:10pt;" vAlign="middle" align="center">
				<th>姓名</th>
				<th>密码</th>
				<th>性别</th>
				<th>联系电话</th>
				<th>手机</th>
				<th>身份证号</th>
				<th>账户状态</th>
				<th>操作</th>
			</tr>
			<%
				list = dao.findAll();
                for( int i = 0; i < list.size(); i++ ) {
                    e = list.get(i);
			%>
			<tr style="font-style: normal; font-weight: normal; text-decoration: none; background-color: white; font-size:10pt;" align="center">
				<td><%=e.getName()%></td>
				<td><%=e.getPassword()%></td>
				<td><%=e.getGender()%></td>
				<td><%=e.getTel()%></td>
				<td><%=e.getMobile()%></td>
				<td><%=e.getIdNo()%></td>
				<td><%=e.getStatus()%></td>
				<td>
					<a href="UserEdit.jsp?id=<%=e.getId()%>">修改</a> 
					<a href="?Action=delete&id=<%=e.getId()%>">删除</a> 
                                        <%if(e.getStatus().equals("正常")){%>
					<a href="?Action=disable&id=<%=e.getId()%>">冻结</a> 
                                        <%}else if(e.getStatus().equals("已冻结")){%>
					<a href="?Action=enable&id=<%=e.getId()%>">解冻</a> 
                                        <%}%>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div></td>
	</tr>
	<tr bgColor="#4296e7"><td colSpan="2"><a style="color: white;" href="UserAdd.jsp">新建</a></td></tr>
</table>

</body>
</html>
