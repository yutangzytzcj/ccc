<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,prj.model.*,prj.dao.*,java.util.*" errorPage="" %>
<%
request.setCharacterEncoding("utf-8");
CardDao dao = new CardDao();
Card e = dao.findById(Integer.valueOf(request.getParameter("id")));

Integer userId = (Integer)request.getSession().getAttribute("UserId");
if( request.getParameter("Action") != null ) {
    e.setUser(Integer.valueOf(request.getParameter("User")));
    e.setNo(String.valueOf(request.getParameter("No")));
    e.setCreateDate(java.sql.Timestamp.valueOf(request.getParameter("CreateDate")));
    e.setExpireDate(java.sql.Timestamp.valueOf(request.getParameter("ExpireDate")));
    //e.setBalance(Double.valueOf(request.getParameter("Balance")));
    e.setLimited(Double.valueOf(request.getParameter("Limited")));
    //e.setOverdue(Double.valueOf(request.getParameter("Overdue")));
    e.setBillDate(Integer.valueOf(request.getParameter("BillDate")));
    //e.setStatus(String.valueOf(request.getParameter("Status")));
    dao.update(e);
	response.sendRedirect("CardList.jsp");
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
			<td colSpan="2"><div align="center"><font color="#ffffff">修改信用卡</font></div></td>
		</tr>
		<tr>
			<td><br />
				<div><form action="CardEdit.jsp" method="post">
					<input type="hidden" name="Action" value="insert" />
					<input type="hidden" name="id" value="<%=e.getId()%>" />
                    
                    <table style="border-width: 1px; border-style: solid; width: 100%; height: 50px; border-collapse: collapse;"
						border="1" rules="all" cellSpacing="0" cellPadding="4">
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">用户</td>
							<td>
<%
List<User> _UserEntities = (new UserDao()).findAll();
%>
<select id="User" name="User">
<%for(int i = 0; i < _UserEntities.size(); i++){%>

<%if( e.getUser() != null &&  _UserEntities.get(i).getId().equals(e.getUser())){%>
<option value="<%=_UserEntities.get(i).getId()%>" selected="selected"><%=_UserEntities.get(i).getName()%></option>
<%}else{%>
<option value="<%=_UserEntities.get(i).getId()%>"><%=_UserEntities.get(i).getName()%></option>
<%}%>


<%}%>
</select>
                            
                            </td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">卡号</td>
							<td><input id="No" name="No" type="text" value="<%=e.getNo()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">开卡日期</td>
							<td><input id="CreateDate" name="CreateDate" type="text" value="<%=e.getCreateDate()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">有效期</td>
							<td><input id="ExpireDate" name="ExpireDate" type="text" value="<%=e.getExpireDate()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">限额</td>
							<td><input id="Limited" name="Limited" type="text" value="<%=e.getLimited()%>"></td>
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
</body>
</html>
