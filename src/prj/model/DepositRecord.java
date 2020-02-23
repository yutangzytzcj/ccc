package prj.model;



public class DepositRecord {
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
    private String title;
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    private java.sql.Timestamp time;
    public void setTime(java.sql.Timestamp time){
        this.time = time;
    }
    public java.sql.Timestamp getTime(){
        return this.time;
    }
    private Double amount;
    public void setAmount(Double amount){
        this.amount = amount;
    }
    public Double getAmount(){
        return this.amount;
    }

    private String cardName;
    public void setCardName(String cardName){
        this.cardName = cardName;
    }
    public String getCardName(){
        return this.cardName;
    }
    
}
