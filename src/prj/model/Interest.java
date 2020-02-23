package prj.model;


public class Interest {
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
    private Double overdue;
    public void setOverdue(Double overdue){
        this.overdue = overdue;
    }
    public Double getOverdue(){
        return this.overdue;
    }
    private Double amount;
    public void setAmount(Double amount){
        this.amount = amount;
    }
    public Double getAmount(){
        return this.amount;
    }
    private Double rate;
    public void setRate(Double rate){
        this.rate = rate;
    }
    public Double getRate(){
        return this.rate;
    }

    private String cardName;
    public void setCardName(String cardName){
        this.cardName = cardName;
    }
    public String getCardName(){
        return this.cardName;
    }
    
}
