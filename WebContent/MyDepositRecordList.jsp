<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,prj.model.*,prj.dao.*,java.util.*" errorPage="" %>
<%
request.setCharacterEncoding("utf-8");
TransactionDao dao = new TransactionDao();
Transaction e = null;
List<Transaction> list = null;
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
    e=dao.findById(Integer.parseInt(request.getParameter("id")));
    dao.delete(Integer.parseInt(request.getParameter("id")));
    response.getWriter().print("<script type='text/script'>window.alert('操作成功！');</script>");
}
%>
<table border="1" cellSpacing="0" borderColorLight="#145aa0" borderColorDark="#9cc7ef" cellPadding="4" width="100%" align="center">
	<tr bgColor="#4296e7"><td colSpan="2"><div align="center"><font color="#ffffff">还款管理</font></div></td></tr>
	<tr>
		<td><br><div>
			<table style="border-color: black; width: 100%; font-family: verdana; font-size: 8pt; border-collapse: collapse;" 
				border="1" rules="all" cellSpacing="0" cellPadding="2">
				<tr style="font-weight: bold; background-color: rgb(248, 250, 252); font-size:10pt;" vAlign="middle" align="center">
				<th>卡号</th>
				<th>标题</th>
				<th>日期</th>
				<th>金额</th>
				
			</tr>
			<%
				list = dao.findByType("还款");
                for( int i = 0; i < list.size(); i++ ) {
                    e = list.get(i);
                    CardDao cardDao = new CardDao();
                    Card c = cardDao.findById(e.getCard());
                    if(c.getUser().equals(userId)){
			%>
			<tr style="font-style: normal; font-weight: normal; text-decoration: none; background-color: white; font-size:10pt;" align="center">
				<td><%=e.getCardName()%></td>
				<td><%=e.getTitle()%></td>
				<td><%=e.getTime()%></td>
				<td><%=e.getAmount()%></td>
				
			</tr>
			<%
                                               }
				}
			%>
		</table>
	</div></td>
	</tr>
	<tr bgColor="#4296e7"><td colSpan="2"></td></tr>
</table>

</body>
</html>
