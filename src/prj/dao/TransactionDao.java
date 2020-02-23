package prj.dao;

import java.sql.*;
import java.util.*;
import prj.model.*;

public class TransactionDao {
    public List<Transaction> findAll() throws Exception{
        List<Transaction> list = new ArrayList<Transaction>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id] ORDER BY [Transaction].[Time]";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Transaction e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
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
        sql = "DELETE FROM [Transaction] WHERE [Id]=" + id;
        stmt.executeUpdate(sql);
    }

    public void deleteInterestByCard(Integer cid) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = null;
        sql = "DELETE FROM [Transaction] WHERE [Type]='利息' AND [Card]=" + cid;
        stmt.executeUpdate(sql);
    }

    
    public void add(Transaction e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
       	String sql = "INSERT INTO [Transaction] ([Card],[Type],[Year],[Month],[Title],[Amount],[Balance],[Overdue],[Time]) VALUES("+e.getCard()+",'"+e.getType()+"',"+e.getYear()+","+e.getMonth()+",'"+e.getTitle()+"',"+e.getAmount()+","+e.getBalance()+","+e.getOverdue()+",'"+e.getTime()+"')";
        sql = sql.replace("'null'", "null");
        stmt.executeUpdate(sql);
    }
    public void update(Transaction e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = "UPDATE [Transaction] SET [Card] = "+e.getCard()+",[Type] = '"+e.getType()+"',[Year] = "+e.getYear()+",[Month] = "+e.getMonth()+",[Title] = '"+e.getTitle()+"',[Amount] = "+e.getAmount()+",[Balance] = "+e.getBalance()+",[Overdue] = "+e.getOverdue()+",[Time] = '"+e.getTime()+"' WHERE [Id]=" + e.getId();
        sql = sql.replace("'null'", "null");

        stmt.executeUpdate(sql);
    }

    public Transaction findById(Integer id) throws Exception{
        Transaction e = null;
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id] WHERE [Transaction].[Id]="+id;

        rs = stmt.executeQuery(sql);
        if(rs.next()){
            e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return e;
    }


    public List<Transaction> findByCard(Integer cond) throws Exception{
        List<Transaction> list = new ArrayList<Transaction>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id]  WHERE [Transaction].[Card]="+cond+" ORDER BY [Transaction].[Time]";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Transaction e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Transaction> findByType(String cond) throws Exception{
        List<Transaction> list = new ArrayList<Transaction>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id]  WHERE [Transaction].[Type]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Transaction e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Transaction> findByYear(Integer cond) throws Exception{
        List<Transaction> list = new ArrayList<Transaction>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id]  WHERE [Transaction].[Year]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Transaction e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Transaction> findByMonth(Integer cond) throws Exception{
        List<Transaction> list = new ArrayList<Transaction>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id]  WHERE [Transaction].[Month]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Transaction e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Transaction> findByTitle(String cond) throws Exception{
        List<Transaction> list = new ArrayList<Transaction>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id]  WHERE [Transaction].[Title]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Transaction e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Transaction> findByAmount(Double cond) throws Exception{
        List<Transaction> list = new ArrayList<Transaction>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id]  WHERE [Transaction].[Amount]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Transaction e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Transaction> findByBalance(Double cond) throws Exception{
        List<Transaction> list = new ArrayList<Transaction>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id]  WHERE [Transaction].[Balance]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Transaction e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Transaction> findByOverdue(Double cond) throws Exception{
        List<Transaction> list = new ArrayList<Transaction>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id]  WHERE [Transaction].[Overdue]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Transaction e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Transaction> findByTime(java.sql.Timestamp cond) throws Exception{
        List<Transaction> list = new ArrayList<Transaction>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Transaction].*, [Card].No AS CardName  FROM [Transaction] LEFT JOIN [Card] ON [Transaction].[Card] = [Card].[Id]  WHERE [Transaction].[Time]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Transaction e = new Transaction();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setType((String)rs.getObject("Type"));
            e.setYear((Integer)rs.getObject("Year"));
            e.setMonth((Integer)rs.getObject("Month"));
            e.setTitle((String)rs.getObject("Title"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setBalance((((java.math.BigDecimal)rs.getObject("Balance")).doubleValue()));
            e.setOverdue((((java.math.BigDecimal)rs.getObject("Overdue")).doubleValue()));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

}
