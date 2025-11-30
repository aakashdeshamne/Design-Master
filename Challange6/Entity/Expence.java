package Challange6.Entity;
public class Expence{
    private String expenceId;
    private String expenceName;
    private double amount;
    private User paidBy;
    private String grpID;
    public Expence(String expenceId, String expenceName, double amount, User paidBy, String grpID) {
        this.expenceId = expenceId;
        this.expenceName = expenceName;
        this.amount = amount;
        this.paidBy = paidBy;
        this.grpID = grpID;
    }
    public String getExpenceId() {
        return expenceId;
    }
    public String getExpenceName() {
        return expenceName;
    }
    public double getAmount() {
        return amount;
    }
    public User getPaidBy() {
        return paidBy;
    }
    public String getGrpID() {
        return grpID;
    }
}