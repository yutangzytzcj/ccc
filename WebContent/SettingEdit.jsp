<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,prj.model.*,prj.dao.*,java.util.*" errorPage="" %>
<%
String msg = null;
request.setCharacterEncoding("utf-8");
SettingDao dao = new SettingDao();
//Setting e = dao.findById(Integer.valueOf(request.getParameter("id")));
Setting e = dao.findAll().get(0);

Integer userId = (Integer)request.getSession().getAttribute("UserId");
if( request.getParameter("Action") != null ) {
    e.setMinPayRate(Double.valueOf(request.getParameter("MinPayRate")));
    e.setInterestRate(Double.valueOf(request.getParameter("InterestRate")));
    e.setOverDays(Integer.valueOf(request.getParameter("OverDays")));
    e.setBillDate(Integer.valueOf(request.getParameter("BillDate")));
    dao.update(e);
        msg="操作成功！";

	//response.sendRedirect("SettingList.jsp");
    //return;
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
			<td colSpan="2"><div align="center"><font color="#ffffff">系统设置</font></div></td>
		</tr>
		<tr>
			<td><br />
				<div><form action="SettingEdit.jsp" method="post">
					<input type="hidden" name="Action" value="insert" />
					<input type="hidden" name="id" value="<%=e.getId()%>" />
                    
                    <table style="border-width: 1px; border-style: solid; width: 100%; height: 50px; border-collapse: collapse;"
						border="1" rules="all" cellSpacing="0" cellPadding="4">
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">最低还款额</td>
							<td><input id="MinPayRate" name="MinPayRate" type="text" value="<%=e.getMinPayRate()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">利率</td>
							<td><input id="InterestRate" name="InterestRate" type="text" value="<%=e.getInterestRate()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">还款天数</td>
							<td><input id="OverDays" name="OverDays" type="text" value="<%=e.getOverDays()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">帐单日</td>
							<td><input id="BillDate" name="BillDate" type="text" value="<%=e.getBillDate()%>"></td>
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
