package prj.dao;



import java.sql.*;
import java.util.*;
import prj.model.*;

public class AdminDao {
    public List<Admin> findAll() throws Exception{
        List<Admin> list = new ArrayList<Admin>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Admin].*  FROM [Admin]";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Admin e = new Admin();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    
    public void delete(Integer id) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = null;
        sql = "DELETE FROM [Admin] WHERE [Id]=" + id;
        stmt.executeUpdate(sql);
    }
    
    public void add(Admin e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
       	String sql = "INSERT INTO [Admin] ([Name],[Password]) VALUES('"+e.getName()+"','"+e.getPassword()+"')";
        sql = sql.replace("'null'", "null");
        stmt.executeUpdate(sql);
    }
    public void update(Admin e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = "UPDATE [Admin] SET [Name] = '"+e.getName()+"',[Password] = '"+e.getPassword()+"' WHERE [Id]=" + e.getId();
        sql = sql.replace("'null'", "null");

        stmt.executeUpdate(sql);
    }

    public Admin findById(Integer id) throws Exception{
        Admin e = null;
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Admin].*  FROM [Admin] WHERE [Admin].[Id]="+id;

        rs = stmt.executeQuery(sql);
        if(rs.next()){
            e = new Admin();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return e;
    }


    public List<Admin> findByName(String cond) throws Exception{
        List<Admin> list = new ArrayList<Admin>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Admin].*  FROM [Admin] WHERE [Admin].[Name]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Admin e = new Admin();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Admin> findByPassword(String cond) throws Exception{
        List<Admin> list = new ArrayList<Admin>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Admin].*  FROM [Admin] WHERE [Admin].[Password]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Admin e = new Admin();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

}
