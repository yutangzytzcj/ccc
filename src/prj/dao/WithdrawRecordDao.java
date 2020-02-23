package prj.dao;



import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import prj.model.*;

public class WithdrawRecordDao {
    public List<WithdrawRecord> findAll() throws Exception{
        List<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [WithdrawRecord].*, [Card].No AS CardName  FROM [WithdrawRecord] LEFT JOIN [Card] ON [WithdrawRecord].[Card] = [Card].[Id]";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            WithdrawRecord e = new WithdrawRecord();
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
        sql = "DELETE FROM [WithdrawRecord] WHERE [Id]=" + id;
        stmt.executeUpdate(sql);
    }
    
    public void add(WithdrawRecord e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
       	String sql = "INSERT INTO [WithdrawRecord] ([Card],[Title],[Time],[Amount]) VALUES("+e.getCard()+",'"+e.getTitle()+"','"+e.getTime()+"',"+e.getAmount()+")";
        sql = sql.replace("'null'", "null");
        stmt.executeUpdate(sql);
    }
    public void update(WithdrawRecord e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = "UPDATE [WithdrawRecord] SET [Card] = "+e.getCard()+",[Title] = '"+e.getTitle()+"',[Time] = '"+e.getTime()+"',[Amount] = "+e.getAmount()+" WHERE [Id]=" + e.getId();
        sql = sql.replace("'null'", "null");

        stmt.executeUpdate(sql);
    }

    public WithdrawRecord findById(Integer id) throws Exception{
        WithdrawRecord e = null;
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [WithdrawRecord].*, [Card].No AS CardName  FROM [WithdrawRecord] LEFT JOIN [Card] ON [WithdrawRecord].[Card] = [Card].[Id] WHERE [WithdrawRecord].[Id]="+id;

        rs = stmt.executeQuery(sql);
        if(rs.next()){
            e = new WithdrawRecord();
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


    public List<WithdrawRecord> findByCard(Integer cond) throws Exception{
        List<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [WithdrawRecord].*, [Card].No AS CardName  FROM [WithdrawRecord] LEFT JOIN [Card] ON [WithdrawRecord].[Card] = [Card].[Id]  WHERE [WithdrawRecord].[Card]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            WithdrawRecord e = new WithdrawRecord();
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
    

    public List<WithdrawRecord> findByTitle(String cond) throws Exception{
        List<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [WithdrawRecord].*, [Card].No AS CardName  FROM [WithdrawRecord] LEFT JOIN [Card] ON [WithdrawRecord].[Card] = [Card].[Id]  WHERE [WithdrawRecord].[Title]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            WithdrawRecord e = new WithdrawRecord();
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
    

    public List<WithdrawRecord> findByTime(java.sql.Timestamp cond) throws Exception{
        List<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [WithdrawRecord].*, [Card].No AS CardName  FROM [WithdrawRecord] LEFT JOIN [Card] ON [WithdrawRecord].[Card] = [Card].[Id]  WHERE [WithdrawRecord].[Time]='"+cond+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            WithdrawRecord e = new WithdrawRecord();
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
    

    public List<WithdrawRecord> findByAmount(Double cond) throws Exception{
        List<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [WithdrawRecord].*, [Card].No AS CardName  FROM [WithdrawRecord] LEFT JOIN [Card] ON [WithdrawRecord].[Card] = [Card].[Id]  WHERE [WithdrawRecord].[Amount]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            WithdrawRecord e = new WithdrawRecord();
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
