package prj.dao;



import java.sql.*;
import java.util.*;
import prj.model.*;

public class InterestDao {
    public List<Interest> findAll() throws Exception{
        List<Interest> list = new ArrayList<Interest>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Interest].*, [Card].Name AS CardName  FROM [Interest] LEFT JOIN [Card] ON [Interest].[Card] = [Card].[Id]";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Interest e = new Interest();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setRate((((java.math.BigDecimal)rs.getObject("Rate")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

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
        sql = "DELETE FROM [Interest] WHERE [Id]=" + id;
        stmt.executeUpdate(sql);
    }
    
    public void add(Interest e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
       	String sql = "INSERT INTO [Interest] ([Card],[Year],[Month],[Overdue],[Amount],[Rate]) VALUES("+e.getCard()+","+e.getYear()+","+e.getMonth()+","+e.getOverdue()+","+e.getAmount()+","+e.getRate()+")";
        sql = sql.replace("'null'", "null");
        stmt.executeUpdate(sql);
    }
    public void update(Interest e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = "UPDATE [Interest] SET [Card] = "+e.getCard()+",[Year] = "+e.getYear()+",[Month] = "+e.getMonth()+",[Overdue] = "+e.getOverdue()+",[Amount] = "+e.getAmount()+",[Rate] = "+e.getRate()+" WHERE [Id]=" + e.getId();
        sql = sql.replace("'null'", "null");

        stmt.executeUpdate(sql);
    }

    public Interest findById(Integer id) throws Exception{
        Interest e = null;
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Interest].*, [Card].Name AS CardName  FROM [Interest] LEFT JOIN [Card] ON [Interest].[Card] = [Card].[Id] WHERE [Interest].[Id]="+id;

        rs = stmt.executeQuery(sql);
        if(rs.next()){
            e = new Interest();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setOverdue((Double)rs.getObject("Overdue"));
            e.setAmount((Double)rs.getObject("Amount"));
            e.setRate((Double)rs.getObject("Rate"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return e;
    }


    public List<Interest> findByCard(Integer cond) throws Exception{
        List<Interest> list = new ArrayList<Interest>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Interest].*, [Card].Name AS CardName  FROM [Interest] LEFT JOIN [Card] ON [Interest].[Card] = [Card].[Id]  WHERE [Interest].[Card]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Interest e = new Interest();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setRate((((java.math.BigDecimal)rs.getObject("Rate")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Interest> findByYear(Integer cond) throws Exception{
        List<Interest> list = new ArrayList<Interest>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Interest].*, [Card].Name AS CardName  FROM [Interest] LEFT JOIN [Card] ON [Interest].[Card] = [Card].[Id]  WHERE [Interest].[Year]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Interest e = new Interest();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setRate((((java.math.BigDecimal)rs.getObject("Rate")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Interest> findByMonth(Integer cond) throws Exception{
        List<Interest> list = new ArrayList<Interest>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Interest].*, [Card].Name AS CardName  FROM [Interest] LEFT JOIN [Card] ON [Interest].[Card] = [Card].[Id]  WHERE [Interest].[Month]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Interest e = new Interest();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setRate((((java.math.BigDecimal)rs.getObject("Rate")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Interest> findByOverdue(Double cond) throws Exception{
        List<Interest> list = new ArrayList<Interest>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Interest].*, [Card].Name AS CardName  FROM [Interest] LEFT JOIN [Card] ON [Interest].[Card] = [Card].[Id]  WHERE [Interest].[Overdue]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Interest e = new Interest();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setRate((((java.math.BigDecimal)rs.getObject("Rate")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Interest> findByAmount(Double cond) throws Exception{
        List<Interest> list = new ArrayList<Interest>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Interest].*, [Card].Name AS CardName  FROM [Interest] LEFT JOIN [Card] ON [Interest].[Card] = [Card].[Id]  WHERE [Interest].[Amount]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Interest e = new Interest();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setRate((((java.math.BigDecimal)rs.getObject("Rate")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Interest> findByRate(Double cond) throws Exception{
        List<Interest> list = new ArrayList<Interest>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Interest].*, [Card].Name AS CardName  FROM [Interest] LEFT JOIN [Card] ON [Interest].[Card] = [Card].[Id]  WHERE [Interest].[Rate]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Interest e = new Interest();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setRate((((java.math.BigDecimal)rs.getObject("Rate")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

}
