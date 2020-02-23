package prj.model;



public class Bill {
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
    private Double balance;
    public void setBalance(Double balance){
        this.balance = balance;
    }
    public Double getBalance(){
        return this.balance;
    }
    private Double paid;
    public void setPaid(Double paid){
        this.paid = paid;
    }
    public Double getPaid(){
        return this.paid;
    }
    private Double minPay;
    public void setMinPay(Double minPay){
        this.minPay = minPay;
    }
    public Double getMinPay(){
        return this.minPay;
    }
    private java.sql.Timestamp deadline;
    public void setDeadline(java.sql.Timestamp deadline){
        this.deadline = deadline;
    }
    public java.sql.Timestamp getDeadline(){
        return this.deadline;
    }

    private String cardName;
    public void setCardName(String cardName){
        this.cardName = cardName;
    }
    public String getCardName(){
        return this.cardName;
    }
    
}
