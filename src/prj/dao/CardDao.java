package prj.dao;


import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import prj.model.*;

public class CardDao {
    public List<Card> findAll() throws Exception{
        List<Card> list = new ArrayList<Card>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id]";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Card e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setLimited((((java.math.BigDecimal)rs.getObject("Limited")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
            e.setUserName((String)rs.getObject("UserName"));

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
        sql = "DELETE FROM [Card] WHERE [Id]=" + id;
        stmt.executeUpdate(sql);
    }
    
    public void add(Card e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
       	String sql = "INSERT INTO [Card] ([User],[No],[CreateDate],[ExpireDate],[Balance],[Limited],[Overdue],[BillDate],[Status]) VALUES("+e.getUser()+",'"+e.getNo()+"','"+e.getCreateDate()+"','"+e.getExpireDate()+"',"+e.getBalance()+","+e.getLimited()+","+e.getOverdue()+","+e.getBillDate()+",'"+e.getStatus()+"')";
        sql = sql.replace("'null'", "null");
        stmt.executeUpdate(sql);
    }
    public void update(Card e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = "UPDATE [Card] SET [User] = "+e.getUser()+",[No] = '"+e.getNo()+"',[CreateDate] = '"+e.getCreateDate()+"',[ExpireDate] = '"+e.getExpireDate()+"',[Balance] = "+e.getBalance()+",[Limited] = "+e.getLimited()+",[Overdue] = "+e.getOverdue()+",[BillDate] = "+e.getBillDate()+",[Status] = '"+e.getStatus()+"' WHERE [Id]=" + e.getId();
        sql = sql.replace("'null'", "null");

        stmt.executeUpdate(sql);
    }

    public Card findById(Integer id) throws Exception{
        Card e = null;
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id] WHERE [Card].[Id]="+id;

        rs = stmt.executeQuery(sql);
        if(rs.next()){
            e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance(((BigDecimal)rs.getObject("Balance")).doubleValue());
            e.setLimited(((BigDecimal)rs.getObject("Limited")).doubleValue());
            e.setOverdue(((BigDecimal)rs.getObject("Overdue")).doubleValue());
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return e;
    }


    public List<Card> findByUser(Integer cond) throws Exception{
        List<Card> list = new ArrayList<Card>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id]  WHERE [Card].[User]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Card e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setLimited((((java.math.BigDecimal)rs.getObject("Limited")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
            e.setUserName((String)rs.getObject("UserName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Card> findByNo(String cond) throws Exception{
        List<Card> list = new ArrayList<Card>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id]  WHERE [Card].[No]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Card e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setLimited((((java.math.BigDecimal)rs.getObject("Limited")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
            e.setUserName((String)rs.getObject("UserName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Card> findByCreateDate(java.sql.Timestamp cond) throws Exception{
        List<Card> list = new ArrayList<Card>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id]  WHERE [Card].[CreateDate]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Card e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setLimited((((java.math.BigDecimal)rs.getObject("Limited")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
            e.setUserName((String)rs.getObject("UserName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Card> findByExpireDate(java.sql.Timestamp cond) throws Exception{
        List<Card> list = new ArrayList<Card>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id]  WHERE [Card].[ExpireDate]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Card e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setLimited((((java.math.BigDecimal)rs.getObject("Limited")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
            e.setUserName((String)rs.getObject("UserName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Card> findByBalance(Double cond) throws Exception{
        List<Card> list = new ArrayList<Card>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id]  WHERE [Card].[Balance]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Card e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setLimited((((java.math.BigDecimal)rs.getObject("Limited")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
            e.setUserName((String)rs.getObject("UserName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Card> findByLimited(Double cond) throws Exception{
        List<Card> list = new ArrayList<Card>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id]  WHERE [Card].[Limited]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Card e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setLimited((((java.math.BigDecimal)rs.getObject("Limited")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
            e.setUserName((String)rs.getObject("UserName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Card> findByOverdue(Double cond) throws Exception{
        List<Card> list = new ArrayList<Card>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id]  WHERE [Card].[Overdue]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Card e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setLimited((((java.math.BigDecimal)rs.getObject("Limited")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
            e.setUserName((String)rs.getObject("UserName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Card> findByBillDate(java.sql.Timestamp cond) throws Exception{
        List<Card> list = new ArrayList<Card>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id]  WHERE [Card].[BillDate]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Card e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setLimited((((java.math.BigDecimal)rs.getObject("Limited")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
            e.setUserName((String)rs.getObject("UserName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Card> findByStatus(String cond) throws Exception{
        List<Card> list = new ArrayList<Card>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Card].*, [User].Name AS UserName  FROM [Card] LEFT JOIN [User] ON [Card].[User] = [User].[Id]  WHERE [Card].[Status]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Card e = new Card();
            e.setId((Integer)rs.getObject("Id"));
            e.setUser((Integer)rs.getObject("User"));
            e.setNo((String)rs.getObject("No"));
            e.setCreateDate((java.sql.Timestamp)rs.getObject("CreateDate"));
            e.setExpireDate((java.sql.Timestamp)rs.getObject("ExpireDate"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setLimited((((java.math.BigDecimal)rs.getObject("Limited")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setBillDate((Integer)rs.getObject("BillDate"));
            e.setStatus((String)rs.getObject("Status"));
            e.setUserName((String)rs.getObject("UserName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

}
