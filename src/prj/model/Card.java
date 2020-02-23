package prj.model;


public class Card {
    private Integer id;
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    private Integer user;
    public void setUser(Integer user){
        this.user = user;
    }
    public Integer getUser(){
        return this.user;
    }
    private String no;
    public void setNo(String no){
        this.no = no;
    }
    public String getNo(){
        return this.no;
    }
    private java.sql.Timestamp createDate;
    public void setCreateDate(java.sql.Timestamp createDate){
        this.createDate = createDate;
    }
    public java.sql.Timestamp getCreateDate(){
        return this.createDate;
    }
    private java.sql.Timestamp expireDate;
    public void setExpireDate(java.sql.Timestamp expireDate){
        this.expireDate = expireDate;
    }
    public java.sql.Timestamp getExpireDate(){
        return this.expireDate;
    }
    private Double balance;
    public void setBalance(Double balance){
        this.balance = balance;
    }
    public Double getBalance(){
        return this.balance;
    }
    private Double limited;
    public void setLimited(Double limited){
        this.limited = limited;
    }
    public Double getLimited(){
        return this.limited;
    }
    private Double overdue;
    public void setOverdue(Double overdue){
        this.overdue = overdue;
    }
    public Double getOverdue(){
        return this.overdue;
    }
    private Integer billDate;
    public void setBillDate(Integer billDate){
        this.billDate = billDate;
    }
    public Integer getBillDate(){
        return this.billDate;
    }
    private String status;
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }

    private String userName;
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
    
}
