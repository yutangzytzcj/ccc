<%@page import="prj.util.Converter"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,prj.model.*,prj.dao.*,java.util.*" errorPage="" %>
<%
request.setCharacterEncoding("utf-8");

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
	<tr bgColor="#4296e7"><td colSpan="2"><div align="center"><font color="#ffffff">账单</font></div></td></tr>
	<tr>
		<td><br><div>
			<table style="border-color: black; width: 100%; font-family: verdana; font-size: 8pt; border-collapse: collapse;" 
				border="1" rules="all" cellSpacing="0" cellPadding="2">
				<tr style="font-weight: bold; background-color: rgb(248, 250, 252); font-size:10pt;" vAlign="middle" align="center">
				<th>卡号</th>
				<th>年</th>
				<th>月</th>
				<th>还款日</th>
				<th>应还款金额</th>
				<th>最低还款额</th>
			</tr>
			<%
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT U.Id AS UserId, U.Name AS UserName, C.No AS CardName, [Year], [Month], C.BillDate,"
                + "SUM(CASE WHEN [Type]='还款' THEN 0 - Amount ELSE Amount END) AS Balance,  SUM(CASE WHEN [Type]='还款' THEN 0 - Amount ELSE Amount END) / 10 AS MinPay "
                + "FROM [Transaction] T INNER JOIN [Card] C ON T.Card=C.Id "
                + "INNER JOIN [User] U ON C.[User] = U.Id "
                + "GROUP BY U.Id, U.Name, C.No, [Year], [Month], C.BillDate "
                + "ORDER BY UserId, CardName, [Year], [Month], C.BillDate";
        rs = stmt.executeQuery(sql);
        while(rs.next()){			%>
			<tr style="font-style: normal; font-weight: normal; text-decoration: none; background-color: white; font-size:10pt;" align="center">
				<td><%=rs.getObject("CardName")%></td>
				<td><%=rs.getObject("Year")%></td>
				<td><%=rs.getObject("Month")%></td>
				<td><%=rs.getObject("BillDate")%>日</td>
				<td><%=rs.getObject("Balance")%></td>
				<td><%=rs.getObject("MinPay")%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div></td>
	</tr>
	<tr bgColor="#4296e7"><td colSpan="2">
                &nbsp;
        </td></tr>
</table>

</body>
</html>
