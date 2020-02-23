package prj.dao;



import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import prj.model.*;

public class DepositRecordDao {
    public List<DepositRecord> findAll() throws Exception{
        List<DepositRecord> list = new ArrayList<DepositRecord>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [DepositRecord].*, [Card].No AS CardName  FROM [DepositRecord] LEFT JOIN [Card] ON [DepositRecord].[Card] = [Card].[Id]";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            DepositRecord e = new DepositRecord();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setTitle((String)rs.getObject("Title"));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
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
        sql = "DELETE FROM [DepositRecord] WHERE [Id]=" + id;
        stmt.executeUpdate(sql);
    }
    
    public void add(DepositRecord e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
       	String sql = "INSERT INTO [DepositRecord] ([Card],[Title],[Time],[Amount]) VALUES("+e.getCard()+",'"+e.getTitle()+"','"+e.getTime()+"',"+e.getAmount()+")";
        sql = sql.replace("'null'", "null");
        stmt.executeUpdate(sql);
    }
    public void update(DepositRecord e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = "UPDATE [DepositRecord] SET [Card] = "+e.getCard()+",[Title] = '"+e.getTitle()+"',[Time] = '"+e.getTime()+"',[Amount] = "+e.getAmount()+" WHERE [Id]=" + e.getId();
        sql = sql.replace("'null'", "null");

        stmt.executeUpdate(sql);
    }

    public DepositRecord findById(Integer id) throws Exception{
        DepositRecord e = null;
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [DepositRecord].*, [Card].No AS CardName  FROM [DepositRecord] LEFT JOIN [Card] ON [DepositRecord].[Card] = [Card].[Id] WHERE [DepositRecord].[Id]="+id;

        rs = stmt.executeQuery(sql);
        if(rs.next()){
            e = new DepositRecord();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setTitle((String)rs.getObject("Title"));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setAmount(((BigDecimal)rs.getObject("Amount")).doubleValue());
        }
        rs.close();
        stmt.close();
        conn.close();
        return e;
    }


    public List<DepositRecord> findByCard(Integer cond) throws Exception{
        List<DepositRecord> list = new ArrayList<DepositRecord>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [DepositRecord].*, [Card].No AS CardName  FROM [DepositRecord] LEFT JOIN [Card] ON [DepositRecord].[Card] = [Card].[Id]  WHERE [DepositRecord].[Card]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            DepositRecord e = new DepositRecord();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setTitle((String)rs.getObject("Title"));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<DepositRecord> findByTitle(String cond) throws Exception{
        List<DepositRecord> list = new ArrayList<DepositRecord>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [DepositRecord].*, [Card].No AS CardName  FROM [DepositRecord] LEFT JOIN [Card] ON [DepositRecord].[Card] = [Card].[Id]  WHERE [DepositRecord].[Title]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            DepositRecord e = new DepositRecord();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setTitle((String)rs.getObject("Title"));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<DepositRecord> findByTime(java.sql.Timestamp cond) throws Exception{
        List<DepositRecord> list = new ArrayList<DepositRecord>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [DepositRecord].*, [Card].No AS CardName  FROM [DepositRecord] LEFT JOIN [Card] ON [DepositRecord].[Card] = [Card].[Id]  WHERE [DepositRecord].[Time]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            DepositRecord e = new DepositRecord();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setTitle((String)rs.getObject("Title"));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<DepositRecord> findByAmount(Double cond) throws Exception{
        List<DepositRecord> list = new ArrayList<DepositRecord>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [DepositRecord].*, [Card].No AS CardName  FROM [DepositRecord] LEFT JOIN [Card] ON [DepositRecord].[Card] = [Card].[Id]  WHERE [DepositRecord].[Amount]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            DepositRecord e = new DepositRecord();
            e.setId((Integer)rs.getObject("Id"));
            e.setCard((Integer)rs.getObject("Card"));
            e.setTitle((String)rs.getObject("Title"));
            e.setTime((java.sql.Timestamp)rs.getObject("Time"));
            e.setAmount((((java.math.BigDecimal)rs.getObject("Amount")).doubleValue()));
            e.setCardName((String)rs.getObject("CardName"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

}
