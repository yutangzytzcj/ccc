<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv=Pragma content=no-cache>
<meta http-equiv=Cache-Control content=no-cache>
<meta http-equiv=Expires content=-1000>
<link href="css/admin.css" type="text/css" rel="stylesheet">
</head>

<body>
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170
			background=images/menu_bg.jpg border=0>
			<TR>
				<TD vAlign=top align=middle>
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TR>
							<TD height=10></TD>
						</TR>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
                                            <%if(request.getSession().getAttribute("Role").toString().equals("SA")){%>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="AdminList.jsp" target="main">管理员帐户管理</A>
							</TD>
						</TR>
                                            <%} else if(request.getSession().getAttribute("Role").toString().equals("Admin")){%>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="AdminChangePassword.jsp" target="main">修改密码</A>
							</TD>
						</TR>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="SettingEdit.jsp" target="main">系统设置</A>
							</TD>
						</TR>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="UserList.jsp" target="main">用户管理</A>
							</TD>
						</TR>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="CardList.jsp" target="main">信用卡管理</A>
							</TD>
						</TR>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="WithdrawRecordList.jsp" target="main">消费管理</A>
							</TD>
						</TR>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="DepositRecordList.jsp" target="main">还款管理</A>
							</TD>
						</TR>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="TransactionList.jsp" target="main">交易明细</A>
							</TD>
						</TR>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="BillList.jsp" target="main">账单</A>
							</TD>
						</TR>
						
                                                <%}else{%>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="UserEditInfo.jsp" target="main">修改个人信息</A>
							</TD>
						</TR>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="MyCard.jsp" target="main">我的信用卡</A>
							</TD>
						</TR>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="MyBillList.jsp" target="main">我的账单</A>
							</TD>
						</TR>
                                                <TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="MyDepositRecordList.jsp" target="main">我的还款记录</A>
							</TD>
						</TR>
                                                <TR height=22>
							<TD style="PADDING-LEFT: 30px" background=images/menu_bt.jpg>
								<A class=menuParent href="MyWithdrawRecordList.jsp" target="main">我的消费记录</A>
							</TD>
						</TR>
                                                <%}%>
				</TD>
				<TD width=1 bgColor=#d1e6f7></TD>
			</TR>
		</TABLE>

</body>
</html>