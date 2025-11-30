package Challange6.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Challange6.Entity.Expence;
import Challange6.Entity.Group;
import Challange6.Entity.User;

public class SplitWise {
    private Map<String, User>users=new HashMap<>();
    private Map<String,Group>groups=new HashMap<>();
    private Map<String,Map<String,Double>>globleBalancesheet=new HashMap<>();
    public void addUser(String userId,String userName){
        users.put(userId,new User(userId,userName));
    }
    public void createGroup(String groupId,String groupName,List<User>members){
        groups.put(groupId,new Group (groupId,groupName,members));
    }
    public void updateSheet(String paidBy,String paidTo,double amount){
        globleBalancesheet.putIfAbsent(paidBy, new HashMap<>());
        globleBalancesheet.get(paidBy).merge(paidTo,amount,Double::sum);
    }
    public void addgroupExpence(String expenceId,String expenceName,double amount,User paidBy,String groupId){
        Expence e=new Expence(expenceId, expenceName, amount, paidBy, groupId);
        Group g=groups.get(groupId);
        g.addExpence(e);
        double share=amount/g.getMembers().size();
        for(User u:g.getMembers()){
            if(!u.getUserId().equals(paidBy.getUserId())){
                updateSheet(paidBy.getUserId(), u.getUserId(), share);
            }
        }
    }
    public void addDirectExpence(String expenceId,String expenceName,double amount,User paidBy,User paidTo){
        Expence e=new Expence(expenceId, expenceName, amount, paidBy, "");
        double share=amount;
        updateSheet(paidBy.getUserId(), paidTo.getUserId(), share);
    }
    public void showBalanceSheet(){
        for(String paidBy:globleBalancesheet.keySet()){
            Map<String,Double>balances=globleBalancesheet.get(paidBy);
            for(String paidTo:balances.keySet()){
                double amount=balances.get(paidTo);
                if(amount>0){
                    System.out.println(paidTo+" owes "+paidBy+" : "+amount);
                }
            }
        }
    }
    public void showGroupExpences(String groupId){
        Group g=groups.get(groupId);
        System.out.println("Expences for Group: "+g.getGroupName());
        for(Expence e:g.getExpences()){
            System.out.println("Expence ID: "+e.getExpenceId()+", Name: "+e.getExpenceName()+", Amount: "+e.getAmount()+", Paid By: "+e.getPaidBy().getUserName());
        }
    }
}
