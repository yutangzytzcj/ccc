package prj.dao;



import java.sql.*;
import java.util.*;
import prj.model.*;

public class SettingDao {
    public List<Setting> findAll() throws Exception{
        List<Setting> list = new ArrayList<Setting>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Setting].*  FROM [Setting]";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Setting e = new Setting();
            e.setId((Integer)rs.getObject("Id"));
            e.setMinPayRate((((java.math.BigDecimal)rs.getObject("MinPayRate")).doubleValue()));
            e.setInterestRate((((java.math.BigDecimal)rs.getObject("InterestRate")).doubleValue()));
            e.setOverDays((Integer)rs.getObject("OverDays"));
            e.setBillDate((Integer)rs.getObject("BillDate"));

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
        sql = "DELETE FROM [Setting] WHERE [Id]=" + id;
        stmt.executeUpdate(sql);
    }
    
    public void add(Setting e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
       	String sql = "INSERT INTO [Setting] ([MinPayRate],[InterestRate],[OverDays],[BillDate]) VALUES("+e.getMinPayRate()+","+e.getInterestRate()+","+e.getOverDays()+","+e.getBillDate()+")";
        sql = sql.replace("'null'", "null");
        stmt.executeUpdate(sql);
    }
    public void update(Setting e) throws Exception{
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        String sql = "UPDATE [Setting] SET [MinPayRate] = "+e.getMinPayRate()+",[InterestRate] = "+e.getInterestRate()+",[OverDays] = "+e.getOverDays()+",[BillDate] = "+e.getBillDate()+" WHERE [Id]=" + e.getId();
        sql = sql.replace("'null'", "null");

        stmt.executeUpdate(sql);
    }

    public Setting findById(Integer id) throws Exception{
        Setting e = null;
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Setting].*  FROM [Setting] WHERE [Setting].[Id]="+id;

        rs = stmt.executeQuery(sql);
        if(rs.next()){
            e = new Setting();
            e.setId((Integer)rs.getObject("Id"));
            e.setMinPayRate((Double)rs.getObject("MinPayRate"));
            e.setInterestRate((Double)rs.getObject("InterestRate"));
            e.setOverDays((Integer)rs.getObject("OverDays"));
            e.setBillDate((Integer)rs.getObject("BillDate"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return e;
    }


    public List<Setting> findByMinPayRate(Double cond) throws Exception{
        List<Setting> list = new ArrayList<Setting>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Setting].*  FROM [Setting] WHERE [Setting].[MinPayRate]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Setting e = new Setting();
            e.setId((Integer)rs.getObject("Id"));
            e.setMinPayRate((((java.math.BigDecimal)rs.getObject("MinPayRate")).doubleValue()));
            e.setInterestRate((((java.math.BigDecimal)rs.getObject("InterestRate")).doubleValue()));
            e.setOverDays((Integer)rs.getObject("OverDays"));
            e.setBillDate((Integer)rs.getObject("BillDate"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Setting> findByInterestRate(Double cond) throws Exception{
        List<Setting> list = new ArrayList<Setting>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Setting].*  FROM [Setting] WHERE [Setting].[InterestRate]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Setting e = new Setting();
            e.setId((Integer)rs.getObject("Id"));
            e.setMinPayRate((((java.math.BigDecimal)rs.getObject("MinPayRate")).doubleValue()));
            e.setInterestRate((((java.math.BigDecimal)rs.getObject("InterestRate")).doubleValue()));
            e.setOverDays((Integer)rs.getObject("OverDays"));
            e.setBillDate((Integer)rs.getObject("BillDate"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Setting> findByOverDays(Integer cond) throws Exception{
        List<Setting> list = new ArrayList<Setting>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Setting].*  FROM [Setting] WHERE [Setting].[OverDays]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Setting e = new Setting();
            e.setId((Integer)rs.getObject("Id"));
            e.setMinPayRate((((java.math.BigDecimal)rs.getObject("MinPayRate")).doubleValue()));
            e.setInterestRate((((java.math.BigDecimal)rs.getObject("InterestRate")).doubleValue()));
            e.setOverDays((Integer)rs.getObject("OverDays"));
            e.setBillDate((Integer)rs.getObject("BillDate"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

    public List<Setting> findByBillDate(Integer cond) throws Exception{
        List<Setting> list = new ArrayList<Setting>();
        Class.forName(DbConfig.DriverName); 
        Connection conn = DriverManager.getConnection(DbConfig.ConnString); 
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = null;
        sql = "SELECT [Setting].*  FROM [Setting] WHERE [Setting].[BillDate]="+cond+"";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Setting e = new Setting();
            e.setId((Integer)rs.getObject("Id"));
            e.setMinPayRate((((java.math.BigDecimal)rs.getObject("MinPayRate")).doubleValue()));
            e.setInterestRate((((java.math.BigDecimal)rs.getObject("InterestRate")).doubleValue()));
            e.setOverDays((Integer)rs.getObject("OverDays"));
            e.setBillDate((Integer)rs.getObject("BillDate"));

            list.add(e);
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }
    

}
