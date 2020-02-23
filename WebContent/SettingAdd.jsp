<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,prj.model.*,prj.dao.*,java.util.*" errorPage="" %>
<%
request.setCharacterEncoding("utf-8");
SettingDao dao = new SettingDao();
Setting e = null;

Integer userId = (Integer)request.getSession().getAttribute("UserId");
if( request.getParameter("Action") != null ) {
	e = new Setting();
    e.setMinPayRate(Double.valueOf(request.getParameter("MinPayRate")));
    e.setInterestRate(Double.valueOf(request.getParameter("InterestRate")));
    e.setOverDays(Integer.valueOf(request.getParameter("OverDays")));
    e.setBillDate(Integer.valueOf(request.getParameter("BillDate")));
    dao.add(e);
	response.sendRedirect("SettingList.jsp");
    return;
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
			<td colSpan="2"><div align="center"><font color="#ffffff">添加Setting</font></div></td>
		</tr>
		<tr>
			<td><br />
				<div><form action="SettingAdd.jsp" method="post">
					<input type="hidden" name="Action" value="insert" />
                    <table style="border-width: 1px; border-style: solid; width: 100%; height: 50px; border-collapse: collapse;"
						border="1" rules="all" cellSpacing="0" cellPadding="4">
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">MinPayRate</td>
							<td><input id="MinPayRate" name="MinPayRate" type="text" value=""></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">InterestRate</td>
							<td><input id="InterestRate" name="InterestRate" type="text" value=""></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">OverDays</td>
							<td><input id="OverDays" name="OverDays" type="text" value=""></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">BillDate</td>
							<td><input id="BillDate" name="BillDate" type="text" value=""></td>
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
</body>
</html>
