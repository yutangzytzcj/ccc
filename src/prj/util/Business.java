/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.util;

import java.sql.Timestamp;
import java.util.*;
import prj.dao.*;
import prj.model.*;



public class Business {
    public static void ProcessTransactions(Integer cardId) throws Exception{
        CardDao cdao = new CardDao();
        Card card = cdao.findById(cardId);
        SettingDao sdao = new SettingDao();
        Setting setting = sdao.findAll().get(0);
        TransactionDao tdao = new TransactionDao();
        tdao.deleteInterestByCard(cardId);
        List<Transaction> transactions = tdao.findByCard(cardId);
        Double balance = 0D;
        Timestamp tsBill = null;
        Timestamp tsDeadline=null;
        if(transactions.size()>0){
            Double due = 0D;
            Double paid = 0D;
            Timestamp prevDate = null;
            for(int i = 0; i < transactions.size(); i++){
                Transaction t = transactions.get(i);
                Integer year = t.getYear();
                Integer month = t.getMonth();
                
                Calendar cal = Calendar.getInstance();
                cal.setTime(new java.util.Date(t.getTime().getTime()));
                int y = cal.get(Calendar.YEAR);
                int m = cal.get(Calendar.MONTH);
                int d = cal.get(Calendar.DAY_OF_MONTH);
                
                cal.set(y, m, card.getBillDate());
                if(tsBill==null){
                    tsBill = new Timestamp(cal.getTime().getTime());
                    cal.add(Calendar.DAY_OF_MONTH, setting.getOverDays());
                    tsDeadline = new Timestamp(cal.getTime().getTime());
                }
                
                if(prevDate != null && prevDate.before(tsBill) && t.getTime().after(tsBill)){
                    due=0-balance;
                    paid=0D;
                    tsBill = new Timestamp(cal.getTime().getTime());
                    cal.add(Calendar.DAY_OF_MONTH, setting.getOverDays());
                    tsDeadline = new Timestamp(cal.getTime().getTime());
                    
                }
                if(prevDate != null && prevDate.before(tsDeadline) && t.getTime().after(tsDeadline)){
                    if(due>paid){
                        t.setOverdue(due);
                    }
                }
                if(i==(transactions.size()-1) && new Timestamp(new java.util.Date().getTime()).after(tsDeadline)){
                    if(due>paid){
                        //t.setOverdue(due);
                        Transaction nt = new Transaction();
                        nt.setAmount(due * setting.getInterestRate());
                        nt.setBalance(balance-nt.getAmount());
                        nt.setCard(card.getId());
                        nt.setMonth(month);
                        nt.setYear(year);
                        nt.setOverdue(due);
                        nt.setTime(tsDeadline);
                        nt.setTitle("利息");//鍒╂伅
                        nt.setType("利息");
                        tdao.add(nt);
                        balance=nt.getBalance();
                    }
                }
                
                if(t.getType().equals("消费") || t.getType().equals("利息")){//娑堣垂
                    t.setBalance(balance - t.getAmount());
                }else if(t.getType().equals("还款")) {//杩樻
                    t.setBalance(balance + t.getAmount());
                    paid+=t.getAmount();
                }
                balance=t.getBalance();
                tdao.update(t);
                prevDate=t.getTime();
            }
        }
        card.setBalance(balance);
        cdao.update(card);
    }
}
