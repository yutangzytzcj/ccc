<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,prj.model.*,prj.dao.*,java.util.*" errorPage="" %>
<%
request.setCharacterEncoding("utf-8");
UserDao dao = new UserDao();
User e = dao.findById(Integer.valueOf(request.getParameter("id")));

Integer userId = (Integer)request.getSession().getAttribute("UserId");
if( request.getParameter("Action") != null ) {
    e.setName(String.valueOf(request.getParameter("Name")));
    e.setPassword(String.valueOf(request.getParameter("Password")));
    e.setGender(String.valueOf(request.getParameter("Gender")));
    e.setTel(String.valueOf(request.getParameter("Tel")));
    e.setMobile(String.valueOf(request.getParameter("Mobile")));
    e.setIdNo(String.valueOf(request.getParameter("IdNo")));
    e.setStatus(String.valueOf(request.getParameter("Status")));
    dao.update(e);
	response.sendRedirect("UserList.jsp");
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
        <script type="text/javascript">
            function check(){
                if(document.all.Mobile.value.length!=11){
                    alert("手机号码必须是11个数字！");
                    return false;
                }
                if(document.all.IdNo.value.length!=11){
                    alert("身份证号必须是11个数字！");
                    return false;
                }
                return true;
            }
        </script>
</head>
<body>

    <table border="1" cellSpacing="0" borderColorLight="#145aa0" borderColorDark="#9cc7ef" cellPadding="4" width="100%" align="center">
		<tr bgColor="#4296e7">
			<td colSpan="2"><div align="center"><font color="#ffffff">修改User</font></div></td>
		</tr>
		<tr>
			<td><br />
				<div><form action="UserEdit.jsp" method="post" onsubmit="return check();">
					<input type="hidden" name="Action" value="insert" />
					<input type="hidden" name="id" value="<%=e.getId()%>" />
                                        <input type="hidden" name="Status" value="<%=e.getStatus()%>">
                    
                    <table style="border-width: 1px; border-style: solid; width: 100%; height: 50px; border-collapse: collapse;"
						border="1" rules="all" cellSpacing="0" cellPadding="4">
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">姓名</td>
							<td><input id="Name" name="Name" type="text" value="<%=e.getName()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">密码</td>
							<td><input id="Password" name="Password" type="text" value="<%=e.getPassword()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">性别</td>
							<td><input id="Gender" name="Gender" type="text" value="<%=e.getGender()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">联系电话</td>
							<td><input id="Tel" name="Tel" type="text" value="<%=e.getTel()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">手机</td>
							<td><input id="Mobile" name="Mobile" type="text" value="<%=e.getMobile()%>"></td>
						</tr>
						<tr style="width: 79%;">
							<td style="width: 164px;" align="right">身份证号</td>
							<td><input id="IdNo" name="IdNo" type="text" value="<%=e.getIdNo()%>"></td>
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
