<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,prj.model.*,prj.dao.*,java.util.*" errorPage="" %>
<%
request.setCharacterEncoding("utf-8");
String role = request.getParameter("role");
if(role.equals("SA")){
    if(request.getParameter("username").equals("sa") && request.getParameter("password").equals("sa")){
            request.getSession().setAttribute("User",null);
            request.getSession().setAttribute("UserId",1);
            request.getSession().setAttribute("UserName","后台管理员");
            request.getSession().setAttribute("Role", role);
            response.sendRedirect("home.jsp");
    }else {
        response.sendRedirect("login.jsp");
    }
}else if(role.equals("Admin")){
    AdminDao dao = new AdminDao();
    List<Admin> list = dao.findByName(request.getParameter("username"));
    if(list.size()>0 && list.get(0).getPassword().equals(request.getParameter("password"))){
            request.getSession().setAttribute("User",list.get(0));
            request.getSession().setAttribute("UserId",list.get(0).getId());
            request.getSession().setAttribute("UserName",list.get(0).getName());
            request.getSession().setAttribute("Role", role);
            response.sendRedirect("home.jsp");
    }else {
        response.sendRedirect("login.jsp");
    }
}else{
    UserDao dao = new UserDao();
    List<User> list = dao.findByName(request.getParameter("username"));
    if(list.size()>0 && list.get(0).getPassword().equals(request.getParameter("password"))){
            request.getSession().setAttribute("User",list.get(0));
            request.getSession().setAttribute("UserId",list.get(0).getId());
            request.getSession().setAttribute("UserName",list.get(0).getName());
            request.getSession().setAttribute("Role", role);
            response.sendRedirect("home.jsp");
    }else {
        response.sendRedirect("login.jsp");
    }
}
%>
