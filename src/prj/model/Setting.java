package prj.model;


public class Setting {
    private Integer id;
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    private Double minPayRate;
    public void setMinPayRate(Double minPayRate){
        this.minPayRate = minPayRate;
    }
    public Double getMinPayRate(){
        return this.minPayRate;
    }
    private Double interestRate;
    public void setInterestRate(Double interestRate){
        this.interestRate = interestRate;
    }
    public Double getInterestRate(){
        return this.interestRate;
    }
    private Integer overDays;
    public void setOverDays(Integer overDays){
        this.overDays = overDays;
    }
    public Integer getOverDays(){
        return this.overDays;
    }
    private Integer billDate;
    public void setBillDate(Integer billDate){
        this.billDate = billDate;
    }
    public Integer getBillDate(){
        return this.billDate;
    }

    
}
