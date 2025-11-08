package Challange3.Entity;
public class Member{
    private int memberId;
    private String name;
    private String email;
    private int borrowedBookCount;
    private int borrowLimit=5;

    public Member(int memberId, String name, String email, int borrowedBookCount, int borrowLimit) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedBookCount = borrowedBookCount;
        this.borrowLimit = borrowLimit;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public int getBorrowedBookCount() {
        return borrowedBookCount;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    public void setBorrowLimit(int borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    public void increaseBorrowedBookCount() {
        this.borrowedBookCount++;
    }
    
    public void decreaseBorrowedBookCount() {
        this.borrowedBookCount--;
    }
}