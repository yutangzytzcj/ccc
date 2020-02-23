package prj.model;

public class Transaction {
    private Integer id;
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    private Integer card;
    public void setCard(Integer card){
        this.card = card;
    }
    public Integer getCard(){
        return this.card;
    }
    private String type;
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    private Integer year;
    public void setYear(Integer year){
        this.year = year;
    }
    public Integer getYear(){
        return this.year;
    }
    private Integer month;
    public void setMonth(Integer month){
        this.month = month;
    }
    public Integer getMonth(){
        return this.month;
    }
    private String title;
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    private Double amount;
    public void setAmount(Double amount){
        this.amount = amount;
    }
    public Double getAmount(){
        return this.amount;
    }
    private Double balance;
    public void setBalance(Double balance){
        this.balance = balance;
    }
    public Double getBalance(){
        return this.balance;
    }
    private Double overdue;
    public void setOverdue(Double overdue){
        this.overdue = overdue;
    }
    public Double getOverdue(){
        return this.overdue;
    }
    private java.sql.Timestamp time;
    public void setTime(java.sql.Timestamp time){
        this.time = time;
    }
    public java.sql.Timestamp getTime(){
        return this.time;
    }

    private String cardName;
    public void setCardName(String cardName){
        this.cardName = cardName;
    }
    public String getCardName(){
        return this.cardName;
    }
    
}
