package prj.dao;



import java.sql.*;
import java.util.*;
import prj.model.*;

public class BillDao {
    public List<Bill> findAll() throws Exception{
        List<Bill> list = new ArrayList<Bill>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Bill].*, [Card].No AS CardName  FROM [Bill] LEFT JOIN [Card] ON [Bill].[Card] = [Card].[Id]";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Bill e = new Bill();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setPaid((((java.math.BigDecimal)rs.getObject("Paid")).doubleValue()));
            e.setMinPay((((java.math.BigDecimal)rs.getObject("MinPay")).doubleValue()));
            e.setDeadline((java.sql.Timestamp)rs.getObject("Deadline"));
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
        sql = "DELETE FROM [Bill] WHERE [Id]=" + id;
        stmt.executeUpdate(sql);
    }
    
    public void deleteByYearAndMonth(Object year, Object month) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = null;
        sql = "DELETE FROM [Bill] WHERE [Year]=" + year + " AND [Month]=" + month;
        stmt.executeUpdate(sql);
    }    
    
    public void add(Bill e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
       	String sql = "INSERT INTO [Bill] ([Card],[Year],[Month],[Balance],[Paid],[MinPay],[Deadline]) VALUES("+e.getCard()+","+e.getYear()+","+e.getMonth()+","+e.getBalance()+","+e.getPaid()+","+e.getMinPay()+",'"+e.getDeadline()+"')";
        sql = sql.replace("'null'", "null");
        stmt.executeUpdate(sql);
    }
    public void update(Bill e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = "UPDATE [Bill] SET [Card] = "+e.getCard()+",[Year] = "+e.getYear()+",[Month] = "+e.getMonth()+",[Balance] = "+e.getBalance()+",[Paid] = "+e.getPaid()+",[MinPay] = "+e.getMinPay()+",[Deadline] = '"+e.getDeadline()+"' WHERE [Id]=" + e.getId();
        sql = sql.replace("'null'", "null");

        stmt.executeUpdate(sql);
    }

    public Bill findById(Integer id) throws Exception{
        Bill e = null;
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Bill].*, [Card].No AS CardName  FROM [Bill] LEFT JOIN [Card] ON [Bill].[Card] = [Card].[Id] WHERE [Bill].[Id]="+id;

        rs = stmt.executeQuery(sql);
        if(rs.next()){
            e = new Bill();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setBalance((Double)rs.getObject("Balance"));
            e.setPaid((Double)rs.getObject("Paid"));
            e.setMinPay((Double)rs.getObject("MinPay"));
            e.setDeadline((java.sql.Timestamp)rs.getObject("Deadline"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return e;
    }


    public List<Bill> findByCard(Integer cond) throws Exception{
        List<Bill> list = new ArrayList<Bill>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Bill].*, [Card].No AS CardName  FROM [Bill] LEFT JOIN [Card] ON [Bill].[Card] = [Card].[Id]  WHERE [Bill].[Card]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Bill e = new Bill();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setPaid((((java.math.BigDecimal)rs.getObject("Paid")).doubleValue()));
            e.setMinPay((((java.math.BigDecimal)rs.getObject("MinPay")).doubleValue()));
            e.setDeadline((java.sql.Timestamp)rs.getObject("Deadline"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Bill> findByYear(Integer cond) throws Exception{
        List<Bill> list = new ArrayList<Bill>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Bill].*, [Card].No AS CardName  FROM [Bill] LEFT JOIN [Card] ON [Bill].[Card] = [Card].[Id]  WHERE [Bill].[Year]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Bill e = new Bill();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setPaid((((java.math.BigDecimal)rs.getObject("Paid")).doubleValue()));
            e.setMinPay((((java.math.BigDecimal)rs.getObject("MinPay")).doubleValue()));
            e.setDeadline((java.sql.Timestamp)rs.getObject("Deadline"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Bill> findByMonth(Integer cond) throws Exception{
        List<Bill> list = new ArrayList<Bill>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Bill].*, [Card].No AS CardName  FROM [Bill] LEFT JOIN [Card] ON [Bill].[Card] = [Card].[Id]  WHERE [Bill].[Month]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Bill e = new Bill();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setPaid((((java.math.BigDecimal)rs.getObject("Paid")).doubleValue()));
            e.setMinPay((((java.math.BigDecimal)rs.getObject("MinPay")).doubleValue()));
            e.setDeadline((java.sql.Timestamp)rs.getObject("Deadline"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Bill> findByBalance(Double cond) throws Exception{
        List<Bill> list = new ArrayList<Bill>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Bill].*, [Card].No AS CardName  FROM [Bill] LEFT JOIN [Card] ON [Bill].[Card] = [Card].[Id]  WHERE [Bill].[Balance]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Bill e = new Bill();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setPaid((((java.math.BigDecimal)rs.getObject("Paid")).doubleValue()));
            e.setMinPay((((java.math.BigDecimal)rs.getObject("MinPay")).doubleValue()));
            e.setDeadline((java.sql.Timestamp)rs.getObject("Deadline"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Bill> findByPaid(Double cond) throws Exception{
        List<Bill> list = new ArrayList<Bill>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Bill].*, [Card].No AS CardName  FROM [Bill] LEFT JOIN [Card] ON [Bill].[Card] = [Card].[Id]  WHERE [Bill].[Paid]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Bill e = new Bill();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setPaid((((java.math.BigDecimal)rs.getObject("Paid")).doubleValue()));
            e.setMinPay((((java.math.BigDecimal)rs.getObject("MinPay")).doubleValue()));
            e.setDeadline((java.sql.Timestamp)rs.getObject("Deadline"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Bill> findByMinPay(Double cond) throws Exception{
        List<Bill> list = new ArrayList<Bill>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Bill].*, [Card].No AS CardName  FROM [Bill] LEFT JOIN [Card] ON [Bill].[Card] = [Card].[Id]  WHERE [Bill].[MinPay]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Bill e = new Bill();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setPaid((((java.math.BigDecimal)rs.getObject("Paid")).doubleValue()));
            e.setMinPay((((java.math.BigDecimal)rs.getObject("MinPay")).doubleValue()));
            e.setDeadline((java.sql.Timestamp)rs.getObject("Deadline"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Bill> findByDeadline(java.sql.Timestamp cond) throws Exception{
        List<Bill> list = new ArrayList<Bill>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Bill].*, [Card].No AS CardName  FROM [Bill] LEFT JOIN [Card] ON [Bill].[Card] = [Card].[Id]  WHERE [Bill].[Deadline]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Bill e = new Bill();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setPaid((((java.math.BigDecimal)rs.getObject("Paid")).doubleValue()));
            e.setMinPay((((java.math.BigDecimal)rs.getObject("MinPay")).doubleValue()));
            e.setDeadline((java.sql.Timestamp)rs.getObject("Deadline"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

}
