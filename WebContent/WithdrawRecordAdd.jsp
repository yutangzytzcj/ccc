<%@page import="prj.util.Business"%>
<%@page import="prj.util.*"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,prj.model.*,prj.dao.*,java.util.*" errorPage="" %>
<%
request.setCharacterEncoding("utf-8");
TransactionDao dao = new TransactionDao();
Transaction e = null;

Integer userId = (Integer)request.getSession().getAttribute("UserId");
if( request.getParameter("Action") != null ) {
    CardDao cdao = new CardDao();
    Card card = cdao.findById(Integer.valueOf(request.getParameter("Card")));
    
    e = new Transaction();
    e.setCard(Integer.valueOf(request.getParameter("Card")));
    e.setType("消费");
    e.setTitle(String.valueOf(request.getParameter("Title")));
    e.setTime(Converter.StringToTimestamp(request.getParameter("Time")));
    e.setAmount(Double.valueOf(request.getParameter("Amount")));
    e.setOverdue(0D);
    e.setBalance(0D);
    
    Calendar c = Calendar.getInstance();
    c.setTime(new java.util.Date(e.getTime().getTime()));
    
    e.setYear(c.get(Calendar.YEAR));
    if(c.get(Calendar.DAY_OF_MONTH) >= card.getBillDate()){
        e.setMonth(c.get(Calendar.MONTH)+2);
    }else{
        e.setMonth(c.get(Calendar.MONTH)+1);
    }

    dao.add(e);
    
    Business.ProcessTransactions(e.getCard());
    
   
    response.sendRedirect("WithdrawRecordList.jsp");
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
			<td colSpan="2"><div align="center"><font color="#ffffff">添加消费记录</font></div></td>
		</tr>
		<tr>
			<td><br />
				<div><form action="WithdrawRecordAdd.jsp" method="post">
					<input type="hidden" name="Action" value="insert" />
                    <table style="border-width: 1px; border-style: solid; width: 100%; height: 50px; border-collapse: collapse;"
						border="1" rules="all" cellSpacing="0" cellPadding="4">
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">信用卡</td>
							<td>
<%
List<Card> _CardEntities = (new CardDao()).findAll();
%>
<select id="Card" name="Card">
<%for(int i = 0; i < _CardEntities.size(); i++){%>
<option value="<%=_CardEntities.get(i).getId()%>"><%=_CardEntities.get(i).getNo()%></option>
<%}%>
</select>
                            
                            </td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">标题</td>
							<td><input id="Title" name="Title" type="text" value=""></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">日期</td>
							<td><input id="Time" name="Time" type="text" value=""></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">金额</td>
							<td><input id="Amount" name="Amount" type="text" value=""></td>
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
