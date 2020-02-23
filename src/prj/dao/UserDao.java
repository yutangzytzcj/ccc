package prj.dao;


import java.sql.*;
import java.util.*;
import prj.model.*;

public class UserDao {
    public List<User> findAll() throws Exception{
        List<User> list = new ArrayList<User>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [User].*  FROM [User]";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            User e = new User();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));
            e.setGender((String)rs.getObject("Gender"));
            e.setTel((String)rs.getObject("Tel"));
            e.setMobile((String)rs.getObject("Mobile"));
            e.setIdNo((String)rs.getObject("IdNo"));
            e.setStatus((String)rs.getObject("Status"));

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
        sql = "DELETE FROM [User] WHERE [Id]=" + id;
        stmt.executeUpdate(sql);
    }
    
    public void add(User e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
       	String sql = "INSERT INTO [User] ([Name],[Password],[Gender],[Tel],[Mobile],[IdNo],[Status]) VALUES('"+e.getName()+"','"+e.getPassword()+"','"+e.getGender()+"','"+e.getTel()+"','"+e.getMobile()+"','"+e.getIdNo()+"','"+e.getStatus()+"')";
        sql = sql.replace("'null'", "null");
        stmt.executeUpdate(sql);
    }
    public void update(User e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = "UPDATE [User] SET [Name] = '"+e.getName()+"',[Password] = '"+e.getPassword()+"',[Gender] = '"+e.getGender()+"',[Tel] = '"+e.getTel()+"',[Mobile] = '"+e.getMobile()+"',[IdNo] = '"+e.getIdNo()+"',[Status] = '"+e.getStatus()+"' WHERE [Id]=" + e.getId();
        sql = sql.replace("'null'", "null");

        stmt.executeUpdate(sql);
    }

    public User findById(Integer id) throws Exception{
        User e = null;
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [User].*  FROM [User] WHERE [User].[Id]="+id;

        rs = stmt.executeQuery(sql);
        if(rs.next()){
            e = new User();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));
            e.setGender((String)rs.getObject("Gender"));
            e.setTel((String)rs.getObject("Tel"));
            e.setMobile((String)rs.getObject("Mobile"));
            e.setIdNo((String)rs.getObject("IdNo"));
            e.setStatus((String)rs.getObject("Status"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return e;
    }


    public List<User> findByName(String cond) throws Exception{
        List<User> list = new ArrayList<User>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [User].*  FROM [User] WHERE [User].[Name]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            User e = new User();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));
            e.setGender((String)rs.getObject("Gender"));
            e.setTel((String)rs.getObject("Tel"));
            e.setMobile((String)rs.getObject("Mobile"));
            e.setIdNo((String)rs.getObject("IdNo"));
            e.setStatus((String)rs.getObject("Status"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<User> findByPassword(String cond) throws Exception{
        List<User> list = new ArrayList<User>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [User].*  FROM [User] WHERE [User].[Password]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            User e = new User();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));
            e.setGender((String)rs.getObject("Gender"));
            e.setTel((String)rs.getObject("Tel"));
            e.setMobile((String)rs.getObject("Mobile"));
            e.setIdNo((String)rs.getObject("IdNo"));
            e.setStatus((String)rs.getObject("Status"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<User> findByGender(String cond) throws Exception{
        List<User> list = new ArrayList<User>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [User].*  FROM [User] WHERE [User].[Gender]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            User e = new User();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));
            e.setGender((String)rs.getObject("Gender"));
            e.setTel((String)rs.getObject("Tel"));
            e.setMobile((String)rs.getObject("Mobile"));
            e.setIdNo((String)rs.getObject("IdNo"));
            e.setStatus((String)rs.getObject("Status"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<User> findByTel(String cond) throws Exception{
        List<User> list = new ArrayList<User>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [User].*  FROM [User] WHERE [User].[Tel]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            User e = new User();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));
            e.setGender((String)rs.getObject("Gender"));
            e.setTel((String)rs.getObject("Tel"));
            e.setMobile((String)rs.getObject("Mobile"));
            e.setIdNo((String)rs.getObject("IdNo"));
            e.setStatus((String)rs.getObject("Status"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<User> findByMobile(String cond) throws Exception{
        List<User> list = new ArrayList<User>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [User].*  FROM [User] WHERE [User].[Mobile]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            User e = new User();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));
            e.setGender((String)rs.getObject("Gender"));
            e.setTel((String)rs.getObject("Tel"));
            e.setMobile((String)rs.getObject("Mobile"));
            e.setIdNo((String)rs.getObject("IdNo"));
            e.setStatus((String)rs.getObject("Status"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<User> findByIdNo(String cond) throws Exception{
        List<User> list = new ArrayList<User>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [User].*  FROM [User] WHERE [User].[IdNo]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            User e = new User();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));
            e.setGender((String)rs.getObject("Gender"));
            e.setTel((String)rs.getObject("Tel"));
            e.setMobile((String)rs.getObject("Mobile"));
            e.setIdNo((String)rs.getObject("IdNo"));
            e.setStatus((String)rs.getObject("Status"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<User> findByStatus(String cond) throws Exception{
        List<User> list = new ArrayList<User>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [User].*  FROM [User] WHERE [User].[Status]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            User e = new User();
            e.setId((Integer)rs.getObject("Id"));
            e.setName((String)rs.getObject("Name"));
            e.setPassword((String)rs.getObject("Password"));
            e.setGender((String)rs.getObject("Gender"));
            e.setTel((String)rs.getObject("Tel"));
            e.setMobile((String)rs.getObject("Mobile"));
            e.setIdNo((String)rs.getObject("IdNo"));
            e.setStatus((String)rs.getObject("Status"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

}
